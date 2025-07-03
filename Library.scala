

import scala.io.StdIn._

object Library {
  def main(args: Array[String]) = {
    println("Try programiz.pro")

    val obj = book()
    val Books = List(book(1, "The curious Incident", "Marrk Haddon", "Novels"),
      book(2, "Life of Pi", "Yaan Martel", "Fantasy"),
      book(3, "Time Travelers", "A.R. Capetta", "Adventure"),
      book(4, "The Incandescent", "Emily Tesh", "Fantasy"),
      book(5, "Tt", "Emily Tesh", "comics"))

    var disp = 1
    while (disp >= 1 && disp <= 4) {
      println("enter 1 for Display")
      disp = readInt()
      if (disp == 1) {
        val tit = Books.map(_.title)
        println("Books in Central libraryName")

        val check = (title: String) => {
          val result = if (tit.contains(title)) "Available" else "is borrowed"
          result
        }
        for (item <- Books) {
          item.Displayinfo(check(item.title))
        }
      }

      println("To Add Books in library enter 2 ")
      disp = readInt()

      val temp = obj.addBooks(Books, disp)

      def searching(temp: List[book]) = {
        println("book Name")
        val bookName = readLine()
        val r = temp.map(_.title)
        if (!r.contains(bookName)){
          println("INVALID")
        }
        else {

          for (a <- temp; if (a.title == bookName)) {
            println(a)
          }
        }



      }

      println("search book enter 3")
      disp = readInt()
      if (disp == 3) {
        searching(temp)
      }


      println("borrow the book enter 4")
      disp = readInt()

      val borrowed = obj.markAsBorrowed(temp, disp)

      println("enter 5 to return")
      disp = readInt()

      obj.markAsReturned(borrowed, disp)
      println(" Re do enter 1 to 4 / to exit enter 5")
      disp = readInt()

    }


  }


}

case class book(bookId: Int = 1000, title: String = "option", author: String = "sam", genre: String = "Fantacy") {

  def Displayinfo(is: String): book = {
    println(s"$bookId   $title  by $author [ '$is' ] $genre")
    book(bookId, title, author, genre)

  }

  def addBooks(books: List[book], disp: Int): List[book] = {
    if (disp == 2) {
      var bo = books;
      val isA = "Available"
      //  println("bo ; "+bo)

      def sample(): List[book] = {
        println(" id -> title -> author -> genre ")
        val id = readInt();
        val ti = readLine();
        val au = readLine();
        val genr = readLine()
        val tt = book(id, ti, au, genr)
        println(tt)
        bo = tt :: bo

        bo
      }

      println("Enter no-of- books")
      val items = readInt()
      for (i <- 0 to items) {
        sample()
      }

      for (a <- bo) {
        a.Displayinfo(isA)
      }

      bo
    }
    else {
      books
    }
  }
  var fTemp: List[book] = Nil
  def markAsBorrowed(collectionBook: List[book], disp: Int): List[book] = {
    if (disp == 4) {

      val dup = collectionBook;
      val item = collectionBook.map(_.title);
      println("Book name")
      val sInput = readLine()
      //for(a <- item)
//      if (!item.contains(sInput)) {
//        println("INVALID");Nil
//      }
//      else {


        if (item.contains(sInput)) {
          val newCollection = collectionBook.filterNot(x => x.title == sInput)

          val rr = newCollection.map(_.title)

          def res(tit: String): String = if (rr.contains(tit)) "AVAILABLE" else "BORROWED"

          for (item <- dup; if (item.title == sInput)) {

            println("SUCCESS")
            fTemp = item.Displayinfo(res(item.title))::fTemp

          }

          println("To Add again enter '4 'else '3'")
          val i = readInt()
          if (i == 4) {

            markAsBorrowed(newCollection: List[book], i)
          }
          fTemp
        }
        else {
          println("ERROR!\n" + sInput + " is already Borrowed or INVALID DATA")
          dup
        }
     // }

    }
      else
      {
        Nil
      }


  }

  def markAsReturned(afterBorrow: List[book], disp: Int): Unit = {
    println(afterBorrow)

    if (disp == 5) {
      if (afterBorrow == Nil) {
        println("No books to return")
      }
      val presence = "AVAILABLE"

      afterBorrow match {
        case Nil =>
        case h :: t => h.Displayinfo(presence)
          //println("After returned book status")
          markAsReturned(t, 5)
      }
    }

  }


}

