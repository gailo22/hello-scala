package hello

import java.util.Timer
import java.util.TimerTask

import scala.concurrent._

object TimedEvent {
  val timer = new Timer

  def delayedSuccess[T](secs: Int, value: T): Future[T] = {
    val result = Promise[T]
    timer.schedule(new TimerTask() {
      def run() = {
        result.success(value)
      }
    }, secs * 1000)
    result.future
  }

  def delayedFailure(secs: Int, msg: String): Future[Int] = {
    val result = Promise[Int]
    timer.schedule(new TimerTask() {
      def run() = {
        result.failure(new IllegalArgumentException(msg))
      }
    }, secs * 1000)
    result.future
  }
}