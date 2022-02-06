package mastermind

import mastermind.Colours.AllColours

// Red -> Correct position &  colour
// White -> Correct colour (& NOT position)

object Solver extends Colour {
  case class Solution(result: Row, iterations: Int)

  def makeGuess(remainingPerms: List[Row]) = {
    def pickFirst = remainingPerms.head
    def pickMiddle = remainingPerms(remainingPerms.length / 2)
    def pickOneThird = remainingPerms(remainingPerms.length / 3)

    pickOneThird
  }

  def solve(checkGuess: Row => Score, allChoices : List[Colour]): Solution = {

    def makeGuessAndFilter(remainingPerms: List[Row], iterations: Int): Solution = {

      remainingPerms match {
          // TODO - Need to write a test for this edge case
        case Nil => throw new Exception("No perms remaining. Are you sure about your last score?") // TODO ; Handle this without exception?
        case one :: Nil => Solution(one, iterations)
        case _ => {
          val guess = makeGuess(remainingPerms)
          val guessScore = checkGuess(guess)
          makeGuessAndFilter(filterPermutations(guess, guessScore, remainingPerms), iterations+1)
        }
      }
    }

    makeGuessAndFilter(AllPermutations(allChoices),0)
  }

  def filterPermutations(guess: Row, score: Score, perms: List[Row]): List[Row] = perms.collect {
    case p if Scorer.score(p, guess) == score => p
  }

  def AllPermutations(allChoices : List[Colour]) : List[Row] = for {
    a <- allChoices
    b <- allChoices
    c <- allChoices
    d <- allChoices
  } yield Row(a, b, c, d)
}
