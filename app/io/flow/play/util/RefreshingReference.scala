package io.flow.play.util

import java.util.concurrent.atomic.AtomicReference

import akka.actor.Scheduler
import play.api.Logger

import scala.concurrent.ExecutionContext
import scala.concurrent.duration.FiniteDuration
import scala.util.{Failure, Success, Try}

/**
  * Maintains a reference that gets refreshed every `reloadInterval`
  *
  * The data is refreshed every `reloadInterval` period calling the `retrieve` function up to `maxAtttempts` times
  * Upon successful completion, the data is refreshed with the retrieved data, otherwise the cache is not refreshed.
  *
  * The class will not initialize if the retrieval function fails the first `maxAttempts` times to avoid querying a
  * cache that has never been initialized.
  */
trait RefreshingReference[T] {

  /**
    * The scheduler to use to schedule the [[retrieve]] function every [[reloadInterval]] period.
    */
  def scheduler: Scheduler

  /**
    * The context to use to execute the [[retrieve]] function every [[reloadInterval]] period.
    */
  def retrieveExecutionContext: ExecutionContext

  /**
    * Interval between refreshes
    */
  def reloadInterval: FiniteDuration

  /**
    * Function retuning the data to cache.
    * It is called every [[reloadInterval]] period.
    * If successful, the cache is refreshed with the latest data, otherwise the cache is not refreshed.
    */
  def retrieve: T

  /**
    * Maximum number of attempts to retrieve the data.
    * If the [[retrieve]] function fails [[maxAttempts]] times in a row, the cache will not refresh and will retry
    * to retrieve data after [[reloadInterval]].
    *
    * Default: 3
    */
  def maxAttempts: Int = 3

  /**
    * Forces the cache to refresh. If successful, the cache is refreshed with the latest data, otherwise the cache is not refreshed.
    *
    * @return true if cache is successfully refreshed and false otherwise
    */
  def forceRefresh(): Boolean = {
    doLoadRetry(1, maxAttempts) match {
      case Success(data) =>
        cache.set(data)
        true
      case Failure(ex) =>
        Logger.warn(s"Failed initializing cache after $maxAttempts attempt${if (maxAttempts > 1) "s" else ""}.", ex)
        false
    }
  }

  def get: T = cache.get()

  // load blocking and fail if the retrieval is not successful after maxAttempts
  private[this] val cache: AtomicReference[T] = {
    val retrieved = doLoadRetry(1, maxAttempts) match {
      case Success(data) => data
      case Failure(ex) =>
        Logger.warn(s"Failed initializing cache after $maxAttempts attempt${if (maxAttempts > 1) "s" else ""}.", ex)
        throw ex
    }
    new AtomicReference(retrieved)
  }

  // schedule subsequent reloads
  scheduler.schedule(reloadInterval, reloadInterval) {
    doLoadRetry(1, maxAttempts) match {
      case Success(data) => cache.set(data)
      case Failure(ex) =>
        Logger.warn(s"Failed refreshing cache after $maxAttempts attempt${if (maxAttempts > 1) "s" else ""}. " +
          s"Will try again in $reloadInterval", ex)
    }
  }(retrieveExecutionContext)

  private def doLoadRetry(attempts: Int, maxAttempts: Int): Try[T] =
    Try(retrieve)
      .recoverWith { case ex if attempts < maxAttempts =>
        Logger.warn(s"Failed refreshing cache at attempt $attempts/$maxAttempts. Trying again...", ex)
        doLoadRetry(attempts + 1, maxAttempts)
      }

}

object RefreshingReference {

  /**
    * Helper function to create a new [[RefreshingReference]]
    */
  def apply[T](scheduler: Scheduler, retrieveExecutionContext: ExecutionContext, reloadInterval: FiniteDuration,
               retrieve: () => T, maxAttempts: Int = 3): RefreshingReference[T] = {
    val schedulerOuter = scheduler
    val retrieveExecutionContextOuter = retrieveExecutionContext
    val reloadIntervalOuter = reloadInterval
    val retrieveOuter = retrieve
    val maxAttemptsOuter = maxAttempts
    new RefreshingReference[T]() {
      override def scheduler: Scheduler = schedulerOuter
      override def retrieveExecutionContext: ExecutionContext = retrieveExecutionContextOuter
      override def reloadInterval: FiniteDuration = reloadIntervalOuter
      override def retrieve: T = retrieveOuter()
      override def maxAttempts: Int = maxAttemptsOuter
    }
  }

}
