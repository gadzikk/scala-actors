import akka.actor.{ActorSystem, Props}

import scala.collection.mutable

object Main {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("ActorSystem")
    val queue: mutable.Queue[Int] = mutable.Queue(1,2,3,4,5,6,7,10,12,40,22)
    val consumer = system.actorOf(Props(new Consumer()))
    val producer = system.actorOf(Props(new Producer(consumer, queue)))
    producer ! Message("start")

  }

}
