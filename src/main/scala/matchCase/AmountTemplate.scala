package matchCase

/** @author Chaojay
  * @since 2018-12-12 13:51
  */
abstract class AmountTemplate
  case class Dollar(value: Double) extends AmountTemplate
  case class Currency(value: Double, Unit: String) extends AmountTemplate


