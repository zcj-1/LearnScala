package operCase

/** @author Chaojay
  * @since 2018-12-10 8:07
  */
object StrucTemplate {
  def main(args: Array[String]): Unit = {

    println("--------1、if else--------")
    // 1、if else都有返回值,需要接收，如果不写，则返回Unit类型的()
    val a = 10
    val b = if (a < 10){
      "a小于10"
    }else if (a == 10){
      "a等于10"
    }else{
      "a大于10"
    }
    println(b)

    println("--------2、while,do...while循环--------")
    // 2、while,do...while循环，返回值是Unit类型的()，就是无返回值.scala中没有++ --
    var a1 = 10
    while (a1 <15){
      println(a1)
      a1 += 1
    }


    var b1 = 1
    do{
      println(b1)
      b1 += 1
    }while(b1 < 10)

    println("--------3、while循环的中断--------")
    // 3、while循环的中断
    import scala.util.control.Breaks

    val loopBreak = new Breaks   // 实例化空参对象时可以省略()
    loopBreak.breakable{
      while (a1 < 100){
        println(a1)
        a1 += 1
        if (a1 == 20){
          loopBreak.break()
        }
      }
    }

    println("--------4、for循环--------")
    // 4、for循环,to（左右都闭），until（左闭右开），返回值为Unit类型的()
    for (a <- 1 to 10;b <- 1 until 10){
      println(a * b)
    }

    // for循环的守卫，即判断
    for (a <- 1 to 100; if a % 2 == 0){
      println(a)
    }

    // for循环引入变量
    for (a <- 1 to 10;b = a + 1){
      println(b)
    }

    // for循环使用yield收集结果
    val result = for (a <- 1 to 10) yield a
    println(result)

    // 当有多个for推导式时用{ }代替()
    for {
      a <- 1 to 5
      b <- 1 to 5
    }
      println(a * b)

  }
}
