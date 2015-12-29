package hello.dp.facade

trait Facade {
  type A <: SubSystemA
  type B <: SubSystemB
  
  protected val subA: A
  protected val subB: B
  
  def foo = subB.foo(subA)
  protected class SubSystemA
  protected class SubSystemB {
    def foo(sub: SubSystemA) = println(" Calling foo ")
  }
}

object FacadeA extends Facade {
  type A = SubSystemA
  type B = SubSystemB
  
  val subA: A = new SubSystemA
  val subB: B = new SubSystemB
}
