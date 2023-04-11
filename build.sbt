lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.13.10"
    )),
    name := "scalatest-example"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test
