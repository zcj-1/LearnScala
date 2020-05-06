package operCase

import scala.collection.immutable.Queue
import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/** @author Chaojay
  * @since 2018-12-11 8:37
  */
object CollectionTemplate {
  def main(args: Array[String]): Unit = {

    /**
      * 集合：
      * -- 1.创建
      * -- 2.赋值
      * -- 3.取值
      * -- 4.追加元素
      * 不可变集合与可变集合的区别：
      * -- 1.Scala中默认使用的集合是不可变集合，使用可变集合需要导包
      * -- 2.不可变集合的元素追加会产生一个新的集合，而可变集合是在原集合的基础上追加
      */

    println("=============== 1、数组 Array ===============")
    // 1 数组
    /**
      * ① 定长数组 Array ，即不可变数组。
      */

    // 方式一：必须指定泛型以及长度
    val arr1 = new Array[Int](10)
    // 方式二：
    val arr2 = Array(1, 2, 3, 4)

    // 赋值
    arr2(2) = 5 // 相当于 arr2.update(2, 5)
    println(arr2.mkString(" "))

    // 取值
    println(arr2(3))

    // for 循环遍历
    for (elems <- arr2) {
      println(elems)
    }

    // 追加(实际上是产生了新的数组对象)
    val arr3 = arr1 :+ 2 // 尾部追加
    val arr4 = 2 +: arr1 // 首部追加
    println(arr3.mkString(", "))
    println(arr4.mkString(", "))

    /**
      * ② 可变数组 ArrayBuffer ,
      * -- 实例化时不用声明类型、数组长度
      * -- 实例化时可以不用new，且括号中是数组元素
      */
    // 方式一：
    val arrayBuffer1 = new ArrayBuffer[Int]()
    // 方式二：直接赋值
    val arrayBuffer2 = ArrayBuffer(1, 2, 3)

    println(arrayBuffer1)
    println(arrayBuffer2)

    // 赋值
    arrayBuffer2(1) = 5
    println(arrayBuffer2)

    // 取值
    println(arrayBuffer2(2))

    // 追加 append、+=
    arrayBuffer1.append(3)
    println(arrayBuffer1)

    /**
      * 可变数组与不可变数组的转换
      */
    // 不可变 to 可变
    arr2.toBuffer

    // 可变 to 不可变
    arrayBuffer2.toArray

    /**
      * ③ 多维数组
      * -- 使用 ofDim 最多可实现五维数组
      */
    // 实例化
    val dimArray = Array.ofDim[Int](3, 4)

    for (i <- dimArray) {
      println(i.mkString(" "))
    }

    // 赋值
    dimArray(1)(2) = 3

    for (i <- dimArray) {
      println(i.mkString(" "))
    }

    // 追加（多维数组的追加只能追加一维数组）
    val dimArray1 = dimArray :+ Array(1, 2, 3)

    for (i <- dimArray1) {
      println(i.mkString(", "))
    }

    /**
      * ④ Scala 数组与 Java 数组的互转
      * -- ProcessBuilder 只能传字符串数组
      */
    // Scala to Java
    val arr5 = ArrayBuffer("1", "2", "3")
    import scala.collection.JavaConversions.bufferAsJavaList

    val javaArr = new ProcessBuilder(arr5)
    println(javaArr.command())

    // Java to Scala
    import scala.collection.JavaConversions.asScalaBuffer
    import scala.collection.mutable.Buffer

    val scalaArr: Buffer[String] = javaArr.command()
    println(scalaArr)


    println("=============== 2、元组 Tuple ===============")
    // 2、元组Tuple
    // ① 元组的创建(元组中可以存放任意类型的值)
    val tupleTest = (1, "2", 3)

    // 赋值
    // 元组一旦创建，不能改变值,也不能追加元素

    // ② 元组的访问。需要有下划线 _ ,且下标从 1 开始
    println(tupleTest._2)

    // ③ 元组的遍历
    // 方式一：通过for循环的方式,需要借助 productIterator 产生迭代器
    for (elem <- tupleTest.productIterator) {
      println(elem)
    }

    // 方式二：通过高阶函数形式
    tupleTest.productIterator.foreach(i => println("高阶函数形式：" + i))


    println("=============== 3、列表 List ===============")

    // 3、列表 List（不可变）
    // ① List的创建，方式一：
    val list1 = List(1, 2, 3, "e")
    println(list1)

    // 方式二：Nil 是 List 的空对象。这种方式最后必须有一个List集合
    val list2 = 1 :: 2 :: "w" :: 8 :: Nil
    println(list2)

    // ② 赋值(会产生一个新的集合）
    val list1_2 = list1.updated(1, "g")
    println(list1)
    println(list1_2)

    // ③ 取值
    println(list1(3))

    // 遍历
    for (elem <- list1) {
      println(elem)
    }

    // ④ 追加元素.可以通过  :+,+: 或者 :: 两种方式
    val list3_1 = list1 :+ 8
    println(list3_1)

    val list3_2 = 9 :: 6 :: list1
    println(list3_2)

    /**
      * 可变列表 ListBuffer
      */

    // ① 创建
    val lb = ListBuffer(2, 5, 9)

    // ② 赋值
    lb(2) = 4
    println(lb)

    // ③ 取值
    println(lb(1))

    // 遍历
    for (elem <- lb) {
      println(elem)
    }

    // ④ 追加元素
    lb.append(100, 30)
    println(lb)


    println("=============== 4、 队列 Queue ===============")
    // 4、 队列 Queue

    // ① 创建(不可变Queue创建时需要导包)
    // 方式一：
    val queue1 = Queue(2, 4)
    println(queue1)

    // ② 赋值(会产生一个新的Queue)
    val queue1_2 = queue1.updated(0, 8)
    println(queue1_2)

    // ③ 取值
    println(queue1(0))

    // 遍历
    for (elem <- queue1) {
      println(elem)
    }

    // ④ 追加
    val queue1_3 = queue1.enqueue(90)
    println(queue1_3)
    // 删除
    val queue1_4 = queue1.dequeue
    println(queue1_4)

    /**
      * 可变队列Queue
      */

    // ① 创建
    // 方式一：
    val q1 = new mutable.Queue[Int]()

    // 方式二：
    val q2 = mutable.Queue(1, 2, 3)

    // ② 赋值
    q2(1) = 9
    println(q2)

    // ③ 取值
    println(q2(0))

    // ④ 追加元素 +=、++=、enqueue
    q1 += 1 // 追加一个元素
    println(q1)
    q1 ++= List(90, 34) // 追加一个集合（集合必须有序）
    println(q1)
    q1.enqueue(78, 30)
    println(q1)

    // 删除元素
    q1.dequeue()
    println(q1)

    // 三个常用的方法
    println(q2.head)                // 返回队列的第一个元素
    println(q2.last)                // 返回队列的最后一个元素
    println(q2.tail)                // 返回除了首元素外的其他元素


    println("=============== 5、映射 Map ===============")
    // 5、映射 Map
    // ① 创建(不可变）
    val map1 = Map("Alice" -> 23, "Bob" -> 25, "Tom" -> 33)

    // ② 赋值(会产生新的Map)
    val map1_2 = map1.updated("Alice", 25)
    println(map1_2)

    // ③ 取值
    println(map1("Alice"))
    println(map1.get("Alice").get) // 建议使用

    // ④ 追加 +
    val map2 = map1 + ("Tony" -> 46)
    println(map2)

    /**
      * 可变Map
      */
    // ① 创建
    val m1 = mutable.Map("Alice" -> 23, "Bob" -> 25, "Tom" -> 33)

    val m3 = new mutable.HashMap[String, Int]() // 空 Map，只有可变 Map 可以

    // ② 赋值
    m1("Alice") = 30
    println(m1)
    m1 += ("Bob" -> 45)
    println(m1)

    // ③ 取值
    println(m1.get("Alice"))

    // 遍历
    for (elem <- m1) {
      println(elem)
    }

    for ((k, v) <- m1) {
      println(k + ":" + v)
    }

    for (k <- m1.keys) {
      println(k)
    }

    for (v <- m1.values) {
      println(v)
    }
    // ④ 追加元素 +=(参数是元组对或者映射）、+（参数是映射）
    m1 += ("Tony" -> 45)
    m1 += Tuple2("Kotlin", 19)
    println(m1)

    val m2 = m1 + ("Jay" -> 34) // 产生新的集合
    println(m2)

    // 删除元素
    m1 -= ("Alice")
    println(m1)

    println("=============== 6、集 Set ===============")
    // 6、集 Set
    // ① 创建（不可变）
    val set1 = Set(1, 2, 3)

    // ② 赋值
    // Set只能追加，不能赋值

    // ③ 取值
    // Set的取值只能是遍历，因为无序，不能通过下标来取值
    for (elem <- set1) {
      println(elem)
    }

    // ④ 追加
    // 不可变集合不能追加

    /**
      * 可变集
      */
    // ① 创建
    val set2 = mutable.Set(1, 2, 3)

    // ② 赋值
    // 不能赋值

    // ③ 取值
    for (elem <- set2) {
      println(elem)
    }

    // ④ 追加 add、+=
    set2.add(7)
    println(set2)

    set2 += 4
    println(set2)

    // 删除元素 -=
    set2 -= 3
    println(set2)

    // 取两个set的交集  &
    val set3 = set2 & set1
    println(set3)

    // 取两个set的差集  &~
    val set4 = set2 &~ set1
    println(set4)

    // 取两个set的并集  ++
    val set5 = set2 ++ set1
    println(set5)


    println("=============== 7、集合中的元素与函数之间的映射 ===============")

    // map 将集合中的每一个元素映射到函数,有返回值
    val first = List("Alice", "Tony", "Bob")

    // 方式一：x => x.toUpperCase()可理解为lamdam表达式
    val second = first.map(x => x.toUpperCase())
    println(second)

    // 方式二：
    def f(arg: String): String = {
      arg.toLowerCase()
    }
    val second2 = first.map(f)
    println(second2)

    // 方式三：使用 _ 时，同一元素只能使用一次
    val forth = first.map(_.toUpperCase())
    println(forth)

    // flatmap：同map一样有多种使用方式
    val third = first.flatMap(x => x.toUpperCase())
    println(third)

    println("=============== 8、化简、折叠、扫描 ===============")

    val ls1 = List(1, 2, 3, 4, 5, 6)

    println("-------- 1、化简 --------")
    // 1、化简：将表达式化为最简，如下两个表达式：
    val fifth = first.flatMap(x => x.toUpperCase())
    val six = first.map(_.toUpperCase())          // 最简

    println("-------- 2、折叠 --------")
    // 2、折叠：即将多个值按照某种方法折叠成最简值
    /**
      * reduce:调用的是fold(0)
      */
    // 方式一: reduceLeft,由左向右运算
    val ls2 = ls1.reduceLeft(_ + _)   // 等价于 val ls2 = ls1.reduceLeft((x, y) => x + y)
    println(ls2)

    // 方式二：reduceRight，由右向左运算
    val ls3 = ls1.reduceRight(_ - _)
    println(ls3)

    /**
      * fold:必须指定初始值
      */
    // fold、foldLeft、foldRight 必须指定初始值。其中 foldLeft 与 foldRight 分别可以简写为：  /： 和  :\
    val lsFold = ls1.fold(5)(_ - _)
    println(lsFold)

    // /：即 foldLeft
    val lsFoldLeft = (8/:ls1)(_ - _)
    println(lsFoldLeft)

    // :\ 即 foldRight
    val lsFoldRight = (ls1:\4)(_ - _)
    println(lsFoldRight)

    println("========================= 统计一句话中，各个文字出现的次数 ==============================")
    println()

    val sentence = "一首现代诗《笑里藏刀》:哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈刀哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"

    val degree = (mutable.Map[Char, Int]()/:sentence)((m, d) => m + (d -> (m.getOrElse(d, 0) + 1)))
    println(degree)

    /**
      * (mutable.Map[Char, Int]()/:sentence)((m, d) => m + (d -> (m.getOrElse(d, 0) + 1)))解析：
      *     -- mutable.Map[Char, Int]() ： 初始值
      *     -- /:                       ： foldLeft
      *     -- sentence                 ： 要折叠的集合
      *     -- m                        ： 一个map对象，表示上一次的结果，然后作为参数传递
      *     -- d                        ： map对象中的key，表示当前的字符，作为第二个参数传递
      *     -- d -> (m.getOrElse(d, 0) + 1) ： 一个map键值对
      */

    /**
      * 函数柯里化（curry）：
      * 柯里化的意义：函数柯里化是面向函数编程自然而然产生的，讨论柯里化的意义并没有意义
      * fold、foldLeft、foldRight、scan、scanLeft、scanRight等都是柯里化函数
      */
    // 类型一：匿名方式
    val curryFunction = (x: Int) => (y: Int) => x + y
    val result1 = curryFunction(4)(5)
    println(result1)

    // 类型二：非匿名方式，此时必须传入全部参数
    def curryFunction2(x: Int)(y: Int): Int = {
      x + y
    }
    val result2 = curryFunction2(4)(5)
    println(result2)

    println("-------- 3、扫描 --------")
    // 3、扫描：即对某个集合的所有元素做fold操作，但是会把产生的所有中间结果放置于一个集合中保存。
    // scan、scanLeft、scanRight：需要传入初始值
    val lsScan = (1 to 10).scanLeft(0)(_ + _)
    println(lsScan)


    println("=============== 9、拉链 ===============")
    // 9、拉链：使用 zip 将两个集合拉在一起
    val zipList1 = List("张三", "李四")
    val zipList2 = List("15893467832", "18734569034")
    val zipResult = zipList1 zip zipList2  // 等价于 zipList1.zip(zipList2)
    println(zipResult)

    // 将拉链的结果装入 Map 集合
    val zipMap = mutable.Map[String, String]()
    for (tuple <- zipResult){
      println(tuple)
      zipMap += tuple
    }
    println(zipMap)


    println("=============== 10、Stream 和 View ===============")
    // 10、Stream 和 View
    /**
      * Stream 和 View:
      *                 共同点：Stream 和 View 都是懒执行集合
      *                 不同点：Stream 集合可以缓存数据，并且Stream集合可以无限大；
      *                         View集合不能缓存数据，每次都是从头开始运算，是有限大的
      */

    // Stream
    def streamTemplate(initNum: BigInt): Stream[BigInt] = {
      initNum #:: streamTemplate(initNum + 1)
    }

    val firstStream = streamTemplate(0)
    println(firstStream)

    val secondStream = firstStream.tail

    val thirdStream = secondStream.tail
    println(secondStream)
    println(thirdStream)

    /**
      * tail 方法：
      *           -- 1、生成一个新的Stream集合
      *           -- 2、会触发Stream的使用，会在调用tail方法的Stream集合上新增元素
      */

    // view
    val myView = (1L to 100000L).view.map(x => x).filter(x => x.toString == x.toString.reverse)

    println(myView.mkString(","))


    println("=============== 11、并行集合 ===============")
    // 11、并行集合:多线程在集合中的应用 (调用 par 方法）
    val threadName = ((0 to 10000)).par.map{case _ => Thread.currentThread().getName}.distinct
    println(threadName)
  }
}
