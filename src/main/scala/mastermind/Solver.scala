package mastermind

import mastermind.Colours._

// Red -> Correct position &  colour
// White -> Correct colour (& NOT position)

object Solver {
  def solve(checkGuess: Row => Score): Row = {

    def makeGuessAndFilter(remainingPerms: List[Row]): List[Row] = {

      remainingPerms match {
          // TODO - Need to write a test for this edge case
        case Nil => throw new Exception("No perms remaining. Are you sure about your last score?") // TODO ; Handle this without exception?
        case one :: Nil => List(one)
        case _ => {
          val guess = remainingPerms.head
          val guessScore = checkGuess(guess)
          makeGuessAndFilter(filterPermutations(guess, guessScore, remainingPerms))
        }
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
