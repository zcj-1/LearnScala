package collectionCase

import scala.collection.mutable

/** @author Chaojay
  * @since 2018-12-11 12:44
  */
object SetTemplate {
  def main(args: Array[String]): Unit = {

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
  }
}
