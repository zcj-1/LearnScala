package objectTemplate

/** @author Chaojay
  * @since 2018-12-13 9:16
  */
class Cat {
  val hair = Cat.growHair
  private var name = ""

  def changeName(name: String) = {
    this.name = name
  }

  def describe = println("hair:" + hair + "name:" + name)
}

object Cat {
  private var hair = 0

  def apply(): Cat = new Cat()

  private def growHair = {
    hair += 1
    hair
  }
}