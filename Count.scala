object charOccurrenceCounter {
  def main(args: Array[String]): Unit = {
    val text = "this my Character occurrenceCounter"
    val targetChar = 'r'  // Character to count

    val count = text.count(_ == targetChar) //built function 

    println(s"Text: $text")
    println(s"Character :'$targetChar' \noccurs : $count times.")
  }
}
