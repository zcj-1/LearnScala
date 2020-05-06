package collectionCase

import scala.collection.immutable.Queue
import scala.collection.mutable

/** @author Chaojay
  * @since 2018-12-11 12:43
  */
object QueueTemplate {
  def main(args: Array[String]): Unit = {

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
    println(q2.head)
    println(q2.last)
    println(q2.tail)
  }
}
