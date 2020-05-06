package highOrderFunction

/** @author Chaojay
  * @since 2018-12-12 16:01
  */
object HighOrderFunctionTemplate {
  def main(args: Array[String]): Unit = {

    println("========= 1、高阶函数 =========")

    def test1(x: String, y: Int, f: (String, Int) => String): String = {
      f(x, y)
    }

    def f(x: String, y: Int): String = {
      return x + y
    }

    val r1 = test1("hello", 1, f)
    println(r1)

    println("========= 2、闭包 =========")

    /**
      * 闭包跟柯里化一脉相承，闭包函数是指一个匿名函数使用了一个不属于他的参数
      *
      * @param x
      * @return
      */

    def minusxy(x: Int) = (y: Int) => x + y

    println(minusxy(10))
    println(minusxy(10)(20))

    println("========= 3、curry =========")

    /**
      * 函数编程中，接受多个参数的函数都可以转化为接受单个参数的函数，这个转化过程就叫柯里化，
      * 柯里化就是证明了函数只需要一个参数而已
      * 柯里化就是以函数为主体这种思想发展的必然产生的结果。
      *
      * 柯里化的应用：
      * -- 比较两个字符串在忽略大小写的情况下是否相等，注意，这里是两个任务：
      * 1、全部转大写（或小写）
      * 2、比较是否相等
      */

    val ls1 = List("Hello", "world")
    val ls2 = List("hello", "WorLd")
    println(ls1.corresponds(ls2)(_.equalsIgnoreCase(_)))  // corresponds 是一个柯里化函数

    println("========= 4、控制抽象 =========")

    /**
      * 控制抽象是一类函数：
      *                   1、参数是函数。
      *                   2、函数参数没有输入值也没有返回值。
      */

    def test2(f: () => Unit): Unit = {
      new Thread{
        override def run(): Unit = {
          f()
        }
      }.start()
    }

    test2{ // test2 接收的参数是一个函数，当该参数具有多行逻辑时，需要用大括号 { } 包裹
      () => println("线程开始工作……")
    Thread.sleep(5000)
    println("线程工作完毕！")}
  }
}
