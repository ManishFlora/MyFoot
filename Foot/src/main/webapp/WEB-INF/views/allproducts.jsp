<%@include file="header.jsp" %>
<div class="columns-container" ng-app="listproducts" ng-controller="listController" id="category" >   
<div class="wrapper it_MSYCVDAWVRSQ topcolumn-preset1">
<div class="row it_BPFSWOXAMUFW ">
<div class="it_XMGGKMZYAINS    col-lg-12 ">
<div class="module "></div>
<div class="module "></div></div></div></div>
<div class="breadcrumb clearfix">
<ul class="container">
<li class="home">
<a class="home" href="/Foot/" title="Return to Home">
Home
</a>
</li>
<li class="last">ProductsPage</li>
</ul>
</div>
<div id="columns" class="container">  
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-9 accordionBox">
<h1 class="page-heading  product-listing">
Search&nbsp;
<span class="lighter">
" {{searchkeyword}} "
</span>
<span class="heading-counter">
{{nextFilter().count}} results have been found.    </span>
</h1>
<div class="content_sortPagiBar">
<div class="sortPagiBar clearfix ">
<form id="productsSortForm" action="#" class="productsSortForm">
<div class="select selector1">
<label for="selectProductSort">Sort by</label>
<div class="selector" id="uniform-selectProductSort" style="width: 159px;">
<select id="selectProductSort" class="selectProductSort form-control">
<option value="position:asc" selected="selected">Select</option>
<option value="price:asc">Price: Lowest first</option>
<option value="price:desc">Price: Highest first</option>
<option value="name:asc">Product Name: A to Z</option>
<option value="name:desc">Product Name: Z to A</option>
<option value="quantity:desc">In stock</option>
<option value="reference:asc">Reference: Lowest first</option>
<option value="reference:desc">Reference: Highest first</option>
</select>
<div class="block-filter_btn">
<div class="filter_btn">
<span>filter</span>
</div>
</div>
</div>
</div>
</form>
</div>
</div>
<ul class="product_list row list" ng-model="searchkeyword">
<li class="ajax_block_product col-xs-12" style="opacity: 1;" ng-repeat="listProducts in listProducts | filter:searchkeyword ">
<div class="product-container">
<div class="row">
<div class="left-block col-xs-6">
<div class="product-image-container">
<a class="product_img_link" href="/Foot/viewproduct-{{listProducts.productsId}}" title="Reebok Aspire Green" itemprop="url">
<img class="replace-2x img-responsive" src="resources/images/products/{{listProducts.productsId}}(1).jpg" alt="Reebok Aspire Green" title="Reebok Aspire Green" itemprop="image">
<img class="img-responsive hover-image" src="resources/images/products/{{listProducts.productsId}}(2).jpg" alt="Reebok Aspire Green" title="Reebok Aspire Green">
</a>
<div class="labels">
<a class="sale-box" href="#">
<span class="sale-label">Sale!</span>
</a>
<a class="price-percent" href="#">
<span class="price-percent-reduction">-{{listProducts.productsDiscount}}%</span>
</a>
</div>
<a class="quick-view" href="#" title="Quick view">
<span>Quick view</span>
</a>
</div>
<div class="functional-buttons clearfix">
<div class="wishlist">
<a class="addToWishlist wishlistProd_9" href="/Foot/wishList-{{listProducts.productsId}}?userId=1"></a>
</div>
</div>
<a itemprop="url" class="lnk_view btn btn-sm btn-default" href="/Foot/viewproduct-{{listProducts.productsId}}" title="View">
<span>More</span>
</a>
</div>
<div class="center-block col-xs-6 ">
<div class="product-flags">
<div class="comments_note" itemprop="aggregateRating" itemscope="" itemtype="#">
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
<span class="nb-comments">
</div>
</div><h5 itemprop="name">
<a class="product-name" href="#" title="Reebok Aspire Green" itemprop="url">
<span class="list-name">{{listProducts.productsName}}</span>
<span class="grid-name">{{listProducts.productsName}}</span>
</a>
<span class="product-manufacture">{{listProducts.brandName}}</span>
</h5><p class="product-desc">
<span class="list-desc">{{listProducts.productsDescription}}</span>
</p><div class="right-block "><div class="right-block-content">
<div class="content_price">
<span class="price product-price product-price-new">&#x20b9;{{listProducts.productsPrice - listProducts.discountedPrice}}</span>
<span class="old-price product-price">&#x20b9;{{listProducts.productsPrice}}</span>
</div>
<div class="color-list-container"></div>
<div ng-if="listProducts.productsQuantity ==0">
<span class="availability">
<span class="label-danger">Out of stock</span>
</span>
</div>
<div ng-if="listProducts.productsQuantity !=0">
<span class="availability">
<span class="label-success">In stock</span>
</span>
</div>
<div class="button-container clearfix">
<a class="btn btn-sm btn-default" href="/Foot/addToCart-{{listProducts.productsId}}?userId=1">
<span>Add to cart</span>
</a>
<a class="btn btn-sm btn-default" href="/Foot/buyNow-{{listProducts.productsId}}?userId=1" title="Buy Now">
<span>Buy Now</span>
</a>
<div>
<a itemprop="url" class="lnk_view btn btn-sm btn-default" href="#" title="View">
<span>More</span>
</a>
</div>
<div>
<div class="functional-buttons clearfix">
<div class="wishlist">
<a class="addToWishlist wishlistProd_9" href="#" data-id-product="9" title="Add to Wishlist" onclick="WishlistCart('wishlist_block_list', 'add', '9', false, 1); return false;"></a>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</li>
</ul>
</div>
<div id="left_column" class="column col-xs-12 col-sm-3"> <div class="vicevle_box"></div>
<section id="layered_block_left" class="block">
<h4 class="title_block">Catalog</h4>
<div class="block_content">
<form action="#" id="layered_form">
<div>
<div class="layered_filter">
<div class="layered_subtitle_heading">
<span class="layered_subtitle">Categories</span>
</div>
<ul id="ul_layered_category_0" class="col-lg-12 layered_filter_ul">
<li class="nomargin hiddable col-lg-12">
<input type="checkbox" class="checkbox" name="layered_category_41" id="layered_category_41" value="41">
<label for="layered_category_41">
<a href="index9378.html?id_category=20&amp;controller=category&amp;id_lang=1#categories-neutral_cushioning" data-rel="nofollow">
<strong>Neutral Cushioning</strong>
</a>
</label>
</li>
</ul>
</div>
<div class="layered_filter">
<div class="layered_subtitle_heading">
<span class="layered_subtitle">Availability</span>
</div>
<ul id="ul_layered_quantity_0" class="col-lg-12 layered_filter_ul">
<li class="nomargin hiddable col-lg-12">
<input type="checkbox" class="checkbox" name="layered_quantity_0" id="layered_quantity_0" value="0">
<label for="layered_quantity_0">
<a href="index9378.html?id_category=20&amp;controller=category&amp;id_lang=1#availability-not_available" data-rel="nofollow">
<strong>Not available</strong>
</a>
</label>
</li>
<li class="nomargin hiddable col-lg-12">
<input type="checkbox" class="checkbox" name="layered_quantity_1" id="layered_quantity_1" value="1">
<label for="layered_quantity_1">
<a href="index9378.html?id_category=20&amp;controller=category&amp;id_lang=1#availability-in_stock" data-rel="nofollow">
<strong>In stock</strong>
</a>
</label>
</li>
</ul>
</div>
<div class="layered_filter">
<div class="layered_subtitle_heading">
<span class="layered_subtitle">Condition</span>
</div>
<ul id="ul_layered_condition_0" class="col-lg-12 layered_filter_ul">
<li class="nomargin hiddable col-lg-12">
<input type="checkbox" class="checkbox" name="layered_condition_new" id="layered_condition_new" value="new">
<label for="layered_condition_new">
<a href="index9378.html?id_category=20&amp;controller=category&amp;id_lang=1#condition-new" data-rel="nofollow">
<strong>New</strong>
</a>
</label>
</li>
</ul>
</div>
<div class="layered_filter">
<div class="layered_subtitle_heading">
<span class="layered_subtitle">Manufacturer</span>
</div>
<ul id="ul_layered_manufacturer_0" class="col-lg-12 layered_filter_ul">
<li class="nomargin hiddable col-lg-12">
<input type="checkbox" class="checkbox" name="layered_manufacturer_4" id="layered_manufacturer_4" value="4">
<label for="layered_manufacturer_4">
<a href="index9378.html?id_category=20&amp;controller=category&amp;id_lang=1#manufacturer-adidas" data-rel="nofollow">
<strong>Adidas</strong>
</a>
</label>
</li>
</ul>
</div>
</div>
<input type="hidden" name="id_category_layered" value="20">
</form>
</div>
<div id="layered_ajax_loader" style="display: none;">
<p class="filter-loader">
</p>
</div>
</section>
</div>
</div>
</div>
</div>
</div>
</div>

