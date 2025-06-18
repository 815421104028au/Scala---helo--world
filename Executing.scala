import scala.io.StdIn._
import scala.util.Random
import scala.util.control._

object Executing {
  def main(args: Array[String]): Unit ={
    println("hello user\n your Name: ")
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
     objScreen.bookedSeats(item: Int)
     println("choose 1 for book\nchoose 2 for cancel")
     val temp =readInt()
     if(temp==1){
      objScreen.bookingSeat( objScreen.bookedSeats(item: Int),seat: Int)
     }
     else{
      objScreen.cancelSeat( objScreen.bookedSeats(item: Int),seat: Int)
     }
     if(temp==1){
    val objTicket = new Ticket()
    objTicket.Display(userName,seat,item)
     }
     else{
         println(s"\nyour $seat ticket canceled")
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

        def bookedSeats (item: Int): Set[Int] = { item match{
          case 1 => s1SeatBooked //Set(1, 3, 4, 8)
          case 2 => s2SeatBooked // Set(1, 5, 4, 2)
          case 3 => s3SeatBooked //Set(1, 8, 34, 3)
          
        }
      }
      def bookingSeat(bookedSeats: Set[Int],seat: Int): Unit = {
          if(seat>0 && seat<40){ 
    
             if(bookedSeats.contains(seat)){
            
                  println(s" Trying to bookSeat ${seat} again...\nError: Seat already booked!")
                 
             }
             else if(!bookedSeats.contains(seat)){
                 var booked = bookedSeats + seat
                 booked.foreach( i => print(s"$i "))
             }
          
      }
          
      }   
      def cancelSeat(bookedSeats: Set[Int],seat: Int): Unit = {
      if(seat>0 && seat<40){ 
    
             if(bookedSeats.contains(seat)){
            var booked = bookedSeats - seat
                 booked.foreach( i => print(s"$i "))
                 // println(s" Trying to bookSeat ${seat} again//...\nError: Seat already booked!")
                 
             }
             else {
              println ("invalid")
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
    val i = Random.nextInt(100)
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
  
  val (tId, tName, tLoc, tScreen) = (8154, "RAM CENEMAS", "PBLR", scr)
  def getAvailableScreen(): Unit = {
    println(s"\nTheaterId : $tId TheaterName : $tName TheaterLocation : $tLoc ")
    for(choose <- tScreen){
        //println({bbb(1)} )
       // val choose = scala.collection.immutable.bbb

       println(s"\nScreenId: ${choose(0)} No-of-seats: ${choose(1)} Movie: ${choose(2)} Duration: ${choose(3)}")
    }
  }

}
