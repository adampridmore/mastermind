import mastermind.{Row, Score, Solver}
import mastermind.Colours
import mastermind.Colour

object Game extends App {

  def check(checkGuess: Row[Colour]): Score = {
    println("My guess is:")
    println(checkGuess)
    val scoreText = scala.io.StdIn.readLine("How many did I get right?     [r],[w]")
    println(scoreText)

    val split = scoreText.split(",")
    val red = Integer.parseInt(split(0))
    val white = Integer.parseInt(split(1))

    Score(red, white)
  }

  val solution = new Solver().solve(check, Colours.AllColours)

  println(s"I think you picked: $solution")
}
