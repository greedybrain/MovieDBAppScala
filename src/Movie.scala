//Main Constructor
class Movie(
             val title: String,
             val moreInfoLink: String,
             val runtime: String,
             val genres: List[String],
             val releaseDate: String,
             val synopsis: String) {

  // State, or fields
  private var _runtime = this.runtime;
  private var _releaseDate = this.releaseDate;
  private var _synopsis = this.synopsis;
  private var _genres = this.genres;

  // Auxiliary Constructor
  def this(title: String, moreInfoLink: String) = this(title, moreInfoLink, "", null, "", "")

  // Getters and Setters
  def setRuntime_ (newRuntime: String): Unit = _runtime = newRuntime
  def setReleaseDate_ (newReleaseDate: String): Unit = _releaseDate = newReleaseDate
  def setSynopsis_ (newSynopsis: String): Unit = _synopsis = newSynopsis
  def setGeneres_ (collectionOfGenres: List[String]): Unit = _genres = collectionOfGenres

  def getTitle: String = this.title
  def getMoreInfoLink: String = this.moreInfoLink
  def getRuntime: String = this.runtime
  def getReleaseDate: String = this.releaseDate
  def getSynopsis: String = this.synopsis
  def getGenres: List[String] = this.genres

}
