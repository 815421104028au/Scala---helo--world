import scala.collection .mutable.ArrayBuffer
import scala.collection.Seq
object Main {
def main(args: Array[String] ): Unit = {
val a = ArrayBuffer[Int]()
val b = ArrayBuffer (55, 65, 75)
println(a)
a ++= b

println("1 \n "+a.mkString (" "))
a ++= Array[Int](2, 3, 4, 7)
println ("2 \n "+a.mkString (" "))
a ++= Seq(5, 6, 8, 9)
println ("3 \n "+a.mkString (" "))
a ++= List (11, 33, 23, 14)
println ("4 \n "+a.mkString(" "))
a ++= Vector(76, 63, 36, 73)
println("5 \n "+a.mkString (" "))
//a ++= Map((37, 2),(24, 63), (62, 64),(2, 5))
println("6 \n "+a.mkString(" "))
a -= 76 -= 11
println ("7  ")
a.mkString (" ").foreach (print)
a --= Vector(33, 14)
println("\n8  ")
a.mkString (" ").foreach (print)
println ("\n9  ")
a --= List(5, 9, 2);a.mkString (" ").foreach (print);println ("\n10 ")
a --= Seq(76, 36);a.mkString (" ").foreach(print)
val index = a.indexOf(6)//find
if(index != -1)
{
a.insertAll(index, Seq(99, 100, 101))
println(" \n find and isert")
}
a.mkString (" ").foreach (print)
a.update (0, 100)
println(" \n "+a.mkString (" "))
println("11 \n"+a(2))
if(a.length > 0)
{
a(1) = 22
println (" 13 \n   "+a)
}
//var c = scala.collection.Seq[Int] 
val c = a.containsSlice(ArrayBuffer (100, 22))
println (" \n14 "+c)


a.clear()
println ("\n15 "+a)
}
}
