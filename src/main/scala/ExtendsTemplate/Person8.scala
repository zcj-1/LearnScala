package ExtendsTemplate

/** @author Chaojay
  * @since 2018-12-13 13:44
  */
// 抽象类
abstract class Person8(val pname: String) {
  val id: Int
  var name: String          // 抽象类中没有初始值的字段为抽象字段

  def idString: Int         // 抽象类中没有方法体的方法是抽象方法
}

class Employee8(pname: String) extends Person8(pname) {
  val id = 5;
  var name = pname

  def idString = pname.hashCode
}
