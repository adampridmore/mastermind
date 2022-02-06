import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

import mastermind.Colours._
import mastermind.{Scorer, Row, Score}

class ScorerTests extends AnyWordSpec with Matchers {
 "Mastermind Scorer" should {

   "score a perfect guess as 4 red and 0 white" in {
     val makerRow = Row(Red, Red, White, Orange)
     val breakerRow = Row(Red, Red, White, Orange)
     Scorer.score(makerRow, breakerRow) shouldBe Score(4, 0)
   }

   "score a completely wrong guess as 0 red and 0 white" in {
     val makerRow = Row(Red, Red, Red, Red)
     val breakerRow = Row(Orange, Orange, Orange, Orange)
     Scorer.score(makerRow, breakerRow) shouldBe Score(0, 0)
   }

   "score a guess as 2 red and 2 white" in {
     val makerRow = Row(Red, Red, White, Orange)
     val breakerRow = Row(Red, Orange, White, Red)
     Scorer.score(makerRow, breakerRow) shouldBe Score(2, 2)
   }

   "score a guess as 1 red and 1 white" in {
     val makerRow = Row(Red, Black, White, Yellow)
     val breakerRow = Row(White, Black, Orange, Orange)
     Scorer.score(makerRow, breakerRow) shouldBe Score(1, 1)
   }
 }
}
