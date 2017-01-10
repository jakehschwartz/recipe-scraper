package com.schwartz.scraper

import org.scalajs.dom
import dom.{Node, document}

import scala.scalajs.js.JSApp

/**
  * The main application: when called it will scrap the current page for
  * a recipe as defined by schema.org.
  *
  * Created by Jake on 1/4/17.
  */
object Scraper extends JSApp {
  def main(): Unit = {
    if (isRecipe(document.body.toString)) {
      notify(document.body, "Hooray! This looks like a recipe!!!")
    } else notify(document.body, "This is not a recipe :(")
  }

  def isRecipe(body: String): Boolean = {
    body.contains("http://schema.org/Recipe")
  }

  def notify(targetNode: Node, text: String): Unit = {
    println(text)
  }
}
