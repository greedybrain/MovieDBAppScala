import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

import scala.collection.mutable.ListBuffer

object Scraper {
  val URL: String = "https://www.imdb.com/chart/top/?ref_=nv_mv_250"

  private def fromMainHtmlData: Document = {
    var data: Document = null
    try {
      data = Jsoup.connect(URL).get()
    } catch {
      case exc: Exception => {
        println(exc.getMessage)
      }
    }
    data
  }

  def getMovieListRows: Elements = {
    var rowsOfMovies: Elements = null
    try {
      rowsOfMovies = fromMainHtmlData.select(".lister-list tr")
    } catch {
      case exc: Exception => {
        println(exc.getMessage)
      }
    }
    rowsOfMovies
  }

  def getMovies: ListBuffer[Movie] = {
    val movies: ListBuffer[Movie] = ListBuffer()

    getMovieListRows.forEach(movie => {
      val title: String = movie.select("a").text()
      val moreInfoLink: String = String.format("https://www.imdb.com%s", movie.select("a").attr("href"))

      movies.addOne(new Movie(title, moreInfoLink))
    })
    movies
  }

  private def getSingleMovieHtmlData(movie: Movie): Document = {
    var htmlData: Document = null
    try {
      htmlData = Jsoup.connect(movie.getMoreInfoLink).get()
    } catch {
      case exc: Exception => {
        println(exc.getMessage)
      }
    }
    htmlData
  }

  def getMovie(movie: Movie): Movie = {
    val genres: ListBuffer[String] = ListBuffer()

    val currentMovie: Document = getSingleMovieHtmlData(movie)
    val runtime: String = currentMovie.select("time").text()
    val synopsis: String = currentMovie.select("div.summary_text").text()

    val aTags = currentMovie.select("div.subtext a")

    aTags.forEach(aTag => {
      if (aTag.attr("href").contains("genres")) {
        val genre = aTag.select("a").text()
        genres.addOne(genre)
      } else if (aTag.attr("href").contains("releaseinfo")) {
        val releaseDate = aTag.select("a").text()
        movie.setReleaseDate_(releaseDate)
      }
    })

    println(genres.toArray.mkString("Array(", ", ", ")"))
    movie.setRuntime_(runtime)
    movie.setSynopsis_(synopsis)
    movie.setGeneres_(genres)

    movie
  }

}