<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html lang="en-us">
<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
<head>
<title>FOOT</title>
<meta name="viewport" content="width=device-width, minimum-scale=0.25, maximum-scale=1.0, initial-scale=1.0"/>
<meta name="apple-mobile-web-app-capable" content="yes"/>
<script>
  $(document).ready(function() {
	$('.w-input-search').autocomplete({
		serviceUrl: '${pageContext.request.contextPath}/getTags',
		paramName: "subCategoryName=New",
		delimiter: ",",
	   transformResult: function(response) {
		return {
		  //must convert json to javascript object before process
		  suggestions: $.map($.parseJSON(response), function(item) {
		      return { value: item.subCategoryName};
		      //return { value: item.productName, data: item.id };
		   })
		 };
            }
	 });	
  });
</script>
<script type="text/javascript">
try
{
	if (!window.CloudFlare) 
	{
		var CloudFlare=[{verbose:0,p:0,byc:0,owlid:"cf",bag2:1,mirage2:0,oracle:0,paths:{cloudflare:"/cdn-cgi/nexp/dok3v=1613a3a185/"},atok:"7cffd1bfbd09038605e944d8ebd04ccc",petok:"e8fdb248a32dc3aa3c699d0a2d4bfd269d09ee04-1482002786-1800",zone:"template-help.com",rocket:"0",apps:{"abetterbrowser":{"ie":"7"}}}];
		!function(a,b){a=document.createElement("script"),b=document.getElementsByTagName("script")[0],a.async=!0,a.src="resources/js/cloudflare.min.js",b.parentNode.insertBefore(a,b)}()
	}
}
catch(e)
{
};
</script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300italic,700italic,700,400italic,300&amp;subset=latin,greek-ext,greek,vietnamese,cyrillic-ext,latin-ext,cyrillic" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/jquery.fancybox.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/global.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/contact-form.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/highdpi.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/jquery.bxslider.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/addresses.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/blocklayered.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/authentication.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/jquery.mCustomScrollbar.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/responsive-tables.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/slick.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/animate.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/jquery.fancybox.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/product_list.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/tmrelatedproducts.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/blockcart.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/scenes.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/blockcategories.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/blockcurrencies.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/blocklanguages.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/blockcontact.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/blocknewsletter.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/blocktags.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/category.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/blockviewed.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/homeslider.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/homefeatured.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/hooks.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/print.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/productcomments.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/blockpermanentlinks.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/smartblogstyle.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/smartbloglatestnews.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/smartblogtags.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/front.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/tmnewsletter.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/tmsearch.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/blockwishlist.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/tmmegamenu.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/cms.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/tmmediaparallax.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/tmmanufacturerblock.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/tmmosaicproducts.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/tmmegalayout.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/live_configurator.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/jquery.autocomplete.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/stores.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/socialsharing.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/jquery.jqzoom.css" type="text/css" media="all"/>
<link rel="stylesheet" href="resources/css/product.css" type="text/css" media="all"/>

