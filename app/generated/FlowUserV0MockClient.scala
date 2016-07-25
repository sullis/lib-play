/**
 * Generated by apidoc - http://www.apidoc.me
 * Service version: 0.0.53
 * apidoc:0.11.32 http://www.apidoc.me/flow/user/0.0.53/play_2_4_mock_client
 */
package io.flow.user.v0.mock {

  trait Client extends io.flow.user.v0.interfaces.Client {

    val baseUrl = "http://mock.localhost"

    override def emailVerifications: MockEmailVerifications = MockEmailVerificationsImpl
    override def users: MockUsers = MockUsersImpl
    override def passwordResetForms: MockPasswordResetForms = MockPasswordResetFormsImpl

  }

  object MockEmailVerificationsImpl extends MockEmailVerifications

  trait MockEmailVerifications extends io.flow.user.v0.EmailVerifications {

    def postByToken(
      token: String,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.user.v0.models.EmailVerification] = scala.concurrent.Future {
      io.flow.user.v0.mock.Factories.makeEmailVerification()
    }

  }

  object MockUsersImpl extends MockUsers

  trait MockUsers extends io.flow.user.v0.Users {

    /**
     * Search users. Always paginated.
     */
    def get(
      id: _root_.scala.Option[Seq[String]] = None,
      email: _root_.scala.Option[String] = None,
      limit: Long = 25,
      offset: Long = 0,
      sort: String = "-created_at",
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[io.flow.common.v0.models.User]] = scala.concurrent.Future {
      Nil
    }

    /**
     * Provides visibility into recent changes of each object, including deletion
     */
    def getVersions(
      id: _root_.scala.Option[Seq[String]] = None,
      userId: _root_.scala.Option[Seq[String]] = None,
      limit: Long = 25,
      offset: Long = 0,
      sort: String = "journal_timestamp",
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[io.flow.user.v0.models.UserVersion]] = scala.concurrent.Future {
      Nil
    }

    /**
     * Authenticates a user by email / password.
     */
    def postAuthenticate(
      authenticationForm: io.flow.user.v0.models.AuthenticationForm,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.User] = scala.concurrent.Future {
      io.flow.common.v0.mock.Factories.makeUser()
    }

    /**
     * Returns information about a specific user.
     */
    def getById(
      id: String,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.User] = scala.concurrent.Future {
      io.flow.common.v0.mock.Factories.makeUser()
    }

    /**
     * Create a new user.
     */
    def post(
      userForm: io.flow.user.v0.models.UserForm,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.User] = scala.concurrent.Future {
      io.flow.common.v0.mock.Factories.makeUser()
    }

    /**
     * Update a user.
     */
    def putById(
      id: String,
      userPutForm: io.flow.user.v0.models.UserPutForm,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.User] = scala.concurrent.Future {
      io.flow.common.v0.mock.Factories.makeUser()
    }

    /**
     * Update the password for a user.
     */
    def patchPasswordsById(
      id: String,
      passwordChangeForm: io.flow.user.v0.models.PasswordChangeForm,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit] = scala.concurrent.Future {
      // unit type
    }

    /**
     * Deletes a password for the given user.
     */
    def deletePasswordsById(
      id: String,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit] = scala.concurrent.Future {
      // unit type
    }

  }

  object MockPasswordResetFormsImpl extends MockPasswordResetForms

  trait MockPasswordResetForms extends io.flow.user.v0.PasswordResetForms {

    def postResets(
      passwordResetRequestForm: io.flow.user.v0.models.PasswordResetRequestForm,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit] = scala.concurrent.Future {
      // unit type
    }

    def post(
      passwordResetForm: io.flow.user.v0.models.PasswordResetForm,
      expand: _root_.scala.Option[Seq[String]] = None,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.ExpandableUser] = scala.concurrent.Future {
      io.flow.common.v0.mock.Factories.makeExpandableUser()
    }

  }

  object Factories {

    def randomString(): String = {
      "Test " + _root_.java.util.UUID.randomUUID.toString.replaceAll("-", " ")
    }

    def makeAuthenticationForm() = io.flow.user.v0.models.AuthenticationForm(
      email = randomString(),
      password = randomString()
    )

    def makeEmailVerification() = io.flow.user.v0.models.EmailVerification(
      email = randomString()
    )

    def makeNameForm() = io.flow.user.v0.models.NameForm(
      first = None,
      last = None
    )

    def makePasswordChangeForm() = io.flow.user.v0.models.PasswordChangeForm(
      current = randomString(),
      `new` = randomString()
    )

    def makePasswordResetForm() = io.flow.user.v0.models.PasswordResetForm(
      token = randomString(),
      password = randomString()
    )

    def makePasswordResetRequestForm() = io.flow.user.v0.models.PasswordResetRequestForm(
      email = randomString()
    )

    def makeUserForm() = io.flow.user.v0.models.UserForm(
      email = None,
      password = None,
      name = None
    )

    def makeUserPutForm() = io.flow.user.v0.models.UserPutForm(
      email = None,
      name = None
    )

    def makeUserVersion() = io.flow.user.v0.models.UserVersion(
      id = randomString(),
      timestamp = new org.joda.time.DateTime(),
      `type` = io.flow.common.v0.mock.Factories.makeChangeType(),
      user = io.flow.common.v0.mock.Factories.makeUser()
    )

  }

}