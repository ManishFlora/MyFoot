<%@include file="header.jsp" %>
<div class="breadcrumb clearfix">
<ul class="container">
<li class="home">
<a class="home" href="/Foot/" title="Return to Home">
Home
</a>
</li>
<li class="last">Products Page</li>
</ul>
</div>
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12">
<h1 class="page-heading bottom-indent">
Products Form</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<form:form enctype="multipart/form-data" modelAttribute="products"  action="addproductsSupplier">
<fieldset style="padding:0 19px 21px 19px;background-image:url('resources/images/form-contact-shadow.png');">
<h3 class="page-subheading">Add New Products</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>ID</label>
<form:input path="productsId" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Name</label>
<form:input path="productsName" class="form-control" type="text" value=""/>
<form:errors cssStyle="color: red;" path="productsName"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Quantity</label>
<form:input path="productsQuantity" class="form-control" type="text" value=""/>
<form:errors cssStyle="color: red;" path="productsQuantity"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Price</label>
<form:input path="productsPrice" class="form-control" type="text" value=""/>
<form:errors path="productsPrice" cssStyle="color: red;"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Discount</label>
<form:input path="productsDiscount" class="form-control" type="text" value=""/>
<form:errors path="productsDiscount" cssStyle="color: red;"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Description</label>
<form:input path="productsDescription" class="form-control" id="message" name="message"/>
<form:errors path="productsDescription" cssStyle="color: red;"/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group selector1">
<label>Category</label>
<form:select id="id_contact" class="form-control" name="id_contact" path="category.categoryName" itemValue="categoryName">
<form:option value="Choose Category"></form:option>
<form:options items="${categoryList}" itemLabel="categoryName" itemValue="categoryName"/>
</form:select>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group selector1">
<label>Sub-Category</label>
<form:select id="id_contact" class="form-control" name="id_contact" path="subcategory.subCategoryName" itemValue="subCategoryName">
<form:option value="Choose Sub-Category"></form:option>
<form:options items="${subCategoryList}" itemLabel="subCategoryName" itemValue="subCategoryName"/>
</form:select>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group selector1">
<label>Brand</label>
<form:select id="id_contact" class="form-control" name="id_contact" path="brand.brandName" itemValue="brandName">
<form:option value="Choose Brand"></form:option>
<form:options items="${brandList}" itemLabel="brandName" itemValue="brandName"/>
</form:select>
</div>
</div>
<div class="uploader" id="uniform-fileUpload">
<input name="fileUpload" type="file" multiple="multiple" class="form-control"/>
</div>
</div>
<c:if test="${!empty products.productsName}">
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Edit Products
</span>
</button>
</div>
</c:if>
<c:if test="${empty products.productsName}">
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Add Products
</span>
</button>
<input type="button" onclick="toggle();" id="buttonToggle" class="btn btn-default btn-sm" value="Show List">
</div>
</c:if>
</fieldset>
</form:form>
</div>
</div>
</div>
</div>
</div>
</div>
<%@include file="footer.jsp" %>