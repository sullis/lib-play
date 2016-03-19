/**
 * Generated by apidoc - http://www.apidoc.me
 * Service version: 0.0.11
 * apidoc:0.11.19 http://www.apidoc.me/flow/user/0.0.11/play_2_4_client
 */
package io.flow.user.v0.models {

  case class AuthenticationForm(
    email: String,
    password: String
  )

  /**
   * Represents the successful response of an email verification token. We return the
   * email address in this case to allow the UI to display which email address was
   * verified.
   */
  case class EmailVerification(
    email: String
  )

  case class NameForm(
    first: _root_.scala.Option[String] = None,
    last: _root_.scala.Option[String] = None
  )

  case class PasswordChangeForm(
    current: String,
    `new`: String
  )

  case class PasswordResetForm(
    token: String,
    password: String
  )

  case class PasswordResetRequestForm(
    email: String
  )

  case class UserForm(
    email: _root_.scala.Option[String] = None,
    password: _root_.scala.Option[String] = None,
    name: _root_.scala.Option[io.flow.user.v0.models.NameForm] = None
  )

  case class UserPutForm(
    email: _root_.scala.Option[String] = None,
    name: _root_.scala.Option[io.flow.user.v0.models.NameForm] = None
  )

  case class UserVersion(
    id: String,
    timestamp: _root_.org.joda.time.DateTime,
    `type`: io.flow.common.v0.models.ChangeType,
    user: io.flow.common.v0.models.User
  )

}

