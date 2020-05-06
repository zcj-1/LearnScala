package classTemplate

/** @author Chaojay
  * @since 2018-12-12 19:23
  */
/**
  * 6、单例对象
  *  主构造器私有化
  *  通过伴生类对象来创建静态对象
  */
class CacheBean private {

}

object CacheBean{
  var instance: CacheBean = _

  def apply(): CacheBean = {
    if (instance == null){
      instance = new CacheBean
    }
    instance
  }
}
