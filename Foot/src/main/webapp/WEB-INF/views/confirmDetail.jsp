<%@include file="header.jsp"%>
<div class="columns-container">
<div class="wrapper it_MSYCVDAWVRSQ topcolumn-preset1">
<div class="row it_BPFSWOXAMUFW ">
<div class="it_XMGGKMZYAINS    col-lg-12 ">
<div class="module "></div>
<div class="module "></div>
</div>
</div>
</div>
<div class="breadcrumb clearfix">
<ul class="container">
<li class="home">
<a class="home" href="/Foot/" title="Return to Home"> Home </a>
</li>
<li class="crumb-1">
<a href="#" title="Summary" rel="nofollow">Summary</a>
</li>
<li class="last">Addresses</li>
</ul>
</div>
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12 accordionBox">
<h1 class="page-heading">Addresses</h1>
<form action="#" method="post">
<div class="addresses clearfix">
<div class="row">
<div class="col-xs-12 col-sm-6">
<form:form modelAttribute="shippingAddress">
<ul class="address item box" id="address_delivery">
<li class="address_title"><h3 class="page-subheading">Your delivery address</h3></li>
<li class="address_firstname address_lastname">${sessionScope.firstName} ${sessionScope.lastName}</li>
<li class="address_company">${shippingAddress.flatNumber}</li>
<li class="address_address1 address_address2">${shippingAddress.streetAddress}</li>
<li class="address_city address_state_name address_postcode">${shippingAddress.city}</li>
<li class="address_country_name">${shippingAddress.state}</li>
<li class="address_phone">${shippingAddress.country}</li>
<li class="address_phone_mobile">${shippingAddress.zipCode}</li>
<li class="address_update">
<button type="submit" class="btn btn-success btn-sm" name="_eventId_edit">
<span>Update<i class="fa fa-refresh right"></i></span>
</button>
<button type="submit" class="btn btn-success btn-sm" name="_eventId_submit">
<span>Continue<i class="fa fa-arrow-right right"></i></span>
</button>
</li>
</ul>
</form:form>
</div>
</div>
<div id="ordermsg" class="form-group">
<label>If you would like to add a comment about your order, please write it in the field below.</label>
<textarea class="form-control" cols="60" rows="6" name="message"></textarea>
</div>
</div>
<p class="cart_navigation clearfix">
<input type="hidden" class="hidden" name="step" value="2">
<input type="hidden" name="back" value="">
<a href="#" title="Previous" class="btn btn-default btn-md icon-left"><span>Cancel</span>
</a>
<button type="submit" name="processAddress" class="btn btn-default btn-md icon-right">
<span>Proceed to checkout</span>
</button>
</p>
</form>
</div>
</div>
</div>
</div>
</div>
<div class="wrapper it_ZGMGQDGNWEAS container home-preset1">
<div class="row it_OMEMJXWGTWWQ ">
<div class="it_BMLRHIIHSZDK    col-lg-12 ">
<div class="module "></div>
<div class="module "></div>
</div>
</div>
</div>
</div>
<%@include file="footer.jsp"%>