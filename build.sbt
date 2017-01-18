name := "recipe-scraper"

version := "1.0"

scalaVersion := "2.12.1"

enablePlugins(ScalaJSPlugin)

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "com.lihaoyi" %%% "utest" % "0.4.5" % "test"
)

jsDependencies += RuntimeDOM

testFrameworks += new TestFramework("utest.runner.Framework")

persistLauncher := true