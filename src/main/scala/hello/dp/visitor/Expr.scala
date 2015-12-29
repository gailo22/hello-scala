package hello.dp.visitor

sealed abstract class Expr
case class Num(n: Int) extends Expr
case class Sum(l: Expr, r: Expr) extends Expr

object App {

  def prettyPrint(e: Expr): Unit = e match {
    case Num(n) => print(n)
    case Sum(l, r) => prettyPrint(l); print(" + "); prettyPrint(r)
  }

  def eval(e: Expr): Int = e match {
    case Num(n) => n
    case Sum(l, r) => eval(l) + eval(r)
  }

  def main(args: Array[String]) = {
    val e1 = Sum(Sum(Num(1), Num(2)), Num(3))
    prettyPrint(e1)
    print(" \n" + eval(e1))
    ()
  }

}
