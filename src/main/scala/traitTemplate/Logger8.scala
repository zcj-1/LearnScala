package traitTemplate

/** @author Chaojay
  * @since 2018-12-14 10:03
  */
// 8、特质中的抽象字段
trait Logger8 {
  def log(msg: String)
}

trait ConsoleLogger8 extends Logger8 {
  def log(msg: String) {
    println(msg)
  }
}

trait ShortLogger8 extends Logger8 {
  val maxLength: Int    // 抽象字段  在子类中必须被重写

  abstract override def log(msg: String) {
    super.log(if (msg.length <= maxLength) msg else s"${msg.substring(0, maxLength - 3)}...")
  }
}

class Account8 {
  protected var balance = 0.0
}

abstract class DrawAccount8 extends Account8 with Logger8{
  var interest = 0.0

  def withdraw(amount: Double) {
    if (amount > balance) log("余额不足")
    else balance -= amount
  }
}

object Main8 extends App {
  val acct = new DrawAccount8 with ConsoleLogger8 with ShortLogger8 {
    val maxLength = 20  // 重写抽象字段并赋值
  }
  acct.withdraw(100)
  println(acct.maxLength)
}

