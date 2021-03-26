import java.util.Locale
import java.util.Scanner
import scala.collection.mutable.ListBuffer
import util.control.Breaks._

object CLI {
  def getUserChoice: Int = {
    val scanner: Scanner = new Scanner(System.in)
    var userChoice: Int = 0

    Listings.showAll()
    breakable {
      while(true) {
        println("\nWhich movie do you want to see more details about? (Choose choice number): ")
        userChoice = scanner.nextInt()
        if (userChoice < 1 || userChoice > 250) println("Please choose a number from 1 to 250")
        else break
      }
    }
    userChoice
  }

  private def doesUserWantNewMovieDetails(): Unit = {
    try {
      val scanner: Scanner = new Scanner(System.in)
      breakable {
        while(true) {
          println("\nWould you like to check another movie? (y/n): ")
          val decision = scanner.nextLine().toLowerCase(Locale.ROOT)
          if (decision.equals("y")) {
            run()
          }
          else {
            println("Ok, bye!")
            break
          }
        }
      }
    }
    catch {
      case exc: Exception => {
        println(exc.getMessage)
      }
    }
  }

  def run(): Unit = {
    val movies: ListBuffer[Movie] = Listings.movies

    val userChoice = this.getUserChoice - 1
    val movie = Scraper.getMovie(movies.apply(userChoice))

    printf("Title: %s%n", movie.getTitle)
    print("Genres: ")
    if (movie.getGenres.size > 1) movie.getGenres.foreach(genre => printf("%s, ", genre))
    else movie.getGenres.foreach(genre => printf("%s", genre))
    printf("%nRelease Date: %s%n", movie.getReleaseDate)
    printf("Runtime: %s%n", movie.getRuntime)
    printf("Synopsis: %s%n", movie.getSynopsis)
    printf("More Info: %s%n", movie.getMoreInfoLink)

    doesUserWantNewMovieDetails()
  }

}


