package hello.byexample

object Expression {
  
  abstract class Expr {
    def isNumber: Boolean
    def isSum: Boolean
    def numValue: Int
    def leftOp: Expr
    def rightOp: Expr
  }
  
  class Number(n: Int) extends Expr {
    def isNumber: Boolean = true
    def isSum: Boolean = false
    def numValue: Int = n
    def leftOp: Expr = sys.error("Number.leftOp")
    def rightOp: Expr = sys.error("Number.rightOp")
  }
  
  class Sum(e1: Expr, e2: Expr) extends Expr {
    def isNumber: Boolean = false
    def isSum: Boolean = true
    def numValue: Int = sys.error("Sum.numValue")
    def leftOp: Expr = e1
    def rightOp: Expr = e2
  }
  
  def eval(e: Expr): Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else sys.error("unrecognized expression kind")
  }

  def main(args: Array[String]): Unit = {

    val sum = new Sum(new Number(1), new Sum(new Number(3), new Number(7)))
    println(eval(sum))
  }

}

class ExpressionOO {
  
  abstract class Expr {
    def eval: Int
    def print
  }
  
  class Number(n: Int) extends Expr {
    def eval: Int = n
    def print { Console.print(n) }
  }
  
  class Sum(e1: Expr, e2: Expr) extends Expr {
    def eval: Int = e1.eval + e2.eval
    def print {
      Console.print("(")
      //print(e1)
      Console.print("+")
      //print(e2)
      Console.print(")")
    }
  }

  class Prod(e1: Expr, e2: Expr) extends Expr {
    def eval: Int = e1.eval * e2.eval
    def print {
      // :TODO to implement}
    }
  }

}

class ExpressionCaseClass {
  
  abstract class Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr
  
  def eval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(l, r) => eval(l) + eval(r)
    case Prod(l, r) => eval(l) * eval(r)
  }
  
}

class ExpressionCaseClassAnonymous {

  abstract class Expr {
    def eval: Int = this match {
      case Number(n) => n
      case Sum(e1, e2) => e1.eval + e2.eval
    }
  }

  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr

}
