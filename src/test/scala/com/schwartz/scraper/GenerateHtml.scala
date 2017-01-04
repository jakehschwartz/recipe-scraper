package com.schwartz.scraper

import java.io.{File, PrintWriter}

import scalaj.http.Http

/**
  * Generates html files to be used a test files for the project. Generate your
  * own html files by creating a files called links.txt that contains the urls
  * for the recipes you want (one url per line)
  *
  * Due to how sbt copies the files from resources to the target directory, the
  * files will be created in a directory located at /tmp/html/
  *
  * Created by Jake on 1/3/17.
  */
object GenerateHtml extends App {

  val outputDir = new File("/tmp/html/")
  outputDir.mkdir()

  io.Source.fromResource("links.txt")
    .getLines()
    .flatMap { url =>
      try {
        val resp = Http(url).asString
        if (resp.code == 200)
          Some(resp.body.replaceAll("\n", ""))
        else None
      } catch {
        case _: Throwable =>
          println(s"$url failed")
          None
      }
    }
    .filter(_.nonEmpty)
    .foreach { html =>
      val title = if (html.contains("<title>"))
        html.substring(html.indexOf("<title>") + 7, html.indexOf("</title>"))
          .replaceAll("\\s", "-")
          .replaceAll("/", "")
          .toLowerCase
      else html.hashCode.toString
      val name = s"$title.html"
      val file = new File(outputDir, name)
      new PrintWriter(file) { write(html) }
    }
}
