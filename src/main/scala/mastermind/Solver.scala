package mastermind

import mastermind.Colours._

// Red -> Correct position &  colour
// Red -> Correct colour (& NOT position)

object Solver {
  def solve(checkGuess: Row => Score): Row = {

    def makeGuessAndFilter(remainingPerms: List[Row]): List[Row] = {
      val guess = remainingPerms.head
      val guessScore = checkGuess(guess)

      guessScore match {
        case Score(4, 0) => List(guess)
        case _ => makeGuessAndFilter(filterPermutations(guess, guessScore, remainingPerms))
      }
    }

    makeGuessAndFilter(Permutations).head
  }

  def filterPermutations(guess: Row, score: Score, perms: List[Row]): List[Row] = perms.collect {
    case p if Scorer.score(p, guess) == score => p
  }

  val Permutations: List[Row] = {
    val allColours = List(Red, Green, Orange, Yellow, Black, White)

    for {
      a <- allColours
      b <- allColours
      c <- allColours
      d <- allColours
    } yield Row(a, b, c, d)
  }
}
