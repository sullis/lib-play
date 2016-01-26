package io.flow.play.expanders

import io.flow.common.v0.models.UserReference
import io.flow.play.util.Expander
import play.api.libs.json._
import scala.concurrent.{Future, ExecutionContext}
import io.flow.common.v0.models.json._

case class User (
  fieldName: String,
  userClient: io.flow.user.v0.interfaces.Client
  ) extends Expander {
  def expand(records: Seq[JsValue])(implicit ec: ExecutionContext): Future[Seq[JsValue]] = {
    val userIds: Seq[String] = records.map { r =>
      ((r \ fieldName).validate[UserReference]: @unchecked) match {
        case JsSuccess(userReference, _) => userReference.id
      }
    }

    userIds match {
      case Nil => Future {
        records
      }
      case ids => {
        userClient.users.get(id = Some(ids), limit = userIds.size).map(users =>
          Map(users.map(user => user.id -> user): _*)
        ).map(userIdLookup =>
          records.map { r =>
            r.validate[JsObject] match {
              case JsSuccess(obj, _) => {
                (r \ fieldName).validate[UserReference] match {
                  case JsSuccess(userReference, _) => {
                    obj ++ Json.obj(
                      fieldName ->
                        (userIdLookup.get(userReference.id) match {  //getOrElse can't be used to serialize multiple types - no formatter
                          case Some(user) => Json.toJson(user)
                          case None => Json.toJson(userReference)
                        })
                    )
                  }
                  case JsError(_) => r
                }
              }
              case JsError(_) => r
            }
          }
        )
      }
    }
  }
}
