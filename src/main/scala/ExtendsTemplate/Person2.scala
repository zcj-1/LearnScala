package ExtendsTemplate

/** @author Chaojay
  * @since 2018-12-13 13:13
  */
// 2、重写父类方法
class Person2 {
  var name = ""

  override def toString = getClass.getName + "[name=" + name + "]"
}

class Employee2 extends Person2 {
  var salary = 0.0

  override def toString = super.toString + "[salary=" + salary + "]" // 使用 super 关键子调用父类的方法
}

