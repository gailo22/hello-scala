package hello

import scala.language.higherKinds
import scalaz.syntax._

object worksheet2 {
	println("hello")                          //> hello

	trait Index[F[_]] { self =>
		def index[A](fa: F[A], i: Int): Option[A]
	}
	
	trait IndexOps[F[_], A] extends Ops[F[A]] {
		//final def index(n: Int): Option[A] = F.index(self, n)
	}
}