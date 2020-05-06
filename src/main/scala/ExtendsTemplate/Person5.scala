package ExtendsTemplate

/** @author Chaojay
  * @since 2018-12-13 13:22
  */
// 超类的构造
/**
  * 类有一个主构器和任意数量的辅助构造器，而每个辅助构造器都必须以对先前定义的辅助构造器或主构造器的调用开始。
  * 子类的辅助构造器最终都会调用主构造器，只有主构造器可以调用超类的辅助或主构造器。
  * 辅助构造器永远都不可能直接调用超类的构造器。在Scala的构造器中，你不能调用super(params)。
  */
class Person5(val name: String, val age: Int) {
  override def toString = getClass.getName + "[name=" + name +
    ",age=" + age + "]"
}
class Employee5(name: String, age: Int, val salary : Double) extends Person5(name, age) {
  override def toString = super.toString + "[salary=" + salary + "]"
}

