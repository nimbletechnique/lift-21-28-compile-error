package bootstrap.liftweb

import net.liftweb.http.rest.RestHelper
import net.liftweb.http.{GetRequest, Req}
import net.liftweb.json.JsonAST._
import net.liftweb.util.BasicTypesHelpers._

/**
 * Created by IntelliJ IDEA.
 * User: collin
 * Date: Sep 28, 2010
 * Time: 9:05:28 AM
 * To change this template use File | Settings | File Templates.
 */

object RestAPI extends RestHelper {
  serve {
    case Req("test" :: Nil, "xml", GetRequest) => <b>SUCCESS</b>
    case Req("test" :: Nil, "json", GetRequest) => JString("SUCCESS")

    case XmlGet("api" :: "static" :: Nil, request) => <b>Static: {request}</b>
    case JsonGet("api" :: "static" :: Nil, request) => JString("Static: " + request)

    case "api" :: "static" :: "user" :: _ XmlPost xml => <div>Received xml: {xml}</div>


  }
}
