<%@include file="header.jsp" %>
<div ng-app="supplier" ng-controller="supplierController">
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12">
<h1 class="page-heading bottom-indent">
Supplier Form</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<form:form id="registrationForm" modelAttribute="supplier">
<fieldset style="padding:0 19px 21px 19px;background:url('resources/images/form-contact-shadow.png')">
<h3 class="page-subheading">Add New Supplier</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label for="message">Address</label>
<form:input path="supplierAddress" class="form-control" id="message" name="message"/>
<form:errors path="supplierAddress" cssStyle="color: red;"/>
</div>
</div>
</div>
<div class="submit">
<button type="submit" class="btn btn-default btn-sm" name="_eventId_submit">
<span>
Add Address
</span>
</button>
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