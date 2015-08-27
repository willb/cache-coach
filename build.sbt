name := "cachecoach"

organization := "com.redhat.et"

version := "0.0.1"

val SPARK_VERSION = "1.4.1"

scalaVersion := "2.10.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % Test

libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.2.10"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

fork := true
