package classTemplate

import scala.beans.BeanProperty

/** @author Chaojay
  * @since 2018-12-12 18:52
  */

/**
  * 4、Bean属性
  * 使用@BeanProperty注解标识某个属性变量
  * 这样会自动生成 Java 版的getter和setter方法
  * 此时，会同时存在 Java 和 Scala 两个版本的getter和setter方法
  */
class Person {
  @BeanProperty var name: String = _
}
