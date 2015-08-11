import scala.io.StdIn

object Edist {
  def main(args: Array[String]): Unit = {
    var testCaseCount = 10

    for(i <- 0 until testCaseCount) {
      val caseNumber = StdIn.readLine.toInt
      val from = StdIn.readLine
      val to = StdIn.readLine

      // The operation that finds and removes the
      // common chars in the given string
      val diffs: Tuple2[String, String] = noOp(from, to)
      // This operation finds the number of operations which will
      // replace one letter with another letter
      val replacable: Int = Math.min(diffs._1.length, diffs._2.length)
      // This operation will add or remove extra letters
      val addRemove: Int = Math.abs(diffs._1.length - diffs._2.length)
      // The total number of operations are those which replace, add
      // or remove
      println(addRemove + replacable)
    }
  }

  def noOp(from: String, to: String) = {
    new Tuple2(from.diff(to), to.diff(from))
  }
}
