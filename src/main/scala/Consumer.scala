import akka.actor.Actor

class Consumer extends Actor {
  override def receive: Receive = {
    case product:Product => {
      println("Consumer: " + product.value + " received")
      Thread.sleep(3000)
      sender ! Message("give me more!")
    }
    case "empty Queue" => println("Consumer: thank you for handling all my requests!")
  }
}
