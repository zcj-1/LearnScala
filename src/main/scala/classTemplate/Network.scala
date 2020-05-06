package classTemplate

import scala.collection.mutable.ArrayBuffer

/** @author Chaojay
  * @since 2018-12-13 8:56
  */
class Network {

  // 此时Member的全类名是new Network().Member
  class Member(name: String){

    // 记录每一个Member的联系人
    val contacts = new ArrayBuffer[Network#Member]()
  }

  // 记录当前局域网内的用户
  val members = new ArrayBuffer[Network#Member]()

  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}
