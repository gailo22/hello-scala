package hello.dp.memento

trait Originator {
  def createMemento: Memento
  def setMemento(m: Memento)
  
  trait Memento {
    def getState[Originator]
    def setState[Originator]
  }
}
