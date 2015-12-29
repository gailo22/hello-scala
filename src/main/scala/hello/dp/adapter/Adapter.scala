package hello.dp.adapter

trait Target {
  def f
}

class Adaptee {
  def g = println("g")
}


trait Adapter {
  self: Target with Adaptee =>
  def f = g
}

object App {
  
  def main(args: Array[String]) = {
    val adapter = new Adaptee with Adapter with Target
    adapter.f
    adapter.g
    ()
  }
}