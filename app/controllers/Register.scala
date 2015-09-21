package controllers

import controllers.Application._
import play.api.mvc.Action
import play.mvc.Controller
/**
* @author denzyl
*/
object Register extends Controller{
  def index = Action {
    Ok(views.html.register())
  }
}
