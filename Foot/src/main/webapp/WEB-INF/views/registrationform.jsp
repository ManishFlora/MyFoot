<%@include file="header.jsp" %>
<div>
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12">
<h1 class="page-heading bottom-indent">Registration Form</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<form:form modelAttribute="userDetail" action="addUser">
<fieldset style="padding:0 19px 21px 19px;background:url(resources/images/form-contact-shadow.png">
<h3 class="page-subheading">User Details</h3>
<div id="userDetailForm">
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="id">ID</label>
<form:input path="user_Id" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>User Name</label>
<form:input path="user_Name" class="form-control" type="text" value=""/>
<form:errors path="user_Name"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Password</label>
<form:input type="password" path="user_Password" class="form-control"/>
<form:errors path="user_Password"/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>First Name</label>
<form:input path="first_Name" class="form-control" id="message" name="message"/>
<form:errors path="first_Name"/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Last Name</label>
<form:input path="last_Name" class="form-control" id="message" name="message"/>
<form:errors path="last_Name"/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Email Id</label>
<form:input path="email_Id" class="form-control" id="message" name="message"/>
<form:errors path="email_Id"/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Contact Number</label>
<form:input path="contact_Number" class="form-control" id="message" name="message"/>
<form:errors path="contact_Number"/>
</div>
</div>
</div>
</div>
<div id="billingAddressForm">
<h3 class="page-subheading">Billing Address</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="id">ID</label>
<form:input path="billingAddress.billingAddress_Id" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Flat Number</label>
<form:input path="billingAddress.flat_Number" class="form-control" type="text" value=""/>
<form:errors path="billingAddress.flat_Number"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Street Address</label>
<form:input path="billingAddress.street_Address" class="form-control" type="text" value=""/>
<form:errors path="billingAddress.street_Address"/>
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
<form:input path="billingAddress.zip_Code" class="form-control" type="text" value=""/>
<form:errors path="billingAddress.zip_Code"/>
</p>
</div>
</div>
</div>
<div id="shippingAddressForm">
<h3 id="headerToggle" class="page-subheading">Shipping Address</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="id">ID</label>
<form:input path="shippingAddress.shippingAddress_Id" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Flat Number</label>
<form:input path="shippingAddress.flat_Number" class="form-control" type="text" value=""/>
<form:errors path="shippingAddress.flat_Number"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Street Address</label>
<form:input path="shippingAddress.street_Address" class="form-control" type="text" value=""/>
<form:errors path="shippingAddress.street_Address"/>
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
<form:input path="shippingAddress.zip_Code" class="form-control" type="text" value=""/>
<form:errors path="shippingAddress.zip_Code"/>
</p>
</div>
</div>
</div>
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Register
</span>
</button>
<input type="button" value="Add BillingAddress" class="btn btn-default btn-sm"/>
<input type="button" value="Add ShippingAddress" class="btn btn-default btn-sm"/>
</div>
</fieldset>
</form:form>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<%@include file="footer.jsp" %>