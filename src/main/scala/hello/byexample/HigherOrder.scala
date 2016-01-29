package hello.byexample

object NotHigherOrder {
  
  def sumInts(a: Int, b: Int): Int =
    if (a > b) 0 else a + sumInts(a + 1, b)
    
  def square(x: Int): Int = x * x
  
  def sumSquares(a: Int, b: Int): Int =
    if (a > b) 0 else square(a) + sumSquares(a + 1, b)

  def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)
  
  def sumPowersOfTwo(a: Int, b: Int): Int =
    if (a > b) 0 else powerOfTwo(a) + sumPowersOfTwo(a + 1, b)
    
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f, a + 1, b)
    
}

object HigherOrder {
  
  def id(x: Int): Int = x
  def square(x: Int): Int = x * x
  def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)
  
  def sumInts(a: Int, b: Int): Int = sum(id, a, b)
  def sumSquares(a: Int, b: Int): Int = sum(square, a, b)
  def sumPowersOfTwo(a: Int, b: Int): Int = sum(powerOfTwo, a, b)
  
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f, a + 1, b)
  
}

object Anonymous {
  
  def sumInts(a: Int, b: Int): Int = sum(x => x, a, b)
  def sumSquares(a: Int, b: Int): Int = sum(x => x * x, a, b)
  
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f, a + 1, b)
  
}

object Currying {
  
  def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)
  
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sumF(a + 1, b)
    sumF
  }
  
  def sumCurry(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sumCurry(f)(a + 1, b)
  
  def sumInts = sum(x => x)
  def sumSquares = sum(x => x * x)
  def sumPowersOfTwo = sum(powerOfTwo)
  
  val sumIntsVal = sum(x => x)
  val sumSquaresVal = sum(x => x * x)
  val sumPowersOfTwoVal = sum(powerOfTwo)
}