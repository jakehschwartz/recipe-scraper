package com.schwartz.scraper

import java.io.File

import org.scalatest.{Matchers, WordSpec}

import scala.io.Source

/**
  * Created by Jake on 1/7/17.
  */
class ScraperUnitTest extends WordSpec with Matchers {

  "isRecipe" should {
    "fail for a non recipe html page" in {
      val html = Source.fromResource("no-recipe.html").getLines().mkString
      Scraper.isRecipe(html) should be(false)
    }

    "work for the recipes" in {
      val dir = new File(getClass.getResource("/html/").toURI)
      val failed = dir.listFiles().flatMap { f =>
        val name = f.getName
        val html = Source.fromFile(f).getLines().mkString("")
        if(!Scraper.isRecipe(html)) {
          Some(name)
        } else None
      }

      failed.length should be(0)
    }
  }
}
