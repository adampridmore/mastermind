import mastermind.{Row, Score, Solver}
import mastermind.Colours
import mastermind.Colour


object GameWordle extends App with PromptUser[Char] {

  def assertWord(word: String) : String = {
    if (word.length() != 5) {
      throw new IllegalArgumentException(s"Invalid word length: '$word'")
    } else {
      word
    }
  }

  def allWords(x : List[Char]) : List[Row[Char]] = {
    scala.io.Source
      .fromResource("word-list.txt")
      .getLines()
      .map(assertWord)
      .map(_.toList)
      .map(Row(_))
      .toList
  }

  def check(checkGuess: Row[Char]): Score = {
    val(red, white) = askUser(checkGuess)

    Score(red, white)
  }

  val allChars = ('A' to 'Z').toList

  val solution = new Solver().solve(check, allChars, allWords)

  println(s"I think you picked: $solution")
}
