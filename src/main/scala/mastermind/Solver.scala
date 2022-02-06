package mastermind

class Solver[T] {
  case class Solution(result: Row[T], iterations: Int)

  def makeGuess(remainingPerms: List[Row[T]]) = {
    def pickFirst = remainingPerms.head
    def pickMiddle = remainingPerms(remainingPerms.length / 2)
    def pickOneThird = remainingPerms(remainingPerms.length / 3)

    pickOneThird
  }

  def solve(checkGuess: Row[T] => Score, allChoices : List[T]): Solution = {

    def makeGuessAndFilter(remainingPerms: List[Row[T]], iterations: Int): Solution = {

      remainingPerms match {
        // TODO - Need to write a test for this edge case & Handle this without exception?
        case Nil => throw new Exception("No perms remaining. Are you sure about your last score?") 
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

  def filterPermutations(guess: Row[T], score: Score, perms: List[Row[T]]): List[Row[T]] = perms.collect {
    case p if Scorer.score(p, guess) == score => p
  }

  def AllPermutations(allChoices : List[T]) : List[Row[T]] = for {
    a <- allChoices
    b <- allChoices
    c <- allChoices
    d <- allChoices
  } yield Row(a, b, c, d)
}