<script src="resources/js/angular.min.js"></script>
<script src="resources/js/contact-form.js"></script>
<script src="resources/js/sendtoafriend.js"></script>
<script src="resources/js/productscategory.js"></script>
<script src="resources/js/jquery-1.11.0.min.js"></script>
<script src="resources/js/crossselling.js"></script>
<script src="resources/js/jquery.jqzoom.js"></script>
<script src="resources/js/jquery-migrate-1.2.1.min.js"></script>
<script src="resources/js/jquery.easing.js"></script>
<script src="resources/js/tools.js"></script>
<script src="resources/js/cms.js"></script>
<script src="resources/js/jquery.idTabs.js"></script>
<script src="resources/js/jquery.scrollTo.js"></script>
<script src="resources/js/jquery.serialScroll.js"></script>
<script src="resources/js/jquery.bxslider.js"></script>
<script src="resources/js/jquery.fancybox.js"></script>
<script src="resources/js/validate.js"></script>
<script src="resources/js/jquery.autocomplete.js"></script>
<script src="resources/js/global.js"></script>
<script src="resources/js/productcomments.js"></script>
<script src="resources/js/10-bootstrap.min.js"></script>
<script src="resources/js/14-device.min.js"></script>
<script src="resources/js/15-jquery.total-storage.min.js"></script>
<script src="resources/js/custom-file-input.js"></script>
<script src="resources/js/16-jquery.scrollmagic.min.js"></script>
<script src="resources/js/17-jquery.scrollmagic.debug.js"></script>
<script src="resources/js/18-TimelineMax.min.js"></script>
<script src="resources/js/19-TweenMax.min.js"></script>
<script src="resources/js/20-jquery.bxslider.js"></script>
<script src="resources/js/22-jquery.scrollbar.js"></script>
<script src="resources/js/23-jquery.mousewheel.min.js"></script>
<script src="resources/js/24-jquery.simplr.smoothscroll.min.js"></script>
<script src="resources/js/breakpoints.js"></script>
<script src="resources/js/jquery.rating.pack.js"></script>
<script src="resources/js/jquery.mCustomScrollbar.js"></script>
<script src="resources/js/slick.js"></script>
<script src="resources/js/products-comparison.js"></script>
<script src="resources/js/treeManagement.js"></script>
<script src="resources/js/blocknewsletter.js"></script>
<script src="resources/js/homeslider.js"></script>
<script src="resources/js/tmnewsletter.js"></script>
<script src="resources/js/front2.js"></script>
<script src="resources/js/tmmegamenu.js"></script>
<script src="resources/js/product.js"></script>
<script src="resources/js/index.js"></script>
<script src="resources/js/jquery.rd-parallax.min.js"></script>
<script src="resources/js/jquery.youtubebackground.js"></script>
<script src="resources/js/jquery.vide.min.js"></script>
<script src="resources/js/tmmediaparallax.js"></script>
<script src="resources/js/tmmosaicproducts.js"></script>
<script src="resources/js/video1.js"></script>
<script src="resources/js/jquery.textareaCounter.plugin.js"></script>
<script src="resources/js/tmmegalayout.js"></script>
<script src="resources/js/themeconfiglink.js"></script>
<script src="resources/js/hoverIntent.js"></script>
<script src="resources/js/superfish.js"></script>
<script src="resources/js/front3.js"></script>
<script src="resources/js/tmrelatedproducts.js"></script>
<script src="resources/js/front.js"></script>

