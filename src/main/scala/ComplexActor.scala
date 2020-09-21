import akka.actor.Actor

class ComplexActor extends Actor {
  override def receive: Receive = {
    case m:Message => {
      println("complex: " + m.body)
      sender ! Confirmation("message successfully received")
    }
  }
}
