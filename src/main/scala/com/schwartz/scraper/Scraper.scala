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
      notify("Hooray! This looks like a recipe!!!")
    } else notify("This is not a recipe :(")
  }

  def isRecipe(str: String): Boolean = {
    str.contains("http://schema.org/Recipe")
  }

  def notify(text: String): Unit = {
    dom.window.alert(text)
  }
}