<div class="wrapper it_ZGMGQDGNWEAS container home-preset1">
<div class="row it_OMEMJXWGTWWQ ">
<div class="it_BMLRHIIHSZDK    col-lg-12 ">
<div class="module "></div>
<div class="module "></div></div></div></div>

<script type="text/javascript">
angular.module("listproducts",[]).controller("listController",function($scope,$http,$location)
		{
	$scope.searchkeyword = location.search.substr(8);
	$scope.letterlimit = 3;
	$scope.listProducts = ${listProducts};
	$scope.subCategoryList = ${subCategoryList};
	$scope.sort = function(keyname) 
	{
		$scope.sortkey=keyname;
		$scope.reverse=!$scope.reverse;
	}
	$scope.myFilter = [];
	$scope.myNewFilter = function(searchword) 
	{
        var i = $.inArray(searchword, $scope.myFilter);
        if (i > -1) 
        {
            $scope.myFilter.splice(i, 1);
        }
        else 
        {
            $scope.myFilter.push(searchword);
        }
    }
	$scope.nextFilter = function(listProducts) 
	{
        if ($scope.myFilter.length > 0) 
        {
            if ($.inArray(listProducts.subCategoryName, $scope.myFilter) < 0)
                return;
            return listProducts;
	    }
        }
		});
</script>

<%@include file="footer.jsp" %>