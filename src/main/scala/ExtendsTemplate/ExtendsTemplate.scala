package ExtendsTemplate

/** @author Chaojay
  * @since 2018-12-13 12:29
  */

/**
  * 在scala中，所有其他类都是AnyRef的子类，类似Java的Object。
  * AnyVal和AnyRef都扩展自Any类。Any类是根节点
  * Any中定义了isInstanceOf、asInstanceOf方法，以及哈希方法等。
  * Null类型的唯一实例就是null对象。可以将null赋值给任何引用，但不能赋值给值类型的变量。
  * Nothing类型没有实例。它对于泛型结构是有用处的，举例：空列表Nil的类型是List[Nothing]，它是List[T]的子类型，T可以是任何类。
  */
object ExtendsTemplate extends App {

  /**
    * 继承类和Java一样使用extends关键字，在定义中给出子类需要而超类没有的字段和方法，或者重写超类的方法
    */

  // 1、继承类
  /**
    * 如果类声明为final，该类将不能被继承。如果单个方法声明为final，将不能被重写。
    */

  val employee = new Employee
  println(employee.description)

  // 2、重写方法
  /**
    * 重写父类一个非抽象方法需要用override修饰符，调用超类的方法使用super关键字
    */

  val employee2 = new Employee2
  println(employee2)

  // 3、类型检查和转换
  /**
    * 要测试某个对象是否属于某个给定的类，可以用isInstanceOf方法。
    * 用 asInstanceOf 方法将引用转换为子类的引用。classOf获取对象的类名。
    * 1)  classOf[String]就如同Java的 String.class
    * 2)  obj.isInstanceOf[T]就如同Java的obj instanceof T
    * 3)  obj.asInstanceOf[T]就如同Java的(T)obj
    */

  println("Hello".isInstanceOf[String])
  println("123".asInstanceOf[String])
  println(classOf[String])


  // 4、受保护的字段和方法
  /**
    * 在Scala中，用protected关键字修饰的字段和方法，只有该类以及其子类才能访问，同一个包的其他类不能访问
    */

  // 5、超类的构造
  /**
    * class Person5(val name: String, val age: Int)
    * class Employee5(name: String, age: Int, val salary : Double) extends Person5(name, age)
    * Employee5 继承 Person5 必须实现父类的构造，Java中隐式调用super()，Scala中在继承的父类后填参
    */
  /**
    * 类有一个主构器和任意数量的辅助构造器，而每个辅助构造器都必须以对先前定义的辅助构造器或主构造器的调用开始。
    * 子类的辅助构造器最终都会调用主构造器，只有主构造器可以调用超类的辅助或主构造器。
    * 辅助构造器永远都不可能直接调用超类的构造器。在Scala的构造器中，你不能调用super(params)。
    */

  // 6、重写字段
  /**
    * 1、def只能重写另一个def
    *  2、val只能重写另一个val或不带参数的def
    *  3、var只能重写另一个抽象的var
    *  什么是抽象var？
    *  abstract class Person3 {
    *    var name:String  // name 就是抽象var。在抽象类中，没有初始值的字段是抽象字段，没有具体实现的方法是抽象方法
    *  }
    */

  // 7、匿名子类
  /**
    * 和Java一样，你可以通过包含带有定义或重写的代码块的方式创建一个匿名的子类
    * 代码块：{
    *   def greeting = "Greetings, Earthling! My name is Fred."
    * } 即为匿名子类
    */

  val alien = new Person7("fired"){
    def greeting = "Greetings, Earthling! My name is Fred."
  }
  println(alien.greeting)

  // 8、抽象类
  /**
    * 可以通过abstract关键字标记不能被实例化的类。
    * 方法不用标记abstract，只要省掉方法体即可。
    * 类可以拥有抽象字段，抽象字段就是没有初始值的字段。
    */

  val employee8 = new Employee8("Tony")
  println(employee8.idString)

  // 9、构造顺序和提前定义
  /**
    * 当子类重写了父类的方法或者字段后，父类又依赖这些字段或者方法初始化，这个时候就会出现问题，比如：
      class Creature {
        val range: Int = 10
        val env: Array[Int] = new Array[Int](range)
      }
      class Ant extends Creature {
        override val range = 2
      }
      此时的构造顺序为：
      1)  Ant的构造器在做它自己的构造之前，调用Creature的构造器
      2)  Creature的构造器将它的range字段设为10
      3)  Creature的构造器为了初始化env数组，调用range()取值器
      4)  该方法被重写以输出（还未初始化的）Ant类的range字段值
      5)  range方法返回0，（这是对象被分配空间时所有整形字段的初始值）
      6)  env被设为长度为0的数组。
      7)  Ant构造器继续执行，将其range字段设为2.
      那么env的大小是多少？是0，惊不惊喜，意不意外？
      问题解决，3种方案：
      1)  可以将val声明为final，这样子类不可改写。
      2)  可以将超类中将val声明为lazy，这样安全但并不高效。
      3)  还可以使用提前定义语法，可以在超类的构造器执行之前初始化子类的val字段：

      class Ant2 extends {
        override val range = 3
      } with Creature // 应用了动态混入
    */

}
