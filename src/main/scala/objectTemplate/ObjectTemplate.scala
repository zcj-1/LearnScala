package objectTemplate

/** @author Chaojay
  * @since 2018-12-13 9:14
  */
//
object ObjectTemplate extends App {

  // 1、伴生类对象
  /**
    * 类和它的伴生对象可以相互访问私有特性，他们必须存在同一个源文件中。必须同名
    */

  val cat1 = new Cat
  val cat2 = Cat()

  cat1.changeName("黑猫")
  cat2.changeName("白猫")

  cat1.describe
  cat2.describe

  // 2、apply 方法
  /**
    * apply方法一般都声明在伴生类对象中，可以用来实例化伴生类的对象
    * 也可以用来实现单例模式
    */

  // 3、应用程序对象
  /**
    * 每一个Scala应用程序都需要从一个对象的main方法开始执行
    * 或者扩展一个App特质，如当前文件 object ObjectTemplate extends App
    */

  // 4、枚举
  /**
    * 在Scala中没有枚举类型，定义一个扩展Enumeration类的对象，并以value调用初始化枚举中所有可能用到的值
    */

  println(TrafficLightColor.RED.id)
  println(TrafficLightColor.RED)

  println(TrafficLightColor.YELLOW.id)
  println(TrafficLightColor.YELLOW)

  println(TrafficLightColor.GREEN.id)
  println(TrafficLightColor.GREEN)

}
