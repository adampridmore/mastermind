import mastermind.{Row, Score, Scorer, Solver}
import org.scalatest.{Matchers, WordSpec}
import mastermind.Colours._

class SolverTests extends WordSpec with Matchers {
  "Mastermind Solver with 3 permutations" should {

    "give 1 possibility for a score of 3 red" in {
      val perms = List(
        Row(Red, White, Blue, Blue),
        Row(Red, Red, Red, Red)
      )
      val guess = Row(Red, White, Blue, Yellow)
      Solver.filterPermutations(guess, Score(3, 0), perms) shouldBe List(Row(Red, White, Blue, Blue))
    }
  }

  "Mastermind Solver with all permutations" should {
    "solve a game" in {
      val maker = Row(Red, Green, Blue, White)

      def checkGuess(guess: Row) : Score = {
        Scorer.score(maker, guess)
      }

      Solver.solve(checkGuess) shouldBe Row(Red, Green, Blue, White)
    }
  }
}
