package hello.dp.observer

trait Subject[T] {
  self: T =>
  private var observers: List[T => Unit] = Nil
  def subscribe(obs: T => Unit) = observers = obs :: observers
  //  def unsubscribe(obs: T => Unit) = observers = observers - obs
  protected def publish = for (obs <- observers) obs(this)
}

class Sensor(val label: String) {
  var value: Double = _
  def changeValue(v: Double) = {
    value = v
  }
}

// Pattern s p e c i f i c code
trait SensorSubject extends Sensor with Subject[Sensor] {
  override def changeValue(v: Double) = {
    super.changeValue(v)
    publish
  }
}

class Display(label: String) {
  def notify(s: Sensor) =
    println(label + " " + s.label + " " + s.value)
}

object App {
  def main(args: Array[String]) = {
    val s1 = new Sensor(" s1 ") with SensorSubject
    val d1 = new Display("d1")
    val d2 = new Display("d2")
    s1.subscribe(d1.notify)
    s1.subscribe(d2.notify)
    s1.changeValue(10)
  }
}