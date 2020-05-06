package collectionCase

import scala.collection.mutable.ArrayBuffer

/** @author Chaojay
  * @since 2018-12-11 12:41
  */
object ArrayTemplate {
  def main(args: Array[String]): Unit = {
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

    // 追加
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
  }
}
