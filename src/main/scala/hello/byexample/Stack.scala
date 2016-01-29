package hello.byexample

object Stack {
  
  abstract class Stack[A] {
    def push(x: A): Stack[A] = new NonEmptyStack[A](x, this)
    def isEmpty: Boolean
    def top: A
    def pop: Stack[A]
  }
  
  class EmptyStack[A] extends Stack[A] {
    def isEmpty = true
    def top = sys.error("EmptyStack.top")
    def pop = sys.error("EmptyStack.pop")
  }
  
  class NonEmptyStack[A](elem: A, rest: Stack[A]) extends Stack[A] {
    def isEmpty = false
    def top = elem
    def pop = rest
  }

  def isPrefix[A](p: Stack[A], s: Stack[A]): Boolean = {
    p.isEmpty ||
      p.top == s.top && isPrefix[A](p.pop, s.pop)
  }
  
  def main(args: Array[String]): Unit = {
		  val s1 = new EmptyStack[String].push("abc")
		  val s2 = new EmptyStack[String].push("abx").push(s1.top)
		  println(isPrefix[String](s1, s2))
  }

}
