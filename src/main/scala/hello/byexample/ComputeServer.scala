package hello.byexample

import scala.concurrent._

class ComputeServer(n: Int) {
  
  private abstract class Job {
    type T
    def task: T
    def ret(x: T)
  }
  
  private val openJobs = new Channel[Job]()
  
  private def processor(i: Int) {
    while (true) {
      val job = openJobs.read
      job.ret(job.task)
    }
  }
  
  def future[A](p: => A): () => A = {
    val reply = new SyncVar[A]()
    openJobs.write {
      new Job {
        type T = A
        def task = p
        def ret(x: A) = reply.set(x)
      }
    }
    () => reply.get
  }
  
//  spawn(replicate(0, n) { processor })

}