package io.flow.user.v0.models {

  package object json {
    import play.api.libs.json.__
    import play.api.libs.json.JsString
    import play.api.libs.json.Writes
    import play.api.libs.functional.syntax._
    import io.flow.common.v0.models.json._
    import io.flow.user.v0.models.json._

    private[v0] implicit val jsonReadsUUID = __.read[String].map(java.util.UUID.fromString)

    private[v0] implicit val jsonWritesUUID = new Writes[java.util.UUID] {
      def writes(x: java.util.UUID) = JsString(x.toString)
    }

    private[v0] implicit val jsonReadsJodaDateTime = __.read[String].map { str =>
      import org.joda.time.format.ISODateTimeFormat.dateTimeParser
      dateTimeParser.parseDateTime(str)
    }

    private[v0] implicit val jsonWritesJodaDateTime = new Writes[org.joda.time.DateTime] {
      def writes(x: org.joda.time.DateTime) = {
        import org.joda.time.format.ISODateTimeFormat.dateTime
        val str = dateTime.print(x)
        JsString(str)
      }
    }

    implicit def jsonReadsUserAuthenticationForm: play.api.libs.json.Reads[AuthenticationForm] = {
      (
        (__ \ "email").read[String] and
        (__ \ "password").read[String]
      )(AuthenticationForm.apply _)
    }

    def jsObjectAuthenticationForm(obj: io.flow.user.v0.models.AuthenticationForm) = {
      play.api.libs.json.Json.obj(
        "email" -> play.api.libs.json.JsString(obj.email),
        "password" -> play.api.libs.json.JsString(obj.password)
      )
    }

    implicit def jsonWritesUserAuthenticationForm: play.api.libs.json.Writes[AuthenticationForm] = {
      new play.api.libs.json.Writes[io.flow.user.v0.models.AuthenticationForm] {
        def writes(obj: io.flow.user.v0.models.AuthenticationForm) = {
          jsObjectAuthenticationForm(obj)
        }
      }
    }

    implicit def jsonReadsUserEmailVerification: play.api.libs.json.Reads[EmailVerification] = {
      (__ \ "email").read[String].map { x => new EmailVerification(email = x) }
    }

    def jsObjectEmailVerification(obj: io.flow.user.v0.models.EmailVerification) = {
      play.api.libs.json.Json.obj(
        "email" -> play.api.libs.json.JsString(obj.email)
      )
    }

    implicit def jsonWritesUserEmailVerification: play.api.libs.json.Writes[EmailVerification] = {
      new play.api.libs.json.Writes[io.flow.user.v0.models.EmailVerification] {
        def writes(obj: io.flow.user.v0.models.EmailVerification) = {
          jsObjectEmailVerification(obj)
        }
      }
    }

    implicit def jsonReadsUserNameForm: play.api.libs.json.Reads[NameForm] = {
      (
        (__ \ "first").readNullable[String] and
        (__ \ "last").readNullable[String]
      )(NameForm.apply _)
    }

    def jsObjectNameForm(obj: io.flow.user.v0.models.NameForm) = {
      (obj.first match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("first" -> play.api.libs.json.JsString(x))
      }) ++
      (obj.last match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("last" -> play.api.libs.json.JsString(x))
      })
    }

    implicit def jsonWritesUserNameForm: play.api.libs.json.Writes[NameForm] = {
      new play.api.libs.json.Writes[io.flow.user.v0.models.NameForm] {
        def writes(obj: io.flow.user.v0.models.NameForm) = {
          jsObjectNameForm(obj)
        }
      }
    }

    implicit def jsonReadsUserPasswordChangeForm: play.api.libs.json.Reads[PasswordChangeForm] = {
      (
        (__ \ "current").read[String] and
        (__ \ "new").read[String]
      )(PasswordChangeForm.apply _)
    }

    def jsObjectPasswordChangeForm(obj: io.flow.user.v0.models.PasswordChangeForm) = {
      play.api.libs.json.Json.obj(
        "current" -> play.api.libs.json.JsString(obj.current),
        "new" -> play.api.libs.json.JsString(obj.`new`)
      )
    }

    implicit def jsonWritesUserPasswordChangeForm: play.api.libs.json.Writes[PasswordChangeForm] = {
      new play.api.libs.json.Writes[io.flow.user.v0.models.PasswordChangeForm] {
        def writes(obj: io.flow.user.v0.models.PasswordChangeForm) = {
          jsObjectPasswordChangeForm(obj)
        }
      }
    }

    implicit def jsonReadsUserPasswordResetForm: play.api.libs.json.Reads[PasswordResetForm] = {
      (
        (__ \ "token").read[String] and
        (__ \ "password").read[String]
      )(PasswordResetForm.apply _)
    }

    def jsObjectPasswordResetForm(obj: io.flow.user.v0.models.PasswordResetForm) = {
      play.api.libs.json.Json.obj(
        "token" -> play.api.libs.json.JsString(obj.token),
        "password" -> play.api.libs.json.JsString(obj.password)
      )
    }

    implicit def jsonWritesUserPasswordResetForm: play.api.libs.json.Writes[PasswordResetForm] = {
      new play.api.libs.json.Writes[io.flow.user.v0.models.PasswordResetForm] {
        def writes(obj: io.flow.user.v0.models.PasswordResetForm) = {
          jsObjectPasswordResetForm(obj)
        }
      }
    }

    implicit def jsonReadsUserPasswordResetRequestForm: play.api.libs.json.Reads[PasswordResetRequestForm] = {
      (__ \ "email").read[String].map { x => new PasswordResetRequestForm(email = x) }
    }

    def jsObjectPasswordResetRequestForm(obj: io.flow.user.v0.models.PasswordResetRequestForm) = {
      play.api.libs.json.Json.obj(
        "email" -> play.api.libs.json.JsString(obj.email)
      )
    }

    implicit def jsonWritesUserPasswordResetRequestForm: play.api.libs.json.Writes[PasswordResetRequestForm] = {
      new play.api.libs.json.Writes[io.flow.user.v0.models.PasswordResetRequestForm] {
        def writes(obj: io.flow.user.v0.models.PasswordResetRequestForm) = {
          jsObjectPasswordResetRequestForm(obj)
        }
      }
    }

    implicit def jsonReadsUserUserForm: play.api.libs.json.Reads[UserForm] = {
      (
        (__ \ "email").readNullable[String] and
        (__ \ "password").readNullable[String] and
        (__ \ "name").readNullable[io.flow.user.v0.models.NameForm]
      )(UserForm.apply _)
    }

    def jsObjectUserForm(obj: io.flow.user.v0.models.UserForm) = {
      (obj.email match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("email" -> play.api.libs.json.JsString(x))
      }) ++
      (obj.password match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("password" -> play.api.libs.json.JsString(x))
      }) ++
      (obj.name match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("name" -> jsObjectNameForm(x))
      })
    }

    implicit def jsonWritesUserUserForm: play.api.libs.json.Writes[UserForm] = {
      new play.api.libs.json.Writes[io.flow.user.v0.models.UserForm] {
        def writes(obj: io.flow.user.v0.models.UserForm) = {
          jsObjectUserForm(obj)
        }
      }
    }

    implicit def jsonReadsUserUserPutForm: play.api.libs.json.Reads[UserPutForm] = {
      (
        (__ \ "email").readNullable[String] and
        (__ \ "name").readNullable[io.flow.user.v0.models.NameForm]
      )(UserPutForm.apply _)
    }

    def jsObjectUserPutForm(obj: io.flow.user.v0.models.UserPutForm) = {
      (obj.email match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("email" -> play.api.libs.json.JsString(x))
      }) ++
      (obj.name match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("name" -> jsObjectNameForm(x))
      })
    }

    implicit def jsonWritesUserUserPutForm: play.api.libs.json.Writes[UserPutForm] = {
      new play.api.libs.json.Writes[io.flow.user.v0.models.UserPutForm] {
        def writes(obj: io.flow.user.v0.models.UserPutForm) = {
          jsObjectUserPutForm(obj)
        }
      }
    }

    implicit def jsonReadsUserUserVersion: play.api.libs.json.Reads[UserVersion] = {
      (
        (__ \ "id").read[String] and
        (__ \ "timestamp").read[_root_.org.joda.time.DateTime] and
        (__ \ "type").read[io.flow.common.v0.models.ChangeType] and
        (__ \ "user").read[io.flow.common.v0.models.User]
      )(UserVersion.apply _)
    }

    def jsObjectUserVersion(obj: io.flow.user.v0.models.UserVersion) = {
      play.api.libs.json.Json.obj(
        "id" -> play.api.libs.json.JsString(obj.id),
        "timestamp" -> play.api.libs.json.JsString(_root_.org.joda.time.format.ISODateTimeFormat.dateTime.print(obj.timestamp)),
        "type" -> play.api.libs.json.JsString(obj.`type`.toString),
        "user" -> io.flow.common.v0.models.json.jsObjectUser(obj.user)
      )
    }

    implicit def jsonWritesUserUserVersion: play.api.libs.json.Writes[UserVersion] = {
      new play.api.libs.json.Writes[io.flow.user.v0.models.UserVersion] {
        def writes(obj: io.flow.user.v0.models.UserVersion) = {
          jsObjectUserVersion(obj)
        }
      }
    }
  }
}

