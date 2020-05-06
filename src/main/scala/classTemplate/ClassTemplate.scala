package classTemplate

/** @author Chaojay
  * @since 2018-12-12 18:30
  */
object ClassTemplate {

  def main(args: Array[String]): Unit = {

    // 1、简单的类的创建和无参方法
    val dog = new Dog()
    dog.shout()


    // 2、getter 和 setter 方法
    /**
      * 对于scala类中的每一个属性，编译后，会有一个私有的字段和相应的getter、setter方法生成：
      *             getter: leg
      *             setter: leg_=
      * 尖叫提示：自己手动创建变量的getter和setter方法需要遵循以下原则：
      *            1) 字段属性名以“_”作为前缀，如：_leg
      *            2) getter方法定义为：def leg = _leg
      *            3) setter方法定义时，方法名为属性名去掉前缀，并加上后缀，后缀是：“leg_=”
      */

    dog.leg_=(4)
    println(dog.leg)


    // 3、对象私有字段 （见 Executive 类）


    // 4、Bean属性
    /**
      * 使用@BeanProperty注解标识某个属性变量
      * 这样会自动生成 Java 版的getter和setter方法
      * 此时，会同时存在 Java 和 Scala 两个版本的getter和setter方法
      */
    val person = new Person()
    person.setName("zhangsan")
    println(person.getName)

    person name_= "lisi"
    println(person.name)


    // 5、构造器
    /**
      * scala中构造分为主构造器和辅助构造器
      * 辅助构造器必须借助其他构造器使用，不能单独存在，最终都会经过主构造器
      * 主构造器：
      *         1） 主构造的参数直接放置于类名之后
      *         2） 主构造器会执行类定义中的所有语句
      *         3)  通过private设置的主构造器的私有属性
      *         4)  如果不带val和var的参数至少被一个方法使用，该参数将自动升级为字段。
      *           -- 这时，参数就变成了类的不可变字段，而且这两个字段是对象私有的，这类似于 private[this] val 字段的效果。
      *           -- 否则，该参数将不被保存为字段，即实例化该对象时传入的参数值，不会被保留在实例化后的对象之中
      */

    val classConstructTemplate = new ClassConstructTemplate("dog", 2)
    println(classConstructTemplate)


    // 6、单例对象
    val cacheBean = CacheBean()  // 此时不能通过 new 来创建对象，只能通过apply方法,且必须加小括号()
    println(cacheBean)
  }


  // 7、嵌套类
  /**
    * 如果内部类不是静态的，即没有在伴生类对象中声明内部类，那么这个内部类的全类型是 new 外部类.内部类
    * 在Java中自动实现了类型投影
    */

  val network1 = new Network
  val Tony = network1.join("Tony")
  val Alice = network1.join("Alice")

  Tony.contacts += Alice // 此时两人可以成为好友

  val network2 = new Network
  val John = network2.join("John")

//  Alice.contacts += John   // 因为John和Alice这两个对象的并不属于同一个Member，所以无法加为好友
  /**
    * 解决方法：
    *         1）将内部类声明成静态内部类，即在伴生类对象中声明内部类
    *         2）使用类型投影：外部类#内部类
    */
  Alice.contacts += John
}
