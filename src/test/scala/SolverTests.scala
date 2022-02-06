import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

import mastermind.Colours._
import mastermind.{Scorer, Row, Score, Solver}
import mastermind.Colours
import mastermind.Colour

class SolverTests extends AnyWordSpec with Matchers {
  "Mastermind Solver with 3 permutations" should {

    "give 1 possibility for a score of 3 red" in {
      val perms = List[Row[Colour]](
        Row(Red, White, Orange, Orange),
        Row(Red, Red, Red, Red)
      )
      val guess = Row[Colour](Red, White, Orange, Yellow)
      new Solver().filterPermutations(guess, Score(3, 0), perms) shouldBe List(Row(Red, White, Orange, Orange))
    }
  }

  "Mastermind Solver with all permutations" should {
    "solve a game" in {
      val maker = Row[Colour](Red, Green, Orange, White)

      def checkGuess(guess: Row[Colour]) : Score = {
        Scorer.score[Colour](maker, guess)
      }

      val solution = new Solver().solve(checkGuess, Colours.AllColours)
      solution.result shouldBe Row(Red, Green, Orange, White)
      solution.iterations shouldBe 4
    }
  }

  "Solver with letters" should {
    "handle a word" in {
      val maker = Row[Char]('A','B', 'C','D')

      def checkGuess(guess: Row[Char]) : Score = {
        Scorer.score[Char](maker, guess)
      }

      // val allChars = List('A', 'B', 'C', 'D', 'E')
      val allChars = ('A' to 'Z').toList

      val solution = new Solver().solve(checkGuess, allChars)
      solution.result shouldBe Row[Char]('A','B', 'C','D')
      // solution.iterations shouldBe 4
    }

    // TODO
    // Not just 2 red 1 white,.
    // but each letter is either not in word, in word, in word and right place
    // Which massivly reduces the numbmer of guesses needed.
    "Solver for wordl also scores the result to each peg" in {

    }
  }
}
