package traitTemplate

/** @author Chaojay
  * @since 2018-12-14 10:00
  */
// 7、特质中的具体字段
trait Logger7 {
  def log(msg: String)
}

trait ConsoleLogger7 extends Logger7 {
  def log(msg: String) {
    println(msg)
  }
}

trait ShortLogger7 extends Logger7 {
  val maxLength = 15  // 具体字段
  abstract override def log(msg: String) {
    super.log(if (msg.length <= maxLength) msg else s"${msg.substring(0, maxLength - 3)}...")
  }
}

class Account7 {
  protected var balance = 0.0
}

class DrawAccount7 extends Account7 with ConsoleLogger7 with ShortLogger7 {
  var interest = 0.0
  def withdraw(amount: Double) {
    if (amount > balance) log("余额不足")
    else balance -= amount
  }
}

object Main7 extends App {
  val acct = new DrawAccount7
  acct.withdraw(100)
  println(acct.maxLength)
}

