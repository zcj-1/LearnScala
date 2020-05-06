package ExtendsTemplate

/** @author Chaojay
  * @since 2018-12-13 13:32
  */
// 重写父类中的字段或抽象字段
class Person6(val name:String, var age:Int){
  println("主构造器已经被调用")
  val school="五道口职业技术学院"
  def sleep="8 hours"
  override def toString="我的学校是：" + school + "我的名字和年龄是：" + name + "," + age
}

class Person6_1(name:String, age:Int) extends Person6(name, age){
  override val school: String = "清华大学" // 重写父类中的字段 school
}

