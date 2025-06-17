// Online Scala Editor for free
// Write, Edit and Run your Scala code using Scala Online Compiler

import scala.io.StdIn._
import scala.util.Random
import scala.util.control._

object Executing {
  def main(args: Array[String]): Unit ={
    println("hello user")
    val userId = Random.nextInt(10)
    var userName = readLine()
    
    val objTheater = new Theater()
    objTheater.getAvailableScreen()
     
    val objScreen = new Screen()
   
     println("\nenter 1  screen1\nenter 2  screen3\nenter 3  screen3 ")
     val item = readInt()
     
     objScreen.getScreen(item)
    objTheater.disp(item)
     

   
    println("\n enter seat")
     val seat = readInt()
     objScreen.isAvailable(item: Int, seat: Int)
    val objTicket = new Ticket()
    objTicket.Display(userName,seat,item)

  }
}
trait Movie {

  val (m1Name, m1Du, m1Rate,m1Type) = ("LEO", 200, 3.8, "Drama")
  val (m2Name, m2Du, m2Rate,m2Type) = ("VIP", 250, 4.8, "action")
  val (m3Name, m3Du, m3Rate,m3Type) = ("A1", 350,4.5, "Comedy")
  def Displaymovie(i: Int, totSeat: Int, ShowTime: String, movie: String): Unit = {

   println(s"\nscreen id : $i TotalSeat : $totSeat show @$ShowTime A.M  Movie : $movie")
  
  }

}
class Screen extends Movie {
  /*val screenId: Int
  val seats: Int
  val movie: Movie
  val showTime: String
  val bookedSeats: Set[Int]*/
  val (s1Id, s1Seat, s1movie, s1ShoTime, s1SeatBooked) = (100, 40, m1Name, "06:00",Set(1, 3, 4, 8))
  val (s2Id, s2Seat, s2movie, s2ShoTime, s2SeatBooked) = (101, 40, m2Name, "06:00",Set(1, 5, 4, 2))
  val (s3Id, s3Seat, s3movie, s3ShoTime, s3SeatBooked) = (103, 40, m3Name, "06:00",Set(1, 8, 34, 3))
  val s1 = List(s1Id, s1Seat, s1movie, m1Du)
  val s2 = List(s2Id, s2Seat, s2movie, m2Du)
  val s3 = List(s3Id, s3Seat, s3movie, m3Du)
  val scr = List(s1, s2, s3)
  def isAvailable(item: Int, seat: Int): Unit = {
      var bookedSeats = item match{
          case 1 => s1SeatBooked //Set(1, 3, 4, 8)
          case 2 => s2SeatBooked // Set(1, 5, 4, 2)
          case 3 => s3SeatBooked //Set(1, 8, 34, 3)
          
        } 
      if(seat>0 && seat<40){
        val loop = new Breaks;
         loop.breakable{
            // var bookedSeat = Set(3, 2, 4, 5)
          for(s <- bookedSeats){
              //println(bookedSeat)
             if(seat==s){
                // print(seat+"  "+ s)
                  println(s" Trying to bookSeat ${seat} again...\nError: Seat already booked!")
                  Booking(bookedSeats: Set[Int],seat: Int);
                 loop.break
             }
                  
             }
             }
          }
         
    
  }   
  def Booking(bookedSeats: Set[Int],seat: Int): Unit ={
      /*var bookedSeat = item match{
          case 1 => s1SeatBooked //Set(1, 3, 4, 8)
          case 2 => s2SeatBooked // Set(1, 5, 4, 2)
          case 3 => s3SeatBooked*/
      for(a <-bookedSeats){
      if(seat != a){
          print(s"$seat   $a")
           var bb = bookedSeats + seat;
       //print(seat) 
      }else{
       //var bb = bookedSeats + seat;
      // bb.foreach(println)
       //for(d <- bb) {
        print(s"booked seats : $a ")
        //         }
      }
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
class Ticket extends Screen {
  /*val ticketId: Int
  val screen: Screen
  val seatNumber: Int
  val price: Double
  val user: User*/
 // println("enter seat no")
 // val Seat = readInt()
  def i = Random.nextInt(10)
 /* println("enter 1 | 2 | 3 to chose movie")
  val it = readInt()
 
  }*/
  def Display(userName: String, seat: Int,item: Int): Unit = {
       var movie: String = item match{
      case 1=> s1movie;
      case 2 =>s2movie;
      case 3=> s3movie;
      case _ => "in valid"
       }
       println(s"\nPrinting Ticket\nTicketId : $i  \nMovie: $movie \nUser: $userName \nseat: $seat")
       }
  }


           
       
       
  
  
class Theater extends Screen {
  /*val theaterId: Int
  val name: String
  val location: String
  val screens: List[Screen]*/
  val (tId, tName, tLoc, tScreen) = (8154, "RAM CENEMAS", "PBLR", scr)
  def getAvailableScreen(): Unit = {
    println(s"\nTheaterId : $tId TheaterName : $tName TheaterLocation : $tLoc ")
    for(choose <- tScreen){
        //println({bbb(1)} )
       // val choose = scala.collection.immutable.bbb

       println(s"\nScreenId:${choose(0)} No-of-seats :${choose(1)} Movie:${choose(2)} Duration: ${choose(3)}")
    }
  }

}
