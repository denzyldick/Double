package models

import java.math.BigInteger
import java.security.SecureRandom
import java.sql.{ResultSet, Connection}

import play.api.db.DB
import play.mvc.WebSocket
import play.mvc.WebSocket.{In, Out}
import play.api.Play.current

/**
  * Created by denzyl on 11/4/15.
  */
abstract class UserSocket() {
  val connection: Connection = DB.getConnection()

  var in: WebSocket.In[String]
  var out: WebSocket.Out[String]

  def socket(in: WebSocket.In[String], out: WebSocket.Out[String]): Unit = {

    this.in = in
    this.out = out

  }

}

class User extends UserSocket {
  override var in: In[String] = _
  override var out: Out[String] = _


  def login(email: String, password: String): Boolean = {
    val statement = connection.prepareStatement("SELECT * FROM user WHERE email = ? AND password  = ?")
    statement.setString(1, email)
    statement.setString(2, password)
    println(email + password + statement.executeQuery().first())
    statement.executeQuery().first()
  }

  def authorized(token: String): Boolean = {
    val statement = connection.prepareStatement("SELECT * FROM user WHERE token = ?")
    statement.setString(1, token)
    statement.executeQuery.first()
  }

  def create(email: String, password: String, name: String, sex: String): Boolean = {
    val statement = connection.prepareStatement("INSERT INTO user(email,password,name,sex,token)VALUES(?,?,?,?,?)")
    statement.setString(1, email)
    statement.setString(2, password)
    statement.setString(3, name)
    statement.setString(4, sex)
    statement.execute()
  }

  def generateToken(): String = {
    new BigInteger(130, new SecureRandom()).toString
  }

  def isCouple(user: User): Boolean = {
    true
  }

  def sentMessage(m: Message): Unit = {
    this.out.write(m.get)
  }
}
