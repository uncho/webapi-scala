package controllers

import models.db._

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import javax.inject.Inject

import play.api._
import play.api.mvc._
import play.api.libs.json.{JsString, JsNumber, Json}




class HomeController @Inject() (user_dao: UserDAO)  extends Controller {

  val names = List("tarou","baka","chinko","unko")
  val items = List(1, 2, 2)
  val profiles = Map("member" -> names.map(x => Map(x -> 1)), "items" -> names.map(x => Map(x -> 1)))

  def json() = {
    Json.obj("foo" -> "bar",
      "hoges" -> Json.obj("hoge1" -> 10, "hoge2" -> 20),
      "fugas" -> Json.arr(
        Json.obj("fuga1" -> 100, "fuga2" -> 200),
        Json.obj("fuga1" -> 1200, "fuga2" -> 2200)
      )
    )
  }

  def json2() = {
    Json.toJson(profiles)
  }

  def index() = Action {
    Ok(views.html.index("testString"))
  }

  def userList = Action.async {
    user_dao.searchAll.map(users => Ok(users.toString()))
  }

}
