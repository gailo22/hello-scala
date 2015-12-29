package hello.dp.bridge

trait Window {
  self: WindowImp =>

  def drawRect(x1: Int, x2: Int, x3: Int, x4: Int) = {
    drawLine(x1, x2)
    drawLine(x1, x3)
    drawLine(x2, x4)
    drawLine(x3, x4)
  }
}

// abstractions
trait TransientWindow {
  self: Window =>
  def drawCloseBox = drawRect(4, 3, 2, 1)
}

trait IconWindow {
  self: Window =>
  def drawBorder = drawRect(1, 2, 3, 4)
}

// common interface forall implementors
trait WindowImp {
  def drawLine(x: Int, y: Int)
}

// implementors
trait WindowOSX extends WindowImp {
  def drawLine(x: Int, y: Int) = println("drawing l i n e in OSX")
}

trait WindowVista extends WindowImp {
  def drawLine(x: Int, y: Int) = println("drawing l i n e in Vista ")
}

object App {

  def main(args: Array[String]) = {
    val windowOSX: Window = new Window with WindowOSX
    windowOSX.drawRect(1, 2, 3, 4)
  }
}
