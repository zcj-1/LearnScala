package classTemplate

/** @author Chaojay
  * @since 2018-12-12 18:44
  */
/**
  * 3、类的私有字段属性
  */
package society{
  package professional{
    class Executive {
      private[professional] var workDetails = null
      private[society] var friends = null
      private[this] var secrets = null

      def help(another: Executive) {
        println(another.workDetails)
//      println(another.secrets) // 因为another属于另一个Executive对象，而secrets字段是当前this对象的字段，所以会报错：访问不到
      }

    }
  }
}
