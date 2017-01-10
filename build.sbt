name := "recipe-scraper"

version := "1.0"

scalaVersion := "2.12.1"

enablePlugins(ScalaJSPlugin)

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "org.webjars" % "toastr" % "2.1.2",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

jsDependencies += RuntimeDOM

persistLauncher := true