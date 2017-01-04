# recipe-scraper

ScalaJS project to scrape page for recipes #1ppm

## Goal
To have something that can run in the browser (as a bookmarklet or maybe an extension), that will extract recipe 
information from the DOM according [schema.org's recipe guidelines](https://schema.org/Recipe). From there, it will 
simply print to the console what it finds. And, of course, this will be completed by the end of January 2017, as apart 
of [#1ppm](https://github.com/1ppm/1ppmLog).

## Motivation
I've been unhappy with the various cookbook apps I have tried, so I would like to make my own. The first step is to 
collect recipes. I liked [yummly's](yummly.com) workflow of using a bookmarklet to add recipes. Bookmarklet's are 
usually written in JavaScript but because I do not know JavaScript, nor do I wish to dive into that end of the stack,
I will use my Scala knowledge and use the ScalaJS transpiler to generate JS code. This will not only allow me to
complete the project in the month timeframe, but will allow me to test-drive ScalaJS and assess it for potential future
front end work.

## Set Up
???

## Log

### 01/01/2017
After much deliberation (mostly figuring out that my other project couldn't be done using the 3rd party API I wanted to 
use), I have decided that my January project will be a recipe scraper. You can read more about the goals and motivations
of the project above.


### 01/02/2017
Created the empty repo for the project and put it on GitHub. \#progress

### 01/03/2017
In addition to creating an empty Scala project, I also added test data. This data is the html from all of the recipe 
urls that I exported from my yummly account. The raw html has been checked in but if you want to use your own, use the 
GenerateHtml application to generate your own.