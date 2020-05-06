package ExtendsTemplate

/** @author Chaojay
  * @since 2018-12-13 13:11
  */
// 1、继承
class Person {
  var name = ""
}

class Employee extends Person {
  var salary = 0.0

  def description = "员工姓名：" + name + " 薪水：" + salary
}