<script type="text/javascript">
var CUSTOMIZE_TEXTFIELD = 1;
var FancyboxI18nClose = 'Close';
var FancyboxI18nNext = 'Next';
var FancyboxI18nPrev = 'Previous';
var PS_CATALOG_MODE = false;
var added_to_wishlist = 'The product was successfully added to your wishlist.';
var ajax_allowed = false;
var ajaxsearch = false;
var allowBuyWhenOutOfStock = false;
var availableLaterValue = '';
var availableNowValue = '';
var baseDir = 'index.jsp';
var baseUri = '';
var jqZoomEnabled = true;
var blocking_popup = '1';
var comparator_max_item = 2;
var comparedProductsIds = [];
var contentOnly = false;
var currency = {"id":1,"name":"Rupees","iso_code":"INR","iso_code_num":"840","sign":"&#x20b9;","blank":"0","conversion_rate":"1.000000","deleted":"0","format":"1","decimals":"1","active":"1","prefix":"&#x20b9; ","suffix":"","id_shop_list":null,"force_id":false};
var currencyBlank = 0;
var currencyFormat = 1;
var currencyRate = 1;
var currencySign = '&#x20b9;';
var customizationIdMessage = 'Customization #';
var delete_txt = 'Delete';
var default_eco_tax = 0;
var displayDiscountPrice = null;
var displayList = false;
var freeProductTranslation = 'Free!';
var freeShippingTranslation = 'Free shipping!';
var generated_date = 1482002836;
var hasDeliveryAddress = false;
var highDPI = false;
var homeslider_loop = 1;
var homeslider_pause = 3000;
var homeslider_speed = 500;
var homeslider_width = 10000;
var id_lang = 1;
var img_dir = '';
var instantsearch = true;
var isGuest = 0;
var isLogged = 0;
var isMobile = false;
var is_logged = false;
var loggin_required = 'You must be logged in to manage your wishlist.';
var max_item = 'You cannot add more than 2 product(s) to the product comparison';
var min_item = 'Please select at least one product';
var module_url = '';
var mywishlist_url = '';
var nbItemsPerLine = 3;
var nbItemsPerLineMobile = 2;
var nbItemsPerLineTablet = 2;
var page_name = 'index';
var placeholder_blocknewsletter = 'Your Email Address';
var popup_status = true;
var priceDisplayMethod = 1;
var priceDisplayPrecision = 2;
var quickView = true;
var removingLinkText = 'remove this product from my cart';
var roundMode = 2;
var search_url = '${pageContext.request.contextPath}/getTags';
var search_url_local = '${pageContext.request.contextPath}/getTags';
var static_token = '0a9f6300ab69c9db1344dae91e1ba312';
var tmnewsletter_status = '2';
var tmolarkchat_status = '2';
var toBeDetermined = 'To be determined';
var token = 'd5af4605833a6822aa2884ab1916c972';
var user_newsletter_status = 0;
var usingSecureMode = true;
var wishlistProductsIds = false;
</script>
<script>
    $(document).ready(function(){
      var elem = $('.newsletter-parallax #newsletter_block_left');
      if (elem.length) {
        $('body').append('    <div class=\"rd-parallax rd-parallax-1\">\r\n                                                              <div class=\"rd-parallax-layer\" data-offset=\"0\" data-speed=\"0.2\" data-type=\"media\" data-fade=\"false\" data-url=\"/prestashop_61157/img/cms/img-parallax1.jpg\" data-direction=\"normal\"><\/div>\r\n                        <div class=\"rd-parallax-layer\" data-offset=\"0\" data-speed=\"0\" data-type=\"html\" data-fade=\"false\" data-direction=\"normal\">\r\n                  <div class=\"container\">\r\n              <div class=\"parallax-main-layout\"><\/div>\r\n      <\/div>      <\/div>\r\n    <\/div>\r\n  ');
        var wrapper = $('.rd-parallax-1');
        elem.before(wrapper);
        $('.rd-parallax-1 .parallax-main-layout').replaceWith(elem);
        win = $(window);
                win.on('load resize', function() {
          wrapper.css('width', win.width()).css('margin-left', Math.floor(win.width() * -0.5)).css('left', '50%');
        });
            }
    });
  </script>
<script>
    $(document).ready(function(){
      var elem = $('.topcolumn-preset1 #tm_manufacturers_block');
      if (elem.length) {
        $('body').append('    <div class=\"rd-parallax rd-parallax-2\">\r\n                                                              <div class=\"rd-parallax-layer\" data-offset=\"0\" data-speed=\"0.2\" data-type=\"media\" data-fade=\"false\" data-url=\"/prestashop_61157/img/cms/img-parallax1.jpg\" data-direction=\"normal\"><\/div>\r\n                        <div class=\"rd-parallax-layer\" data-offset=\"0\" data-speed=\"0\" data-type=\"html\" data-fade=\"false\" data-direction=\"normal\">\r\n                  <div class=\"container\">\r\n              <div class=\"parallax-main-layout\"><\/div>\r\n      <\/div>      <\/div>\r\n    <\/div>\r\n  ');
        var wrapper = $('.rd-parallax-2');
        elem.before(wrapper);
        $('.rd-parallax-2 .parallax-main-layout').replaceWith(elem);
        win = $(window);
                win.on('load resize', function() {
          wrapper.css('width', win.width()).css('margin-left', Math.floor(win.width() * -0.5)).css('left', '50%');
        });
            }
    });
  </script>
<script>
    $(document).ready(function(){
      var elem = $('#tmhtmlcontent_footer');
      if (elem.length) {
        $('body').append('    <div class=\"rd-parallax rd-parallax-3\">\r\n                                                              <div class=\"rd-parallax-layer\" data-offset=\"1\" data-speed=\"0.2\" data-type=\"media\" data-fade=\"false\" data-url=\"/prestashop_61157/img/cms/img-parallax4.jpg\" data-direction=\"normal\"><\/div>\r\n                        <div class=\"rd-parallax-layer\" data-offset=\"0\" data-speed=\"0\" data-type=\"html\" data-fade=\"false\" data-direction=\"normal\">\r\n                  <div class=\"container\">\r\n              <div class=\"parallax-main-layout\"><\/div>\r\n      <\/div>      <\/div>\r\n    <\/div>\r\n  ');
        var wrapper = $('.rd-parallax-3');
        elem.before(wrapper);
        $('.rd-parallax-3 .parallax-main-layout').replaceWith(elem);
        win = $(window);
                win.on('load resize', function() {
          wrapper.css('width', win.width()).css('margin-left', Math.floor(win.width() * -0.5)).css('left', '50%');
        });
            }
    });
  </script>
