<%@include file="header.jsp" %>
<div ng-app="products" ng-controller="productsController">
<div id="product">
<div class="columns-container">
<div class="wrapper it_MSYCVDAWVRSQ topcolumn-preset1">
<div class="row it_BPFSWOXAMUFW ">
<div class="it_XMGGKMZYAINS col-lg-12 ">
<div class="module "></div>
<div class="module ">
</div>
</div>
</div>
</div> 
<div class="breadcrumb clearfix">
<ul class="container">
<li class="home">
<a class="home" href="/Foot/" title="Return to Home">
Home
</a>
</li>
<li class="crumb-1">
<a href="#" title="Return to Home" rel="nofollow">
{{listView.categoryName}}
</a>
</li>
<li class="crumb-1">
<a href="#" title="Return to Home" rel="nofollow">
{{listView.subCategoryName}}
</a>
</li>
<li class="crumb-1">
<a href="#" title="Return to Home" rel="nofollow">
{{listView.brandName}}
</a>
</li>
<li class="crumb-4 last">{{listView.productsName}}</li>
</ul>
</div>
 
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12 accordionBox">
 
<div>
<div class="primary_block row">
 
<div class="pb-left-column col-sm-6 col-md-6 col-lg-6">
 
<div id="image-block" class="clearfix is_caroucel">
<ul id="usefull_link_block" class="clearfix no-print">
<li class="sendtofriend">
<a id="send_friend_button" href="#" title="Send to a friend">
<span>Send to a friend</span>
</a>
<div style="display: none;">
<div id="send_friend_form">
<div class="row">
<div class="product clearfix col-xs-12 col-sm-6">
<h2 class="page-subheading">
Send to a friend
</h2>
<img src="resources/images/view/{{listView.productsId}}(0).jpg" alt="Reebok ONE Cushion">
<div class="product_desc">
<p class="product_name">
<strong>{{listView.productsId}}</strong>
</p>
<p>Keds and sneakers became an inevitable part of our life. Either you have a quick pace of your life or a slow relaxed rhythm, there is nothing better than stepping in your favorite sneakers and heading off to... to wherever.</p>
</div>
</div>
</div>
</div>
</li>
</ul>
<p class="buttons_bottom_block wishlist-prodict no-print">
<a id="wishlist_button_nopop" href="/Foot/wishList-{{listView.productsId}}?userId=1" rel="nofollow" title="Add to my wishlist">
</a>
</p>
<span class="image_loader" style="opacity: 0; display: none;"></span>
<div class="labels">
<span class="sale-box no-print">
<span class="sale-label">Sale!</span>
</span>
<a class="price-percent" href="#">
<span class="price-percent-reduction">-{{listView.productsDiscount}}%</span>
</a>
</div>
<span id="view_full_size">
<a class="jqzoom" title="Reebok ONE Cushion" rel="gal1" href="#" style="outline-style: none; text-decoration: none;">
<img src="resources/images/view/{{listView.productsId}}(1).jpg" title="Reebok ONE Cushion" alt="Reebok ONE Cushion">
</a>
</span>
</div>  
 
<div id="views_block" class="clearfix">
<div id="thumbs_list">
<ul id="thumbs_list_frame" style="width: 971px;">
<li id="thumbnail_159" style="width: 170px;">
<a href="javascript:void(0);" title="Reebok ONE Cushion">
<img class="img-responsive" id="thumb_159" src="resources/images/view/{{listView.productsId}}(2).jpg" alt="Reebok ONE Cushion" title="Reebok ONE Cushion" height="80" width="80" itemprop="image">
</a>
</li>
<li id="thumbnail_160" style="width: 170px;">
<a href="javascript:void(0);" title="Reebok ONE Cushion">
<img class="img-responsive" id="thumb_160" src="resources/images/view/{{listView.productsId}}(3).jpg" alt="Reebok ONE Cushion" title="Reebok ONE Cushion" height="80" width="80" itemprop="image">
</a>
</li>
<li id="thumbnail_161" style="width: 170px;">
<a href="javascript:void(0);" title="Reebok ONE Cushion">
<img class="img-responsive" id="thumb_161" src="resources/images/view/{{listView.productsId}}(4).jpg" alt="Reebok ONE Cushion" title="Reebok ONE Cushion" height="80" width="80">
</a>
</li>
</ul>
</div>  
</div>
 
 
<p class="resetimg clear no-print">
<span id="wrapResetImages" style="display: none;">
<a href="#" data-id="resetImages">
<i class="material-design-replay4 "></i>
Display all pictures
</a>
</span>
</p>
</div>
 
