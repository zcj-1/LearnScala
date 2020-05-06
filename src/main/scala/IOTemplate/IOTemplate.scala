package IOTemplate

import java.io.{File, PrintWriter}

import scala.io.{Source, StdIn}

/** @author Chaojay
  * @since 2018-12-15 11:57
  */
// Scala 中的IO比Java简单，也可以完全使用Java的（ObjectInputStream,ObjectOutputStream）
object IOTemplate extends App {
  // 1、读取
  // 读取本地文件 Source.fromFile
  val file = Source.fromFile("C:\\Users\\chaojay\\Desktop\\电脑配置.txt", "UTF-8") // 返回一个char迭代器
  // 方式一：
  val lines = file.getLines()
  for (line <- lines){
    println(line)
  }

  // 方式二：
  val contents = file.mkString.split("\t") // 使用mkString方法将char转换为字符串，然后以\t切分

  println(contents.mkString(" "))  // mkString方法会遍历整个内容

  file.close()  // 关闭资源

  // 读取网络资源 Source.fromURL
  val webFile = Source.fromURL("http://www.baidu.com")

  webFile.foreach(print)

  webFile.close()


  // 2、写入 ： 实例化PrintWriter对象
  val writer = new PrintWriter(new File("writer.txt"))

  writer.print("nihao")

  writer.close()


  // 3、获取控制台输入

  println("请输入内容：")

  // 过时的 API: Console
  val consoleContent = Console.readLine()
  println("您输入的内容是：" + consoleContent)

  // 新 API：StdIn、StdOut
  println("请输入内容")
  val stdInContent = StdIn.readLine()
  println("您输入的内容是：" + stdInContent)


  // 4、序列化
  /**
    * Scala的序列化同样是继承 Serializable 类，序列ID在IDEA编辑器中好像只能手写添加在类名前
    *  例：
    *     @SerialVersionUID(1L) class Person extends Serializable{
    */


  // 5、进程控制
  // 1）执行shell
  /**
    * scala提供了scala.sys.process包，该包中提供了用于与shell程序交互的工具。
    * 注意：在执行shell操作时，必须以“；”分割
    */
//  import scala.sys.process._
//  "ls -al"!;
//  "ls -al"!!;
  /**
    * !和!!的区别：process包中有一个将字符串隐式转换成ProcessBuild对象的功能，感叹号就是执行这个对象。
    *            -- 单感叹号，程序执行成功返回0，执行失败返回非0，
    *            -- 双感叹号，程序执行成功结果以 字符串 的形式返回。
    */

  // 2）管道符 #|
//  "ls -al" #| "grep root"!!;

  // 3) 重定向 #>>
//  "ls -al" #>> new File("shell.txt")!;

  /**
    * 在Scala中还提供了以下shell操作：
    *               -- p #&& q，即p任务执行成功后，则执行q任务。
    *               -- p #|| q，即p任务执行不成功，则执行q任务。
    */


  // 6、正则表达式
  import scala.util.matching.Regex

  // 方式一：
  val pattern1 = new Regex("(S|s)cala")

  // 方式二：
  val pattern2 = "(S|s)cala".r

  val str = "Scala is scalable and cool"
  println((pattern2 findAllIn str).mkString(","))

}