<script>
    $(document).ready(function(){
      var elem = $('.home-preset3 #tm_manufacturers_block');
      if (elem.length) {
        $('body').append('    <div class=\"rd-parallax rd-parallax-4\">\r\n                                                              <div class=\"rd-parallax-layer\" data-offset=\"0\" data-speed=\"0.2\" data-type=\"media\" data-fade=\"false\" data-url=\"/prestashop_61157/img/cms/img-parallax1.jpg\" data-direction=\"normal\"><\/div>\r\n                        <div class=\"rd-parallax-layer\" data-offset=\"0\" data-speed=\"0\" data-type=\"html\" data-fade=\"false\" data-direction=\"normal\">\r\n                  <div class=\"container\">\r\n              <div class=\"parallax-main-layout\"><\/div>\r\n      <\/div>      <\/div>\r\n    <\/div>\r\n  ');
        var wrapper = $('.rd-parallax-4');
        elem.before(wrapper);
        $('.rd-parallax-4 .parallax-main-layout').replaceWith(elem);
        win = $(window);
                win.on('load resize', function() {
          wrapper.css('width', win.width()).css('margin-left', Math.floor(win.width() * -0.5)).css('left', '50%');
        });
            }
    });
  </script>
<script>
    $(document).ready(function(){
      var elem = $('.preset_topcolumn2  #tm_manufacturers_block');
      if (elem.length) {
        $('body').append('    <div class=\"rd-parallax rd-parallax-5\">\r\n                                                              <div class=\"rd-parallax-layer\" data-offset=\"0\" data-speed=\"0.2\" data-type=\"media\" data-fade=\"false\" data-url=\"/prestashop_61157/img/cms/img-parallax1.jpg\" data-direction=\"normal\"><\/div>\r\n                        <div class=\"rd-parallax-layer\" data-offset=\"0\" data-speed=\"0\" data-type=\"html\" data-fade=\"false\" data-direction=\"normal\">\r\n                  <div class=\"container\">\r\n              <div class=\"parallax-main-layout\"><\/div>\r\n      <\/div>      <\/div>\r\n    <\/div>\r\n  ');
        var wrapper = $('.rd-parallax-5');
        elem.before(wrapper);
        $('.rd-parallax-5 .parallax-main-layout').replaceWith(elem);
        win = $(window);
                win.on('load resize', function() {
          wrapper.css('width', win.width()).css('margin-left', Math.floor(win.width() * -0.5)).css('left', '50%');
        });
            }
    });
  </script>
<script>
    $(document).ready(function(){
      $(window).on('load', function(){
        $.RDParallax();
        $('.rd-parallax-layer video').each(function(){
          $(this)[0].play();
        });
      });
    });
  </script>
</head>

