package io.flow.play.controllers

import io.flow.common.v0.models.Healthcheck
import io.flow.common.v0.models.json._

import play.api._
import play.api.mvc._
import play.api.libs.json._

trait Healthchecks extends Controller {

  def getInternalAndHealthcheck() = Action { request =>
    Ok(Json.toJson(Healthcheck(status = status)))
  }

  def status(): String = "healthy"

}