package controllers

import play.api.libs.json.Json
import play.api.mvc._


object Application extends Controller {

  def index = Action {
    Ok(Json.obj("status"->"ok"))
  }

}