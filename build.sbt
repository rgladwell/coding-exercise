import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "me.gladwell",
      scalaVersion := "2.11.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "address-book",
    libraryDependencies += scalaTest % Test
  )
