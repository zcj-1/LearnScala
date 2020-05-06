package operCase

/** @author Chaojay
  * @since 2018-12-10 8:58
  */
object UserFunctionTemplate {
  def main(args: Array[String]): Unit = {
    // 在scala中可以在函数内定义函数
    // 定义函数的几种方式：

    // 1、最标准方式
    println("--------1、最标准方式---------")
    def test1(a: Int,b: Int): Int = {
      a + b
    }

    println(test1(2, 3))

    // 2、省略返回值,默认返回最后一行操作.常用
    println("--------2、省略返回值---------")
    def test2(a: Int,b: Int) = {
      a * b
      a + b
      println(a * b)
    }

    println(test2(9, 2))

    // 3、根据结果自动判断返回值类型
    def test3(a: Int,b: Int) = {
      if (a > 10){
        a + b
      }else{
        "a小于10"
      }
    }

    println(test3(11, 3))
    println(test3(8, 2))

    // 4、可变参数长度，类似于Java中的...
    println("--------4、可变参数长度--------")
    def test4(a: Int*) ={
      for (b <- a){
        println(b)
      }
    }

    test4(4, 3, 9)

    // 5、递归函数，要求必须显示声明返回值类型
    println("--------5、递归函数--------")
    def factorial(a: Int): Int = {
      if (a == 1){
        a
      }else{
        factorial(a - 1) * a
      }
    }

    println(factorial(3))

    // 6、带有默认值参数的函数,类似于python中的关键字参数
    println("--------6、带有默认值参数的函数--------")
    def test6(a: Int,b: Int = 4) = {
      a + b
    }

    println(test6(4))
    println(test6(4,8))
    println(test6(5, b = 3))

    /**
      * 在Scala中，将返回值类型为 Unit 类型的函数称之为过程，有明确返回值类型的称之为函数
      */

    // 绝对过程,没有=的函数是一个绝对过程，返回值时Unit类型的(),没有意义
    def test7(a: Int){
      a
    }
    println(test7(3))
  }
}
