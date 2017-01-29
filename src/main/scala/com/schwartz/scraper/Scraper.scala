package com.schwartz.scraper

import org.scalajs.dom
import org.scalajs.dom.raw.Element

import scala.scalajs.js.{JSApp, JSON}

/**
  * The main application: when called it will scrap the current page for
  * a recipe as defined by schema.org.
  *
  * Created by Jake on 1/4/17.
  */
object Scraper extends JSApp {
  def main(): Unit = {
    findRecipe(dom.document.body) match {
      case Some(elem) =>
        val fields = parseRecipe(elem) :+ ("title", dom.document.title)
        val map = fields.groupBy(_._1).mapValues(_.map(_._2))

        notify(s"Hooray! This looks like a recipe!!!\n${JSON.stringify(map)}")
      case None => notify("This is not a recipe :(")
    }
  }

  /**
    * Recursively looks for the beginning of a recipe in the DOM
    * @param elem - the parent element
    * @return element where the recipe begins, if it exists
    */
  def findRecipe(elem: Element): Option[Element] = {
    if (elem.hasAttribute("itemtype") && elem.getAttribute("itemtype") == "http://schema.org/Recipe") {
      Some(elem)
    } else (0 until elem.children.length).map(elem.children.item).flatMap(x => findRecipe(x)).headOption
  }

  /**
    * Parse the DOM for attributes that the define a recipe
    * @param elem - the parent element
    * @return a list of property names and values
    */
  def parseRecipe(elem: Element): List[(String, String)] = {
    // For images, use the src attribute
    if (elem.hasAttribute("itemprop") && elem.tagName == "img") {
      (elem.getAttribute("itemprop"), elem.getAttribute("src")) :: Nil
    } else if (elem.hasAttribute("itemprop")) {
      (elem.getAttribute("itemprop"), elem.innerHTML) :: Nil
    } else (0 until elem.children.length).map(elem.children.item).toList.flatMap(parseRecipe)
  }

  def notify(text: String): Unit = {
    dom.window.alert(text)
  }
}