package io.flow.user.v0 {

  object Bindables {

    import play.api.mvc.{PathBindable, QueryStringBindable}
    import org.joda.time.{DateTime, LocalDate}
    import org.joda.time.format.ISODateTimeFormat
    import io.flow.user.v0.models._

    // Type: date-time-iso8601
    implicit val pathBindableTypeDateTimeIso8601 = new PathBindable.Parsing[org.joda.time.DateTime](
      ISODateTimeFormat.dateTimeParser.parseDateTime(_), _.toString, (key: String, e: Exception) => s"Error parsing date time $key. Example: 2014-04-29T11:56:52Z"
    )

    implicit val queryStringBindableTypeDateTimeIso8601 = new QueryStringBindable.Parsing[org.joda.time.DateTime](
      ISODateTimeFormat.dateTimeParser.parseDateTime(_), _.toString, (key: String, e: Exception) => s"Error parsing date time $key. Example: 2014-04-29T11:56:52Z"
    )

    // Type: date-iso8601
    implicit val pathBindableTypeDateIso8601 = new PathBindable.Parsing[org.joda.time.LocalDate](
      ISODateTimeFormat.yearMonthDay.parseLocalDate(_), _.toString, (key: String, e: Exception) => s"Error parsing date $key. Example: 2014-04-29"
    )

    implicit val queryStringBindableTypeDateIso8601 = new QueryStringBindable.Parsing[org.joda.time.LocalDate](
      ISODateTimeFormat.yearMonthDay.parseLocalDate(_), _.toString, (key: String, e: Exception) => s"Error parsing date $key. Example: 2014-04-29"
    )



  }

}


