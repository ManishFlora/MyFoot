<%@include file="header.jsp" %>
<div class="columns-container">
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
<li class="last">Your shopping cart</li>
</ul>
</div>
<div ng-app="listproducts" ng-controller="listController">
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12 accordionBox">
<h1 id="cart_title" class="page-heading">Shopping-cart summary
<span class="heading-counter">Your shopping cart contains:
<span id="summary_products_quantity">{{wishList.length}} product</span>
</span>
</h1>
<p ng-if="{{wishList.length}} == 0" id="emptyCartWarning" class="alert alert-warning">Your shopping cart is empty.</p>
<div id="order-detail-content" class="table_block table-responsive">
<table id="cart_summary" class="table table-bordered stock-management-on">
<thead>
<tr>
<th class="cart_product first_item">Product</th>
<th class="cart_description item">Description</th>
<th class="cart_avail item">Avail.</th>
<th class="cart_unit item">Unit price</th>
<th class="cart_total item">Total</th>
<th class="cart_delete last_item">&nbsp;</th>
<th class="cart_delete last_item">&nbsp;</th>
</tr>
</thead>
<tbody ng-repeat = "wishList in wishList">
<tr id="product_11_768_0_0" class="cart_item last_item first_item address_0 odd">
<td class="cart_product">
<img height="100" width="auto" class="img-responsive" src="resources/images/products/{{wishList.productsId}}(1).jpg"/>
</td>
<td class="cart_description" data-title="Description">
<p class="product-name">
<a>{{wishList.productsName}}</a>
</p>
<small>
<a>{{wishList.orderDetail}}</a>
</small>
</td>
<td class="cart_avail">
<span class="label label-success">
In Stock
</span>
</td>
<td class="cart_unit" data-title="Unit price">
<span class="price" id="product_price_11_768_0">
<span class="price special-price">{{wishList.productsPrice - wishList.discountedPrice}}</span>
<span class="price-percent-reduction small">
&nbsp;-{{wishList.productsDiscount}}%&nbsp;
</span>
<span class="old-price">&#x20b9;{{wishList.productsPrice}}</span>
</span>
</td>
<td class="cart_total" data-title="Total">
<span class="price" id="total_product_price_11_768_0">
&#x20b9;{{wishList.productsPrice - wishList.discountedPrice}}
</span>
</td>
<td class="cart_delete text-center" data-title="Delete">
<div>
<a rel="nofollow" title="Delete" class="cart_quantity_delete" id="11_768_0_0" href="/Foot/deleteWishList-{{wishList.cartId}}"><i class="fa fa-trash-o"></i></a>
</div>
</td>
<td class="cart_delete text-center" data-title="Delete">
<div>
<a rel="nofollow" title="Add to Cart" class="cart_quantity_delete" id="11_768_0_0" href="/Foot/addToCart-{{wishList.productsId}}">
<i class="fa fa-plus"></i></a>
</div>
</td>
</tr>
</tbody>
<tfoot>
<tr class="cart_total_price">
<td rowspan="4" colspan="3" id="cart_voucher" class="cart_voucher">
</td>
<td colspan="3" class="text-right">Total products</td>
<td colspan="2" class="price" id="total_product">{{wishList.length}}</td>
</tr>
<tr style="display: none;">
<td colspan="3" class="text-right">
Total gift-wrapping cost                      </td>
<td colspan="2" class="price-discount price" id="total_wrapping">
&#x20b9;0.00
</td>
</tr>
<tr class="cart_total_delivery unvisible">
<td colspan="3" class="text-right">Total shipping</td>
<td colspan="2" class="price" id="total_shipping">Free shipping!</td>
</tr>
<tr class="cart_total_voucher unvisible">
<td colspan="3" class="text-right">
Total vouchers
</td>
<td colspan="2" class="price-discount price" id="total_discount">
&#x20b9;0.00
</td>
</tr>
<tr class="cart_total_price">
<td colspan="3" class="total_price_container text-right">
<span>Total</span>
<div class="hookDisplayProductPriceBlock-price">
</div>
</td>
<td colspan="2" class="price" id="total_price_container">
<span id="total_price">&#x20b9;{{getTotal()}}</span>
</td>
</tr>
</tfoot>
</table>
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
<div class="it_BMLRHIIHSZDK    col-lg-12 ">
<div class="module "></div>
<div class="module "></div></div></div></div>

<script>
angular.module("listproducts",[]).controller("listController",function($scope)
		{
	$scope.wishList = ${wishList};
	$scope.getTotal = function(){
	    var total = 0;
	    for(var i = 0; i < $scope.wishList.length; i++){
	        var product = $scope.wishList[i];
	        total += (product.productsPrice - product.discountedPrice);
	    }
	    return total;
	}
		});
</script>
<%@include file="footer.jsp" %>