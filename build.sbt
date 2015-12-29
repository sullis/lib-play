import play.PlayImport.PlayKeys._

name := "lib-play"

organization := "io.flow"

scalaVersion in ThisBuild := "2.11.7"

crossScalaVersions := Seq("2.11.7")

version := "0.0.10"

lazy val root = project
  .in(file("."))
  .enablePlugins(PlayScala)
  .settings(
    libraryDependencies ++= Seq(
      ws,
      "org.scalatest" %% "scalatest" % "2.2.5" % "test"
    )
)

publishTo := {
  val host = "https://flow.artifactoryonline.com/flow"
  if (isSnapshot.value) {
    Some("Artifactory Realm" at s"$host/libs-snapshot-local;build.timestamp=" + new java.util.Date().getTime)
  } else {
    Some("Artifactory Realm" at s"$host/libs-release-local")
  }
}

