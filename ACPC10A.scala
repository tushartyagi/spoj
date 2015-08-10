import scala.io.StdIn


object Main {
  def main(args: Array[String]): Unit = {
    var eof = false

    while(!eof) {
      val s = StdIn.readLine
      if (allZeros(s)) eof = true
      else {
        val parts = s.split("\\s")
        val a = parts(0).toInt
        val b = parts(1).toInt
        val c = parts(2).toInt

        if(c - b == b - a) {
          println("AP " + (c + (b - a)))
        }
        else if (c / b == b / a) {
          println("GP " + (c * (b / a)))
        }
      }
    }


    def allZeros(s: String): Boolean = {
      s.split("\\s").forall(_ == "0")
    }
  }
}
