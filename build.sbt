name := """webapi-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
//  jdbc,
  cache,
  ws,
//  evolutions,
  "mysql" % "mysql-connector-java" % "5.1.40",
  "com.typesafe.play" %% "play-slick" % "1.1.1",
  "com.typesafe.play" %% "play-slick-evolutions" % "1.1.1",

  "io.spray" %%  "spray-json" % "1.3.1"
)

routesGenerator := InjectedRoutesGenerator