<body id="index" class="index hide-left-column hide-right-column lang_en  one-column">
<div id="page">
<div id="page_preloader" class="loader">
<div class="preloader_img">
<img class="logo img-responsive" src="" width="200" height="40"/>
<div class="img_end"></div>
</div>
</div>
<div class="header-container">
<header id="header">
<div class="nav clearfix">
<nav>
<div class="nav-setting">
<div class="btn-setting material-design-settings49"></div>
<div class="block-setting">
</div>
</div>
<div id="header-login">
<c:if test="${empty pageContext.request.userPrincipal}">
<div id="header-login">
<div class="current_toogle header_user_info"><a href="#" onclick="return false;">Sign in</a></div>
<ul id="header-login-content" class="toogle_content_box">
<li>
<div class="icon-close material-design-close47"></div>
<h4>login</h4>
<form id="header_login_form" method="post" action="perform_login">
<div id="create_header_account_error" class="alert alert-danger" style="display:none;"></div>
<div class="form_content clearfix">
<div class="form-group">
<input class="form-control" placeholder="Username" name="username" type="text" value=""/>
</div>
<div class="form-group">
<span><input class="form-control" type="password" placeholder="Password" name="password" value=""/></span>
</div>
<p class="submit">
<input type="submit" class="btn btn-default" value="Sign in">
</p>
<p>
<a href="/Foot/registrationform" class="create btn btn-default">Create an account</a>
</p>
<p>
<a href="/Foot/forget" class="forgot-password">Forgot your password?</a>
</p>
</div>
</form>
</li>
</ul>
</div>
</c:if>
<c:if test="${!empty pageContext.request.userPrincipal}">
<div id="header-login">
<div class="current_toogle header_user_info"><a href="#" onclick="return false;"><span class="fa fa-user"></span>  ${pageContext.request.userPrincipal.name}</a></div>
<ul id="header-login-content" class="toogle_content_box" style="display: none;">
<sec:authorize access="hasRole('ROLE_USER')">
<li class="login">
<ul>
<li>
<a href="#" title="My orders" rel="nofollow"><span class="fa fa-shopping-cart">	My orders</span></a>
</li>
<li>
<a href="#" title="My addresses" rel="nofollow"><span class="fa fa-home">	My addresses</span></a>
</li>
<li>
<a href="/Foot/profile" title="Manage my personal information" rel="nofollow"><span class="fa fa-user">	My personal info</span></a>
</li>
<li class="lnk_wishlist">
<a href="#" title="My wishlists">
<span class="fa fa-heart">	My wishlists</span>
</a>
</li>
</ul>
</li>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_SUPPLIER')">
<li class="login">
<ul>
<li>
<a href="#" title="My orders" rel="nofollow"><span class="fa fa-shopping-cart">	My orders</span></a>
</li>
<li>
<a href="#" title="My addresses" rel="nofollow"><span class="fa fa-home">	My addresses</span></a>
</li>
<li>
<a href="/Foot/profile" title="Manage my personal information" rel="nofollow"><span class="fa fa-user">	My personal info</span></a>
</li>
<li class="lnk_wishlist">
<a href="#" title="My wishlists">
<span class="fa fa-heart">	My wishlists</span>
</a>
</li>
<li class="lnk_wishlist">
<a href="/Foot/productssupplierform" title="My wishlists">
<span class="fa fa-plus">	Add Products</span>
</a>
</li>
</ul>
</li>
</sec:authorize>
<p class="logout">
<a class="btn btn-default btn-sm" href="/Foot/logout" title="Sign out" rel="nofollow">                    	
Sign out
</a>
</p>
</ul>
</div>
</c:if>
</div>

<div id="languages-block-top" class="languages-block">
<div>
<span>English</span>
</div>
<ul id="first-languages" class="languages-block_ul">
<li class="selected">
<span>en</span>
</li>
<li>
<a href="#" title="Deutsch (German)" rel="alternate" hreflang="de">
<span>de</span>
</a>
</li>
<li>
<a href="#" title="Русский (Russian)" rel="alternate" hreflang="ru">
<span>ru</span>
</a>
</li>
<li>
<a href="#" title="Español (Spanish)" rel="alternate" hreflang="es">
<span>es</span>
</a>
</li>
<li>
<a href="#" title="Français (French)" rel="alternate" hreflang="fr">
<span>fr</span>
</a>
</li>
</ul>
</div>
<div id="currencies-block-top">
<form id="setCurrency" action="#" method="post">
<div>
<input type="hidden" name="id_currency" id="id_currency" value=""/>
<input type="hidden" name="SubmitCurrency" value=""/>
<span class="cur-label">Currency :</span>
<strong>INR</strong>
</div>
<ul id="first-currencies" class="currencies_ul">
<li class="selected">
<a href="#" rel="nofollow" title="Rupees (INR)">
&#x20b9;
</a>
</li>
<li>
<a href="#" rel="nofollow" title="Dollar (USD)">
$
</a>
</li>
<li>
<a href="#" rel="nofollow" title="Euro (EUR)">
&euro;
</a>
</li>
</ul>
</form>
</div>
 
 
<div class="header_links">
<ul id="header_links">
<li id="header_link_home"><a href="/Foot/" class="header_links_home">home</a></li>
<li id="header_link_contact">
<a href="/Foot/contact" title="contact">contact</a>
</li>
<li>
<a href="/Foot/aboutus" >about us</a>
</li>
<li id="header_link_blog">
<a href="#" title="blog">blog</a>
</li>
</ul>
</div>
 
