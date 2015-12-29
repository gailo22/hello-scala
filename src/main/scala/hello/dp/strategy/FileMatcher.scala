package hello.dp.strategy

object FileMatcher {
  private val filesHere = (new java.io.File(".")).listFiles

  // matcher is a strategy
  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  // Strategy selection
  def filesContaining(query: String) =
    filesMatching { x => x.contains(query) } // in line strategy

  def filesRegex(query: String) =
    filesMatching(matchRegex(query)) // using a method
    
  def filesEnding(query: String) =
    filesMatching(new FilesEnding(query).matchEnding) // lifting a method
    
  // Strategies
  private def matchRegex(query: String) =
    { s: String => s.matches(query) }
  
  private class FilesEnding(query: String) {
    def matchEnding(s: String) = s.endsWith(query)
  }
}

object App {
  def main(args: Array[String]) {
    val query = args(0);
    var matchingFiles = FileMatcher.filesEnding(query)
    matchingFiles = FileMatcher.filesContaining(query)
    matchingFiles = FileMatcher.filesRegex(query)
    matchingFiles = FileMatcher.filesEnding(query)
  }
}