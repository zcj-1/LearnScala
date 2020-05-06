package classTemplate

import scala.beans.BeanProperty

/** @author Chaojay
  * @since 2018-12-12 19:07
  */

/**
  * 5、构造器
  * scala中构造分为主构造器和辅助构造器
  * 辅助构造器必须借助其他构造器使用，不能单独存在，最终都会经过主构造器
  * 主构造器：
  *         1） 主构造的参数直接放置于类名之后
  *         2） 主构造器会执行类定义中的所有语句
  *         3)  通过private设置的主构造器的私有属性
  *         4)  如果不带val和var的参数至少被一个方法使用，该参数将自动升级为字段。
  *           -- 这时，参数就变成了类的不可变字段，而且这两个字段是对象私有的，这类似于 private[this] val 字段的效果。
  *           -- 否则，该参数将不被保存为字段，即实例化该对象时传入的参数值，不会被保留在实例化后的对象之中
  */

/**
  * ① name: String	                        对象私有字段 private val。如果没有方法使用name, 则没有该字段
  * ② private val/var name: String	        私有字段，私有的getter和setter方法
  * ③ var name: String	                    私有字段，公有的getter和setter方法
  * ④ @BeanProperty val/var name: String	  私有字段，公有的Scala版和Java版的getter和setter方法
  */
//class Animal private(private var name: String,private var age: Int) {// 对应 ②
//class Animal private(var name: String,var age: Int) {  // 对应 ③
//class Animal private(name: String,age: Int) {  // 3）在参数前加private私有化主构造器
//class Animal private(@BeanProperty name: String,@BeanProperty age: Int) {  // 对应 ④
class ClassConstructTemplate(name: String, age: Int) {  // 4）不用val和var修饰的主构造器

  println(name, age)
  // 辅助构造器，名字是 this, 通过不同参数进行区分，每一个辅助构造器都必须以主构造器或者已经定义的辅助构造器的调用开始
  def this() = {
    this("", 1)
  }

  def this(name: String) = {
    this()
  }

  def this(age: Int) = {
    this()
  }
}
