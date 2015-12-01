package controllers
import play.api.mvc._
import play.api.libs.json._

/**
  * Created by denzyl on 10/28/15.
  */
case class UserId(userId: Int)
object User extends Controller {

//    implicit val userRead: Reads[Int] =    (JsPath \ "userId").read[Int]
//  )UserId _
  /**
    * Get user information
    * @return
    */
  def index = Action(BodyParsers.parse.json) { request => {

    Ok(Json.obj("status" -> "ok"))
    }
  }
}
