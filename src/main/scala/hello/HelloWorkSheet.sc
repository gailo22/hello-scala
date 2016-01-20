import scala.collection.mutable.ListBuffer
import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object HelloWorkSheet1 {
  
  def loop(x: Int, y: Int) = x + y                //> loop: (x: Int, y: Int)Int
  
  println(loop(2 ,3))                             //> 5
  
  // remove element from List
  List(1,2,3,4,5) diff List(4)                    //> res0: List[Int] = List(1, 2, 3, 5)
  
  ListBuffer(1,2,3,4,5) - 4                       //> res1: scala.collection.mutable.ListBuffer[Int] = ListBuffer(1, 2, 3, 5)
  
  
  def f(n: Int): Future[Int] = Future(n + 1)      //> f: (n: Int)scala.concurrent.Future[Int]
  def g(n: Int): Future[Int] = Future(n - 1)      //> g: (n: Int)scala.concurrent.Future[Int]
  
  val n = f(42).flatMap(g)                        //> n  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$DefaultPro
                                                  //| mise@3830b652
  assert(Await.result(n, 1.second) == 42)
  
  def h(n: Int): Future[Int] = Future(n * 2)      //> h: (n: Int)scala.concurrent.Future[Int]
 
	val m = for {
	  m1 <- f(42)
	  m2 <- g(m1)
	  m3 <- h(m2)
	} yield m3                                //> m  : scala.concurrent.Future[Int] = scala.concurrent.impl.Promise$DefaultPro
                                                  //| mise@107ad736
	assert(Await.result(m, 1.second) == 84)

}