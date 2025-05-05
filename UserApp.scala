// Step 1: Create the User class
class User(val id: Int, val name: String, val age: Int)
{
def show (): Unit ={
println(s"$id $name $age")
}
}

// Step 2: Create another class with main method
object UserApp {
  def main(args: Array[String]): Unit = {
  

    // Step 3: Create a List of Users
    val users = List(
      new User(1, "John", 40),
      new User(2, "Jacob", 35),
      new User(3, "Abraham", 33),
      new User(4, "Kevin", 25),
      new User(5, "Hayes", 28),
      new User(6, "Abraham", 40),
      new User(7, "Daniel", 55),
      new User(8, "Kim", 69),
      new User(9, "Lisa", 40),
      new User(10, "Jacob", 36)
    )

    // Step 4: Print all User Names
    println("All User Names:")
    for (user <- users) {
    //println(u.name)
    user.show()
    }
    

    // Step 5: Print name(s) of the oldest customer(s)
    //val maxAge = users.map(_.age).max
    println("\nOldest Customer(s):")
    //for (user <- users )
    //if (u.age == maxAge) 
    //println(u.name)
    val maxage = Int.MaxValue
    val minage = Int.MinValue 
    val max = users.foldLeft(minage){ (maxage, user) =>
   if(user.age > maxage) user.age else maxage
   }
    println(s" max age of user $max")
    for (user <- users)
    if (user.age == max)
    user.show()
    //println(user.name)
    println("\n Youngest  Customer (s):")
    val min = users.foldLeft(maxage){(minage, user) =>
    if(user.age < minage) user.age else minage
    }
     println(s" min age of user $min")
     for (user <- users)
     if (user.age == min)
     user.show()
     //println(user.name)
    // Step 6: Print name(s) of the youngest customer(s)
    //val minAge = users.map(_.age).min
    //println("\nYoungest Customer(s):")
    //for (u <- users )
    //if (u.age == minAge) 
    //println(u.name)

    // Step 7: Print names of users who are 40 years old
    println("\nCustomers aged 40:")
    for (u <- users)
    if (u.age == 40) 
    u.show()
    //println(u.name)

    // Step 8: Print all customer IDs with name "Jacob"
    println("\nCustomer IDs with name 'Jacob':")
    for (u <- users)
    if (u.name == "Jacob") 
    println(u.id)

    // Step 9: Print all customer ages with name "Abraham"
    println("\nCustomer Ages with name 'Abraham':")
    for (u <- users)
    if (u.name == "Abraham") 
    println(u.age)
  }
}
