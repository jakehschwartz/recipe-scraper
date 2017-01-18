package com.schwartz.scraper

import java.io.File

import org.scalajs.dom.raw.DOMParser
import utest._


import scala.io.Source

/**
  * Created by Jake on 1/7/17.
  */
object ScraperUnitTest extends TestSuite {

  val parser = new DOMParser

  val tests = this{
    "isRecipe should fail for a non recipe html page" - {
      val html = Source.fromResource("no-recipe.html").getLines().mkString
      val doc = parser.parseFromString(html, "text/html")
      Scraper.isRecipe(doc.documentElement) ==> false
    }

    "isRecipe should work for the recipes" - {
      val dir = new File(getClass.getResource("/html/").toURI)
      val failed = dir.listFiles().flatMap { f =>
        val name = f.getName
        val html = Source.fromFile(f).getLines().mkString("")
        val doc = parser.parseFromString(html, "text/html")
        if(!Scraper.isRecipe(doc.documentElement)) {
          Some(name)
        } else None
      }

      failed.length ==> 0
    }
  }
}
