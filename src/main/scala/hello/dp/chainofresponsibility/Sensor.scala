package hello.dp.chainofresponsibility

class Sensor extends Handler[Int] {
  var value = 0
  def changeValue(v: Int) {
    value = v
    handleRequest(value)
  }
}

class Display1 extends Handler[Int] {
  def show(v: Int) = println(v)
  override def doThis(v: Int) = show(v)
  override def handlingCriteria(v: Int): Boolean = v < 4
}

class Display2 {
  def show(v: Int) = println(v)
}

// another solution , pattern specific code is kept in separate trait
trait Display2Handler extends Display2 with Handler[Int] {
  override def doThis(v: Int) = show(v)
  override def handlingCriteria(v: Int): Boolean = v >= 4
}

object App {

  def main(args: Array[String]) = {
    val sensor = new Sensor
    val display1 = new Display1
    val display2 = new Display2 with Display2Handler
    sensor.successor = display1
    display1.successor = display2
    sensor.changeValue(2)
    sensor.changeValue(4)
  }
}
