package hello.dp

class Rational(n: Int, d: Int) {
  require(d != 0)
  
  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val demon = d / g
  
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
    
  def + (that: Rational): Rational =
    new Rational(
        numer * that.demon + that.numer * demon,
        demon * that.demon
        )
 
  def * (that: Rational): Rational =
    new Rational(numer * that.numer, demon * that.demon)
  
  override def toString = numer + "/" + demon
  
}