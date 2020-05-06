package matchCase

/** @author Chaojay
  * @since 2018-12-12 14:20
  */
abstract class ItemTemplate
  case class Article(desc: String,price: Double) extends ItemTemplate
  case class Bundle(desc: String,discount: Double,itemTemplate: ItemTemplate*) extends ItemTemplate


