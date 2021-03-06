package hello.byexample

object Nat {

  abstract class Nat {
    def isZero: Boolean
    def predecessor: Nat
    def successor: Nat
    def +(that: Nat): Nat
    def -(that: Nat): Nat
  }

  object Zero extends Nat {
    def isZero: Boolean = true
    def predecessor: Nat = sys.error("negative number")
    def successor: Nat = new Succ(Zero)
    def +(that: Nat): Nat = that
    def -(that: Nat): Nat = if (that.isZero) Zero
                            else sys.error("negative number")
  }

  class Succ(x: Nat) extends Nat {
    def isZero: Boolean = false
    def predecessor: Nat = x
    def successor: Nat = new Succ(this)
    def +(that: Nat): Nat = x + that.successor
    def -(that: Nat): Nat = if (that.isZero) this
                            else x - that.predecessor
  }

}