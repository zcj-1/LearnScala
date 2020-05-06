package traitTemplate

/** @author Chaojay
  * @since 2018-12-13 12:00
  */
// 带有具体实现方法的特质
trait ConsoleLogger2 {
  def log(msg: String) {
    println(msg)
  }
}

class Account2 {
  protected var balance = 0.0
}

class DrawAccount2 extends Account2 with ConsoleLogger2{
  def withdraw(amount: Double) {
    if (amount > balance) log("余额不足")
    else balance -= amount
  }
}
