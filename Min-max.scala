object SimpleMinMaxFinder {


  def findMin(list: List[Int]): Int = {
    var min = list.head  // head is first elements
    for (num <- list) {
      if (num < min) min = num  // based on condition  it work 
    }
    min // return  Int yupe
  }

  
  def findMax(list: List[Int]): Int = {
    var max = list.head  // head first element
    for (num <- list) {
      if (num > max) max = num  //  based on condition
    }
    max
  }

 
  def main(args: Array[String]): Unit = {
    val numbers = List(5, 3, 9, 1, 7, 2)
    
    println("Original list: " + numbers.mkString(", "))  // mkString is used to omit the type like List(1, 2 ,3 )as o/p
    println("Minimum value: " + findMin(numbers))
    // Output: 1
    println("Maximum value: " + findMax(numbers)) 
    // Output: 9
  }
}
