package hello.dp.state

class Context {
  
  private var currentState: State = State1
  def operation = currentState.operation
  trait State {
    def operation
  }
  
  private object State1 extends State {
    def operation = { println(" State1 "); currentState = State2 }
  }
  
  private object State2 extends State {
    def operation = { println(" State2 "); currentState = State1 }
  }
}

object App {
  def main(args: Array[String]) = {
    val c = new Context
    c.operation
    c.operation
    c.operation
    ()
  }
}