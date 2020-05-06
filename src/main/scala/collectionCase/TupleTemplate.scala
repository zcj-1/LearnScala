package collectionCase

/** @author Chaojay
  * @since 2018-12-11 12:43
  */
object TupleTemplate {
  def main(args: Array[String]): Unit = {

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
  }
}
