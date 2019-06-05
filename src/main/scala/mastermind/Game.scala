package mastermind

import scala.util.Random

object Game extends App {
  val masterPegs = Solver.Permutations(Random.nextInt(Solver.Permutations.length))

  println("Shhh my pegs are:")
  println(masterPegs)

  println("Please enter a colour guess: Red, White, Orange, Yellow, Black, Green")
  
  val guess = scala.io.StdIn.readLine("What is your guess?")

  val colours = guess.split(",").map(_.trim)
  val guessRow = Row(colours.toList.map(Colour(_)))

  println("Your score is: " + Scorer.score(masterPegs, guessRow))
}
