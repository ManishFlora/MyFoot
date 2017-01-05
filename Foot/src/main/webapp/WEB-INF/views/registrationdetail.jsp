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
<h3 class="page-subheading">User Details</h3>
<div id="userDetailForm">
<div class="clearfix">
<div style="display:none;" class="col-xs-12 col-md-3">
<p class="form-group">
<form:input path="userId" readonly="true" class="form-control" type="hidden" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>User Name</label>
<form:input path="userName" class="form-control" type="text" value=""/>
<form:errors cssClass="error" cssStyle="color: red;" path="userName"/>
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
<button type="submit" class="btn btn-default btn-sm" name="_eventId_submit">
<span>
Register
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