</nav>
</div>
<div class="row-top clearfix">
<!-- <div id="header_logo"> -->
<!-- <a href="/Foot/" title="FOOT"> -->
<!-- <img class="logo img-responsive" src="" width="200" height="30"/> -->
<!-- </a> -->
<!-- </div> -->
 
<div class="cartBox ">
<div class="shopping_cart">
<a href="#" title="View my shopping cart" rel="nofollow">
<b>Cart</b>
<span class="ajax_cart_quantity unvisible">0</span>
<span class="ajax_cart_product_txt unvisible">Product</span>
<span class="ajax_cart_product_txt_s unvisible">Products</span>
<span class="ajax_cart_total unvisible">
</span>
<span class="ajax_cart_no_product">(empty)</span>
</a>
<div class="cart_block block">
<div class="block_content">
 
<div class="cart_block_list">
<p class="cart_block_no_products">
No products
</p>
<div class="cart-prices">
<div class="cart-prices-line first-line  unvisible">
<span class="cart_block_shipping_cost ajax_cart_shipping_cost">
To be determined </span>
<span>
Shipping
</span>
</div>
<div class="cart-prices-line last-line">
<span class="price cart_block_total ajax_block_cart_total">$0.00</span>
<span class="cart-total-price">Total</span>
</div>
</div>
<p class="cart-buttons">
<a id="button_order_cart" class="btn btn-default" href="#" title="Check out" rel="nofollow">
<span>
Check out
</span>
</a>
</p>
</div>
</div>
</div> 
</div>
</div>
<div id="layer_cart">
<div class="box-cart-popup">
<span class="cross" title="Close window"></span>
<div class="layer_cart_product">
<span class="title">
<i class="material-design-check52"></i>
Product successfully added to your shopping cart
</span>
<div class="product-image-container layer_cart_img">
</div>
<div class="cart-info-right">
<span class="title">
 
<span class="ajax_cart_product_txt_s  unvisible">
<strong><span class="ajax_cart_quantity">0</span> items</strong>
<em><i class="material-design-shopping231"></i>You Have In your cart</em>
</span>
 
<span class="ajax_cart_product_txt unvisible">
<strong><span>1</span>item</strong>
<em><i class="material-design-shopping231"></i> You Have In your cart</em>
</span>	
</span>
</div>
</div>
<div class="layer_cart_center clearfix">
<div class="title-cart_center">
<span id="layer_cart_product_title" class="product-name"></span>
</div>
<div class="layer_cart_row-info">
<div class="layer_cart_row">
<strong class="dark">
Total products
</strong>
<span class="ajax_block_products_total">
</span>
</div>
<div class="layer_cart_row">
<strong class="dark unvisible">
Total shipping&nbsp; </strong>
<span class="ajax_cart_shipping_cost unvisible">
To be determined </span>
</div>
<div class="layer_cart_row">
<strong class="dark">
Total
</strong>
<span class="ajax_block_cart_total">
</span>
</div>
</div>
</div>
<div class="crossseling"></div>
<div class="layer_cart_cart clearfix">
<div class="layer_cart_product_info">
<div>
<strong class="dark">Quantity</strong>
<span id="layer_cart_product_quantity"></span>
</div>
<div>
<strong class="dark">Total</strong>
<span id="layer_cart_product_price"></span>
</div>
</div>
<div class="button-container">
<span class="continue btn btn-default" title="Continue shopping">
<span>
Continue shopping
</span>
</span>
<a class="btn btn-default" href="#" title="Proceed to checkout" rel="nofollow">
<span>
Proceed to checkout
</span>
</a>
</div>
</div>
</div>
</div>


