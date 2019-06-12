import mastermind.{Row, Score, Scorer, Solver}
import org.scalatest.{Matchers, WordSpec}
import mastermind.Colours._

class SolverTests extends WordSpec with Matchers {
  "Mastermind Solver with 3 permutations" should {

    "give 1 possibility for a score of 3 red" in {
      val perms = List(
        Row(Red, White, Orange, Orange),
        Row(Red, Red, Red, Red)
      )
      val guess = Row(Red, White, Orange, Yellow)
      Solver.filterPermutations(guess, Score(3, 0), perms) shouldBe List(Row(Red, White, Orange, Orange))
    }
  }

  "Mastermind Solver with all permutations" should {
    "solve a game" in {
      val maker = Row(Red, Green, Orange, White)

      def checkGuess(guess: Row) : Score = {
        Scorer.score(maker, guess)
      }

      val solution = Solver.solve(checkGuess)
      solution.result shouldBe Row(Red, Green, Orange, White)
      solution.iterations shouldBe 4
    }
  }
}
