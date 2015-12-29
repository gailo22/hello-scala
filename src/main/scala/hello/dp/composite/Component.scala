package hello.dp.composite

sealed abstract class Component {
  def display
}

case class Text(var text: String) extends Component {
  def display = println(text)
}

case class Picture(var picture: String) extends Component {
  def display = println(picture)
}

case class Composite(var children: List[Component]) extends Component {
  def display = children.foreach(x => x.display)
}

object App {
  def main(args: Array[String]) = {
    val tree =
      Composite(List(Composite(List(Text(" t1 "), Picture("p1"))), Text(" t2 ")))
    tree.display
    tree.children(1).display
  }

  def changeAllText(c: Component, s: String): Component = c match {
    case tx @ Text(v) => {
      tx.text = s
      tx
    }
    case p @ Picture(v) => p
    case c @ Composite(cs) => {
      c.children =
        for {
          c <- cs
          cnew = changeAllText(c, s)
        } yield cnew
      c
    }
  }

}