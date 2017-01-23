<%@include file="header.jsp" %>
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12">
<h1 class="page-heading bottom-indent">Registration Form</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<form:form modelAttribute="userDetail" action="addUser">
<fieldset style="padding:0 19px 21px 19px; background:url('resources/images/form-contact-shadow.png') repeat-x white;">
<h3 class="page-subheading">User Details</h3>
<div id="userDetailForm">
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="id">ID</label>
<form:input path="userId" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>User Name</label>
<form:input path="userName" class="form-control" type="text" value=""/>
<form:errors cssStyle="color: red;" path="userName"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Password</label>
<form:input type="password" path="userPassword" class="form-control"/>
<form:errors cssStyle="color: red;" path="userPassword"/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>First Name</label>
<form:input path="firstName" class="form-control" id="message" name="message"/>
<form:errors cssStyle="color: red;" path="firstName"/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Last Name</label>
<form:input path="lastName" class="form-control" id="message" name="message"/>
<form:errors cssStyle="color: red;" path="lastName"/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Email Id</label>
<form:input path="emailId" class="form-control" id="message" name="message"/>
<form:errors cssStyle="color: red;" path="emailId"/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Contact Number</label>
<form:input path="contactNumber" class="form-control" id="message" name="message"/>
<form:errors cssStyle="color: red;" path="contactNumber"/>
</div>
</div>
</div>
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Register
</span>
</button>
</div>
</div>
</fieldset>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<div id="billingAddressForm">
<fieldset style="padding:0 19px 21px 19px; background:url('resources/images/form-contact-shadow.png') repeat-x white;">
<h3 class="page-subheading">Billing Address</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="id">ID</label>
<form:input path="billingAddress.billingAddressId" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Flat Number</label>
<form:input path="billingAddress.flatNumber" class="form-control" type="text" value=""/>
<form:errors path="billingAddress.flatNumber"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Street Address</label>
<form:input path="billingAddress.streetAddress" class="form-control" type="text" value=""/>
<form:errors path="billingAddress.streetAddress"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Country</label>
<form:input path="billingAddress.country" class="form-control" type="text" value=""/>
<form:errors path="billingAddress.country"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>State</label>
<form:input path="billingAddress.state" class="form-control" type="text" value=""/>
<form:errors path="billingAddress.state"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>City</label>
<form:input path="billingAddress.city" class="form-control" type="text" value=""/>
<form:errors path="billingAddress.city"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Pin Code</label>
<form:input path="billingAddress.zipCode" class="form-control" type="text" value=""/>
<form:errors path="billingAddress.zipCode"/>
</p>
</div>
</div>
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Add Detail
</span>
</button>
</div>
</fieldset>
</div>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<div id="shippingAddressForm">
<fieldset style="padding:0 19px 21px 19px; background:url('resources/images/form-contact-shadow.png') repeat-x white;">
<h3 id="headerToggle" class="page-subheading">Shipping Address</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="id">ID</label>
<form:input path="shippingAddress.shippingAddressId" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Flat Number</label>
<form:input path="shippingAddress.flatNumber" class="form-control" type="text" value=""/>
<form:errors path="shippingAddress.flatNumber"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Street Address</label>
<form:input path="shippingAddress.streetAddress" class="form-control" type="text" value=""/>
<form:errors path="shippingAddress.streetAddress"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Country</label>
<form:input path="shippingAddress.country" class="form-control" type="text" value=""/>
<form:errors path="shippingAddress.country"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>State</label>
<form:input path="shippingAddress.state" class="form-control" type="text" value=""/>
<form:errors path="shippingAddress.state"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>City</label>
<form:input path="shippingAddress.city" class="form-control" type="text" value=""/>
<form:errors path="shippingAddress.city"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Pin Code</label>
<form:input path="shippingAddress.zipCode" class="form-control" type="text" value=""/>
<form:errors path="shippingAddress.zipCode"/>
</p>
</div>
</div>
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Add Detail
</span>
</button>
</div>
</fieldset>
</div>
</div>
</form:form>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<%@include file="footer.jsp" %>