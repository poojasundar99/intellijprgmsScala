package Futures

import java.time.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration._
import scala.language.postfixOps

object Future1 extends App
{

  implicit val ec = ExecutionContext.global

  val f = Future{
    println("First Future"+Thread.currentThread().getName)
    22
  }
  val f1 = Future{
    println("Second Future "+Thread.currentThread().getName)
    1233
  }
  println(f1)

  val ob = Await.ready(f, 0 nanos) //Future[Try] O/P
  println(ob)

//  val obj = Await.result(f1,1 nanos) //Future oda value return
//  println(obj)




}
