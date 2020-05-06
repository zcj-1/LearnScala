package genericTemplate

/** @author Chaojay
  * @since 2018-12-14 9:09
  */
class Animal

class Dog extends Animal {}

object MainFoo extends App {
  override def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3)
    val list2 = List("1", "2", "3")
    val list3 = List("1", "2", 3)

    def test1(x: List[Any]) = {  // 因为泛型被擦除，所以只会打印 Int list
      x match {
        case list: List[Int] => "Int list"
        case list: List[String] => "String list"
        case list: List[Any] => "Any list"
      }
    }

    println(test1(list1))
    println(test1(list2))
    println(test1(list3))

    import scala.reflect.runtime.universe._   // 导包
    def test2[A: TypeTag](x: List[A]) = typeOf[A] match {   // 这里使用 typeOf[A] 来进行泛型匹配
      case t if t =:= typeOf[String] => "String List"
      case t if t <:< typeOf[Animal] => "Dog List"
      case t if t =:= typeOf[Int] => "Int List"
    }

    println(test2(List("string")))
    println(test2(List(new Dog)))
    println(test2(List(1, 2)))
  }
}

