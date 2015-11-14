package controllers

import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._

/**
  * Created by denzyl on 10/28/15.
  */
object User extends Controller {

  case class UserId(userId: Int)

  //  implicit val userRead: Reads[UserId] =    ((JsPath \ "userId").read[Int] ))(UserId.apply _)
  /**
    * Get user information
    * @return
    */
  def index = Action(BodyParsers.parse.json) { request => {

    Ok(Json.obj("status" -> "ok"))
    }
  }
}
