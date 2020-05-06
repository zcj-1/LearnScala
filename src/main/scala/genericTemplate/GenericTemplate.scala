package genericTemplate

/** @author Chaojay
  * @since 2018-12-14 8:38
  */
object GenericTemplate extends App {

  // 1、类型变量界定：上界、下届
  /**
    * 上界：
    * 在Java泛型里表示某个泛型是另外一个泛型的子类型可以使用extends关键字，
    * 而在scala中使用符号“<:”，这种形式称之为泛型的上界。
    *
    * 下界：
    * 在Java泛型里表示某个泛型是另外一个泛型的父类型，使用super关键字，
    * 而在scala中，使用符号“>:”，这种形式称之为泛型的下界。
    */

  /**
    * 上界多界：
    * 在Java中，T同时是A和B的子类型，称之为多界，形式如：<T extends A & B>。
    * 在Scala中，对上界和下界不能有多个，但是可以使用混合类型，如：[T <: A with B]。
    *
    * 下界多界：
    * 在Java中，不支持下界的多界形式。如:<T super A &Ｂ>这是不支持的。
    * 在Scala中，对复合类型依然可以使用下界，如：[T >: A with B]。
    */


  // 2、视图界定
  /**
    * 在Scala中，如果想标记某一个泛型可以隐式的转换为另一个泛型，可以使用 “<%”：[T <% Comparable[T]]，
    */


  // 3、上下文界定
  /**
    * 视图界定 T <% V要求必须存在一个从T到V的隐式转换。
    * 上下文界定的形式为 T:M，其中M是另一个泛型类，它要求必须存在一个类型为M[T]的隐式值。
    */


  // 4、Mainfest 上下文界定
  /**
    * Manifest是 scala2.8 引入的一个特质，用于编译器在运行时也能获取泛型类型的信息。
    * 在JVM上，泛型参数类型T在运行时是被“擦拭”掉的，编译器把T当作Object来对待，所以T的具体信息是无法得到的；
    * 为了使得在运行时得到T的信息，scala需要额外通过Manifest来存储T的信息，并作为参数用在方法的运行时上下文。
      def test[T] (x:T, m:Manifest[T]) { ... }
      有了Manifest[T]这个记录T类型信息的参数m，在运行时就可以根据m来更准确的判断T了。
      但如果每个方法都这么写，让方法的调用者要额外传入m参数，非常不友好，且对方法的设计是一道伤疤。
      好在scala中有隐式转换、隐式参数的功能，在这个地方可以用隐式参数来减轻调用者的麻烦。
      def test[T](x: T)(implicit m: Manifest[T]) { ... }
      隐式参数 m 是由编译器根据上下文自动传入的,表示的是参数类型
      不过上面的 test 方法定义使用隐式参数的方式，仍显得啰嗦，于是scala里又引入了“上下文绑定”，
      可以简化为：def test[T: Manifest](x: T) { ... }
      在引入Manifest的时候，还引入了一个更弱一点的ClassManifest，所谓的弱是指类型信息不如Manifest那么完整，
      主要针对高阶类型的情况
      scala在2.10里却用 TypeTag 替代了Manifest，用ClassTag替代了ClassManifest，原因是在路径依赖类型中，Manifest存在问题
      scala2.10以后：def test[T: TypeTag](x: T) { ... }
    */

  // Manifest 示例：
  def foo[T](x: List[T])(implicit m: Manifest[T]) = {
    println(m)
    if (m <:< manifest[String])  // <:< 协变
      println("Hey, this list is full of strings")
    else
      println("Non-stringy list")
  }

  foo(List("one", "two"))
  foo(List(1, 2))
  foo(List("one", 2))

  // TypeTag 示例见Animal


  // 5、多重界定
  /**
    * 类型变量界定：
    * 不能同时有多个上界或下界，变通的方式是使用复合类型
      T <: A with B
      T >: A with B
      可以同时有上界和下界，如
      T >: A <: B
      这种情况下界必须写在前边，上界写在后边，位置不能反。同时A要符合B的子类型，A与B不能是两个无关的类型。
    */

  /**
    * 视图界定：
    * 可以同时有多个view bounds
      T <% A <% B
      这种情况要求必须同时存在 T=>A的隐式转换，和T=>B的隐式转换。
    */

  // 示例见 A
  implicit def string2A(s:String) = new A
  implicit def string2B(s:String) = new B
  def foo2[ T <% A <% B](x:T)  = println("foo2 OK")
  foo2("test")

  /**
    * 上下文界定：
    * 可以同时有多个上下文界定
      T : C : D
      这种情况要求必须同时存在C[T]类型的隐式值，和D[T]类型的隐式值。
    */

  // 示例见 C
  implicit val c = new C[Int]
  implicit val d = new D[Int]
  def foo3[ T : C : D ](i:T) = println("foo3 OK")
  foo3(2)


  // 6、类型约束
  /**
    * T =:= U意思为：T类型是否等于U类型
      T <:< U意思为：T类型是否为U或U的子类型
      T <%< U意思为：T类型是否被隐式（视图）转换为U
      如果想使用上面的约束，需要添加“隐式类型证明参数”比如：
      class Pair5[T] (val first: T, val second: T)(implicit ev: T <:< Comparable[T]){}
    */

  // 7、型变
  /**
    *     英文	                中文	                          示例
      Variance	              型变	                    Function[-T, +R]
      Nonvariant	            不变	                        Array[A]
      Covariant	              协变                      	Supplier[+A]
      Contravariant	          逆变	                      Consumer[-A]
      Immutable	              不可变	                      String
      Mutable	                可变	                     StringBuilder
    */

  /**
    * 型变(Variance)拥有三种基本形态：协变(Covariant), 逆变(Contravariant), 不变(Nonconviant)，可以形式化地描述为：
    一般地，假设类型C[T]持有类型参数T；给定两个类型A和B，如果满足A <: B，则C[A]与 C[B]之间存在三种关系：
    如果C[A] <: C[B]，那么C是协变的(Covariant);
    如果C[A] >: C[B]，那么C是逆变的(Contravariant);
    否则，C是不变的(Nonvariant)。
    */

  /**
    * Scala的类型参数使用 + 标识“协变”，- 标识“逆变”，而不带任何标识的表示“不变”(Nonvariable)：
      trait C[+A]   // C is covariant
      trait C[-A]   // C is contravariant
      trait C[A]    // C is nonvariant
    */

  /**
    * 如何判断一个类型是否有型变能力：
      一般地，“不可变的”(Immutable)类型意味着“型变”(Variant)，而“可变的”(Mutable)意味着“不变”(Nonvariant)。
      其中，对于不可变的(Immutable)类型C[T]
      如果它是一个生产者，其类型参数应该是协变的，即C[+T]；
      如果它是一个消费者，其类型参数应该是逆变的，即C[-T]。
    */
}
