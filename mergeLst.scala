object mergeLst {  //singleton obj
  def main(args: Array[String]): Unit = {  //entry function 
    val lst1 = List(8, 6, 1)
    val lst2 = List(7, 9, 3)

    val result = (lst1 ++ lst2).sorted  //++concatenate

    println(s"Merged Sorted List: $result") //String Interpolation 
  }
}
