package hello.dp.command

class Button(var click: (() => Unit))

trait Undoable { def undo }

class CallBack extends (() => Unit) with Undoable {
  def apply(): Unit = println(" callback ! ")
  def undo = println("undoing ! ")
}

object History {
  var commands: List[(() => Unit) with Undoable] = List()
  val undoAll = commands.foreach(_.undo)
}

object App {
  val button = new Button(() => println(" click ! "))
  button.click
}