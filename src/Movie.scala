import scala.collection.mutable.ListBuffer

//Main Constructor
class Movie(
             private var title: String,
             private var moreInfoLink: String,
             private var runtime: String,
             private var genres: ListBuffer[String],
             private var releaseDate: String,
             private var synopsis: String) {

  // Auxiliary Constructor
  def this(title: String, moreInfoLink: String) = this(title, moreInfoLink, "", ListBuffer(), "", "")

  // Getters and Setters
  def setRuntime(newRuntime: String): Unit = this.runtime = newRuntime
  def setReleaseDate(newReleaseDate: String): Unit = this.releaseDate = newReleaseDate
  def setSynopsis(newSynopsis: String): Unit = this.synopsis = newSynopsis
  def setGeneres(collectionOfGenres: ListBuffer[String]): Unit = this.genres = collectionOfGenres

  def getTitle: String = this.title
  def getMoreInfoLink: String = this.moreInfoLink
  def getRuntime: String = this.runtime
  def getReleaseDate: String = this.releaseDate
  def getSynopsis: String = this.synopsis
  def getGenres: ListBuffer[String] = this.genres

}
