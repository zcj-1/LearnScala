package objectTemplate

/** @author Chaojay
  * @since 2018-12-13 9:28
  */
/**
  * 在Scala中没有枚举类型，定义一个扩展Enumeration类的对象，并以value调用初始化枚举中所有可能用到的值
  */
object TrafficLightColor extends Enumeration {

  val RED = Value(0, "red")  // 参数：第一个为枚举的唯一id，第二个为枚举值
  val GREEN = Value(1, "green")
  val YELLOW = Value(2, "yellow")

}
