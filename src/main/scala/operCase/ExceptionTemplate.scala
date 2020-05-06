package operCase

/** @author Chaojay
  * @since 2018-12-11 8:28
  */
object ExceptionTemplate {
  /**
    * 在Scala中，使用try-catch捕获异常时，实际上是使用match-case进行模式匹配，ex 是异常的实例对象
    * @param args
    */
  def main(args: Array[String]): Unit = {

    try {
      val result = divider(20, 5)
      println(result)
    } catch {
      case ex:NumberFormatException => println("捕获异常：" + ex.getMessage)
    } finally {}
  }

  def divider(x: Int,y: Int) = {
    if (y == 0 ) throw new NumberFormatException("0不能作为除数!")

    x / y
  }
}
