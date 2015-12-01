package controllers

import models.{Authentication, User}
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._


object Login extends Controller {

  case class Credentials(email: String, password: String)

  implicit val credentialReads: Reads[Credentials] =
    (
      (JsPath \ "email").read[String] and (JsPath \ "password").read[String]
    )(Credentials.apply _)

  def index = Action(BodyParsers.parse.json) { request =>
    val login = request.body.validate[Credentials]
    login.fold(
      error => {
        BadRequest(Json.obj("status" -> "false", "message" -> "Bad request"))
      }, valid = credentials => {
        val user: Boolean = new User().login(credentials.email, credentials.password)
        if (user) {
          Ok(Json.obj("access_token"->"FOQWPEJFBNGURG)$$M@LROSLSLQL:QPERO#$K!-tu9"))
        } else {
          BadRequest(Json.obj("status" -> "false", "message" -> "Wrong credentials"))
        }
      }
    )
  }
}
