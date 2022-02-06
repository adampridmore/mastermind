import mastermind.{Row, Score, Solver}
import mastermind.Colours
import mastermind.Colour


object GameWordle extends App with PromptUser[Char] {

  def check(checkGuess: Row[Char]): Score = {
    val(red, white) = askUser(checkGuess)

    Score(red, white)
  }

  val allChars = ('A' to 'Z').toList

  val solution = new Solver().solve(check, allChars)

  println(s"I think you picked: $solution")
}
