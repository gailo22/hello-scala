package hello.dp.singleton

object Singleton {
  
  private val instance: Singleton = new Singleton
  def getInstance() = instance

}

class Singleton private() // private constructor

object App {

  val s = Singleton.getInstance()

}