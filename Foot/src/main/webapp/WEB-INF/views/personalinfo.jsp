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
<div class="large-left col-sm-12">
<div class="row">
<div class="col-xs-12 col-md-6">
<ul>
<li style="height:150; width:auto;">
<img id="userImage" height="50" width="auto" class="img-responsive img-circle animated fadeInUp" src="resources/images/user/${pageContext.request.userPrincipal.name}.jpg">
</li>
</ul>
</div>
<h1 class="page-heading">{{userList.firstName}}	{{userList.lastName}}</h1>
<div class="row">
<div class="col-xs-12 col-md-3">
<form method="post" id="login_form">
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
<div class="col-xs-12 col-md-3">
<form method="post" id="login_form">
<h3 class="page-subheading">Delivery Address</h3>
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
</div> 
</div> 
</div> 
</div>
</div>

<div id="columns" class="container">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12">
<h1 class="page-heading bottom-indent">Upload Photo</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<div class="clearfix">
<form:form enctype="multipart/form-data" modelAttribute="userDetail" action="addImage">
<fieldset style="padding:0 19px 21px 19px;background:url(resources/images/form-contact-shadow.png">
<div class="uploader" id="uniform-fileUpload">
<label>Photos</label>
<form:input type="file" path="userImage"/>
</div>
<button type="submit" class="btn btn-link">
<span>
Add Photo
</span>
</button>
</fieldset>
</form:form>
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
$scope.billingAddressList=${billingAddressList};
});
</script>
<%@include file="footer.jsp" %>