<div class="pb-right-column col-sm-6 col-md-6 col-lg-6">
<div class="product-info-line">
<p id="product_reference">
<label>Reference: </label>
<span class="editable" itemprop="sku">{{listView.productsId}}</span>
</p>
 
<p id="availability_statut" style="display: none;">
<span id="availability_value" class="label label-success"></span>
</p>
<p id="product_condition">
<label>Condition: </label>
<link itemprop="itemCondition" href="#">
<span class="editable">New product</span>
</p>
 
<p id="pQuantityAvailable">
<span id="quantityAvailable">{{listView.productsQuantity}}</span>
<span style="display: none;" id="quantityAvailableTxt">Item</span>
<span id="quantityAvailableTxtMultiple">Items</span>
</p>
</div>
<p class="warning_inline" id="last_quantities" style="display: none;">Warning: Last items in stock!</p>
<p id="availability_date" style="display: none;">
<span id="availability_date_label">Availability date:</span>
<span id="availability_date_value"></span>
</p>
 
<div id="oosHook" style="display: none;">
</div>
<div class="title-brand-block clearfix">
<div class="product-brand pull-left">
<img src="resources/images/brand/{{listView.brandId}}.jpg" alt="">
</div>
<h1 itemprop="name">{{listView.productsName}}</h1>
<div class="product-manufacture">{{listView.brandName}}</div>
</div>
 
<form:form modelAttribute="productSpecification" action="/Foot/addToCart-${sessionScope.productsId}?userId=1">
<p class="hidden">
<input type="hidden" name="token" value="0a9f6300ab69c9db1344dae91e1ba312">
<input type="hidden" name="id_product" value="13" id="product_page_product_id">
<input type="hidden" name="add" value="1">
<input type="hidden" name="id_product_attribute" id="idCombination" value="844">
</p>
<div class="box-info-product">
<div class="content_prices clearfix">
 
