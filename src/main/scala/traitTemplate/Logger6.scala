package traitTemplate

/** @author Chaojay
  * @since 2018-12-14 9:53
  */
// 6、当作富接口使用的特质:即该特质中既有抽象方法，又有非抽象方法
trait Logger6 {
  def log(msg: String)  // 抽象方法

  def info(msg: String) {   // 具体实现的方法，然后调用抽象方法
    log("INFO: " + msg)
  }

  def warn(msg: String) {
    log("WARN: " + msg)
  }

  def severe(msg: String) {
    log("SEVERE: " + msg)
  }
}

trait ConsoleLogger6 extends Logger6 {
  def log(msg: String) {
    println(msg)
  }
}

class Account6 {
  protected var balance = 0.0
}

abstract class DrawAccount6 extends Account6 with Logger6 {
  def withdraw(amount: Double) {
    if (amount > balance) severe("余额不足")
    else balance -= amount
  }
}

object Main6 extends App {
  val acct = new DrawAccount6 with ConsoleLogger6
  acct.withdraw(100)
}

