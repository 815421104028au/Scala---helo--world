object Exercise {
  def main(args: Array[String]): Unit = {

    // Step 2: Create a Map with student ID and Name
    var stdMap = Map(
      1 -> "John",
      2 -> "Jacob",
      3 -> "Abraham",
      4 -> "Kevin",
      5 -> "Hayes"
    )

    //  Print all keys and values
    println("All Student id Names:")
    for((id, name)<- stdMap){
    println(id)
    println(name)
    }

    //  Update name of student with ID 2
    stdMap += (2 -> "Stephen") //this  will not allow when tuple is immutable 
    println("\nAfter Updating ID 2 to Stephen:")
    stdMap.values.foreach(println)

    // Add new student (ID 6 -> Titus)
    stdMap = stdMap + (6 -> "Titus")// this is allow tuple is immutable 
    println("\nAfter Adding ID 6 -> Titus:")
    stdMap.values.foreach(println)

    //  Remove student with ID 2
    stdMap -= 2
    println("\nAfter Removing ID 2:")
    
    for((id, name) <- stdMap){
    println(s"$id $name");
    }

    // Step 7: Print name of student with ID 3
    println("\nStudent with ID 3:")
    val result = stdMap.find(_._2 == "Kevin")//we can use find  gives one op or filter gives continue
    .map(_._1)
    println (result)
  }
}
