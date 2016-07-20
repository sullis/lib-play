package io.flow.play.controllers

import io.flow.common.v0.models.{UserReference, User}
import io.flow.play.util.AuthData
import play.api.mvc.Results.Unauthorized
import scala.concurrent.Future
import play.api.mvc._

/**
  * Provides helpers for actions that require a user to be identified.
  */
trait IdentifiedController extends AnonymousController {

  import scala.concurrent.ExecutionContext.Implicits.global

  def unauthorized[A](request: Request[A]): Result = Unauthorized

  class IdentifiedRequest[A](
    val auth: AuthData,
    request: Request[A]
  ) extends WrappedRequest[A](request) {
    val user = auth.user
  }

  object Identified extends ActionBuilder[IdentifiedRequest] {

    def invokeBlock[A](request: Request[A], block: (IdentifiedRequest[A]) => Future[Result]) = {
      auth(request.headers) match {
        case None => {
          Future { unauthorized(request) }
        }
        case Some(auth) => {
          block(
            new IdentifiedRequest(auth, request)
          )
        }
      }
    }
  }
}

trait IdentifiedRestController extends IdentifiedController with UserFromFlowAuth
