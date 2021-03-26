import scala.collection.mutable.ListBuffer

//Main Constructor
class Movie(
             private var title: String,
             private var moreInfoLink: String,
             private var runtime: String,
             private var genres: ListBuffer[String],
             private var releaseDate: String,
             private var synopsis: String) {

  // State, or fields

  // Auxiliary Constructor
  def this(title: String, moreInfoLink: String) = this(title, moreInfoLink, "", null, "", "")

  // Getters and Setters
  def setRuntime_ (newRuntime: String): Unit = this.runtime = newRuntime
  def setReleaseDate_ (newReleaseDate: String): Unit = this.releaseDate = newReleaseDate
  def setSynopsis_ (newSynopsis: String): Unit = this.synopsis = newSynopsis
  def setGeneres_ (collectionOfGenres: ListBuffer[String]): Unit = this.genres = collectionOfGenres

  def getTitle: String = this.title
  def getMoreInfoLink: String = this.moreInfoLink
  def getRuntime: String = this.runtime
  def getReleaseDate: String = this.releaseDate
  def getSynopsis: String = this.synopsis
  def getGenres: ListBuffer[String] = this.genres

}
