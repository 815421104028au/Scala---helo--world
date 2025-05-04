import scala.collection.mutable.ArrayBuffer
class Numbers {
val num= ArrayBuffer[Int]() // cteate ArrayBuffer
} // class  is need for sime specific  behaviour like encapsulation 
object n1{
def main(args: Array[String]):Unit = {
val n =  new Numbers ()
n.num += 4;
n.num += 5;
n.num += 6;  //add elements to buffer
n.num += 7;
println(n.num)
n.num.append(8, 9, 10) //suffix multiple 
println (n.num)
n.num.prepend(1,2,3) //prefix multiple 
println(n.num)
//n.num -= 9
n.num --=Seq(9, 10) //remove all with specific 
println(n.num)
 val a = n.num.filter(x => x >= 1 && x <= 5)
  println(a)
n.num.remove(2) //remove some particular
println(n.num)
n.num.insert (2,3) //insert specific position to add element
println(n.num)
n.num.remove(0, 3) //remove multiple with specific 

println (n.num)

}
