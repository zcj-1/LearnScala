package traitTemplate

/** @author Chaojay
  * @since 2018-12-14 10:23
  */
// 11、扩展类的特质
// 1) 特质可以继承自类，以用来拓展该类的一些功能
trait LoggedException extends Exception{
  def log(): Unit ={
    println(getMessage())
  }
}
// 2) 所有混入该特质的类，会自动成为那个特质所继承的超类的子类。此时UnhappyException是Exception的子类
class UnhappyException extends LoggedException{
  override def getMessage = "哦，我的上帝，我要踢爆他的屁股！"
}
// 3)  如果混入该特质的类，已经继承了另一个类，不就矛盾了？注意，只要继承的那个类是特质超类的子类即可。
//正确：IndexOutOfBoundsException 必须是 Exception 的子类
class UnhappyException2 extends IndexOutOfBoundsException with LoggedException{
  override def getMessage = "哦，我的上帝，我要踢爆他的屁股！"
}
//错误：
//class UnhappyException3 extends JFrame with LoggedException{
//  override def getMessage = "哦，我的上帝，我要踢爆他的屁股！"
//}

