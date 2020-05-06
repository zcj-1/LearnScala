package operCase

/** @author Chaojay
  * @since 2018-12-08 13:38
  */
object OperationTemplate {
  def main(args: Array[String]): Unit = {

    // 1、option类型，有两个子类 Some 和 None
    val map = Map("name" -> "Tom", "age" -> 18)

    println(map.get("name"))  // 结果：Some(Tom) 返回的是some集合
    println(map.get("name").get)  // Some集合中的内容可以通过get获取
    println(map.get("sex"))   // 结果：None  返回的是None

    println(map("name"))

  }
}
