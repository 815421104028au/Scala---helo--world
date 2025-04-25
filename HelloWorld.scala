object HelloWorld {
  def main(args: Array[String]): Unit = {
    var name = "_"
    println(HelloWorld.demo(name)) // Just pass the variable
  }

  def demo(name: String): String = {  
/*when the args enter fun
then it is  considered  as immutable 
even is discribe as var keyword */

    val newName = "String"
    newName // Return the new string
  }
}
