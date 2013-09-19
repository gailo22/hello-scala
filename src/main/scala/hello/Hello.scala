package hello

object Hello {

  def main(args: Array[String]): Unit = {
    println("Hello world")
    startThread.start();
    startThread.start();
    startThread.start();
  }

  def startThread = {
    new Thread(new Runnable() {
      var i = 0
      def run() = {
        i += 1
        println("Run " + i)
      }
    })
  }

}