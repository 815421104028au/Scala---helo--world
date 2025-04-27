object demo {
var arr = List(2,5,7,8,3,6,1)
var lst = arr.toArray
//var lst = tenlst.toArray
def main(args: Array[String ]): Unit  ={
for(i <- 0 until lst.length) {
for (j <- i + 1 until lst.length)
{
 if (lst(i) > lst(j)) {
var temp= lst(i)
lst(i) = lst(j)
lst(j) = temp
}
}
}
var list = lst.toList
println(list)
println(lst.mkString(", "))

for(i <- 0 until lst.length) {
for (j <- i + 1 until lst.length)
{
 if (lst(i) < lst(j)) {
var temp= lst(i)
lst(i) = lst(j)
lst(j) = temp
}
}
}
var reverse = lst.toList
println (" \n reverse")
println(reverse)
println(lst.mkString(", "))
}
//println(list)tem
}
