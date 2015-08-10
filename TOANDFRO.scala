import scala.io.StdIn

object TOANDFRO {
  def main(args: Array[String]): Unit = {
    var eof = false

    while(!eof) {
      val columnCount = StdIn.readLine.toInt
      if (columnCount == 0) eof = true
      else {
        val encryptedMessage = StdIn.readLine
        val parts: List[String] = createParts(encryptedMessage, columnCount)
        val reversed: List[String] = reverseAlternate(parts)
        val decryptedMessage: String = decryptList(reversed)
        println(decryptedMessage)
      }
    }
  }

  def createParts(s: String, l: Int): List[String] = {
    if (s.length > l) {
      val parts = s.splitAt(l)
      parts._1 :: createParts(parts._2, l)
    }
    else s :: List()
  }

  def reverseAlternate(l: List[String]): List[String] = {
    // There's this easy way of doing list operation, but as -
    // of now I am here to learn
    // for(i <- 0 until l.length) { }
    reverseAlternateR(l.head, l.tail.head, l.tail.tail)
  }

  def reverseAlternateR(first: String, second: String, tail: List[String]): List[String] = {
    if (tail.isEmpty ) {
      first :: second.reverse :: List()
    } else if (tail.length == 1) {
      first :: second.reverse :: tail
    }
    else {
      first :: second.reverse :: reverseAlternateR(tail.head, tail.tail.head, tail.tail.tail)
    }
  }

  def decryptList(l: List[String]): String = {
    var currentCount = 0
    val columnCount = l(0).length // These are padded to be equal always
    val message = new StringBuilder()
    for (column <- 0 until columnCount) {
      l.foreach((s) => { message.append(s(column)) })
    }
    message.toString
  }
}
