package mastermind

import mastermind.Colours._

// Red -> Correct position &  colour
// White -> Correct colour (& NOT position)

object Solver {
  case class Solution(result: Row, iterations: Int)

  def solve(checkGuess: Row => Score): Solution = {

    def makeGuessAndFilter(remainingPerms: List[Row], iterations: Int): Solution = {

      remainingPerms match {
          // TODO - Need to write a test for this edge case
        case Nil => throw new Exception("No perms remaining. Are you sure about your last score?") // TODO ; Handle this without exception?
        case one :: Nil => Solution(one, iterations)
        case _ => {
          val guess = remainingPerms.head
          val guessScore = checkGuess(guess)
          makeGuessAndFilter(filterPermutations(guess, guessScore, remainingPerms), iterations+1)
        }
      }
    }

    makeGuessAndFilter(Permutations,0)
  }

  def filterPermutations(guess: Row, score: Score, perms: List[Row]): List[Row] = perms.collect {
    case p if Scorer.score(p, guess) == score => p
  }

  val Permutations: List[Row] = {

    for {
      a <- AllColours
      b <- AllColours
      c <- AllColours
      d <- AllColours
    } yield Row(a, b, c, d)
  }
}
