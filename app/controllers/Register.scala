package controllers

import controllers.Application._
import play.api.libs.json._
import play.api.mvc._
import play.mvc.Controller
import play.api.libs.functional.syntax._
/**
* @author denzyl
*/
object Register extends Controller{

  case class NewUser(coupleEmail:String,email:String,password:String,name:String)

  implicit val newUserRead: Reads[NewUser] =
  (
      (JsPath \ "coupleEmail").read[String] and
      (JsPath \ "email").read[String] and
      (JsPath \ "password").read[String] and
      (JsPath \ "name").read[String]
    )(NewUser.apply _)

  def index = Action(BodyParsers.parse.json){request => {
    val register = request.body.validate[NewUser]

    register.fold(
      error => {
        BadRequest(Json.obj("status" -> "false", "message" -> "Bad json request"))
      },
      valid = newuser => {
        Ok(Json.obj("status" -> "true", "message" -> "message received successfully"))
      }
    )
    Ok(Json.obj("status" -> "true"))
  }
  }
}
