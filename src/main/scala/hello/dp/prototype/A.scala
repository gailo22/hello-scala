package hello.dp.prototype


class CloneA(a: A) {
  def copy = new A(a.state)
}

class A(var state: Int)

object App {
  
	implicit def cloneA(a: A): CloneA = new CloneA(a)
  
	def main(args: Array[String]) = {
		def a = new A(2)
		println(a.state)
		
		def aCopy = a.copy
		println(a.state)
		
	}
  
}