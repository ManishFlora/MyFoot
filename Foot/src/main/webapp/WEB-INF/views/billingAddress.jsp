<%@include file="header.jsp" %>
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12">
<h1 class="page-heading bottom-indent">Registration Form</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<form:form modelAttribute="billingAddress">
<div id="billingAddressForm">
<fieldset style="padding:0 19px 21px 19px; background:url('resources/images/form-contact-shadow.png') repeat-x white;">
<h3 class="page-subheading">Billing Address</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="id">ID</label>
<form:input path="billingAddressId" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Flat Number</label>
<form:input path="flatNumber" class="form-control" type="text" value=""/>
<form:errors path="flatNumber"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Street Address</label>
<form:input path="streetAddress" class="form-control" type="text" value=""/>
<form:errors path="streetAddress"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Country</label>
<form:input path="country" class="form-control" type="text" value=""/>
<form:errors path="country"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>State</label>
<form:input path="state" class="form-control" type="text" value=""/>
<form:errors path="state"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>City</label>
<form:input path="city" class="form-control" type="text" value=""/>
<form:errors path="city"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Pin Code</label>
<form:input path="zipCode" class="form-control" type="text" value=""/>
<form:errors path="zipCode"/>
</p>
</div>
</div>
<div class="submit">
<button type="submit" name="_eventId_submit" class="btn btn-default btn-sm">
<span>
Add Detail
</span>
</button>
</div>
</fieldset>
</div>
</form:form>
</div>
</div>
</div>
</div>
</div>
</div>
<%@include file="footer.jsp" %>