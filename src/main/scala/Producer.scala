import akka.actor.{Actor, ActorRef}

import scala.collection.mutable

class Producer(consumer: ActorRef, queue: mutable.Queue[Int]) extends Actor {
  override def receive: Receive = {
    case message: Message => {
      println("Producer: " + message.body)
      if(queue.nonEmpty) {
        consumer ! Product(queue.dequeue())
        println("Producer: value was sent to the Consumer")
      } else {
        consumer ! "empty Queue"
      }
    }
    case _ => println("wrong type of message")

  }
}
