package com.schwartz.scraper

import org.scalajs.dom
import org.scalajs.dom.raw.Element

import scala.scalajs.js.JSApp

/**
  * The main application: when called it will scrap the current page for
  * a recipe as defined by schema.org.
  *
  * Created by Jake on 1/4/17.
  */
object Scraper extends JSApp {
  def main(): Unit = {
    if (isRecipe(dom.document.body)) {
      notify("Hooray! This looks like a recipe!!!")
    } else notify("This is not a recipe :(")
  }

  def isRecipe(elem: Element): Boolean = {
    if (elem.innerHTML.contains("http://schema.org/Recipe")) {
      true
    } else {
      val children = elem.children
      if (children.length == 0) {
        false
      } else (0 until children.length) map children.item exists(x => isRecipe(x))
    }
  }

  def notify(text: String): Unit = {
    dom.window.alert(text)
  }
}
