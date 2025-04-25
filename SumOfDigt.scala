object  sum{
def s(a: Int): Int={
var digit =0
var s = a // reassign is necessary 
var sum = 0 // require for return type
while(s!=0){

var f= s % 10 //last digit comes to calculate
sum =digit +f //Calculate
s = s / 10     //update the s: int
}
return sum

}
def main (ards:Array[String ]): Unit ={
val a = 1554
println(s(a)) //fun call 
}
}
