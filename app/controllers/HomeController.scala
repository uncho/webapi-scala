package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.{JsString, JsNumber, Json}

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
class HomeController extends Controller {

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

  def index = Action {
    Ok(views.html.index("testString"))
  }

}
