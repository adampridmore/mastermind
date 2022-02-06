import mastermind.{Row, Score, Scorer, Solver}
import mastermind.Colours
import mastermind.Colour

object PerformanceTest extends App {
  def testPermutation(maker: Row[Colour]): Int = {

    def checkGuess(guess: Row[Colour]): Score = {
      Scorer.score(maker, guess)
    }

    val solution = new Solver[Colour]().solve(checkGuess, Colours.AllColours)

    solution.iterations
  }

  val result = new Solver[Colour]().defaultAllPermutations(Colours.AllColours)
    .map(perm => (perm, testPermutation(perm)))
    .groupBy(a => a._2)
    .map(a => (a._1, a._2.length))
    .toSeq
    .sortBy(a => -1 * a._1)

  val averageIterations = result.map { 
    case (a, b) => a * b 
  }
  .sum
  .floatValue / new Solver().defaultAllPermutations(Colours.AllColours).length.floatValue


  println("Iterations for all permutations (iterations, number of maker's):")
  println(result.mkString("\n"))
  println(s"Score:$averageIterations")
}
