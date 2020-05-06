package basicCase
import scala.math.sqrt

/** @author Chaojay
  * @since 2018-12-08 9:44
  */
object UseFunction {
  /**
    * 在Scala中，1、如果调用的函数不需要传参数，则调用该函数时可加可不加()
    *               但是如果函数定义时没有加(),则调用时不能加()
    *            2、对象实例化可以通过关键字 new 的方式，也可以不用 new ，默认调用apply方法进行new
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {

    val a = 100

    //1、调用函数，求平方根
    println(sqrt(a))

    //2、静态方法调用（scala中没有静态方法这个概念，需要通过伴生类对象来实现）
    println(BigInt.probablePrime(16, scala.util.Random))

    //3、非静态方法调用，使用对象
    println("HelloWorld".distinct)

    //4、apply方法 "Hello"(4)  等同于  "Hello".apply(4) Array(1,2,3) 等同于 Array.apply(1,2,3)
    println("Hello"(1))
    println("Hello".apply(1))

    //5、update方法  arr(0) = 2 等同于 arr.update(0,2)
    val arr = Array(1, 2 ,3)
    arr.update(0, 2)
    println(arr.mkString(" "))


  }
}
