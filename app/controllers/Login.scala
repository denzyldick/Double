package controllers

import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._



object Login extends Controller {
  case class Credentials(email:String,password:String)
  implicit val credentialsWrites: Writes[Credentials] =(
    (JsPath \ "email").write[String] and
      (JsPath \ "password").write[String]
    )(unlift(Credentials.unapply))

//  def index = Action(BodyParsers.parse.json){ request =>
//    val login = request.body.validate[Credentials]
//    login.fold(
//    error =>{
//      BadRequest(Json.obj("status" ->"KO", "message" -> "Nad req"))
//    },credentials =>{
//        Ok(Json.obj("status"->"ok","message"->"loged in"))
//      }
//    )
//  }


}
