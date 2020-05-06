package collectionCase

import scala.collection.mutable

/** @author Chaojay
  * @since 2018-12-11 12:43
  */
object MapTemplate {
  def main(args: Array[String]): Unit = {

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
  }
}
