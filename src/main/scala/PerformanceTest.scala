import mastermind.{Row, Score, Scorer, Solver}

object PerformanceTest extends App {
  def testPermutation(maker: Row): Int = {

    def checkGuess(guess: Row): Score = {
      Scorer.score(maker, guess)
    }

    val solution = Solver.solve(checkGuess)

    solution.iterations
  }

  val result = Solver.Permutations
    .map(perm => (perm, testPermutation(perm)))
    .groupBy(a => a._2)
    .map(a => (a._1, a._2.length))
    .toSeq
    .sortBy(a => -1 * a._1)

  val averageIterations = result.map { case (a, b) => a * b }.sum.floatValue / Solver.Permutations.length.floatValue


  println("Iterations for all permutations (iterations, number of maker's):")
  println(result.mkString("\n"))
  println(s"Score:$averageIterations")
}
