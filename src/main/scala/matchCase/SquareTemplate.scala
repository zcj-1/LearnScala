package matchCase

/** @author Chaojay
  * @since 2018-12-12 12:41
  */
object SquareTemplate {
  def unapply(arg: Double): Option[Double] = Some(math.sqrt(arg)) // 函数名是unapply，不能变
}
