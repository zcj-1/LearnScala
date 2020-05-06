package operCase

/** @author Chaojay
  * @since 2018-12-11 8:17
  */
object LazyTemplate {
  def main(args: Array[String]): Unit = {

    /**
      * 在Scala中，用lazy关键字修饰的变量称为“懒值”，此时将赋值的方法不会被调用
      * 只有当使用该变量时才会调用执行相应的方法
      */
    lazy val test = lazyTest()
    println("我是一个变量")
    println(test)
  }

  def lazyTest(): String = {
    "lazy方法执行了"
  }
}
