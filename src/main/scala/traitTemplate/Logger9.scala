package traitTemplate

/** @author Chaojay
  * @since 2018-12-14 10:07
  */
// 9、特质的构造顺序
/**
  * 步骤总结：
    1、调用当前类的超类构造器
    2、第一个特质的父特质构造器
    3、第一个特质构造器
    4、第二个特质构造器的父特质构造器由于已经执行完成，所以不再执行
    5、第二个特质构造器
    6、当前类构造器
  */
trait Logger9 {
  println("我在Logger6特质构造器中，嘿嘿嘿。。。")
  def log(msg: String)
}

trait ConsoleLogger9 extends Logger9 {
  println("我在ConsoleLogger6特质构造器中，嘿嘿嘿。。。")
  def log(msg: String) {
    println(msg)
  }
}

trait ShortLogger9 extends Logger9 {
  val maxLength: Int
  println("我在ShortLogger6特质构造器中，嘿嘿嘿。。。")

  abstract override def log(msg: String) {
    super.log(if (msg.length <= maxLength) msg else s"${msg.substring(0, maxLength - 3)}...")
  }
}

class Account9 {
  println("我在Account6构造器中，嘿嘿嘿。。。")
  protected var balance = 0.0
}

abstract class DrawAccount9 extends Account9 with ConsoleLogger9 with ShortLogger9{
  println("我再SavingsAccount6构造器中")
  var interest = 0.0
  override val maxLength: Int = 20
  def withdraw(amount: Double) {
    if (amount > balance) log("余额不足")
    else balance -= amount
  }
}

object Main9 extends App {
  val acct = new DrawAccount9 with ConsoleLogger9 with ShortLogger9
  acct.withdraw(100)
  println(acct.maxLength)
}

