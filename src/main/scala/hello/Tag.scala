package hello

// Compile with -optimize to eliminate boxing/unboxing in specialized
// tag methods.

class User
class Checkin
  
object Tag extends App {
  
  type Tagged[U] = { type Tag = U }
  type @@[T, U] = T with Tagged[U] // Thanks to @retronym for suggesting this type alias
    
  class Tagger[U] {
    def apply[T](t : T) : T @@ U = t.asInstanceOf[T @@ U]
  }
  
  def tag[U] = new Tagger[U]
  
  // Manual specialization needed here ... specializing apply above doesn't help
  def tag[U](i : Int) : Int @@ U = i.asInstanceOf[Int @@ U]
  def tag[U](l : Long) : Long @@ U = l.asInstanceOf[Long @@ U]
  def tag[U](d : Double) : Double @@ U = d.asInstanceOf[Double @@ U]
  
  def fetch[A](id: Int @@ A): A = null.asInstanceOf[A]

  val id = tag[Checkin](10)
    
  fetch[Checkin](id) // Compiles
  //fetch[User](id)    // Does not compile
    
  val ids = tag[User](1) :: tag[User](2) :: tag[User](3) :: Nil
    
  val users : List[(Int @@ User)] = ids       // Compiles
  //val checkins : List[Int @@ Checkin] = ids   // Does not compile
}


