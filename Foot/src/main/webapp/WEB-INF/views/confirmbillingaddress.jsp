<%@include file="header.jsp" %>
<div class="breadcrumb clearfix">
<ul class="container">
<li class="home">
<a class="home" href="/Foot/" title="Return to Home">
Home
</a>
</li>
<li class="last">Registration</li>
</ul>
</div>
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12">
<h1 class="page-heading bottom-indent">Registration Form</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<form:form modelAttribute="billingAddress">
<fieldset style="padding:0 19px 21px 19px; background:url('resources/images/form-contact-shadow.png') repeat-x white;">
<h3 class="page-subheading">Confirm Details</h3>
<div class="clearfix">
<div class="col-md-4">
<b>Flat Number:</b></div><div class="col-md-8">${billingAddress.flatNumber}</div>
<br /><br />
<div class="col-md-4">
<b>Street Address:</b></div><div class="col-md-8">${billingAddress.streetAddress}</div>
<br /><br />
<div class="col-md-4">
<b>City :</b></div><div class="col-md-8">${billingAddress.city}</div>
<br /><br />
<div class="col-md-4">
<b>State :</b></div><div class="col-md-8">${billingAddress.state}</div>
<br /><br />
<div class="col-md-4">
<b>Country :</b></div><div class="col-md-8">${billingAddress.country}</div>
<br /><br />
<div class="col-md-4">
<b>Pin-Code :</b></div><div class="col-md-8">${billingAddress.zipCode}</div>
<br /><br />

</div>
<div class="clearfix">
<div class="submit">
<button type="submit" class="btn btn-default btn-sm" name="_eventId_submit">
<span>
Confirm
</span>
</button>
<button type="submit" class="btn btn-default btn-sm" name="_eventId_edit">
<span>
Edit
</span>
</button>
<button type="submit" class="btn btn-default btn-sm" name="_eventId_cancel">
<span>
Cancel
</span>
</button>
</div>
</div>
</fieldset>
</form:form>
</div>
</div>
</div>
</div>
</div>
</div>
<%@include file="footer.jsp" %>