<div class="all-price-info">
<p class="our_price_display">
<span id="our_price_display" itemprop="price" content="40">&#x20b9;{{listView.productsPrice - ((listView.productsPrice * listView.productsDiscount) / 100)}}</span>
</p>
<p id="old_price"  ng-if="listView.productsDiscount !=0">
<span id="old_price_display">
<span class="price">&#8377;{{listView.productsPrice}}</span></span>
</p>
<p id="reduction_percent"  ng-if="listView.productsDiscount !=0">-{{listView.productsDiscount}}%<span id="reduction_percent_display"></span></p>
<p id="reduction_amount" style="display:none">-{{listView.productsDiscount}}%<span id="reduction_amount_display"></span></p>
</div>
<div class="clear"></div>
<div id="product_comments_block_extra" class="no-print">
<div class="comments_note clearfix">
<span>Rating&nbsp;</span>
<div class="star_content clearfix">
<div class="star star_on"></div>
<div class="star star_on"></div>
<div class="star star_on"></div>
<div class="star star_on"></div>
<div class="star"></div>
<meta itemprop="worstRating" content="0">
<meta itemprop="ratingValue" content="4">
<meta itemprop="bestRating" content="5">
</div>
</div>  
<ul class="comments_advices">
<li>
<a href="#idTab5" class="reviews" title="Read reviews">
Read reviews (<span itemprop="reviewCount">1</span>)
</a>
</li>
</ul>
</div>
</div>  
<div id="short_description_block">
<div id="short_description_content" class="rte align_justify" itemprop="description"><p>{{listView.productsDescription}}</p></div>
</div>  
<div class="product_attributes clearfix">
<div ng-if="listView.productsQuantity != 0">
<div id="attributes">
<div class="clearfix"></div>
<fieldset class="attribute_fieldset clearfix">
<label class="attribute_label">Color&nbsp;</label>
<div class="attribute_list">
<ul>
<li>
<form:radiobutton path="color" class="attribute_radio" name="group_4" value="{{split(listView.color,0)}}" checked="checked"/>
<label>{{split(listView.color,0)}}</label>
</li>
<li>
<form:radiobutton path="color" class="attribute_radio" name="group_4" value="{{split(listView.color,1)}}"/>
<label>{{split(listView.color,1)}}</label>
</li>
<li ng-if="split(listView.color,2) != null">
<form:radiobutton path="color" class="attribute_radio" name="group_4" value="{{split(listView.color,2)}}"/>
<label>{{split(listView.color,2)}}</label>
</li>
<li ng-if="split(listView.color,3) != null">
<form:radiobutton path="color" class="attribute_radio" name="group_4" value="{{split(listView.color,3)}}"/>
<label>{{split(listView.color,3)}}</label>
</li>
<li ng-if="split(listView.color,4) != null">
<form:radiobutton path="color" class="attribute_radio" name="group_4" value="{{split(listView.color,4)}}"/>
<label>{{split(listView.color,4)}}</label>
</li>
<li ng-if="split(listView.color,5) != null">
<form:radiobutton path="color" class="attribute_radio" name="group_4" value="{{split(listView.color,5)}}"/>
<label>{{split(listView.color,5)}}</label>
</li>
</ul>
</div> 
</fieldset>
<fieldset class="attribute_fieldset clearfix select-label">
<label class="attribute_label" for="group_4">Size&nbsp;</label>
<div class="attribute_list">
<div class="selector" id="uniform-group_4" style="width: 87px;">
<form:select path="size" name="group_4" id="group_4" class="form-control attribute_select no-print">
<form:option value="{{split(listView.size,0)}}" selected="selected">{{split(listView.size,0)}}</form:option>
<form:option value="{{split(listView.size,1)}}">{{split(listView.size,1)}}</form:option>
<form:option value="{{split(listView.size,2)}}">{{split(listView.size,2)}}</form:option>
<form:option value="{{split(listView.size,3)}}">{{split(listView.size,3)}}</form:option>
<form:option value="{{split(listView.size,4)}}">{{split(listView.size,4)}}</form:option>
<form:option value="{{split(listView.size,5)}}">{{split(listView.size,5)}}</form:option>
<form:option value="{{split(listView.size,6)}}">{{split(listView.size,6)}}</form:option>
<form:option value="{{split(listView.size,7)}}">{{split(listView.size,7)}}</form:option>
</form:select>
</div>
</div>  
</fieldset>
<fieldset class="attribute_fieldset clearfix">
<label class="attribute_label">Material&nbsp;</label>
<div class="attribute_list">
<ul>
<li>
<form:radiobutton path="material" class="attribute_radio" name="group_5" value="{{split(listView.material,0)}}" checked="checked"/>
<label>{{split(listView.material,0)}}</label>
</li>
<li>
<form:radiobutton path="material" class="attribute_radio" name="group_5" value="{{split(listView.material,1)}}" checked="checked"/>
<label>{{split(listView.material,1)}}</label>
</li>
<li>
<form:radiobutton path="material" class="attribute_radio" name="group_5" value="{{split(listView.material,2)}}" checked="checked"/>
<label>{{split(listView.material,2)}}</label>
</li>
</ul>
</div>  
</fieldset>
</div>  
<form:form modelAttribute="cartItems">
<p id="quantity_wanted_p">
<label for="quantity_wanted">Quantity</label>
<form:input hidden="true" type="text" id="qtyDetail" path="Quantity" value="1"/>
<input type="text" min="1" name="qty" id="quantity_wanted" class="text" value="1"/>
<button type="button" onclick="decrease()" class="btn btn-default button-minus product_quantity_down">
<span>
<i class="material-design-horizontal39"></i>
</span>
</button>
<button type="button" onclick="increase()" class="btn btn-default button-plus product_quantity_up">
<span>
<i class="material-design-add186"></i>
</span>
</button>
<span class="clearfix"></span>
</p>
</form:form>
<div class="box-btn-cosial clearfix">
<div id="add_to_cart_product_page_button">
<p id="add_to_cart" class="buttons_bottom_block no-print">
<input type="submit" value="Add to cart" name="Submit" class="btn btn-sm btn-default ajax_add_to_cart_product_button">
<a type="button" href="/Foot/buyNow-${sessionScope.productsId}?userId=1" class="btn btn-sm btn-default ajax_add_to_cart_product_button">Buy Now</a>
</p>
</div>
</div>
<p class="socialsharing_product no-print">
<button data-type="facebook" type="button" class="btn btn-facebook social-sharing">
<i class="fa fa-facebook"></i>
</button>
<button data-type="twitter" type="button" class="btn btn-twitter social-sharing">
<i class="fa fa-twitter"></i>
</button>
<button data-type="google-plus" type="button" class="btn btn-google-plus social-sharing">
<i class="fa fa-google-plus"></i>
</button>
<button data-type="pinterest" type="button" class="btn btn-pinterest social-sharing">
<i class="fa fa-pinterest"></i>
</button>
</p></div>
 
