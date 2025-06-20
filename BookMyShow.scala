//

import scala.io.StdIn._
import scala.util.Random
//import scala.util.control._

object BookMyShow {
  def main(args: Array[String]): Unit ={
      var i = 1
      while(i==1||i==2||i==3){
    println("hello user\n your Name: ")
    val userId = Random.nextInt(10)
    
    var userName = readLine()

    val objTheater = new Theater()
    objTheater.getAvailableScreen()

    val objScreen = new Screen()

     println("\nenter 1 | 2 | 3 to Select screen")
     val item = readInt()

     objScreen.getScreen(item)
    objTheater.disp(item)
    

     def Buildset(): Set[Int]= { var input = readInt();if(input == 0) Set();else  Buildset() + input}
      
     
     val defaultSeats = objScreen.bookedSeats(item: Int)
     objScreen.movie(item: Int)
     println("enter 1 for book your seats")
     val temp =readInt()
     var yourSeat: Set[Int] = if(temp==1){
         println("\n enter seats\n like 2=>enter,3=>enter,0=>enter \n0 is neccessary to stop recursion")  //like 2->enter,3->enter,0->enter
          val seats = Buildset()                             //0 is neccessary to stop recursion
          println(s"Entered seats${seats.mkString(", ")}")
          objScreen.bookingSeat(defaultSeats: Set[Int],seats: Set[Int],userName: String,objScreen.movie(item: Int))
          seats
     }
     else{
         println("make further process")
         Set()
     }
     
     println("enter 2 for cancel")
     var tt =readInt()
     yourSeat = if(tt==2){
         println("\n enter seats\n like 2=>enter,3=>enter,0=>enter \n0 is neccessary to stop recursion")
         val seats = Buildset()
         println(s"seats you try to cancel ${seats.mkString(", ")}")
          objScreen.cancelSeat( defaultSeats: Set[Int],seats: Set[Int],yourSeat: Set[Int])
         seats
      } 
      else {println("OK");Set()}
     
    
    i = item
    }
  }
}
trait Movie {

  val (m1Name, m1Du, m1Rate,m1Type) = ("LEO", 200, 3.8, "Drama")
  val (m2Name, m2Du, m2Rate,m2Type) = ("VIP", 250, 4.8, "action")
  val (m3Name, m3Du, m3Rate,m3Type) = ("A1", 350,4.5, "Comedy")
  def Displaymovie(i: Int, totSeat: Int, ShowTime: String, movie: String): Unit = {

   println(s"\nYour screen id : $i TotalSeat : $totSeat show @$ShowTime A.M  Movie : $movie")

  }

}
class Screen extends Movie with Ticket {
  
  val (s1Id, s1Seat, s1movie, s1ShoTime, s1SeatBooked) = (100, 40, m1Name, "06:00",Set(1, 3, 4, 8))
  val (s2Id, s2Seat, s2movie, s2ShoTime, s2SeatBooked) = (101, 40, m2Name, "06:00",Set(1, 5, 4, 2))
  val (s3Id, s3Seat, s3movie, s3ShoTime, s3SeatBooked) = (103, 40, m3Name, "06:00",Set(1, 8, 34, 3))
  val s1 = List(s1Id, s1Seat, s1movie, m1Du)
  val s2 = List(s2Id, s2Seat, s2movie, m2Du)
  val s3 = List(s3Id, s3Seat, s3movie, m3Du)
  val scr = List(s1, s2, s3)
  
   def movie(item: Int): String = {item match{
      case 1=> s1movie//LEO
      case 2 => s2movie//VIP
      case 3=>  s3movie//A1
      case _ => "in valid"
         }
   }


        def bookedSeats (item: Int): Set[Int] = { item match{
          case 1 => s1SeatBooked //Set(1, 3, 4, 8)
          case 2 => s2SeatBooked // Set(1, 5, 4, 2)
          case 3 => s3SeatBooked //Set(1, 8, 34, 3)
          }
      }
      def bookingSeat(bookedSeats: Set[Int],seats: Set[Int],userName: String,movie: String): Unit = {
          var booked = bookedSeats
           for(seat <- seats){
         if(seat>0 && seat<40)
         {
             if(bookedSeats.contains(seat)){
             println(s" Trying to bookSeat ${seat} again...\nError: Seat already booked!")
                }
                else if(!bookedSeats.contains(seat)){
                 booked =booked + seat
                 println(s"booked seats No:$seat")
                 Display(userName: String, seat: Int,movie: String)
                 println(s"Recent seats: \n${booked.mkString(", ")}")
                }
             }
          }}
      def cancelSeat(bookedSeats: Set[Int],seats: Set[Int],yourSeat: Set[Int]): Unit = {
      for(seat <- seats){
      if(seat>0 && seat<40){
          if(bookedSeats.contains(seat)){
           println(s"you not allowed to cancel this $seat")
      }
      else if(yourSeat.contains(seat)){
          println(s"you have possiblet to cancel:\n ${yourSeat.mkString(", ")}")
            var canceled = yourSeat - seat
            println(s"canceled $seat Successfully\n remaing are ${canceled.mkString(", ")}")
             }
             else {
              println (s"invalid seat $seat to cancel")
             }}
      }
      }   


   def getScreen(item: Int): Unit ={
   if(item==1){

    Displaymovie(s1Id: Int,s1Seat: Int, s1ShoTime: String,s1movie)
  }
  else if(item==2) {

    Displaymovie(s2Id: Int,s2Seat: Int, s2ShoTime: String,s2movie)
  }
  else if(item ==3){


    Displaymovie(s3Id: Int,s3Seat: Int, s3ShoTime: String,s3movie)
  }
  else {
      println("Nothing")
  }
  }
  def disp(item: Int): Unit={
     item match{
         case 1 => println("\nbooked seat"+s1SeatBooked.mkString(", "))
         case 2 => println("\nbooked seat"+s2SeatBooked.mkString(", "))
         case 3 => println("\nbooked seat"+s3SeatBooked.mkString(", "))
     }
 }

}
trait Ticket {
    
    def Display(userName: String, seat: Int,movie: String): Unit = {
       var i = Random.nextInt(100)
       println(s"Printing Ticket\nTicketId : $i  \nMovie: $movie \nUser: $userName \nseat: $seat\n")
       }
  }
class Theater extends Screen {

  val (tId, tName, tLoc, tScreen) = (8154, "RAM CENEMAS", "PBLR", scr)
  def getAvailableScreen(): Unit = {
    println(s"\nTheaterId : $tId TheaterName : $tName TheaterLocation : $tLoc ")
    for(choose <- tScreen){
        
       println(s"\nScreenId: ${choose(0)} No-of-seats: ${choose(1)}  Movie: '${choose(2)}'  Duration: ${choose(3)}mins")
    }
  }

}
