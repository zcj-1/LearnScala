package implicitTemplate

/** @author Chaojay
  * @since 2018-12-13 21:19
  */
class Dog {
  val name = "金毛"
}

class Skill{
  def fly(animal: Dog,skill: String) = println(animal.name + "已经学会了" + skill)
}

object Learn{
  implicit def learningType(dog: Dog) = new Skill
}

object Run extends App{
  import implicitTemplate.Learn._  // 导入隐式转换函数所在的包，让Dog对象可以隐式转换为Skill对象
  val dog = new Dog
  dog.fly(dog, "游泳")
}
