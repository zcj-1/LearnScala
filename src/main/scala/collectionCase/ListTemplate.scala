package collectionCase

import scala.collection.mutable.ListBuffer

/** @author Chaojay
  * @since 2018-12-11 12:42
  */
object ListTemplate {
  def main(args: Array[String]): Unit = {

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
  }
}
