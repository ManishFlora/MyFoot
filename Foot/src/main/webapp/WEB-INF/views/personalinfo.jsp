<%@include file="header.jsp" %>
<div ng-app="user" ng-controller="userController">
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
<li class="last">{{userList.firstName}}	{{userList.lastName}}</li>
</ul>
</div>
 
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<h1 class="page-heading">{{userList.firstName}}	{{userList.lastName}}</h1>
<div class="row">
<div class="col-xs-12 col-sm-4 col-md-4">
<form method="post" id="login_form" class="box">
<h3 class="page-subheading">Profile</h3>
<div class="clearfix">
<div class="form-group">
<label for="email">First Name</label>
<input class="form-control" type="text" id="email" name="email" value="{{userList.firstName}}">
</div>
<div class="form-group">
<label for="email">Last Name</label>
<input class="form-control" type="text" id="email" name="email" value="{{userList.lastName}}">
</div>
<div class="form-group">
<label for="email">Email Id</label>
<input class="form-control" type="text" id="email" name="email" value="{{userList.emailId}}">
</div>
<div class="form-group">
<label for="email">Contact Number</label>
<input class="form-control" type="text" id="email" name="email" value="{{userList.contactNumber}}">
</div>
</div>
</form>
</div>
<div ng-controller="billingAddressController">
<div class="col-xs-12 col-sm-4 col-md-4">
<form method="post" id="login_form" class="box">
<h3 class="page-subheading">Billing Address</h3>
<div class="clearfix">
<div class="form-group">
<label for="email">Flat Number</label>
<input class="form-control" type="text" id="email" name="email" value="{{billingAddressList.flatNumber}}">
</div>
<div class="form-group">
<label for="email">Street Address</label>
<input class="form-control" type="text" id="email" name="email" value="{{billingAddressList.streetAddress}}">
</div>
<div class="form-group">
<label for="email">City</label>
<input class="form-control" type="text" id="email" name="email" value="{{billingAddressList.city}}">
</div>
<div class="form-group">
<label for="email">State</label>
<input class="form-control" type="text" id="email" name="email" value="{{billingAddressList.state}}">
</div>
<div class="form-group">
<label for="email">Country</label>
<input class="form-control" type="text" id="email" name="email" value="{{billingAddressList.country}}">
</div>
<div class="form-group">
<label for="email">Zip Code</label>
<input class="form-control" type="text" id="email" name="email" value="{{billingAddressList.zipCode}}">
</div>
</div>
</form>
</div>
</div>
<div ng-controller="shippingAddressController">
<div class="col-xs-12 col-sm-4 col-md-4">
<form method="post" id="login_form" class="box">
<h3 class="page-subheading">Shipping Address</h3>
<div class="clearfix">
<div class="form-group">
<label for="email">Flat Number</label>
<input class="form-control" type="text" id="email" name="email" value="{{shippingAddressList.flatNumber}}">
</div>
<div class="form-group">
<label for="email">Street Address</label>
<input class="form-control" type="text" id="email" name="email" value="{{shippingAddressList.streetAddress}}">
</div>
<div class="form-group">
<label for="email">City</label>
<input class="form-control" type="text" id="email" name="email" value="{{shippingAddressList.city}}">
</div>
<div class="form-group">
<label for="email">State</label>
<input class="form-control" type="text" id="email" name="email" value="{{shippingAddressList.state}}">
</div>
<div class="form-group">
<label for="email">Country</label>
<input class="form-control" type="text" id="email" name="email" value="{{shippingAddressList.country}}">
</div>
<div class="form-group">
<label for="email">Zip Code</label>
<input class="form-control" type="text" id="email" name="email" value="{{shippingAddressList.zipCode}}">
</div>
</div>
</form>
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
</div>
<script type="text/javascript">
angular.module('user',[]).controller('userController',function($scope)
{
$scope.userList=${userList};
})
.controller('billingAddressController',function($scope)
{
$scope.billingAddressList=${billingAddressList};
})
.controller('shippingAddressController',function($scope)
{
$scope.shippingAddressList=${shippingAddressList};
});
</script>
<%@include file="footer.jsp" %>