<p id="minimal_quantity_wanted_p" style="display: none;">
The minimum purchase order quantity for the product is
<b id="minimal_quantity_label">1</b>
</p>
</div>  
<div class="box-cart-bottom">
 </div>  
</div>  
</form:form>
<div class="extra-right"> 
</div>  
</div>
</div>  

<div>
<div class="clearfix product-information">
<ul class="product-info-tabs nav nav-stacked clearfix">
<li class="product-description-tab"><a data-toggle="tab" href="#product-description-tab-content">More info</a></li>
<li class="product-features-tab"><a data-toggle="tab" href="#product-features-tab-content">Data sheet</a></li>
<li class="last-tab clearfix"></li>
</ul>
<div class="tab-content">
<h3 class="page-product-heading">More info</h3>
<div id="product-description-tab-content" class="product-description-tab-content tab-pane">
<div class="rte"><h4>DYNAMICALLY FLEXIBLE. NATURALLY SUPERIOR.</h4>
<p>Keds and sneakers became an inevitable part of our life. Either you have a quick pace of your life or a slow relaxed rhythm, there is nothing better than stepping in your favorite sneakers and heading off to... to wherever. Regardless of where you are, your keds or sneakers will make your life comfortable. Always.</p>
<h5>Also available for kids</h5>
<p>Many of our customers visit our from the age of... several months. We are proud of having opened a kids shoes section which offers keds for kids and sneakers for the smallest visitors. For older children there is a huge selection of sneakers which they will love. We work with the best brands, and the best brands work for the best customers.</p></div>
</div>
 
 
<h3 class="page-product-heading">Data sheet</h3>
<div id="product-features-tab-content" class="product-features-tab-content tab-pane">
<table class="table-data-sheet">
<tr class="odd">
<td>Style</td>
<td style="text-transform: capitalize;">{{listView.style}}</td>
</tr>
<tr class="even">
<td>Support System</td>
<td style="text-transform: capitalize;">{{listView.supportSystem}}</td>
</tr>
<tr class="odd">
<td>Shipping</td>
<td style="text-transform: capitalize;">Free shipping</td>
</tr>
<tr class="even">
<td>Weight</td>
<td style="text-transform: capitalize;">{{listView.weight}}</td>
</tr>
<tr class="odd">
<td>Dimensions</td>
<td style="text-transform: capitalize;">{{listView.dimensions}}</td>
</tr>
<tr class="even">
<td>Warranty</td>
<td style="text-transform: capitalize;">{{listView.waranty}}</td>
</tr>
<tr class="odd">
<td>Detail &amp; Care</td>
<td style="text-transform: capitalize;">{{listView.detail}}</td>
</tr>
<tr class="even">
<td>Shoe Width</td>
<td>{{listView.shoeWidth}}</td>
</tr>
<tr class="odd">
<td>Season</td>
<td style="text-transform: capitalize;">{{listView.season}}</td>
</tr>
<tr class="even">
<td>Sole</td>
<td style="text-transform: capitalize;">{{listView.sole}}</td>
</tr>
</table>
</div>
</div>
 
