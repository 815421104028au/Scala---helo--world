
trait User {
  def username: String
  val age: Int = 33
}

trait Tweeter {
 this: User =>  // reassign this we have self type to access the trait User field
  def tweet(tweetText: String) = println(s"$username: $age  $tweetText")
}

class VerifiedTweeter(val username_ : String) extends Tweeter with User {  // We mixin User because Tweeter required it
  def username = s"real $username_" // which is simply override the User abstract method
}
object Main{
    def main(args: Array[String]) = {
      
val realBeyoncé = new VerifiedTweeter("Mark")
realBeyoncé.tweet("Today is awersome") 
println(realBeyoncé.username+" "+ realBeyoncé.age)
 }
}
