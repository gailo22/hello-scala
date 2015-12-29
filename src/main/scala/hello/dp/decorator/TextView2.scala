package hello.dp.decorator

class TextView2(var s: String) {
  def draw = println("Drawing . . " + s)
}

trait BorderDecorator2 extends TextView2 {
  abstract override def draw = { super.draw; drawBorder }
  def drawBorder = println("Drawing border ")
}

object App2 {
  val textViewWithBorder = new TextView2("a") with BorderDecorator2
  textViewWithBorder.draw
}