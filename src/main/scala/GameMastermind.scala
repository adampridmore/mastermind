import mastermind.{Row, Score, Solver}
import mastermind.Colours
import mastermind.Colour

trait PromptUser[T] {
  def askUser(checkGuess: Row[T]) : (Int, Int) = {
    println("My guess is:")
    println(checkGuess)
    val scoreText = scala.io.StdIn.readLine("How many did I get right?     [r],[w]")
    println(scoreText)

    val split = scoreText.split(",").toList

    split match {
      case a::b::nil => (a.toIntOption, b.toIntOption) match {
        case (Some(a), Some(b)) => (a,b)
        case _ => {
          println("Not a valid answer")
          askUser(checkGuess)
        }
      }
      case _ => {
        println("Not a valid answer")
        askUser(checkGuess)
      }
    }
  }
}


object GameMastermind extends App with PromptUser[Colour] {

  def check(checkGuess: Row[Colour]): Score = {
    val(red, white) = askUser(checkGuess)

    Score(red, white)
  }

  val solution = new Solver().solve(check, Colours.AllColours)

  println(s"I think you picked: $solution")
}
