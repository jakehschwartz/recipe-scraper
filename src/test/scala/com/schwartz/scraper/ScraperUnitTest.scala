package com.schwartz.scraper

import java.io.File

import org.scalajs.dom.raw.DOMParser
import org.scalatest.{Matchers, WordSpec}

import scala.io.Source

/**
  * Created by Jake on 1/7/17.
  */
class ScraperUnitTest extends WordSpec with Matchers {

  val parser = new DOMParser

  "isRecipe" should {
    "fail for a non recipe html page" in {
      val html = Source.fromResource("no-recipe.html").getLines().mkString
      val doc = parser.parseFromString(html, "text/html")
      Scraper.isRecipe(doc.documentElement) should be(false)
    }

    "work for the recipes" in {
      val dir = new File(getClass.getResource("/html/").toURI)
      val failed = dir.listFiles().flatMap { f =>
        val name = f.getName
        val html = Source.fromFile(f).getLines().mkString("")
        val doc = parser.parseFromString(html, "text/html")
        if(!Scraper.isRecipe(doc.documentElement)) {
          Some(name)
        } else None
      }

      failed.length should be(0)
    }
  }
}
