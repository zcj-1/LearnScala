package matchCase

/** @author Chaojay
  * @since 2018-12-12 14:42
  */
sealed abstract class TrafficLightColorTemplate // 密封类
  case object Red extends TrafficLightColorTemplate  // 直接是object对象
  case object Yellow extends TrafficLightColorTemplate
  case object Green extends TrafficLightColorTemplate

