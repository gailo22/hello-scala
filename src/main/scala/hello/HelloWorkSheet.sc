import scala.collection.mutable.ListBuffer

object HelloWorkSheet1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def loop(x: Int, y: Int) = x + y                //> loop: (x: Int, y: Int)Int
  
  println(loop(2 ,3))                             //> 5
  
  // remove element from List
  List(1,2,3,4,5) diff List(4)                    //> res0: List[Int] = List(1, 2, 3, 5)
  
  ListBuffer(1,2,3,4,5) - 4                       //> res1: scala.collection.mutable.ListBuffer[Int] = ListBuffer(1, 2, 3, 5)

}