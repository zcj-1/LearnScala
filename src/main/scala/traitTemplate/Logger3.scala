package traitTemplate

/** @author Chaojay
  * @since 2018-12-13 12:04
  */
// 特质的动态混入：在构建对象时混入某个具体的特质，覆盖掉抽象方法，提供具体实现
trait Logger3 {
  def log(msg: String)
}

trait ConsoleLogger3 extends Logger3 {
  def log(msg: String) {
    println(msg)
  }
}

class Account3 {
  protected var balance = 0.0
}

abstract class DrawAccount3 extends Account3 with Logger3 {
  def withdraw(amount: Double) {
    if (amount > balance) log("余额不足")
    else balance -= amount
  }
}

object Main3 extends App {
  val account = new DrawAccount3 with ConsoleLogger3  // 因为此时抽象类混入了特质，所以可以直接 new
  account.withdraw(100)
}

