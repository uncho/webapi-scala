name := """webapi-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
//  jdbc,
  cache,
  ws,
  evolutions,
  "com.h2database" % "h2" % "1.4.191",
  "com.typesafe.play" %% "play-slick" % "1.1.1",
  "com.typesafe.play" %% "play-slick-evolutions" % "1.1.1",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

