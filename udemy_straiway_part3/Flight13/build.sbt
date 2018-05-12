
name := "Flight13"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.5"
lazy val akkaVersion = "2.5.9"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)
