package ReflectTemplate

/** @author Chaojay
  * @since 2018-12-15 10:37
  */
class Person(var name: String,var age: Int) {
  def myPrint() = println("Person类中的myPrint方法")
}

object PersonMain extends App{

  // 一、Scala 通过反射获取实例化对象
  // 1、得到 JavaUniverse 用于反射
  val ref = scala.reflect.runtime.universe

  // 2、得到一个 JavaMirror，用于反射 Person.Class
  val javaMirror = ref.runtimeMirror(getClass.getClassLoader)

  // 3、得到 Person 类的 Type 对象后，得到 type 的特征值并转为ClassSymbol对象
  val personClassSymbol = ref.typeOf[Person].typeSymbol.asClass

  // 4、得到ClassMirror
  val personClassMirror = javaMirror.reflectClass(personClassSymbol)

  // 5、得到构造器Method
  val constructor = ref.typeOf[Person].decl(ref.termNames.CONSTRUCTOR).asMethod

  // 6、实例化反射的对象
  val methodMirror = personClassMirror.reflectConstructor(constructor)

  val person = methodMirror("John", 18)
  /**
    *  实例化对象时要有小括号()，因为是动态反射。此时不能通过反射的对象直接调用方法和属性，还需要通过反射获取
    */
  println(person)

  // 二、Scala 通过反射获取属性
  // 7、通过反射对象获取实例镜像
  val instanceMirror = javaMirror.reflect(person)

  // 8、获取指定的方法
  val method = ref.typeOf[Person].decl(ref.TermName("myPrint")).asMethod

  // 9、通过实例镜像反射得到指定的方法
  val myMethod = instanceMirror.reflectMethod(method)

  // 10、方法调用
  myMethod

  // 三、Scala 通过反射获取方法
  // 11、获取指定属性
  val fields = ref.typeOf[Person].decl(ref.TermName("name")).asTerm

  // 12、通过实例镜像反射得到指定的属性
  val myField = instanceMirror.reflectField(fields)

  // 13、打印属性值。
  println(myField.get)
}
