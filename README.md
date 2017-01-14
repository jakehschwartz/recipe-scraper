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

### 01/04/2017
Started to write some actual Scala code that is turned into JavaScript. I followed steps 0-3 of the [basic tutorial
on the Scala-JS site](http://www.scala-js.org/tutorial/basic/). Step 4 had to do with user input and this application
will not be doing that so I stopped there. There are more steps but I'll save them for another day...

### 01/05/2017
I looked through the rest of the tutorial but most of it did not seem relevant to the project, except for the last step
which sets up a launcher so that the executable can change but the html does not have to. This was very simple to set
up, just another line in the build.sbt and changes to the index.html file.

### 01/08/2017
I struggled all weekend to get some unit testable code because the code can either run on the Scala.js engine or it can 
run on the JVM, but not both. I chose for it to run on the JVM because then it would allow me to read files. In the 
future, the part of the code that use JS will just have to be tested in a different way.

### 01/09/2017
Small addition today, just made the Scraper object print to the console if the recipe. This is just a set up for the
rest of the week where I will turning it into a bookmarklet to be run on demand on any site. I also changed the tests a
because I learned about the runtimeDOM, which I talked about in the [Set Up](#Set Up) section above.

### 01/11/2017
No actual code the past two days, I instead spent the time making some design decisions. I mostly went back and forth
between having the project be a bookmarklet vs. a browser extension. In the end, I stuck with my gut and will press on
with making a bookmarklet. The deciding factor was that I do not want to try to support multiple versions for the 
different browsers. I also learned about a technique to externalize the bookmarklet, which I think will work well. I'll
talk about that more when that is done...

### 01/13/2017
Using some of the code from [this tutorial](https://code.tutsplus.com/tutorials/create-bookmarklets-the-right-way--net-18154),
I was able to set up the project as a bookmarklet. It was a very simple change, just had to create a link that
runs the javascript. This link can then be dragged into the bookmark bar. To see the link, go to 
[the project page](https://jakehschwartz.github.io/recipe-scraper)