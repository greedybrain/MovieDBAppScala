import java.util.Locale;
import java.util.Scanner;
import util.control.Breaks._

object CLI {
  val scanner = new Scanner(System.in)

  def getUserChoice: Int = {
    var userChoice: Int = 0

    //todo Listings.showAll()
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

  private def doesUserWantNewMovieDetails: Unit = {
    try {
      breakable {
        while(true) {
          println("\nWould you like to check another movie? (y/n): ")
          val decision = scanner.nextLine().toLowerCase(Locale.ROOT)
          if (decision.equals("y")) {
            //todo run()
          }
          else break
        }
      }
    }
    catch {
      case exc: Exception => {
        println(exc.getMessage)
      }
    }
  }

//  def run: Unit = {
//
//  }

}

//  public static void run() throws Exception {
//    var movies = Listings.movies;
//
//    var userChoice = CLI.getUserChoice();
//    var movie = Scraper.getMovie(movies.get(--userChoice));
//
//    System.out.printf("Title: %s%n", movie.getTitle());
//    System.out.print("Genres: ");
//    if (movie.getGenres().size() > 1) movie.getGenres().forEach(genre -> System.out.printf("%s, ", genre));
//    else movie.getGenres().forEach(genre -> System.out.printf("%s", genre));
//    System.out.printf("%nRelease Date: %s%n", movie.getReleaseDate());
//    System.out.printf("Runtime: %s%n", movie.getRuntime());
//    System.out.printf("Synopsis: %s%n", movie.getSynopsis());
//    System.out.printf("More Info: %s%n", movie.getMoreInfoLink());
//
//    doesUserWantNewMovieDetails();
//  }
//
//}

