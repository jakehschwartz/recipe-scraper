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
    appendPar(document.body, "Hello World")
  }

  def isRecipe(body: String): Boolean = {
    body.contains("http://schema.org/Recipe")
  }

  def appendPar(targetNode: Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }
}
