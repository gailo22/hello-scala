package hello.byexample

object Factorial extends App {
  
  def factorial(n: Int): Int = 
    if (n == 0) 1 else n * factorial(n - 1)
    
  def factorialTC(n: Int): Int = {
		def loop(n: Int, acc: Int): Int =
				if (n == 0) acc
				else loop(n - 1, n * acc)
		loop(n, 1)
  }
  
  println(factorial(5))
  println(factorialTC(5))
  
}