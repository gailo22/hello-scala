package hello.dp.flyweight

trait DrawingContext { def queryExtrinsicState }

class Character(val char: Char) {
  def draw(context: DrawingContext) = println("drawing character ")
}

object CharacterFactory extends FlyWeightFactory[Char, Character] {
  def createFlyWeight(c: Char) = new Character(c)
}

object App {
  val f1 = CharacterFactory('a')
  val f2 = CharacterFactory('b')
  val f3 = CharacterFactory('a')
}
