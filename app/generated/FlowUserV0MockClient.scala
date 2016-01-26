/**
 * Generated by apidoc - http://www.apidoc.me
 * Service version: 0.0.8
 * apidoc:0.11.6 http://www.apidoc.me/flow/user/0.0.8/play_2_4_mock_client
 */
package io.flow.user.v0.mock {

  trait Client extends io.flow.user.v0.interfaces.Client {

    override def healthchecks: MockHealthchecks = MockHealthchecksImpl
    override def users: MockUsers = MockUsersImpl

  }

  object MockHealthchecksImpl extends MockHealthchecks

  trait MockHealthchecks extends io.flow.user.v0.Healthchecks {

    def getHealthcheck()(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.Healthcheck] = scala.concurrent.Future {
      io.flow.common.v0.mock.Factories.makeHealthcheck()
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
      token: _root_.scala.Option[String] = None,
      limit: Long = 25,
      offset: Long = 0,
      sort: String = "-created_at"
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
      sort: String = "journal_timestamp"
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[io.flow.user.v0.models.UserVersion]] = scala.concurrent.Future {
      Nil
    }

    /**
     * Lookup a user by token. This is publicly available method given that the tokens
     * themselves are secure random strings.
     */
    def getTokensByToken(
      token: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.User] = scala.concurrent.Future {
      io.flow.common.v0.mock.Factories.makeUser()
    }

    /**
     * Returns information about a specific user.
     */
    def getById(
      id: String
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.User] = scala.concurrent.Future {
      io.flow.common.v0.mock.Factories.makeUser()
    }

    /**
     * Create a new user.
     */
    def post(
      userForm: io.flow.user.v0.models.UserForm
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.common.v0.models.User] = scala.concurrent.Future {
      io.flow.common.v0.mock.Factories.makeUser()
    }

  }

  object Factories {

    def randomString(): String = {
      "Test " + _root_.java.util.UUID.randomUUID.toString.replaceAll("-", " ")
    }

    def makeSystem() = io.flow.user.v0.models.System.Github

    def makeNameForm() = io.flow.user.v0.models.NameForm(
      first = None,
      last = None
    )

    def makeUserForm() = io.flow.user.v0.models.UserForm(
      email = None,
      name = None,
      avatarUrl = None
    )

    def makeUserVersion() = io.flow.user.v0.models.UserVersion(
      id = randomString(),
      timestamp = new org.joda.time.DateTime(),
      `type` = io.flow.common.v0.mock.Factories.makeChangeType(),
      user = io.flow.common.v0.mock.Factories.makeUser()
    )

  }

}