<div class="layer_cart_overlay"></div>
<div id="tmsearch" class="clearfix">
<form id="tmsearchbox" action="#">
<div class="tm_search_query_wrapper">
<input class="form-control w-input-search" type="text" id="tm_search_query" placeholder="Search"/>
</div>
<div class="visible_btn" style="display: block;"></div>
<button type="submit" class="btn btn-default button-search fa fa-search">
<span>Search</span>
</button>
</form>
</div>

<div class="top_menu top-level tmmegamenu_item">
<div class="menu-title menu-title-icon material-design-show5"></div>
<div class="tmmegamenu_title">Menu<span class="menu-close material-design-clear5 "></span></div>
<ul class="menu clearfix top-level-menu tmmegamenu_item">
<c:forEach items = "${categoryList}" var="category">
<li class=" top-level-menu-li tmmegamenu_item it_83622113">
<a class="it_83622113 top-level-menu-li-a tmmegamenu_item" href="#">${category.categoryName}</a>
<div class="is-megamenu tmmegamenu_item first-level-menu it_83622113">
<div id="megamenu-row-1-1" class="megamenu-row row megamenu-row-1">
<div id="column-1-1-1" class="megamenu-col megamenu-col-1-1 col-sm-3  menulist1 col_custom1">
<ul class="content">
<li class="html">
<h3>list-menu</h3>
<ul class="list-menu">
<li><a href="#">NEW RELEASES</a></li>
<li><a href="#">LAUNCH CALENDAR</a></li>
<li><a href="#">SUMMER ESSENTIALS</a></li>
<li><a href="#">NATIONAL SPORTS TEAMS</a></li>
<li><a href="#">SALE</a></li>
</ul>
</li>
</ul>
</div>
<div id="column-1-1-2" class="megamenu-col megamenu-col-1-2 col-sm-3  menulist2 col_custom2">
<ul class="content">
<li class="link-title custom-link">
<a href="#">Categories</a>
</li>
<c:forEach items = "${category.subCategory}" var="subCategory">
<li class="category">
<a href="#">${subCategory.subCategoryName}</a>
</li>
</c:forEach>
</ul>
</div>
<div id="column-1-1-3" class="megamenu-col megamenu-col-1-3 col-sm-3  menulist3 col_custom3">
<ul class="content">
<li class="link-title2 custom-link">
<a href="#">Shop By Brand</a>
</li>
<c:forEach items = "${brandList}" var="brand">
<li>
<a href="#">${brand.brandName}</a>
</li>
</c:forEach>
</ul>
</div>
<div id="column-1-1-4" class="megamenu-col megamenu-col-1-4 col-sm-3  colbanner col_custom4">
<ul class="content">
<a href="#">
<li class="megamenu_banner">
<img class="img-responsive" src="resources/images/18b2b9c689be30f26d15a310b1b3832fa3a9393e_banner-menu.jpg" alt="menu-banner"/>
<div class="description">
<h3>Semi-annual</h3>
<h4>Sale</h4>
<h5>over 1,000 styles added</h5>
</div>
</li>
</a>
</ul>
</div>
</div>
</div>
</c:forEach>
<li class=" top-level-menu-li tmmegamenu_item it_40327756">
<a class="it_40327756 top-level-menu-li-a tmmegamenu_item" href="#">Sale</a>
</li>
<c:if test="${!empty pageContext.request.userPrincipal}">
<sec:authorize access="hasRole('ROLE_ADMIN')">
<li class=" simple top-level-menu-li tmmegamenu_item it_58887333">
<a class="it_58887333 top-level-menu-li-a tmmegamenu_item" href="#">Forms</a>
<ul class="is-simplemenu tmmegamenu_item first-level-menu it_58887333">
<li class="category">
<a href="categoryform">CategoryForm</a>
</li>
<li>
<a href="subcategoryform">SubCategoryForm</a>
</li>
<li>
<a href="supplierform">SupplierForm</a>
</li>
<li>
<a href="brandform">BrandForm</a>
</li>
<li>
<a href="productsform">ProductsForm</a>
</li>
</ul>
</sec:authorize>
</c:if>
</ul>
</div>
</div>
</header>
</div>