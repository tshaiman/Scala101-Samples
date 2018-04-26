name := "Flight13"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.7"

scalacOptions += "-deprecation"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0-M16-SNAP1" % "test"

libraryDependencies += "org.scala-lang" % "scala-actors" % "2.11.7"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.0"

libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.4.0"
