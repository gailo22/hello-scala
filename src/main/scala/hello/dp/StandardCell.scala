package hello.dp

trait Cell {
  def save(x: Int)
  def retrieve
}

class StandardCell(protected var state: Int) extends Cell {
  def save(x: Int) = state = x
  def retrieve = state
}

trait Similar {
  def isSimilar(x: Int): Boolean
  def isNotSimilar(x: Int): Boolean = !isSimilar(x)
}

//val cell = new StandardCell(3) 
//  with Similar { def isSimilar(x: Int): state == x }


class StandardCell2(protected var state: Int) extends Cell 
  with Similar {
    def save(x: Int) = state = x
    def retrieve = state
    def isSimilar(x: Int) = state == x
}
