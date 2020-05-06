package traitTemplate

/** @author Chaojay
  * @since 2018-12-13 11:53
  */
// 当作接口使用的特质
trait Logger {
  def log(msg: String)  // 特质中的抽象方法
}

class ConsoleLogger extends Logger3 with Cloneable with Serializable {
  def log(msg: String) {
    println(msg)
  }

  /**
    *  Cloneable 和 Serializable 是Java中的接口，在Scala中将所有Java版的接口都写成了一份特质
    */
}

