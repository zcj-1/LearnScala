package implicitTemplate

import java.io.File

/** @author Chaojay
  * @since 2018-12-13 19:38
  */
object ImplicitTemplate extends App {

  // 1、隐式转换
  /**
    * 隐式转换函数是以implicit关键字声明的带有单个参数的函数。
    * 这种函数将会自动应用，将值从一种类型转换为另一种类型。
    */

  implicit def test(x: Double) = x.toInt  // 函数名可以任意取，必须是单个参数。该函数可以将Double类型隐式转换为Int类型

  val a: Int = 2.6

  println(a)  // 结果：2

  // 2、利用隐式转换丰富类库功能
  /**
    * 如果需要为一个类增加一个方法，可以通过隐式转换来实现
    *     优点：可以不修改该类的源代码而为该类增加新功能
    */

  implicit def fileToRichClass(fileName: File) = new RichClass(fileName) // 将 File 类转换为 RichClass 类

  val fileContents = new File("C:\\Users\\chaojay\\Desktop\\test1.txt").read  // 此时可以调用 RichClass 类的 read 方法
  println(fileContents)

  // 3、隐式值
  /**
    * 将变量标记为implicit，编译器会在方法省略隐式参数的情况下去搜索作用域内匹配给隐式参数类型的隐式值作为缺少参数
    * 当同时匹配到多个隐式值时，会出现二义性，此时会报错
    */

  implicit val name = "隐式值"
  implicit val x = 12

  def test(implicit arg: Int) = arg  // 定义一个包含了隐式参数的函数，返回值是参数

  println(test)  // 此时不传参数  结果：隐式值

  // 4、隐式视图
  /**
    *  1）隐式转换目标类型：即把一种类型隐式转换为另一种类型
    *  2）隐式转换调用类中不存在的方法
    */

  // 1）
  def foo(msg: String) = println(msg)

  implicit def intToString(x: Int) = x.toString

  foo(10)

  // 2) 见 Dog 类

  // 5、隐式类
  /**
    * 在Scala2.10后提供了隐式类，注意：
    *                 1）隐式类所带的构造参数有且只有一个（隐式函数也只能有一个参数）
    *                 2）隐式类必须被定义在“类”或“伴生对象”或“包对象”里
    *                 3）隐式类不能是样例类，即 case class，因为样例类会自动生成伴生类对象
    *                 4）作用域内不能有与之相同名称的标示符
    */

  // 见 StringUtils

  // 6、隐式转换的时机
  /**
    * 1)  当方法中的参数的类型与目标类型不一致时
    * 2)  当对象调用所在类中不存在的方法或成员时，编译器会自动将对象进行隐式转换
    */

  // 7、隐式解析机制
  /**
    * 即编译器是如何查找到缺失信息的，解析具有以下两种规则：
    * 1)  首先会在当前代码作用域下查找隐式实体（隐式方法、隐式类、隐式对象）。
    * 2)  如果第一条规则查找隐式实体失败，会继续在隐式参数的类型的作用域里查找。
    *     类型的作用域是指与该类型相关联的全部伴生模块，一个隐式实体的类型 T 它的查找范围如下：
    *         a)  如果T被定义为T with A with B with C,那么A,B,C都是T的部分，在T的隐式解析过程中，它们的伴生对象都会被搜索。
    *         b)  如果T是参数化类型，那么类型参数和与类型参数相关联的部分都算作T的部分，
    *             比如List[String]的隐式搜索会搜索List的伴生对象和String的伴生对象。
    *         c)  如果T是一个单例类型p.T，即T是属于某个p对象内，那么这个p对象也会被搜索。
    *         d)  如果T是个类型注入S#T，那么S和T都会被搜索。
    */

  // 8、隐式转换的前提
  /**
    * 1)  不能存在二义性
    * 2)  隐式操作不能嵌套
    */
}