package io.flow.user.v0 {

  object Constants {

    val Namespace = "io.flow.user.v0"
    val UserAgent = "apidoc:0.11.19 http://www.apidoc.me/flow/user/0.0.11/play_2_4_client"
    val Version = "0.0.11"
    val VersionMajor = 0

  }

  class Client(
    val baseUrl: String,
    auth: scala.Option[io.flow.user.v0.Authorization] = None,
    defaultHeaders: Seq[(String, String)] = Nil
  ) extends interfaces.Client {
    import io.flow.common.v0.models.json._
    import io.flow.user.v0.models.json._

    private[this] val logger = play.api.Logger("io.flow.user.v0.Client")

    logger.info(s"Initializing io.flow.user.v0.Client for url $baseUrl")

    def emailVerifications: EmailVerifications = EmailVerifications

    def healthchecks: Healthchecks = Healthchecks

    def passwordResetForms: PasswordResetForms = PasswordResetForms

    def users: Users = Users

    object EmailVerifications extends EmailVerifications {
      override def postByToken(
        token: String
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.user.v0.models.EmailVerification] = {
        _executeRequest("POST", s"/users/emails/verifications/${play.utils.UriEncoding.encodePathSegment(token, "UTF-8")}").map {
          case r if r.status == 200 => _root_.io.flow.user.v0.Client.parseJson("io.flow.user.v0.models.EmailVerification", r, _.validate[io.flow.user.v0.models.EmailVerification])
          case r if r.status == 401 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r if r.status == 422 => throw new io.flow.user.v0.errors.ErrorsResponse(r)
          case r => throw new io.flow.user.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200, 401, 422")
        }
      }
    }

    object Healthchecks extends Healthchecks {
      override def getHealthcheck()(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.Healthcheck] = {
        _executeRequest("GET", s"/_internal_/healthcheck").map {
          case r if r.status == 200 => _root_.io.flow.user.v0.Client.parseJson("io.flow.common.v0.models.Healthcheck", r, _.validate[io.flow.common.v0.models.Healthcheck])
          case r => throw new io.flow.user.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200")
        }
      }
    }

    object PasswordResetForms extends PasswordResetForms {
      override def postResets(
        passwordResetRequestForm: io.flow.user.v0.models.PasswordResetRequestForm
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit] = {
        val payload = play.api.libs.json.Json.toJson(passwordResetRequestForm)

        _executeRequest("POST", s"/users/passwords/resets", body = Some(payload)).map {
          case r if r.status == 204 => ()
          case r if r.status == 401 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r if r.status == 422 => throw new io.flow.user.v0.errors.ErrorsResponse(r)
          case r => throw new io.flow.user.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 204, 401, 422")
        }
      }

      override def post(
        passwordResetForm: io.flow.user.v0.models.PasswordResetForm,
        expand: _root_.scala.Option[Seq[String]] = None
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.ExpandableUser] = {
        val payload = play.api.libs.json.Json.toJson(passwordResetForm)

        val queryParameters = expand.getOrElse(Nil).map("expand" -> _)

        _executeRequest("POST", s"/users/passwords", body = Some(payload), queryParameters = queryParameters).map {
          case r if r.status == 200 => _root_.io.flow.user.v0.Client.parseJson("io.flow.common.v0.models.ExpandableUser", r, _.validate[io.flow.common.v0.models.ExpandableUser])
          case r if r.status == 401 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r if r.status == 404 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r if r.status == 422 => throw new io.flow.user.v0.errors.ErrorsResponse(r)
          case r => throw new io.flow.user.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200, 401, 404, 422")
        }
      }
    }

    object Users extends Users {
      override def get(
        id: _root_.scala.Option[Seq[String]] = None,
        email: _root_.scala.Option[String] = None,
        limit: Long = 25,
        offset: Long = 0,
        sort: String = "-created_at",
        headers: Seq[(String, String)] = Nil
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[io.flow.common.v0.models.User]] = {
        val queryParameters = Seq(
          email.map("email" -> _),
          Some("limit" -> limit.toString),
          Some("offset" -> offset.toString),
          Some("sort" -> sort)
        ).flatten ++
          id.getOrElse(Nil).map("id" -> _)

        _executeRequest("GET", s"/users", queryParameters = queryParameters).map {
          case r if r.status == 200 => _root_.io.flow.user.v0.Client.parseJson("Seq[io.flow.common.v0.models.User]", r, _.validate[Seq[io.flow.common.v0.models.User]])
          case r if r.status == 401 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r => throw new io.flow.user.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200, 401")
        }
      }

      override def getVersions(
        id: _root_.scala.Option[Seq[String]] = None,
        userId: _root_.scala.Option[Seq[String]] = None,
        limit: Long = 25,
        offset: Long = 0,
        sort: String = "journal_timestamp"
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[io.flow.user.v0.models.UserVersion]] = {
        val queryParameters = Seq(
          Some("limit" -> limit.toString),
          Some("offset" -> offset.toString),
          Some("sort" -> sort)
        ).flatten ++
          id.getOrElse(Nil).map("id" -> _) ++
          userId.getOrElse(Nil).map("user_id" -> _)

        _executeRequest("GET", s"/users/versions", queryParameters = queryParameters).map {
          case r if r.status == 200 => _root_.io.flow.user.v0.Client.parseJson("Seq[io.flow.user.v0.models.UserVersion]", r, _.validate[Seq[io.flow.user.v0.models.UserVersion]])
          case r if r.status == 401 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r => throw new io.flow.user.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200, 401")
        }
      }

      override def postAuthenticate(
        authenticationForm: io.flow.user.v0.models.AuthenticationForm
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.User] = {
        val payload = play.api.libs.json.Json.toJson(authenticationForm)

        _executeRequest("POST", s"/users/authenticate", body = Some(payload)).map {
          case r if r.status == 200 => _root_.io.flow.user.v0.Client.parseJson("io.flow.common.v0.models.User", r, _.validate[io.flow.common.v0.models.User])
          case r if r.status == 401 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r if r.status == 404 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r if r.status == 422 => throw new io.flow.user.v0.errors.ErrorsResponse(r)
          case r => throw new io.flow.user.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200, 401, 404, 422")
        }
      }

      override def getById(
        id: String
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.User] = {
        _executeRequest("GET", s"/users/${play.utils.UriEncoding.encodePathSegment(id, "UTF-8")}").map {
          case r if r.status == 200 => _root_.io.flow.user.v0.Client.parseJson("io.flow.common.v0.models.User", r, _.validate[io.flow.common.v0.models.User])
          case r if r.status == 401 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r if r.status == 404 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r => throw new io.flow.user.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200, 401, 404")
        }
      }

      override def post(
        userForm: io.flow.user.v0.models.UserForm
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.User] = {
        val payload = play.api.libs.json.Json.toJson(userForm)

        _executeRequest("POST", s"/users", body = Some(payload)).map {
          case r if r.status == 201 => _root_.io.flow.user.v0.Client.parseJson("io.flow.common.v0.models.User", r, _.validate[io.flow.common.v0.models.User])
          case r if r.status == 401 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r if r.status == 422 => throw new io.flow.user.v0.errors.ErrorsResponse(r)
          case r => throw new io.flow.user.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 201, 401, 422")
        }
      }

      override def putById(
        id: String,
        userPutForm: io.flow.user.v0.models.UserPutForm
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.User] = {
        val payload = play.api.libs.json.Json.toJson(userPutForm)

        _executeRequest("PUT", s"/users/${play.utils.UriEncoding.encodePathSegment(id, "UTF-8")}", body = Some(payload)).map {
          case r if r.status == 200 => _root_.io.flow.user.v0.Client.parseJson("io.flow.common.v0.models.User", r, _.validate[io.flow.common.v0.models.User])
          case r if r.status == 401 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r if r.status == 404 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r if r.status == 422 => throw new io.flow.user.v0.errors.ErrorsResponse(r)
          case r => throw new io.flow.user.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200, 401, 404, 422")
        }
      }

      override def patchPasswordsById(
        id: String,
        passwordChangeForm: io.flow.user.v0.models.PasswordChangeForm
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit] = {
        val payload = play.api.libs.json.Json.toJson(passwordChangeForm)

        _executeRequest("PATCH", s"/users/${play.utils.UriEncoding.encodePathSegment(id, "UTF-8")}/passwords", body = Some(payload)).map {
          case r if r.status == 204 => ()
          case r if r.status == 401 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r if r.status == 404 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r if r.status == 422 => throw new io.flow.user.v0.errors.ErrorsResponse(r)
          case r => throw new io.flow.user.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 204, 401, 404, 422")
        }
      }

      override def deletePasswordsById(
        id: String
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit] = {
        _executeRequest("DELETE", s"/users/${play.utils.UriEncoding.encodePathSegment(id, "UTF-8")}/passwords").map {
          case r if r.status == 204 => ()
          case r if r.status == 401 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r if r.status == 404 => throw new io.flow.user.v0.errors.UnitResponse(r.status)
          case r if r.status == 422 => throw new io.flow.user.v0.errors.ErrorsResponse(r)
          case r => throw new io.flow.user.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 204, 401, 404, 422")
        }
      }
    }

    def _requestHolder(path: String): play.api.libs.ws.WSRequest = {
      import play.api.Play.current

      val holder = play.api.libs.ws.WS.url(baseUrl + path).withHeaders(
        "User-Agent" -> Constants.UserAgent,
        "X-Apidoc-Version" -> Constants.Version,
        "X-Apidoc-Version-Major" -> Constants.VersionMajor.toString
      ).withHeaders(defaultHeaders : _*)
      auth.fold(holder) {
        case Authorization.Basic(username, password) => {
          holder.withAuth(username, password.getOrElse(""), play.api.libs.ws.WSAuthScheme.BASIC)
        }
        case a => sys.error("Invalid authorization scheme[" + a.getClass + "]")
      }
    }

    def _logRequest(method: String, req: play.api.libs.ws.WSRequest)(implicit ec: scala.concurrent.ExecutionContext): play.api.libs.ws.WSRequest = {
      val queryComponents = for {
        (name, values) <- req.queryString
        value <- values
      } yield s"$name=$value"
      val url = s"${req.url}${queryComponents.mkString("?", "&", "")}"
      auth.fold(logger.info(s"curl -X $method $url")) { _ =>
        logger.info(s"curl -X $method -u '[REDACTED]:' $url")
      }
      req
    }

    def _executeRequest(
      method: String,
      path: String,
      queryParameters: Seq[(String, String)] = Seq.empty,
      body: Option[play.api.libs.json.JsValue] = None
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[play.api.libs.ws.WSResponse] = {
      method.toUpperCase match {
        case "GET" => {
          _logRequest("GET", _requestHolder(path).withQueryString(queryParameters:_*)).get()
        }
        case "POST" => {
          _logRequest("POST", _requestHolder(path).withQueryString(queryParameters:_*).withHeaders("Content-Type" -> "application/json; charset=UTF-8")).post(body.getOrElse(play.api.libs.json.Json.obj()))
        }
        case "PUT" => {
          _logRequest("PUT", _requestHolder(path).withQueryString(queryParameters:_*).withHeaders("Content-Type" -> "application/json; charset=UTF-8")).put(body.getOrElse(play.api.libs.json.Json.obj()))
        }
        case "PATCH" => {
          _logRequest("PATCH", _requestHolder(path).withQueryString(queryParameters:_*)).patch(body.getOrElse(play.api.libs.json.Json.obj()))
        }
        case "DELETE" => {
          _logRequest("DELETE", _requestHolder(path).withQueryString(queryParameters:_*)).delete()
        }
         case "HEAD" => {
          _logRequest("HEAD", _requestHolder(path).withQueryString(queryParameters:_*)).head()
        }
         case "OPTIONS" => {
          _logRequest("OPTIONS", _requestHolder(path).withQueryString(queryParameters:_*)).options()
        }
        case _ => {
          _logRequest(method, _requestHolder(path).withQueryString(queryParameters:_*))
          sys.error("Unsupported method[%s]".format(method))
        }
      }
    }

  }

  object Client {

    def parseJson[T](
      className: String,
      r: play.api.libs.ws.WSResponse,
      f: (play.api.libs.json.JsValue => play.api.libs.json.JsResult[T])
    ): T = {
      f(play.api.libs.json.Json.parse(r.body)) match {
        case play.api.libs.json.JsSuccess(x, _) => x
        case play.api.libs.json.JsError(errors) => {
          throw new io.flow.user.v0.errors.FailedRequest(r.status, s"Invalid json for class[" + className + "]: " + errors.mkString(" "))
        }
      }
    }

  }

  sealed trait Authorization
  object Authorization {
    case class Basic(username: String, password: Option[String] = None) extends Authorization
  }

  package interfaces {

    trait Client {
      def baseUrl: String
      def emailVerifications: io.flow.user.v0.EmailVerifications
      def healthchecks: io.flow.user.v0.Healthchecks
      def passwordResetForms: io.flow.user.v0.PasswordResetForms
      def users: io.flow.user.v0.Users
    }

  }

  trait EmailVerifications {
    def postByToken(
      token: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.user.v0.models.EmailVerification]
  }

  trait Healthchecks {
    def getHealthcheck()(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.Healthcheck]
  }

  trait PasswordResetForms {
    def postResets(
      passwordResetRequestForm: io.flow.user.v0.models.PasswordResetRequestForm
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    def post(
      passwordResetForm: io.flow.user.v0.models.PasswordResetForm,
      expand: _root_.scala.Option[Seq[String]] = None
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.ExpandableUser]
  }

  trait Users {
    /**
     * Search users. Always paginated.
     */
    def get(
      id: _root_.scala.Option[Seq[String]] = None,
      email: _root_.scala.Option[String] = None,
      limit: Long = 25,
      offset: Long = 0,
      sort: String = "-created_at",
      headers: Seq[(String, String)] = Nil
    ) (
      implicit ec: scala.concurrent.ExecutionContext
    ): scala.concurrent.Future[Seq[io.flow.common.v0.models.User]]

    /**
     * Provides visibility into recent changes of each object, including deletion
     */
    def getVersions(
      id: _root_.scala.Option[Seq[String]] = None,
      userId: _root_.scala.Option[Seq[String]] = None,
      limit: Long = 25,
      offset: Long = 0,
      sort: String = "journal_timestamp"
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[io.flow.user.v0.models.UserVersion]]

    /**
     * Authenticates a user by email / password.
     */
    def postAuthenticate(
      authenticationForm: io.flow.user.v0.models.AuthenticationForm
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.User]

    /**
     * Returns information about a specific user.
     */
    def getById(
      id: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.User]

    /**
     * Create a new user.
     */
    def post(
      userForm: io.flow.user.v0.models.UserForm
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.User]

    /**
     * Update a user.
     */
    def putById(
      id: String,
      userPutForm: io.flow.user.v0.models.UserPutForm
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.User]

    /**
     * Update the password for a user.
     */
    def patchPasswordsById(
      id: String,
      passwordChangeForm: io.flow.user.v0.models.PasswordChangeForm
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]

    /**
     * Deletes a password for the given user.
     */
    def deletePasswordsById(
      id: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit]
  }

  package errors {

    import io.flow.common.v0.models.json._
    import io.flow.user.v0.models.json._

    case class ErrorsResponse(
      response: play.api.libs.ws.WSResponse,
      message: Option[String] = None
    ) extends Exception(message.getOrElse(response.status + ": " + response.body)){
      lazy val errors = _root_.io.flow.user.v0.Client.parseJson("Seq[io.flow.common.v0.models.Error]", response, _.validate[Seq[io.flow.common.v0.models.Error]])
    }

    case class UnitResponse(status: Int) extends Exception(s"HTTP $status")

    case class FailedRequest(responseCode: Int, message: String, requestUri: Option[_root_.java.net.URI] = None) extends Exception(s"HTTP $responseCode: $message")

  }

}
