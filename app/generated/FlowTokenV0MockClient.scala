/**
 * Generated by apidoc - http://www.apidoc.me
 * Service version: 0.2.6
 * apidoc:0.11.49 http://www.apidoc.me/flow/token/0.2.6/play_2_4_mock_client
 */
package io.flow.token.v0.mock {

  trait Client extends io.flow.token.v0.interfaces.Client {

    val baseUrl = "http://mock.localhost"

    override def tokens: MockTokens = MockTokensImpl
    override def tokenValidations: MockTokenValidations = MockTokenValidationsImpl

  }

  object MockTokensImpl extends MockTokens

  trait MockTokens extends io.flow.token.v0.Tokens {

    /**
     * Get all tokens that you are authorized to view. Note that the cleartext token
     * value is never sent. To view the API token itself, see the resource path
     * /tokens/:id/cleartext
     */
    def get(
      id: _root_.scala.Option[Seq[String]] = None,
      organization: _root_.scala.Option[String] = None,
      partner: _root_.scala.Option[String] = None,
      limit: Long = 25,
      offset: Long = 0,
      sort: String = "-created_at",
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[io.flow.token.v0.models.Token]] = scala.concurrent.Future {
      Nil
    }

    /**
     * Get metadata for the token with this ID
     */
    def getById(
      id: String,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.token.v0.models.Token] = scala.concurrent.Future {
      io.flow.token.v0.mock.Factories.makeToken()
    }

    /**
     * Retrieves the token with the actual string token in cleartext
     */
    def getCleartextById(
      id: String,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.token.v0.models.Cleartext] = scala.concurrent.Future {
      io.flow.token.v0.mock.Factories.makeCleartext()
    }

    /**
     * Preferred method to validate a token, obtaining specific information if the
     * token is valid (or a 404 if the token does not exist). We use an HTTP POST with
     * a form body to enusre that the token itself is not logged in the request logs.
     */
    def postAuthentications(
      tokenAuthenticationForm: io.flow.token.v0.models.TokenAuthenticationForm,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.token.v0.models.TokenReference] = scala.concurrent.Future {
      io.flow.token.v0.mock.Factories.makeTokenReference()
    }

    /**
     * Create a new token for the requesting user
     */
    def post(
      tokenForm: io.flow.token.v0.models.TokenForm,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.token.v0.models.Token] = scala.concurrent.Future {
      io.flow.token.v0.mock.Factories.makeToken()
    }

    def deleteById(
      id: String,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Unit] = scala.concurrent.Future {
      // unit type
    }

  }

  object MockTokenValidationsImpl extends MockTokenValidations

  trait MockTokenValidations extends io.flow.token.v0.TokenValidations {

    def post(
      tokenValidationForm: io.flow.token.v0.models.TokenValidationForm,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.token.v0.models.TokenValidation] = scala.concurrent.Future {
      io.flow.token.v0.mock.Factories.makeTokenValidation()
    }

  }

  object Factories {

    def randomString(): String = {
      "Test " + _root_.java.util.UUID.randomUUID.toString.replaceAll("-", " ")
    }

    def makeCleartext() = io.flow.token.v0.models.Cleartext(
      value = randomString()
    )

    def makeOrganizationToken() = io.flow.token.v0.models.OrganizationToken(
      id = randomString(),
      organization = io.flow.common.v0.mock.Factories.makeOrganizationReference(),
      user = io.flow.common.v0.mock.Factories.makeUserReference(),
      environment = io.flow.common.v0.mock.Factories.makeEnvironment(),
      partial = randomString(),
      createdAt = new org.joda.time.DateTime(),
      description = None
    )

    def makeOrganizationTokenForm() = io.flow.token.v0.models.OrganizationTokenForm(
      organization = randomString(),
      environment = io.flow.common.v0.mock.Factories.makeEnvironment(),
      description = None
    )

    def makeOrganizationTokenReference() = io.flow.token.v0.models.OrganizationTokenReference(
      id = randomString(),
      organization = io.flow.common.v0.mock.Factories.makeOrganizationReference(),
      environment = io.flow.common.v0.mock.Factories.makeEnvironment(),
      user = io.flow.common.v0.mock.Factories.makeUserReference()
    )

    def makePartnerReference() = io.flow.token.v0.models.PartnerReference(
      id = randomString()
    )

    def makePartnerToken() = io.flow.token.v0.models.PartnerToken(
      id = randomString(),
      partner = io.flow.token.v0.mock.Factories.makePartnerReference(),
      user = io.flow.common.v0.mock.Factories.makeUserReference(),
      environment = io.flow.common.v0.mock.Factories.makeEnvironment(),
      partial = randomString(),
      createdAt = new org.joda.time.DateTime(),
      description = None
    )

    def makePartnerTokenForm() = io.flow.token.v0.models.PartnerTokenForm(
      partner = randomString(),
      environment = io.flow.common.v0.mock.Factories.makeEnvironment(),
      description = None
    )

    def makePartnerTokenReference() = io.flow.token.v0.models.PartnerTokenReference(
      id = randomString(),
      partner = io.flow.token.v0.mock.Factories.makePartnerReference(),
      environment = io.flow.common.v0.mock.Factories.makeEnvironment(),
      user = io.flow.common.v0.mock.Factories.makeUserReference()
    )

    def makeTokenAuthenticationForm() = io.flow.token.v0.models.TokenAuthenticationForm(
      token = randomString()
    )

    def makeTokenValidation() = io.flow.token.v0.models.TokenValidation(
      status = randomString()
    )

    def makeTokenValidationForm() = io.flow.token.v0.models.TokenValidationForm(
      token = randomString()
    )

    def makeToken() = io.flow.token.v0.mock.Factories.makeOrganizationToken()

    def makeTokenForm() = io.flow.token.v0.mock.Factories.makeOrganizationTokenForm()

    def makeTokenReference() = io.flow.token.v0.mock.Factories.makeOrganizationTokenReference()

  }

}