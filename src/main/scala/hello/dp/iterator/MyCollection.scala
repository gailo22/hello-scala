package hello.dp.iterator

object MyCollection {
  private var items = List(1, 2, 3)
  def foreach(f: Int => Unit) =
    for (i <- 0 to items.length - 1)
      f(items(i))
}

object App {
  
  def main(args: Array[String]) = {
	  for (i <- MyCollection)
		  println(i)
  }
}