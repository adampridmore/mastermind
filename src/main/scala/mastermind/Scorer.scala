package mastermind

import mastermind.Colours._

// Red -> Correct position &  colour
// Red -> Correct colour (& NOT position)

object Scorer {

  def score[T](makerRow: Row[T], breakerRow: Row[T]): Score = {

    def redCount =
      makerRow.pegs
        .zip(breakerRow.pegs)
        .count { case (m, b) => m == b }

    def colourCounts(row: Row[T]) = row.pegs.groupBy(identity).mapValues(_.size)

    def correctColour = {
      val breakerCounts = colourCounts(breakerRow)
      val counts = for {
        (colour, count) <- colourCounts(makerRow)
      } yield Math.min(count, breakerCounts.getOrElse(colour, 0))

      counts.sum
    }

    def whiteCount = correctColour - redCount

    Score(redCount, whiteCount)
  }
}
