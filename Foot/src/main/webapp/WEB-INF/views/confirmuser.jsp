<%@include file="header.jsp" %>
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12">
<h1 class="page-heading bottom-indent">Registration Form</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<form:form modelAttribute="userDetail">
<fieldset style="padding:0 19px 21px 19px; background:url('resources/images/form-contact-shadow.png') repeat-x white;">
<h3 class="page-subheading">Confirm Details</h3>
<div class="clearfix">
<div class="col-md-4">
<b>Name:</b></div><div class="col-md-8">${userDetail.userName}</div>
<br /><br />
<div class="col-md-4">
<b>Email Id:</b></div><div class="col-md-8">${userDetail.emailId}</div>
<br /><br />
<div class="col-md-4">
<b>First Name :</b></div><div class="col-md-8">${userDetail.firstName}</div>
<br /><br />
<div class="col-md-4">
<b>Last Name :</b></div><div class="col-md-8">${userDetail.lastName}</div>
<br /><br />
<div class="col-md-4">
<b>Contact No :</b></div><div class="col-md-8">${userDetail.contactNumber}</div>
<br /><br />
</div>
<div class="clearfix">
<div class="submit">
<button type="submit" class="btn btn-default btn-sm" name="_eventId_confirm">
<span>
Confirm User
</span>
</button>
<button type="submit" class="btn btn-default btn-sm" name="_eventId_submit">
<span>
Confirm Supplier
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