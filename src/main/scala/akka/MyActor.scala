package akka

import scala.actors.Actor
/** @author Chaojay
  * @since 2018-12-19 17:20
  */
// 模拟两个 Actor 之间的通信

case class Message(actor: Actor, msg: String)

class MyActor1 extends Actor{
  override def act(): Unit = {
    while(true){
      receive{
        case msg: Message => if(msg.msg.equals("Hello! You are so beautiful!!")) {
          println("Hello! You are so beautiful!!")
          msg.actor ! Message(this, "Thanks! I'm Alice")
        }else if (msg.msg.equals("I'm Tony.Do you have time tonight?")) {
          println("I'm Tony.Do you have time tonight?")
          msg.actor ! Message(this, "Yeah! I have some time")
        }else if (msg.msg.equals("So,let's go!")) {
          println("So,let's go!")
          msg.actor ! Message(this, "Let' go!")
        }
        case _ =>println("default...")
      }
    }
  }
}

class MyActor2(actor: Actor) extends Actor{
  actor ! Message(this, "Hello! You are so beautiful!!")
  override def act(): Unit = {
    while (true){
      receive{
        case msg: Message => if(msg.msg.equals("Thanks! I'm Alice")){
          println("Thanks! I'm Alice")
          msg.actor ! Message(this, "I'm Tony.Do you have time tonight?")
        }else if (msg.msg.equals("Yeah! I have some time")){
          println("Yeah! I have some time")
          msg.actor ! Message(this, "So,let's go!")
        }else if (msg.msg.equals("Let's go!")){
          println("Let's go!")
        }
        case _ =>println("default...")
      }
    }
  }
}

object Main extends App{

  val actor1 = new MyActor1
  val actor2 = new MyActor2(actor1)
  actor1.start()
  actor2.start()
}
