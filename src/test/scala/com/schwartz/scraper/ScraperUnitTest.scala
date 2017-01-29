package com.schwartz.scraper

import org.scalajs.dom.raw.DOMParser
import utest._

/**
  * Created by Jake on 1/7/17.
  */
object ScraperUnitTest extends TestSuite {

  val parser = new DOMParser

  val tests = this{
    "findRecipe should fail for a non recipe html page" - {
      val doc = parser.parseFromString(google, "text/html")
      Scraper.findRecipe(doc.documentElement) ==> None
    }

    "findRecipe should work for the recipes" - {
      val doc = parser.parseFromString(foodnetwork, "text/html")
      Scraper.findRecipe(doc.documentElement) ==> Some(_)
    }

    "parseRecipe returns a list with properties" - {
      val doc = parser.parseFromString(foodnetwork, "text/html")
      val elem = Scraper.findRecipe(doc.documentElement).get
      val properties = Scraper.parseRecipe(elem)
      (properties.size > 1) ==> true
    }
  }


  lazy val google =
    """
      |<!doctype html><html itemscope="" itemtype="http://schema.org/WebPage" lang="en"><head><meta content="Search the world's information, including webpages, images, videos and more. Google has many special features to help you find exactly what you're looking for." name="description"><meta content="noodp" name="robots"><meta content="text/html; charset=UTF-8" http-equiv="Content-Type"><meta content="/images/branding/googleg/1x/googleg_standard_color_128dp.png" itemprop="image"><title>Google</title><style>#gbar,#guser{font-size:13px;padding-top:1px !important;}#gbar{height:22px}#guser{padding-bottom:7px !important;text-align:right}.gbh,.gbd{border-top:1px solid #c9d7f1;font-size:1px}.gbh{height:0;position:absolute;top:24px;width:100%}@media all{.gb1{height:22px;margin-right:.5em;vertical-align:top}#gbar{float:left}}a.gb1,a.gb4{text-decoration:underline !important}a.gb1,a.gb4{color:#00c !important}.gbi .gb4{color:#dd8e27 !important}.gbf .gb4{color:#900 !important}
      |</style><style>body,td,a,p,.h{font-family:arial,sans-serif}body{margin:0;overflow-y:scroll}#gog{padding:3px 8px 0}td{line-height:.8em}.gac_m td{line-height:17px}form{margin-bottom:20px}.h{color:#36c}.q{color:#00c}.ts td{padding:0}.ts{border-collapse:collapse}em{font-weight:bold;font-style:normal}.lst{height:25px;width:496px}.gsfi,.lst{font:18px arial,sans-serif}.gsfs{font:17px arial,sans-serif}.ds{display:inline-box;display:inline-block;margin:3px 0 4px;margin-left:4px}input{font-family:inherit}a.gb1,a.gb2,a.gb3,a.gb4{color:#11c !important}body{background:#fff;color:black}a{color:#11c;text-decoration:none}a:hover,a:active{text-decoration:underline}.fl a{color:#36c}a:visited{color:#551a8b}a.gb1,a.gb4{text-decoration:underline}a.gb3:hover{text-decoration:none}#ghead a.gb2:hover{color:#fff !important}.sblc{padding-top:5px}.sblc a{display:block;margin:2px 0;margin-left:13px;font-size:11px}.lsbb{background:#eee;border:solid 1px;border-color:#ccc #999 #999 #ccc;height:30px}.lsbb{display:block}.ftl,#fll a{display:inline-block;margin:0 12px}.lsb{background:url(/images/nav_logo229.png) 0 -261px repeat-x;border:none;color:#000;cursor:pointer;height:30px;margin:0;outline:0;font:15px arial,sans-serif;vertical-align:top}.lsb:active{background:#ccc}.lst:focus{outline:none}</style><link href="/images/branding/product/ico/googleg_lodp.ico" rel="shortcut icon"></head><body bgcolor="#fff"><script>(function(){var src='/images/nav_logo229.png';var iesg=false;document.body.onload = function(){window.n && window.n();if (document.images){new Image().src=src;}
      |if (!iesg){document.f&&document.f.q.focus();document.gbqf&&document.gbqf.q.focus();}
      |}
      |})();</script><div id="mngb"> <div id=gbar><nobr><b class=gb1>Search</b> <a class=gb1 href="https://www.google.com/imghp?hl=en&tab=wi">Images</a> <a class=gb1 href="https://maps.google.com/maps?hl=en&tab=wl">Maps</a> <a class=gb1 href="https://play.google.com/?hl=en&tab=w8">Play</a> <a class=gb1 href="https://www.youtube.com/?tab=w1">YouTube</a> <a class=gb1 href="https://news.google.com/nwshp?hl=en&tab=wn">News</a> <a class=gb1 href="https://mail.google.com/mail/?tab=wm">Gmail</a> <a class=gb1 href="https://drive.google.com/?tab=wo">Drive</a> <a class=gb1 style="text-decoration:none" href="https://www.google.com/intl/en/options/"><u>More</u> &raquo;</a></nobr></div><div id=guser width=100%><nobr><span id=gbn class=gbi></span><span id=gbf class=gbf></span><span id=gbe></span><a href="http://www.google.com/history/optout?hl=en" class=gb4>Web History</a> | <a  href="/preferences?hl=en" class=gb4>Settings</a> | <a target=_top id=gb_70 href="https://accounts.google.com/ServiceLogin?hl=en&passive=true&continue=https://www.google.com/" class=gb4>Sign in</a></nobr></div><div class=gbh style=left:0></div><div class=gbh style=right:0></div> </div><center><br clear="all" id="lgpd"><div id="lga"><img alt="Google" height="92" src="/images/branding/googlelogo/1x/googlelogo_white_background_color_272x92dp.png" style="padding:28px 0 14px" width="272" id="hplogo" onload="window.lol&&lol()"><br><br></div><form action="/search" name="f"><table cellpadding="0" cellspacing="0"><tr valign="top"><td width="25%">&nbsp;</td><td align="center" nowrap=""><input name="ie" value="ISO-8859-1" type="hidden"><input value="en" name="hl" type="hidden"><input name="source" type="hidden" value="hp"><input name="biw" type="hidden"><input name="bih" type="hidden"><div class="ds" style="height:32px;margin:4px 0"><input style="color:#000;margin:0;padding:5px 8px 0 6px;vertical-align:top" autocomplete="off" class="lst" value="" title="Google Search" maxlength="2048" name="q" size="57"></div><br style="line-height:0"><span class="ds"><span class="lsbb"><input class="lsb" value="Google Search" name="btnG" type="submit"></span></span><span class="ds"><span class="lsbb"><input class="lsb" value="I'm Feeling Lucky" name="btnI" onclick="if(this.form.q.value)this.checked=1; else top.location='/doodles/'" type="submit"></span></span></td><td class="fl sblc" align="left" nowrap="" width="25%"><a href="/advanced_search?hl=en&amp;authuser=0">Advanced search</a><a href="/language_tools?hl=en&amp;authuser=0">Language tools</a></td></tr></table><input id="gbv" name="gbv" type="hidden" value="1"></form><div id="gac_scont"></div><div style="font-size:83%;min-height:3.5em"><br></div><span id="footer"><div style="font-size:10pt"><div style="margin:19px auto;text-align:center" id="fll"><a href="/intl/en/ads/">Advertising†Programs</a><a href="/services/">Business Solutions</a><a href="https://plus.google.com/116899029375914044550" rel="publisher">+Google</a><a href="/intl/en/about.html">About Google</a></div></div><p style="color:#767676;font-size:8pt">&copy; 2017 - <a href="/intl/en/policies/privacy/">Privacy</a> - <a href="/intl/en/policies/terms/">Terms</a></p></span></center><div id="xjsd"></div><div id="xjsi"><script>(function(){function c(b){window.setTimeout(function(){var a=document.createElement("script");a.src=b;document.getElementById("xjsd").appendChild(a)},0)}google.dljp=function(b,a){google.xjsu=b;c(a)};google.dlj=c;}).call(this);(function(){window.google.xjsrm=[];})();if(google.y)google.y.first=[];if(!google.xjs){window._=window._||{};window._._DumpException=function(e){throw e};if(google.timers&&google.timers.load.t){google.timers.load.t.xjsls=new Date().getTime();}google.dljp('/xjs/_/js/k\x3dxjs.hp.en_US.G-SCu6weVuY.O/m\x3dsb_he,d/rt\x3dj/d\x3d1/t\x3dzcms/rs\x3dACT90oHAzqMJiMkn7Jto8Dvzol1_OAq4wA','/xjs/_/js/k\x3dxjs.hp.en_US.G-SCu6weVuY.O/m\x3dsb_he,d/rt\x3dj/d\x3d1/t\x3dzcms/rs\x3dACT90oHAzqMJiMkn7Jto8Dvzol1_OAq4wA');google.xjs=1;}google.pmc={"sb_he":{"agen":true,"cgen":true,"client":"heirloom-hp","dh":true,"dhqt":true,"ds":"","fl":true,"host":"google.com","isbh":28,"jam":0,"jsonp":true,"msgs":{"cibl":"Clear Search","dym":"Did you mean:","lcky":"I\u0026#39;m Feeling Lucky","lml":"Learn more","oskt":"Input tools","psrc":"This search was removed from your \u003Ca href=\"/history\"\u003EWeb History\u003C/a\u003E","psrl":"Remove","sbit":"Search by image","srch":"Google Search"},"nds":true,"ovr":{},"pq":"","refpd":true,"rfs":[],"scd":10,"sce":5,"stok":"BZxQbjljcQxsw45_HNNUxFqZ19o"},"d":{}};google.y.first.push(function(){if(google.med){google.med('init');google.initHistory();google.med('history');}});if(google.j&&google.j.en&&google.j.xi){window.setTimeout(google.j.xi,0);}
      |</script></div></body></html>
    """.stripMargin

