package mastermind

import mastermind.Colours._

// Red -> Correct position &  colour
// Red -> Correct colour (& NOT position)

object Solver {
  def solve(guess: Row, score: Score, perms: List[Row]): List[Row] = perms.collect {
    case p if Scorer.score(p, guess) == score => p
  }

  val Permutations: List[Row] = {
    val allColours = List(Red, Green, Blue, Yellow, Black, White)

    for {
      a <- allColours
      b <- allColours
      c <- allColours
      d <- allColours
    } yield Row(a, b, c, d)
  }

}
