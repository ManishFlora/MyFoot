<%@include file="header.jsp" %>
<div ng-app="products" ng-controller="productsController">
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12">
<h1 class="page-heading bottom-indent">
Specification Form</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<form:form enctype="multipart/form-data" modelAttribute="productsInfo"  action="addSpecification">
<fieldset style="padding:0 19px 21px 19px;background-image:url('resources/images/form-contact-shadow.png');">
<h3 class="page-subheading">Add Product Specification</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>ID</label>
<form:input path="productsId" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Color</label>
<form:input path="color" class="form-control" type="text" value=""/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Size</label>
<form:input path="size" class="form-control" type="text" value=""/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Material</label>
<form:input path="material" class="form-control" type="text" value=""/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Style</label>
<form:input path="style" class="form-control" type="text" value=""/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Support-System</label>
<form:input path="supportSystem" class="form-control" type="text" value=""/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Weight</label>
<form:input path="weight" class="form-control" type="text" value=""/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Dimensions</label>
<form:input path="dimensions" class="form-control" type="text" value=""/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Waranty</label>
<form:input path="waranty" class="form-control" type="text" value=""/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Detail</label>
<form:input path="detail" class="form-control" type="text" value=""/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Shoe Width</label>
<form:input path="shoeWidth" class="form-control" type="text" value=""/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Season</label>
<form:input path="season" class="form-control" type="text" value=""/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Sole</label>
<form:input path="sole" class="form-control" type="text" value=""/>
</div>
</div>
<div class="uploader" id="uniform-fileUpload">
<input name="fileUpload" type="file" multiple="multiple" class="form-control"/>
</div>
</div>
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Add Info
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
<%@include file="footer.jsp"%>