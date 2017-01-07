name := "recipe-scraper"

version := "1.0"

scalaVersion := "2.12.1"

enablePlugins(ScalaJSPlugin)

libraryDependencies ++= Seq(
  "org.scalaj" %% "scalaj-http" % "2.3.0",
  "org.scala-js" %%% "scalajs-dom" % "0.9.1"
)

persistLauncher := true