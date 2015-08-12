import scala.io.StdIn

object Main extends App {
  override def main(args: Array[String]): Unit = {
    var testCaseCount = StdIn.readLine.toInt

    for(i <- 0 until testCaseCount) {
      val from = StdIn.readLine
      val to = StdIn.readLine

      val edist = Levenshtein(from, to)
      println(edist)
    }
  }

  @inline def min(a: Int, b: Int, c: Int): Int = {
    Math.min(a, Math.min(b, c))
  }

  def Levenshtein(from: String, to: String): Int = {
    val fromLength = from.length
    val toLength = to.length

    if (fromLength == 0)
      toLength
    else if (toLength == 0)
      fromLength
    else {
      val matrix = Array.ofDim[Int](toLength + 1, fromLength + 1)
      // Initialize
      for(i <- 1 to fromLength) matrix(0)(i) = i
      for(i <- 1 to toLength) matrix(i)(0) = i

      // Calculate matrix
      for {
        i <- 1 to fromLength
        j <- 1 to toLength
      } {
        val cost = if (from(i-1) == to(j-1)) 0 else 1
        val upper = matrix(j)(i-1) + 1
        val previous = matrix(j-1)(i) + 1
        val diagonal = matrix(j-1)(i-1) + cost
        matrix(j)(i) = min(upper, previous, diagonal)
      }

      val edist = matrix(toLength)(fromLength)
      edist
    }
  }
}
