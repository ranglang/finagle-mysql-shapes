
val finagleVersion = "19.4.0"
val mysqlConnectorVersion = "8.0.15"
val circeVersion = "0.11.1"
val catsVersion = "1.6.0"
val shapelessVersion = "2.3.3"
val scalaTestVersion = "3.0.7"
val testcontainersVersion = "1.8.3"
val testcontainersScalaVersion = "0.24.0"

lazy val commonSettings = Seq(
  scalaVersion := "2.12.4",
  scalacOptions ++= Seq(
    "-deprecation",
    "-language:implicitConversions",
    "-encoding", "utf-8",
    "-explaintypes",
    "-feature",
    "-Ywarn-unused:imports",
    "-Ywarn-infer-any",
    "-Ypartial-unification"
  ),
  scalacOptions in (Compile, console) ~= (_.filterNot(_ == "-Ywarn-unused:imports"))
)

lazy val libraries = Seq(
  "com.twitter" %% "finagle-mysql" % finagleVersion,
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "com.chuusai" %% "shapeless" % shapelessVersion,
  "org.typelevel" %% "cats-core" % catsVersion,
  "org.scalatest" %%"scalatest" % scalaTestVersion % Test,
  "org.testcontainers" % "mysql" % testcontainersVersion % Test,
  "com.dimafeng" %% "testcontainers-scala" % testcontainersScalaVersion % Test,
  "mysql" % "mysql-connector-java" % mysqlConnectorVersion % Test

)

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    name := "finagle-mysql-shapes",
    organization := "com.linecorp",
    version := "0.4.0-SNAPSHOT",
    publishMavenStyle := true,
    libraryDependencies ++= libraries,
    scalafixSettings
  )
