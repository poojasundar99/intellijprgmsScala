package Futures

import java.lang
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, Future}

object SampleFuture extends App
{

  class FutureExample extends ExecutionContext {

      override def execute(runnable: Runnable): Unit ={
        println("Execution context " +Thread.currentThread().getName)
        new Thread(runnable).start()
        println("Thread " +Thread.currentThread().getName)
      }
      override def reportFailure(cause: Throwable): Unit = ???
    }

  implicit val ec: ExecutionContext = new FutureExample
  println("Thread name " +Thread.currentThread().getName)

  val future: Future[Int] = Future {
    println("Future " + Thread.currentThread().getName)
    Thread.sleep(1000)
    22
  }

  Thread.sleep(3000)
  println(future)


}
