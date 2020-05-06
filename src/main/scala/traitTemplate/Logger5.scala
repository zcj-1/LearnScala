package traitTemplate

/** @author Chaojay
  * @since 2018-12-14 9:46
  */
// 5、在特质中重写抽象方法
trait Logger5 {
  def log(msg: String)
}

//因为有super，Scala认为log还是一个抽象方法
trait TimestampLogger5 extends Logger5 {
  abstract override def log(msg: String) {
    super.log(new java.util.Date() + " " + msg)
  }
}

trait ShortLogger5 extends Logger5 {
  abstract override def log(msg: String) {
    super.log(if (msg.length <= 15) msg else s"${msg.substring(0, 12)}...")
  }
}

trait ConsoleLogger5 extends Logger5 {
  override def log(msg: String) {
    println(msg)
  }
}

class Account5 {
  protected var balance = 0.0
}

abstract class DrawAccount5 extends Account5 with Logger5 {
  def withdraw(amount: Double) {
    if (amount > balance) log("余额不足")
    else balance -= amount
  }
}

object Main5 extends App {
  //这里可以根据12.5的知识点理解此处
  val acct1 = new DrawAccount5 with ConsoleLogger5 with TimestampLogger5 with ShortLogger5
  acct1.withdraw(100)
}

