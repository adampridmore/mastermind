import mastermind.{Row, Score, Solver}
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
      Solver.solve(guess, Score(3, 0), perms) shouldBe List(Row(Red, White, Blue, Blue))
    }
  }
}