  // http://www.foodnetwork.com/recipes/food-network-kitchens/big-batch-healthy-beef-mushroom-and-spinach-calzones.html
  lazy val foodnetwork =
    """
      |<html>
      |<head prefix="og: http://ogp.me/ns# video: http://ogp.me/ns/video#">
      |    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      |    <title>Big-Batch Healthy Beef, Mushroom and Spinach Calzones Recipe : Food Network Kitchen : Food Network</title>
      |    <meta name="description" content="Get this all-star, easy-to-follow Big-Batch Healthy Beef, Mushroom and Spinach Calzones recipe from Food Network Kitchen.">
      |</head>
      |<body>
      |    <article  itemscope itemtype="http://schema.org/Recipe" >
      |        <section class="next-recipe-link"><span style="display: none" class="clicktracking" data-component-path="sni-food/components/pagetypes/recipe/components/next-recipe" data-resource-path="/content/food/recipes/food-network-kitchens/b/bi/big/big-/big-batch-healthy-beef-mushroom-and-spinach-calzones/jcr:content/next-recipe" data-resource-type="sni-food/components/pagetypes/recipe/components/next-recipe"></span>
      |  <aside class="prev-next-wrapper">
      |        <div class="recipe-prev">
      |          <a href="/recipes/rachael-ray/portobello-and-spinach-bolognese-recipe.html">Prev Recipe</a>
      |        </div>
      |        <div class="recipe-next">
      |          <a href="/recipes/food-network-kitchens/mushroom-and-spinach-korma-recipe.html">Next Recipe</a>
      |        </div>
      |  </aside>
      |</section>
      |        <link itemprop="url" href="http://www.foodnetwork.com/recipes/food-network-kitchens/big-batch-healthy-beef-mushroom-and-spinach-calzones.html"/>
      |        <meta itemprop="mainEntityOfPage" content="True"/>
      |                <div class="parsys"><section class="section breadcrumb"><span style="display: none" class="clicktracking" data-component-path="sni-core/components/modules/breadcrumb" data-resource-path="/content/food/recipes/food-network-kitchens/b/bi/big/big-/big-batch-healthy-beef-mushroom-and-spinach-calzones/jcr:content/content-well/breadcrumb" data-resource-type="sni-food/components/modules/breadcrumb"></span>
      |<div class="crumb-wrap">
      |<div class="ad-sponsored">
      |		<div id="dfp_logo"></div>
      |</div>
      |    <div class="crumb"><ul>
      |        <li itemscope itemtype="http://data-vocabulary.org/Breadcrumb">
      |            <a href="/" itemprop="url">
      |                <span itemprop="title">Home</span></a>
      |        </li>
      |        <li itemscope itemtype="http://data-vocabulary.org/Breadcrumb">
      |            <a href="/recipes.html" itemprop="url">
      |                <span itemprop="title">Recipes &amp; How-Tos</span></a>
      |        </li>
      |        <li itemscope itemtype="http://data-vocabulary.org/Breadcrumb">
      |                <span itemprop="title">Big-Batch Healthy Beef, Mushroom and Spinach Calzones</span>
      |        </li>
      |    </ul></div>
      |</div>
      |</section>
      |<section class="title section">
      |<div class="tier-3 title">
      |	<h1 itemprop="name">Big-Batch Healthy Beef, Mushroom and Spinach Calzones</h1>
      |			<meta itemprop="description" content="Get this all-star, easy-to-follow Big-Batch Healthy Beef, Mushroom and Spinach Calzones recipe from Food Network Kitchen"/>
      |</div>
      |</section>
      |<section class="lead-overview section">
      |<div class="bd">
      |    <div class="lead-overview">
      |    <div class="col18">
      |<section class="review-rating section">
      |<a class="community-rating-stars" data-rating='{}' href="#communityReviews"></a>
      |</section>
      |<div class="avatar group" itemprop="author" itemscope itemtype="http://schema.org/Person">
      |    <div class="media">
      |                    <a href="/chefs/food-network-kitchen.html" itemprop="url">
      |                        <img itemprop="image" height="56" width="56" class="pull-left" src="http://foodnetwork.sndimg.com/content/dam/images/food/unsized/2013/11/25/0/FN-Avatar-FN-Logo-126x126.png.rend.sni2col.png"/>
      |                    </a>
      |	                    <h6>Recipe courtesy of <a href="/chefs/food-network-kitchen.html" itemprop="url"><span itemprop="name">Food Network Kitchen</span></a></h6>
      |        <div class="show" itemscope itemtype="http://schema.org/TVSeries">
      |            <dl>
      |            </dl>
      |        </div>
      |    </div>
      |</div>
      |	<p class="quotation">
      |	    <q rel="ellipsis">
      |	        Set aside some extra time one weekend to make a dozen of these calzones. Then pack your freezer full of them and know you've got healthy[ lunches or dinners for those hectic days covered.]
      |	    </q>
      |	</p>
      |        </div>
      |        <section class="global-toolbar-placeholder section"><span style="display: none" class="clicktracking" data-component-path="sni-core/components/modules/global-toolbar" data-resource-path="/content/food/recipes/food-network-kitchens/b/bi/big/big-/big-batch-healthy-beef-mushroom-and-spinach-calzones/jcr:content/content-well/lead-overview/global-toolbar" data-resource-type="sni-core/components/modules/global-toolbar"></span>
      |<!--DEBUG SOCIAL TWITTER TEXT: Get the recipe for Big-Batch Healthy Beef, Mushroom and Spinach Calzones via @FoodNetwork: -->
      |<div id="socialToolbar" class="global-toolbar section" data-st='{"pgtitle":"Big-Batch Healthy Beef, Mushroom and Spinach Calzones : Food Network Kitchen : Food Network","emailUrl":"http://www.foodnetwork.com/recipes/food-network-kitchens/big-batch-healthy-beef-mushroom-and-spinach-calzones.emailsend.html"}'>
      |<div class="st-left">
      |    <div class="st-item saverecipe"></div>
      |  <div class="st-item print">
      |    <a class="btn fig" title="Print the page: Big-Batch Healthy Beef, Mushroom and Spinach Calzones : Food Network Kitchen : Food Network" target="_blank" href="http://www.foodnetwork.com/recipes/food-network-kitchens/big-batch-healthy-beef-mushroom-and-spinach-calzones.print.html" data-popup-width='1100' data-popup-height='700'>
      |      <i class="ss-print"></i>Print
      |    </a>
      |  </div>
      |  <div class="st-item email">
      |    <a data-toggle="modal" data-target="#email-modal" title='Share on e-mail' class="btn fig" href="mailto:?subject=Food%20Network:%20Big-Batch%20Healthy%20Beef%2C%20Mushroom%20and%20Spinach%20Calzones%20%3A%20Food%20Network%20Kitchen%20%3A%20Food%20Network&body=http://www.foodnetwork.com/recipes/food-network-kitchens/big-batch-healthy-beef-mushroom-and-spinach-calzones.html%0A%0AGet%20this%20all-star%2C%20easy-to-follow%20Big-Batch%20Healthy%20Beef%2C%20Mushroom%20and%20Spinach%20Calzones%20recipe%20from%20Food%20Network%20Kitchen">
      |      <i class="ss-mail"></i>Email
      |    </a>
      |  </div>
      |</div>
      |<div class="st-right">
      |  <div class="st-item fblike">
      |    <a class='icon' title='Facebook' target='_blank' href="https://www.facebook.com/sharer/sharer.php?u=http://www.foodnetwork.com/recipes/food-network-kitchens/big-batch-healthy-beef-mushroom-and-spinach-calzones.html%3Fsoc%3Dsocialsharingfb" data-popup-width='600' data-popup-height='354'>
      |      <i class="sss-facebook"></i>
      |    </a>
      |  </div>
      |  <div class="st-item pinit">
      |    <a class='icon' title='Pinterest' href="https://pinterest.com/pin/create%2Fbutton/?url=http://www.foodnetwork.com/recipes/food-network-kitchens/big-batch-healthy-beef-mushroom-and-spinach-calzones.html%3Fsoc%3Dsocialsharingpinterest&amp;media=http://foodnetwork.sndimg.com/content/dam/images/food/fullset/2016/6/9/0/FNK_Big-Batch-Healthy-Beef-Mushroom-and-Spinach-Calzones_s4x3.jpg.rend.sniipadlarge.jpeg&amp;description=Big-Batch%20Healthy%20Beef%2C%20Mushroom%20and%20Spinach%20Calzones%20recipe%20from%20Food%20Network%20Kitchen%20via%20Food%20Network" data-pin-do="buttonPin" data-social-id="lygSm2pxZNG5SQXe" data-pin-round="true" data-pin-custom="true" data-pin-tall="true">
      |      <img src="//assets.pinterest.com/images/pidgets/pinit_fg_en_round_red_32.png"/>
      |    </a>
      |  </div>
      |  <div class="st-item tweet">
      |    <a class='icon' title='Twitter' target='_blank' data-popup-width='440' data-popup-height='260' href="https://twitter.com/share?url=http://www.foodnetwork.com/recipes/food-network-kitchens/big-batch-healthy-beef-mushroom-and-spinach-calzones.html%3Fsoc%3Dsocialsharingtw&amp;text=Get%20the%20recipe%20for%20Big-Batch%20Healthy%20Beef%2C%20Mushroom%20and%20Spinach%20Calzones%20via%20%40FoodNetwork%3A%20">
      |      <i class='sss-twitter'></i>
      |    </a>
      |  </div>
      |  <div class="st-item gplus">
      |    <a class='icon' title='GooglePlus' target='_blank' href='https://plus.google.com/share?url=http://www.foodnetwork.com/recipes/food-network-kitchens/big-batch-healthy-beef-mushroom-and-spinach-calzones.html%3Fsoc%3Dsocialsharinggplus' data-popup-width='585' data-popup-height='450'>
      |      <i class='sss-googleplus'></i>
      |    </a>
      |  </div>
      |      <!-- clipix -->
      |      <div class="st-item clipix">
      |        <div class='icon'
      |           tag='ClipixWidgetApiContainer'
      |           url="http://www.foodnetwork.com/recipes/food-network-kitchens/big-batch-healthy-beef-mushroom-and-spinach-calzones.html%3Fsoc%3Dsocialsharingclipix"
      |           imagesrc="http://foodnetwork.sndimg.com/content/dam/images/food/fullset/2016/6/9/0/FNK_Big-Batch-Healthy-Beef-Mushroom-and-Spinach-Calzones_s4x3.jpg.rend.sniipadlarge.jpeg"
      |           title="Big-Batch Healthy Beef, Mushroom and Spinach Calzones recipe from Food Network Kitchen via Food Network"
      |           usecustomimage="1">
      |          <img src="/etc/designs/food/clientlib/img/clipix-btn-rnd-orange.png">
      |        </div>
      |      </div>
      |</div>
      |  <script>
      |    // Click tracking for Toolbar Pinterest (global-toolbar)
      |    $(document).on('click', '[data-pin-href][data-social-id="lygSm2pxZNG5SQXe"]', function () {
      |      if (typeof SNI.Analytics.moduleTrackLS === 'function') {
      |        SNI.Analytics.moduleTrackLS(this, {
      |          ModuleName: "global-toolbar",
      |          LinkTitle: "Pinterest: " + decodeURIComponent("Big-Batch%20Healthy%20Beef%2C%20Mushroom%20and%20Spinach%20Calzones%20recipe%20from%20Food%20Network%20Kitchen%20via%20Food%20Network").substr(0, 30) + "...",
      |          LocUrl: document.location.href,
      |          LinkPosition: "2",
      |          TargetUrl: ""
      |        });
      |        return false;
      |      }
      |    });
      |  </script>
      |</section>
      |        <div class="recipe">
      |    	<meta itemprop="totalTime" content="PT2H0M">
      |    	<meta itemprop="prepTime" content="PT1H0M">
      |    	<meta itemprop="cookTime" content="PT1H0M">
      |    	<meta itemprop="recipeYield" content="12 calzones">
      |              <div class="col12 pic collapsed">
      |                  <div class="photo-video"><span style="display: none" class="clicktracking" data-component-path="sni-food/components/pagetypes/recipe/components/photo-video" data-resource-path="/content/food/recipes/food-network-kitchens/b/bi/big/big-/big-batch-healthy-beef-mushroom-and-spinach-calzones/jcr:content/content-well/lead-overview/photo-video" data-resource-type="sni-food/components/pagetypes/recipe/components/photo-video"></span>
      |<figure>
      |			<section class="single-photo-recipe"><span style="display: none" class="clicktracking" data-component-path="sni-food/components/pagetypes/recipe/components/single-photo-recipe" data-resource-path="/content/food/recipes/food-network-kitchens/b/bi/big/big-/big-batch-healthy-beef-mushroom-and-spinach-calzones/jcr:content/content-well/lead-overview/photo-video/single-photo-recipe" data-resource-type="sni-food/components/pagetypes/recipe/components/single-photo-recipe"></span>
      |<a href="#lightbox-recipe-image" data-pos="top" class="ico-wrap">
      |	<img title="Big-Batch Healthy Beef, Mushroom and Spinach Calzones" itemprop="image" height="305" alt="Big-Batch Healthy Beef, Mushroom and Spinach Calzones" width="406" src="http://foodnetwork.sndimg.com/content/dam/images/food/fullset/2016/6/9/0/FNK_Big-Batch-Healthy-Beef-Mushroom-and-Spinach-Calzones_s4x3.jpg.rend.sni12col.landscape.jpeg"/>
      |	<span class="ico"><i class="ss-expand"></i></span>
      |</a>
      |<figcaption>Big-Batch Healthy Beef, Mushroom and Spinach Calzones</figcaption></section>
      |</figure>
      |</div>
      |                </div>
      |                <div class="col6 info collapsed">
      |<div class="cooking-times">
      |    <dl>
      |            <dt class="total">Total Time:</dt><dd class="total">2 hr</dd>
      |            <dt>Prep:</dt><dd>30 min</dd>
      |            <dt>Inactive:</dt><dd>30 min</dd>
      |            <dt>Cook:</dt><dd>1 hr</dd>
      |    </dl>
      |</div>
      |                        <hr>
      |<div class="difficulty">
      |		<dl>
      |			<dt>Yield:</dt>
      |			<dd>12 calzones</dd>
      |		</dl>
      |		<dl>
      |			<dt>Level:</dt>
      |			<dd>Easy</dd>
      |		</dl>
      |</div>
      |                        <hr>
      |    <div class="nutrition">
      |        <h6 data-popover="nutrition" data-pos="left"><b>NUTRITION INFO</b> <a href="#" class="btn radial tiny"><i class="ss-upright"></i></a></h6>
      |<script data-popover="nutrition" type="popover/template">
      |	<div class="popover-content nutrition overflow">
      |		<dl>
      |            <dt><b>Nutritional Analysis</b></dt>
      |            <dd><b>Per Serving</b></dd>
      |                <dt>Calories</dt>
      |                <dd>290</dd>
      |                <dt>Fat</dt>
      |                <dd>5 g</dd>
      |                <dt>Saturated Fat</dt>
      |                <dd>0.5 g</dd>
      |                <dt>Cholesterol</dt>
      |                <dd>0 mg</dd>
      |                <dt>Sodium</dt>
      |                <dd>260 mg</dd>
      |                <dt>Carbohydrate</dt>
      |                <dd>50 g</dd>
      |                <dt>Fiber</dt>
      |                <dd>9 g</dd>
      |                <dt>Sugar</dt>
      |                <dd>1 g</dd>
      |                <dt>Protein</dt>
      |                <dd>10 g</dd>
      |		<dl>
      |	</div>
      |</script>
      |    </div>
      |                        <hr>
      |<div>
      |	<ul>
      |		<li class="label secondary" data-popover="label-healthy" data-event="mouseover">Healthy</li>
      |	</ul>
      |	<script data-popover="label-healthy" data-color="orange" type="popover/template">
      |        <div class="popover-content">This recipe has been chosen by culinary and nutrition experts to meet a set of nutrition standards designed for a healthy lifestyle.</div>
      |    </script>
      |</div>
      |                </div>
      |            <div class="col18 hide enlarged" >
      |                    <div class="info">
      |<div class="cooking-times">
      |    <dl>
      |            <dt class="total">Total Time:</dt><dd class="total">2 hr</dd>
      |            <dt>Prep:</dt><dd>30 min</dd>
      |            <dt>Inactive:</dt><dd>30 min</dd>
      |            <dt>Cook:</dt><dd>1 hr</dd>
      |    </dl>
      |</div>
      |                    </div>
      |                        <hr class="vrt"/>
      |                    <div class="info">
      |<div class="difficulty">
      |		<dl>
      |			<dt>Yield:</dt>
      |			<dd>12 calzones</dd>
      |		</dl>
      |		<dl>
      |			<dt>Level:</dt>
      |			<dd>Easy</dd>
      |		</dl>
      |</div>
      |                    </div>
      |                        <hr class="vrt"/>
      |                    <div class="info">
      |    <div class="nutrition">
      |        <h6 data-popover="nutrition" data-pos="left"><b>NUTRITION INFO</b> <a href="#" class="btn radial tiny"><i class="ss-upright"></i></a></h6>
      |<script data-popover="nutrition" type="popover/template">
      |	<div class="popover-content nutrition overflow">
      |		<dl>
      |            <dt><b>Nutritional Analysis</b></dt>
      |            <dd><b>Per Serving</b></dd>
      |                <dt>Calories</dt>
      |                <dd>290</dd>
      |                <dt>Fat</dt>
      |                <dd>5 g</dd>
      |                <dt>Saturated Fat</dt>
      |                <dd>0.5 g</dd>
      |                <dt>Cholesterol</dt>
      |                <dd>0 mg</dd>
      |                <dt>Sodium</dt>
      |                <dd>260 mg</dd>
      |                <dt>Carbohydrate</dt>
      |                <dd>50 g</dd>
      |                <dt>Fiber</dt>
      |                <dd>9 g</dd>
      |                <dt>Sugar</dt>
      |                <dd>1 g</dd>
      |                <dt>Protein</dt>
      |                <dd>10 g</dd>
      |		<dl>
      |	</div>
      |</script>
      |    </div>
      |                    </div>
      |      </div>
      |        </div>
      |    </div>
      |</div>
      |<script data-lightbox="lightbox-recipe-image" class="modal hide fade overlay limitless" type="overlay/template">
      |    <figure>
      |        <img title="Big-Batch Healthy Beef, Mushroom and Spinach Calzones" itemprop="image" height="462" alt="Big-Batch Healthy Beef, Mushroom and Spinach Calzones" width="616" src="http://foodnetwork.sndimg.com/content/dam/images/food/fullset/2016/6/9/0/FNK_Big-Batch-Healthy-Beef-Mushroom-and-Spinach-Calzones_s4x3.jpg.rend.sni18col.jpeg" />
      |        <figcaption>
      |            <small>Big-Batch Healthy Beef, Mushroom and Spinach Calzones</small>
      |        </figcaption>
      |    </figure>
      |</script>
      |</section>
      |<section class="ingredients-instructions recipe-instructions section">
      |<div class="bd">
      |  <div class="col8 ingredients responsive">
      |    <!--TESTCOMMENT-->
      |    <h6>Ingredients</h6>
      |    <ul>
      |          <li itemprop="ingredients">3 tablespoons extra-virgin olive oil</li>
      |          <li itemprop="ingredients">1 pound lean ground beef</li>
      |          <li itemprop="ingredients"> Kosher salt</li>
      |          <li itemprop="ingredients">1/4 teaspoon crushed red pepper flakes</li>
      |          <li itemprop="ingredients">8 ounces cremini mushrooms, sliced (about 1 cup)</li>
      |          <li itemprop="ingredients">4 cloves garlic, finely minced</li>
      |          <li itemprop="ingredients">6 cups packed baby spinach (about 5 ounces)</li>
      |          <li itemprop="ingredients"> One 28-ounce can crushed tomatoes</li>
      |          <li itemprop="ingredients">3 pounds whole-wheat or regular pizza dough</li>
      |          <li itemprop="ingredients"> Cooking spray</li>
      |          <li itemprop="ingredients"> Whole wheat or all-purpose flour, for the work surface</li>
      |          <li itemprop="ingredients">2 1/4 cups shredded part-skim mozzarella</li>
      |          <li itemprop="ingredients">1 large egg, beaten</li>
      |    </ul>
      |    <div id="dfp_native_ingredient"></div>
      |  </div>
      |<div class="col10 directions" itemprop="recipeInstructions">
      |        <h6>Directions</h6>
      |                <ul class="recipe-directions-list"><li><p>Set a pizza stone or baking sheet on an oven rack in the bottom third of the oven, and preheat to 425 degrees F.</p></li><li><p>Heat 1 1/2 tablespoons of the oil in a large nonstick skillet over medium-high heat. Add the <a href="http://www.foodterms.com/encyclopedia/beef/index.html" class="crosslink" debug="210 221">ground beef</a>, 3/4 teaspoon salt and half the pepper flakes, and cook, breaking the beef up into large chunks with a wooden spoon, until the beef is browned all over, about 3 minutes. Add the mushrooms, 2/3 of the garlic and 3/4 teaspoon salt, and cook for 3 minutes more. Fold in the spinach, and cook until wilted, about 1 minute (the mixture should be relatively dry). Transfer the mixture to a large bowl, and let cool completely.</p></li><li><p>Reduce the heat to medium. Add the remaining oil, garlic and pepper flakes to the skillet, and cook, stirring, to lightly brown the garlic, about 1 minute. Add the <a href="http://www.foodterms.com/encyclopedia/tomato/index.html" class="crosslink" debug="811 819">tomatoes</a> and 3/4 teaspoon salt, and <a href="http://www.foodterms.com/encyclopedia/simmer/index.html" class="crosslink" debug="847 853">simmer</a> the sauce until thick, about 6 minutes; set aside.</p></li><li><p>Divide the pizza dough into 12 balls. Spray 2 baking sheets with <a href="http://www.foodterms.com/encyclopedia/cooking-spray/index.html" class="crosslink" debug="974 987">cooking spray</a>. On a well-floured surface, roll out each ball into a 6- or 7-inch circle 1/8 inch thick. On the bottom half of each circle, mound 1/4 cup of the cooled beef mixture and top with 3 tablespoons of the <a href="http://www.foodterms.com/encyclopedia/mozzarella/index.html" class="crosslink" debug="1188 1198">mozzarella</a>. Fold over the top half of the dough to form a semicircle, and pinch the edges to seal. Carefully transfer the calzones with a spatula to the prepared baking sheets. Lightly brush with the beaten <a href="http://www.foodterms.com/encyclopedia/eggs/index.html" class="crosslink" debug="1395 1398">egg</a>. Cut 2 small slits on top of each to vent steam.</p></li><li><p>Refrigerate half the calzones. With a <a href="http://www.foodterms.com/encyclopedia/spatula/index.html" class="crosslink" debug="1490 1497">spatula</a>, transfer the rest of the calzones to the hot <a href="http://www.foodterms.com/encyclopedia/pizza-stone/index.html" class="crosslink" debug="1544 1555">pizza stone</a> or baking sheet and bake until golden brown, about 22 minutes. Repeat with the remaining calzones. Reheat the <a href="http://www.foodterms.com/encyclopedia/tomato-sauce/index.html" class="crosslink" debug="1666 1678">tomato sauce</a>, and serve on the side.</p></li><li><p>To freeze: Let the baked calzones cool completely, then wrap each one tightly in <a href="http://www.foodterms.com/encyclopedia/plastic-wrap/index.html" class="crosslink" debug="1788 1800">plastic wrap</a> and then aluminum foil. Place them in freezer bags, and freeze for up to a month. The sauce can be frozen in 12 small freezer bags for up to a month.</p></li><li><p>To reheat: Thaw the frozen calzones in the fridge for 1 to 2 hours. Unwrap the <a href="http://www.foodterms.com/encyclopedia/calzone/index.html" class="crosslink" debug="2034 2042">calzones</a>, then microwave them on a microwave-safe plate in 1-minute increments, rotating them after each, until heated through, 2 to 4 minutes. To reheat the sauce, microwave it in a microwave-safe bowl in 30-second increments, stirring after each, until the sauce is hot.</p></li><li><p><P></p></li><li><p>Copyright 2016 Television Food Network, G.P. All rights reserved.</p></li></ul>
      |        <p class="copyright">From Food Network Kitchen</p>
      |    <hr>
      |    <div class="categories">
      |        <h6><b>CATEGORIES:</b> </h6>
      |        <ul class="categories"><span style="display: none" class="clicktracking" data-component-path="sni-food/components/pagetypes/recipe/components/categories" data-resource-path="/content/food/recipes/food-network-kitchens/b/bi/big/big-/big-batch-healthy-beef-mushroom-and-spinach-calzones/jcr:content/content-well/ingredients-instructions/categories" data-resource-type="sni-food/components/pagetypes/recipe/components/categories"></span>
      |                                <li  itemprop="recipeCategory"><a href="/topics/spinach-casserole-recipes.html">Spinach</a></li>
      |                                <li  itemprop="recipeCategory"><a href="/topics/dinner.html">Dinner</a></li>
      |                                <li class="last" itemprop="recipeCategory"><a href="/topics/healthy-snack-recipes.html">Healthy</a></li>
      |</ul>
      |        <span data-popover="categories" data-pos="left">View All<a href="#" class="btn radial tiny"> <i class="ss-upright"></i></a></span>
      |        <div class="categories-popover"><span style="display: none" class="clicktracking" data-component-path="sni-food/components/pagetypes/recipe/components/categories-popover" data-resource-path="/content/food/recipes/food-network-kitchens/b/bi/big/big-/big-batch-healthy-beef-mushroom-and-spinach-calzones/jcr:content/content-well/ingredients-instructions/categories-popover" data-resource-type="sni-food/components/pagetypes/recipe/components/categories-popover"></span>
      |<script data-popover="categories" type="popover/template">
      |	<div class="popover-content categories">
      |                <ul>
      |                    <li>Main Ingredient</li>
      |                                    <li class="last"><a href="/content/food/topics/s/spinach-casserole-recipes.html">Spinach</a></li>
      |				</ul>
      |                <ul>
      |                    <li>Course</li>
      |                                    <li ><a href="/content/food/topics/d/dinner.html">Dinner</a></li>
      |                                    <li class="last"><a href="/content/food/topics/m/main-dish.html">Main Dish</a></li>
      |				</ul>
      |                <ul>
      |                    <li>Cooking Style</li>
      |                                    <li ><a href="/content/food/topics/h/healthy-snack-recipes.html">Healthy</a></li>
      |                                    <li class="last"><a href="/content/food/topics/m/make-ahead.html">Make Ahead</a></li>
      |				</ul>
      |	</div>
      |</script></div>
      |    </div>
      |    <hr>
      |    <section class="recipe-direction-carousel"><span style="display: none" class="clicktracking" data-component-path="sni-food/components/pagetypes/recipe/components/recipe-direction-carousel" data-resource-path="/content/food/recipes/food-network-kitchens/b/bi/big/big-/big-batch-healthy-beef-mushroom-and-spinach-calzones/jcr:content/content-well/ingredients-instructions/recipe-direction-carousel" data-resource-type="sni-food/components/pagetypes/recipe/components/recipe-direction-carousel"></span>
      |</section>
      |</div>
      |</div>
      |<a rel="package-overlay-top"></a>
      |</section>
      |<div class="parbase section reference"><div style="display:inline;" class="cq-dd-paragraph"><section class="secondary-inline-video">
      |    <script type="text/javascript" src="//secure-us.imrworldwide.com/novms/js/2/ggcmb400.js"></script>
      |      <script type="text/javascript" src="http://www.player.video.snidigital.com/vpc/1/10/4/js/sni-video.min.js"></script>
      |      <link rel="stylesheet" type="text/css" href="http://www.player.video.snidigital.com/vpc/1/10/4/css/sni-video.min.css">
      |<script>
      |  SNI.Video.Defaults.pausedState.enabled = false;
      |</script>
      |<link rel="stylesheet" href="/etc/designs/food/clientlib/video.min.css" type="text/css">
      |<script type="text/javascript" src="/etc/designs/food/clientlib/video.min.js"></script>
      |<section class="secondary-inline-video">
      |<header class="hr">
      |  <h5>Cooking Tips</h5>
      |        <nav class="cta"><a href="/big-game/big-game-parties/eddie-jackson-s-game-day-playbook.html">More Cooking Tips<i class="ss-navigateright"></i></a></nav>
      |</header>
      |  <div class="bd group">
      |    <div class="vid-wrap col12">
      |      <div id="playerSecInlIframe" class="fnPlayer"></div>
      |      <div id="nextEndframe-playerSecInlIframe" style="display:none;"></div>
      |    </div>
      |      <div class="vid-list col6"></div>
      |  </div>
      |    <!--/content/food/big-game/big-game-parties/eddie-jackson-s-game-day-playbook-->
      |  <script>
      |    var pdkplayerSecInlIframe = SNI.Food.Video.SecondaryInline($.extend(true, {},
      |                                                                    { player: { autoplay: false, containerId: "playerSecInlIframe" }},
      |                                                                    { alternateEndframe: { frameId: "nextEndframe-playerSecInlIframe" } },
      |                                                                    { freewheel: { adContainerId: "obtwHQXTODWC" } },
      |                                                                    {"channels": [{
      |  "title": "Eddie Jackson's Game-Day Playbook",
      |  "start": 0,
      |  "end": 5,
      |  "total": 6,
      |  "videos": [
      |    {
      |      "releaseUrl": "http://link.theplatform.com/s/ip77QC/noqEbWsL9Q9_?format=SMIL&MBR=true",
      |      "mpxId": "http://data.media.theplatform.com/media/data/Media/854457411610",
      |      "title": "Spinach-Artichoke Pepper Dip",
      |      "description": "A bread bowl makes this cheesy, spicy dip even more delicious.",
      |      "length_hhmmss": "02:20",
      |      "length": 140,
      |      "length_sss": 140,
      |      "nlvid": "0264408",
      |      "scrid": "3575147",
      |      "cmsid": "c8ea33de-7286-4105-9c7c-4d29c6c6830e",
      |      "relatedText": "Get the Recipe",
      |      "relatedUrl": "/recipes/eddie-jackson/spinach-artichoke-and-red-pepper-dip.html",
      |      "thumbnailUrl": "http://images.scrippsnetworks.com/up/tp/Scripps_-_Food_Category_Prod/795/91/0264408_92x69.jpg",
      |      "thumbnailUrl16x9": "http://images.scrippsnetworks.com/up/tp/Scripps_-_Food_Category_Prod/795/91/0264408_126x71.jpg",
      |      "videoFormat": "HD",
      |      "showName": "",
      |      "showUrl": "",
      |      "hostName": "",
      |      "hostUrl": "",
      |      "hasSponsorship": false,
      |      "embedUrl": "http://www.foodnetwork.com/videos/spinach-artichoke-pepper-dip-0264408.embed.html"
      |    },
      |    {
      |      "releaseUrl": "http://link.theplatform.com/s/ip77QC/9nitzKhV9HP3?format=SMIL&MBR=true",
      |      "mpxId": "http://data.media.theplatform.com/media/data/Media/854458435815",
      |      "title": "Chip-Crusted Chicken Fingers",
      |      "description": "Dip this super-indulgent snack in Eddie's homemade sriracha-ranch sauce.",
      |      "length_hhmmss": "02:30",
      |      "length": 150,
      |      "length_sss": 150,
      |      "nlvid": "0264410",
      |      "scrid": "3575149",
      |      "cmsid": "46d0d19b-f308-4bd0-a635-da03139ae644",
      |      "relatedText": "Get the recipe",
      |      "relatedUrl": "/recipes/eddie-jackson/sweet-chili-chip-crusted-chicken-fingers-with-sriracha-ranch-dipping-sauce.html",
      |      "thumbnailUrl": "http://images.scrippsnetworks.com/up/tp/Scripps_-_Food_Category_Prod/796/67/0264410_92x69.jpg",
      |      "thumbnailUrl16x9": "http://images.scrippsnetworks.com/up/tp/Scripps_-_Food_Category_Prod/796/67/0264410_126x71.jpg",
      |      "videoFormat": "HD",
      |      "showName": "",
      |      "showUrl": "",
      |      "hostName": "",
      |      "hostUrl": "",
      |      "hasSponsorship": false,
      |      "embedUrl": "http://www.foodnetwork.com/videos/chip-crusted-chicken-fingers-0264410.embed.html"
      |    },
      |    {
      |      "releaseUrl": "http://link.theplatform.com/s/ip77QC/cLGz2euFMFS2?format=SMIL&MBR=true",
      |      "mpxId": "http://data.media.theplatform.com/media/data/Media/854457411638",
      |      "title": "Pesto Pizza with Feta",
      |      "description": "Make this savory pizza's crust the day before, so you can enjoy the party.",
      |      "length_hhmmss": "02:56",
      |      "length": 176,
      |      "length_sss": 176,
      |      "nlvid": "0264409",
      |      "scrid": "3575148",
      |      "cmsid": "ccb6cd91-3759-4609-947a-ef8f483bf740",
      |      "relatedText": "Get the recipe",
      |      "relatedUrl": "/recipes/eddie-jackson/pesto-pizza-with-feta-and-artichokes.html",
      |      "thumbnailUrl": "http://images.scrippsnetworks.com/up/tp/Scripps_-_Food_Category_Prod/795/91/0264409_92x69.jpg",
      |      "thumbnailUrl16x9": "http://images.scrippsnetworks.com/up/tp/Scripps_-_Food_Category_Prod/795/91/0264409_126x71.jpg",
      |      "videoFormat": "HD",
      |      "showName": "",
      |      "showUrl": "",
      |      "hostName": "",
      |      "hostUrl": "",
      |      "hasSponsorship": false,
      |      "embedUrl": "http://www.foodnetwork.com/videos/pesto-pizza-with-feta-0264409.embed.html"
      |    },
      |    {
      |      "releaseUrl": "http://link.theplatform.com/s/ip77QC/B5EaoRhUnhU1?format=SMIL&MBR=true",
      |      "mpxId": "http://data.media.theplatform.com/media/data/Media/854457411611",
      |      "title": "Toasted Coconut Brownies",
      |      "description": "Coconut turns up the dial on this chocolate dessert.",
      |      "length_hhmmss": "02:32",
      |      "length": 152,
      |      "length_sss": 152,
      |      "nlvid": "0264411",
      |      "scrid": "3575150",
      |      "cmsid": "ad040f68-7fe6-40dc-a3fe-9e02129635d9",
      |      "relatedText": "Get the recipe",
      |      "relatedUrl": "/recipes/eddie-jackson/toasted-coconut-brownies.html",
      |      "thumbnailUrl": "http://images.scrippsnetworks.com/up/tp/Scripps_-_Food_Category_Prod/795/91/0264411_92x69.jpg",
      |      "thumbnailUrl16x9": "http://images.scrippsnetworks.com/up/tp/Scripps_-_Food_Category_Prod/795/91/0264411_126x71.jpg",
      |      "videoFormat": "HD",
      |      "showName": "",
      |      "showUrl": "",
      |      "hostName": "",
      |      "hostUrl": "",
      |      "hasSponsorship": false,
      |      "embedUrl": "http://www.foodnetwork.com/videos/toasted-coconut-brownies-0264411.embed.html"
      |    },
      |    {
      |      "releaseUrl": "http://link.theplatform.com/s/ip77QC/t_v6FEbHSGf7?format=SMIL&MBR=true",
      |      "mpxId": "http://data.media.theplatform.com/media/data/Media/854456899863",
      |      "title": "Chocolate Stout Chili",
      |      "description": "Chocolate pairs surprisingly well with this chili's spice.",
      |      "length_hhmmss": "03:52",
      |      "length": 232,
      |      "length_sss": 232,
      |      "nlvid": "0264412",
      |      "scrid": "3575151",
      |      "cmsid": "14dcab22-0db2-4ccf-8ca5-a2ddb47aafa3",
      |      "relatedText": "Get the recipe",
      |      "relatedUrl": "/recipes/eddie-jackson/texas-style-chocolate-stout-chili.html",
      |      "thumbnailUrl": "http://images.scrippsnetworks.com/up/tp/Scripps_-_Food_Category_Prod/794/615/0264412_92x69.jpg",
      |      "thumbnailUrl16x9": "http://images.scrippsnetworks.com/up/tp/Scripps_-_Food_Category_Prod/794/615/0264412_126x71.jpg",
      |      "videoFormat": "HD",
      |      "showName": "",
      |      "showUrl": "",
      |      "hostName": "",
      |      "hostUrl": "",
      |      "hasSponsorship": false,
      |      "embedUrl": "http://www.foodnetwork.com/videos/chocolate-stout-chili-0264412.embed.html"
      |    },
      |    {
      |      "releaseUrl": "http://link.theplatform.com/s/ip77QC/1j7ww8BuiVFP?format=SMIL&MBR=true",
      |      "mpxId": "http://data.media.theplatform.com/media/data/Media/854456899850",
      |      "title": "Slow-Cooker Gumbo",
      |      "description": "Eddie's recipe is layered with flavor (don't skip the file powder).",
      |      "length_hhmmss": "03:19",
      |      "length": 199,
      |      "length_sss": 199,
      |      "nlvid": "0264413",
      |      "scrid": "3575152",
      |      "cmsid": "0d554dc1-9a5a-49d7-911f-42f3fbffda1c",
      |      "relatedText": "Get the recipe",
      |      "relatedUrl": "/recipes/eddie-jackson/slow-cooker-smoked-chicken-and-shrimp-gumbo.html",
      |      "thumbnailUrl": "http://images.scrippsnetworks.com/up/tp/Scripps_-_Food_Category_Prod/794/615/0264413_92x69.jpg",
      |      "thumbnailUrl16x9": "http://images.scrippsnetworks.com/up/tp/Scripps_-_Food_Category_Prod/794/615/0264413_126x71.jpg",
      |      "videoFormat": "HD",
      |      "showName": "",
      |      "showUrl": "",
      |      "hostName": "",
      |      "hostUrl": "",
      |      "hasSponsorship": false,
      |      "embedUrl": "http://www.foodnetwork.com/videos/slow-cooker-gumbo-0264413.embed.html"
      |    }
      |  ]
      |}]} ));
      |  </script>
      |</section>
      |</section>
      |</div>
      |</div>
      |<div class="parbase section reference">
      |</div>
      |<section class="module more-recipe-ideas section"><span style="display: none" class="clicktracking" data-component-path="sni-core/components/modules/more-recipe-ideas" data-resource-path="/content/food/recipes/food-network-kitchens/b/bi/big/big-/big-batch-healthy-beef-mushroom-and-spinach-calzones/jcr:content/content-well/more-recipe-ideas" data-resource-type="sni-food/components/modules/more-recipe-ideas"></span></section>
      |<section class="ad-fn-magazine module section">
      |</section>
      |<div class="reviews section">
      |	    <section>
      |            <div class="reviews-filter" data-review-filters="5c9f0027-2000-4a74-b945-e801861a91c2" id="review-filter-5c9f0027-2000-4a74-b945-e801861a91c2">
      |                <div class="loading">
      |                    <div class="absolute-centering">
      |                        <img alt="Loading review filters..." src="/etc/designs/food/clientlib/img/spinner.gif">
      |                    </div>
      |                </div>
      |                <div class="filters">
      |                    <header class="hr">
      |                        <h5>BROWSE REVIEWS BY KEYWORD</h5>
      |                    </header>
      |                    <ul class="stack"></ul>
      |                </div>
      |                <div class="content"></div>
      |            </div>
      |        </section>
      |        <script id="global_filter_template" type="text/review-template">
      |            <li><i></i><a rel="ellipsis" id="filter_{{id}}" data-index="{{index}}" data-max="38" href="#">{{name}} <cite>{{count}}</cite></a></li>
      |        </script>
      |        <script id="global_review_template" type="text/review-template">
      |            <div class="media">
      |                <div class="ratings">
      |                    {{rating}}
      |                </div>
      |                <p>By {{displayName}} {{location}}</p>
      |                <time datetime="2013-11-02">{{reviewDate}}</time>
      |            </div>
      |            <div class="review">
      |                <div class="wrapper">
      |                    {{body}}
      |                </div>
      |            </div>
      |            <div class="bottom">
      |                <div class="count">
      |                    <p class="pull-left">
      |                        <span class="current">{{current}}</span> of <span class="total">{{total}}</span> reviews for "<b>{{name}}</b>"
      |                    </p>
      |                    <div class="pull-right">
      |                        <a href="#" class="btn fig inverse prev"><i class="ss-left"></i><span>Previous</span></a>
      |                        <a href="#" class="btn fig inverse next"><span>Next</span><i class="ss-right"></i></a>
      |                    </div>
      |                </div>
      |            </div>
      |        </script>
      |        <script id="global_tryout_template" type="text/review-template">
      |            <p id="intro">Filter reviews by keyword by clicking on the keywords above,<br>or try these popular keywords: <br></p>
      |            <div id="try-now-links">
      |                <div class="try-wrap">
      |                    <ul class="tryouts"></ul>
      |                </div>
      |            </div>
      |        </script>
      |		<section class="communityReviews section">
      |		    <header class="hr">
      |                <h5>Reviews</h5>
      |				<section class="review-rating section">
      |<a class="community-rating-stars" data-rating='{"id":"5c9f0027-2000-4a74-b945-e801861a91c2"}' href="#communityReviews"></a>
      |</section>
      |            </header>
      |			<div class="community-comments" id="communityReviews" data-comments='{}'></div>
      |		</section>
      |</div>
      |</div>
      |    </article>
      | </body>
      | </html>
    """.stripMargin
}
