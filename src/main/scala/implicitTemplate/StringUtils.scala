package implicitTemplate

/** @author Chaojay
  * @since 2018-12-13 21:27
  */
object StringUtils {
  // 隐式类
  implicit class StringImprovement(val s: String){
    def increment = s.map(x => (x + 1).toChar)
  }
}

object Main extends App{
  import implicitTemplate.StringUtils._
  println("mobin".increment)
}
