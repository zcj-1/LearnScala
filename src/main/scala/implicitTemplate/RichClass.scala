package implicitTemplate

import java.io.File

import scala.io.Source

/** @author Chaojay
  * @since 2018-12-13 20:37
  */
class RichClass(file: File) {
  def read = Source.fromFile(file.getPath).mkString
}