<section class="page-product-box">
<h3 id="#idTab5" class="idTabHrefShort page-product-heading">Reviews</h3>
<div id="idTab5">
<div id="product_comments_block_tab">
<div class="comment row">
<div class="comment_author col-sm-3">
<span>Grade&nbsp;</span>
<div class="star_content clearfix">
<div class="star star_on"></div>
<div class="star star_on"></div>
<div class="star star_on"></div>
<div class="star star_on"></div>
<div class="star"></div>
</div>
<div class="comment_author_infos">
<strong>Manish F</strong>
<em>2017-01-08 12:59:57</em>
</div>
</div>  
<div class="comment_details col-sm-9">
<h6 class="title_block">Guys, you rock!</h6>
<p>I love your store! There is the largest selection of products of the exceptional quality and the lowest prices like in no other store. My family appreciated my purchase, I have no words to describe how pleased I am...Thanks a lot to your store, to your team and the delivery in time!!! Go on your great business, stay the best!</p>
<ul class="clearfix"  style="display:block;" id="disable">
<li>
<div class="useful-text">Was this comment useful to you?</div>
<div class="useful-buttons">
<button onclick="disable()" class="usefulness_btn btn btn-primary btn-xs btn-default">
<span>Yes</span>
</button>
<button onclick="disable()" class="usefulness_btn btn btn-default btn-xs btn-xs btn-default">
<span>No</span>
</button>
</div>
</li>
<li>
<span class="report_btn">
Report abuse
</span>
</li>
</ul>
</div> 
</div>  
</div>  
</div> 
</section>
</div>  
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<div class="wrapper it_ZGMGQDGNWEAS container home-preset1">
<div class="row it_OMEMJXWGTWWQ ">
<div class="it_BMLRHIIHSZDK col-lg-12 ">
<div class="module "></div>
<div class="module "></div>
</div>
</div>
</div>
</div>
<script>
var products = angular.module("products",[]);
products.controller("productsController",function($scope)
		{
	$scope.listView = ${listView};
	$scope.split = function(string,data)
	{
		var array = string.split(',');
		return array[data];
	}
		});
</script>
<script type="text/javascript">
function disable()
{
	if(document.getElementById("disable").style.display == "block")
	{
		document.getElementById("disable").style.display = "none";
	}
}
</script>
<script>
function decrease()
{
	if(document.getElementById("quantity_wanted").value != 1)
		{
		var data = parseInt(document.getElementById("quantity_wanted").value) - 1;
		document.getElementById("quantity_wanted").value = data;
		document.getElementById("qtyDetail").value = data;
		}
}
</script>
<script type="text/javascript">
function increase()
{
	var data = parseInt(document.getElementById("quantity_wanted").value) + 1;
	document.getElementById("quantity_wanted").value = data;
	document.getElementById("qtyDetail").value = data;
}
</script>
<%@include file="footer.jsp" %>