object fibo {
  def fibonacci(n: Int): Int = {
  var a = 0
  var b = 1
  for (_ <- 1 to n) { //_represent the a = 0
    val c = a + b
    a = b
    b = c
  }
  a
}

def main (args: Array[String] ):Unit = {
// Print Fibonacci numbers from 0 to 10
(0 to 10).map(fibonacci).foreach(println)
  //map computes the fibonacci and foreach print
}
}
