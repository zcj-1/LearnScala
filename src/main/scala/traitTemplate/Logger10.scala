package traitTemplate
import java.io.PrintStream
/** @author Chaojay
  * @since 2018-12-14 10:13
  */
// 10、初始化特质中的字段
trait Logger10 {
  def log(msg: String)
}

trait FileLogger10 extends Logger10 {
  val fileName: String
  val out = new PrintStream(fileName)  // 打印流对象

  override def log(msg: String): Unit = {
    out.print(msg)
    out.flush()
  }
}

class DrawAccount10 {

}

object Main10 extends App {
  //提前定义
  val acct = new {
    override val fileName = "2018-12-14.log"
  } with FileLogger10
  acct.log("heiheihei")
}

