name := "recipe-scraper"

version := "1.0"

scalaVersion := "2.12.1"

enablePlugins(ScalaJSPlugin)

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

persistLauncher := true