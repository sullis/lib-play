/**
 * Generated by API Builder - https://www.apibuilder.io
 * Service version: 0.3.65
 * apibuilder:0.12.61 https://app.apibuilder.io/flow/healthcheck/0.3.65/play_2_4_mock_client
 */
package io.flow.healthcheck.v0.mock {

  trait Client extends io.flow.healthcheck.v0.interfaces.Client {

    val baseUrl: String = "http://mock.localhost"

    override def healthchecks: io.flow.healthcheck.v0.Healthchecks = MockHealthchecksImpl

  }

  object MockHealthchecksImpl extends MockHealthchecks

  trait MockHealthchecks extends io.flow.healthcheck.v0.Healthchecks {

    def getHealthcheck(
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[io.flow.healthcheck.v0.models.Healthcheck] = scala.concurrent.Future.successful {
      io.flow.healthcheck.v0.mock.Factories.makeHealthcheck()
    }

  }

  object Factories {

    def randomString(): String = {
      "Test " + _root_.java.util.UUID.randomUUID.toString.replaceAll("-", " ")
    }

    def makeHealthcheck(): io.flow.healthcheck.v0.models.Healthcheck = io.flow.healthcheck.v0.models.Healthcheck(
      status = Factories.randomString()
    )

  }

}