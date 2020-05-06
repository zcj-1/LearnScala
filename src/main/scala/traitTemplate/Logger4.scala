package traitTemplate

/** @author Chaojay
  * @since 2018-12-13 12:09
  */
/**
  * 叠加特质:动态混入的多个特质继承了同一个特质，并且实现了共同方法
  * 特征：
  *         1）动态混入叠加特质时，是从右向左执行
  *         3）此时super关键字表示为向左调用特质
  *         4）当左边没有特质时，super调用父特质中的方法
  */
trait Logger4 {
  def log(msg: String);
}

trait ConsoleLogger4 extends Logger4 {
  def log(msg: String) {
    println(msg)
  }
}

trait TimestampLogger4 extends ConsoleLogger4 {
  override def log(msg: String) {
    super.log(new java.util.Date() + " " + msg)
  }
}

trait ShortLogger4 extends ConsoleLogger4 {
  override def log(msg: String) {
    super.log(if (msg.length <= 15) msg else s"${msg.substring(0, 12)}...")
  }
}

/**
  * TimestampLogger4 与 ShortLogger4 两个特质都继承了 ConsoleLogger4 特质，并且都实现了 log 方法
  */
class Account4 {
  protected var balance = 0.0
}

abstract class DrawAccount4 extends Account4 with Logger4 {
  def withdraw(amount: Double) {
    if (amount > balance) log("余额不足")
    else balance -= amount
  }
}

object Main4 extends App {
  val acct1 = new DrawAccount4 with TimestampLogger4 with ShortLogger4 // 动态混入叠加特质
  val acct2 = new DrawAccount4 with ShortLogger4 with TimestampLogger4
  acct1.withdraw(100)
  acct2.withdraw(100)
}

