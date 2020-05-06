package ExtendsTemplate

/** @author Chaojay
  * @since 2018-12-13 13:36
  */
// 匿名子类
class Person7(val name: String) {
  override def toString = getClass.getName + "[name=" + name + "]"
}


