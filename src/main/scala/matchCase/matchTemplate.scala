package matchCase

/** @author Chaojay
  * @since 2018-12-12 11:41
  */
object matchTemplate {
  def main(args: Array[String]): Unit = {

    /**
      * 在Scala中的匹配模式中，case _ 是匹配所有，在所有匹配都不成功的情况执行，如果没有case _,且其他匹配不成功，会报错matchError
      * case语句不用break，
      * 可以匹配任意类型
      */

    println("========= 1、模式匹配简单案例 =========")

    def match1() = {
      val test: Char = '+'
      test match {
        case '+' => println("字符test是：" + test)
        case '-' => println("字符test是：" + test)
        case _ => println("通配")
      }
    }

    match1()

    println("========= 2、模式匹配的守卫 =========")

    def match2() = {
      val test = List("a", "b", "c", "d", 1, 2, 3)
      for (elem <- test){
        elem match {
          case "a" => println(elem)
          case "b" => println(elem)
          case "c" => println(elem)
          case "d" => println(elem)
          case _ if elem == 1 => println(elem)  // 守卫
          case _ => println(elem)
        }
      }
    }

    match2()

    println("========= 3、匹配变量 =========")

    def match3() = {
      val test: Char = '+'
      test match {
        case a => println("字符test是：" + a)
        case _ => println("通配")
      }
    }

    match3()

    println("========= 4、匹配类型 =========")

    /**
      * 根据参数类型进行模式匹配，在匹配过程中为了向下兼容，会擦掉泛型
      */

    def match4() = {
      val a = 1
      val obj = if(a == 1) 1
      else if(a == 2) "2"
      else if(a == 3) BigInt(3)
      else if(a == 4) Map("aa" -> 1)
      else if(a == 5) Map(1 -> "aa")
      else if(a == 6) Array(1, 2, 3)
      else if(a == 7) Array("aa")
      else if(a == 8) Array("aa", 1)

      val r1 = obj match {
        case x: Int => x
        case s: String => s
        case bi:BigInt => bi
        case m: Map[String, Int] => "Map[String, Int]类型的Map集合"
        case m: Map[Int, String] => "Map集合"
        case a: Array[Int] => "It's an Array[Int]"
        case a: Array[String] => "It's an Array[String]"
        case a: Array[Any] => "It's an array of something other than Int"
        case _ => 0
      }
      println(r1 + ", " + r1.getClass.getName)
    }

    match4()

    println("========= 5、匹配集合 =========")

    /**
      * 匹配集合时，可以精准按位匹配，也可以按首位匹配
      */

    def match5() = {
      // 匹配数组
      for (arr <- Array(Array(0), Array(1, 0), Array(0, 1, 0), Array(1, 1, 0), Array(1, 1, 0, 1))) {
        val result = arr match {
          case Array(0) => "0"
          case Array(x, y) => x + " " + y
          case Array(x, y, z) => x + " " + y + " " + z
          case Array(1, _*) => "0..."  // _*可以通过 @ 映射给一个变量进行后续使用，eg：Array(1, arg @ _*)
          case _ => "something else"
        }
        println(result)
      }

      // 匹配列表
      for (lst <- Array(List(0), List(1, 0), List(0, 0, 0), List(1, 0, 0))) {
        val result = lst match {
          case 0 :: Nil => "0"
          case x :: y :: Nil => x + " " + y
          case 0 :: tail => "0 ..."
          case _ => "something else"
        }
        println(result)
      }

      // 匹配元组
      for (pair <- Array((0, 1), (1, 0), (1, 1))) {
        val result = pair match {
          case (0, _) => "0 ..."
          case (y, 0) => y + " 0"
          case _ => "neither is 0"
        }
        println(result)
      }
    }

    match5()

    println("========= 6、模式匹配的提取器 =========")

    /**
      * 在模式匹配中，
      *     如果case中的unapply方法返回的是Some集合，匹配成功，
      *     如果返回的时None集合，则匹配失败
      */

    def match6() = {
      val number: Double = 36.0
      number match {
        case SquareTemplate(n) => println(s"${number}" + ":" + s"${n}")
        case _ => println("nothing matched")
      }
    }

    match6()

    println("========= 7、变量声明中的模式匹配 =========")

    def match7() = {
      val (x, y, z) = (1, 2, 3)
      println(x + ":" + y + ":" + z)

      val arr = Array("1", 89, 84)
      val Array(first, second, _) = arr
      println(second)
    }

    match7()

    println("========= 8、for循环中的模式匹配 =========")

    import scala.collection.JavaConverters._

    for ((k, v) <- System.getProperties.asScala if v == ""){
      println(k + " ----- " + v)
    }

    println("========= 9、样例类 =========")

    /**
      * 样例类会自动生成apply和unapply方法
      */

    def match9() = {
      for (amt <- Array(Dollar(500.0), Currency(1000.0, "RMB"))){
        val result = amt match {
          case Dollar(v) => println("$" + v)
          case Currency(_, u) => println("单位是:" + u)
          case _ => println("")
        }
      }
    }

    match9()

    println("========= 10、copy方法和带名参数 =========")

    /**
      * copy创建一个与现有对象值相同的新对象，并可以通过带名参数来修改某些属性。
      */

    def match10() = {
      val amt = Currency(500.0, "$")
      val amt1 = amt.copy(value = 1000.0)
      val amt2 = amt.copy(Unit = "RMB")

      println(amt)
      println(amt1)
      println(amt2)
    }

    match10()

    println("========= 11、case 语句的中置表达式 =========")

    /**
      * 什么是中置表达式？1 + 2，这就是一个中置表达式。如果unapply方法产出一个元组，你可以在case语句中使用中置表示法。
      * 比如可以匹配一个List序列。
      */

    def match11() = {
      List(1, 2, 3) match {
        case first :: second => println(first + "," + second)    // 结果：1,List(2, 3)
        case _ => 0
      }
    }

    match11()

    println("========= 12、匹配嵌套结构 =========")

    val sale = Bundle("愚人节大甩卖系列", 10,
      Article("《九阴真经》", 40),
      Bundle("从出门一条狗到装备全发光的修炼之路系列", 20,
        Article("《如何快速捡起地上的装备》", 80),
        Article("《名字起得太长躲在树后容易被地方发现》",30)))

    def match12() = {

      // 绑定第一个Article的描述
      val r1 = sale match {
        case Bundle(_, _, Article(desc, _), _*) => println(desc)
        case _ => 0
      }

      // 通过@表示法将嵌套的值绑定到变量。_*绑定剩余Item到rest
      val r2 = sale match {
        case Bundle(_, _, _, rest @ _*) => println(rest)
      }

      // 不使用_*绑定剩余Item到rest
      val r3 = sale match {
        case Bundle(_, _, _, rest) => println(rest)
      }

    }
    // 计算某个Item价格的函数，并调用
    def test(it: ItemTemplate): Double = {
      it match {
        case Article(_, p) => p
        case Bundle(_, disc, its@_*) => its.map(test _).sum - disc
      }
    }

    match12()
    println(test(sale))

    println("========= 13、密封类 =========")

    /**
      * 如果想让case类的所有子类都必须在申明该类的相同的文件中定义，可以将样例类的通用超类声明为sealed，叫做密封类，
      * 密封就是外部用户不能在其他文件中定义子类。
      */

    println("========= 14、模拟枚举 =========")

    /**
      * 样例类可以模拟出枚举类型
      */

    def match14() = {
      for (color <- Array(Red, Yellow, Green))
        println(
          color match {
            case Red => "stop"
            case Yellow => "slowly"
            case Green => "go"
          })
    }

    match14()

    println("========= 15、偏函数 =========")

    /**
      * 偏函数，它只对会作用于指定类型的参数或指定范围值的参数实施计算
      * 如果一个函数只能做case匹配，那么这个函数是偏函数
      */

    val f: PartialFunction[Char, Int] = {
      case '+' => 1
      case '-' => 0
    }

    println(f('+'))
    println(f('-'))
    println(f.isDefinedAt('0'))  // 判断偏函数 f 是否有能力处理字符 ‘0’

    // ① 自定义偏函数，需要重写apply和isDefinedAt方法
    val f1 = new PartialFunction[Any, Int] {
      def apply(arg: Any) = arg.asInstanceOf[Int] + 1

      def isDefinedAt(arg: Any): Boolean = if (arg.isInstanceOf[Int]) true else false
    }

    val r1 = List(1,2,3,"a") collect(f1)
    println(r1)

    // ②
    // ① = ②
    def f2: PartialFunction[Any, Int] = {
      case a: Int => a + 1
    }

    val r2 = List(1,2,3,"a") collect(f2)
    println(r2)

    /**
      * map 方法与 collect 方法的区别：
      *                           在偏函数中，map方法不会检查函数是否有能力执行某项计算，即不会执行isDfinedAt方法判断
      *                           collect 方法会执行判断，避免执行偏函数时会报错
      */
  }
}
