package classTemplate

/** @author Chaojay
  * @since 2018-12-12 18:27
  */

/**
  *  1、简单类的创建以及无参方法的调用
  * 在Scala中，类并不声明为Public，一个Scala源文件可以包含多个类,所有这些类都具有公有可见性。
  * 调用无参方法时，可以加（），也可以不加；如果方法定义中不带括号，那么调用时就不能带括号。
  */
class Dog {

  var leg: Int = _

  def shout() = {
    println("汪汪汪~~~")
  }
}
