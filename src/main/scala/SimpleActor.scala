import akka.actor.{Actor, ActorRef}

class SimpleActor(complexActor: ActorRef, name: String) extends Actor {
  override def receive: Receive = {
    case m:Message =>
      println("simpleActor message:  " + m.body)
      complexActor ! m
    case c:Confirmation =>
      Thread.sleep(3000)
      println("simpleActor: ok!")
    case _ => println("'not a message', %s".format(name))
  }
}
