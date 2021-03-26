import scala.collection.mutable.ListBuffer

object Listings {
  var movies: ListBuffer[Movie] = ListBuffer()

  try {
    movies = Scraper.getMovies
  } catch {
    case exc: Exception => {
      println(exc.getMessage)
    }
  }

  private def listingHeader(): Unit = {
      println("\n=============================================================================================");
      println("\t\t\t\t\t\t\t\tTop Rated Movies of All Time");
      println("=============================================================================================");
  }

  def showAll(): Unit = {
    listingHeader()

    var i = 0
    for(i <- i until movies.size) {
      val title: String = movies(i).getTitle
      val moreInfoLink: String = movies(i).getMoreInfoLink

      printf("%d. %s (%s)%n", i + 1, title, moreInfoLink)
    }
  }

}