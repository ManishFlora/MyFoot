<%@include file="header.jsp" %>
<script>
var products = angular.module("products",[]);
products.controller("productsController",function($scope)
		{
	$scope.productsJsonList = ${productsJsonList};
		});
</script>
<script>
function toggle()
{
	if(document.getElementById("buttonToggle").value == "Show List")
	{
		document.getElementById("productsTable").style.display = "block";
		document.getElementById("productsTable").style.visibility = "visible";
		document.getElementById("buttonToggle").value = "Hide List";
	}
	else
	{
		document.getElementById("productsTable").style.display = "none";
		document.getElementById("productsTable").style.visibility = "hidden";
		document.getElementById("buttonToggle").value = "Show List";
	}
}
</script>
<style>
#productsTable
{
	display:none;
	max-width:1315px;
}
</style>
<div ng-app="products" ng-controller="productsController">
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12">
<h1 class="page-heading bottom-indent">
Products Form</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<form:form enctype="multipart/form-data" modelAttribute="products"  action="addproducts">
<fieldset style="padding:0 19px 21px 19px;background-image:url('resources/images/form-contact-shadow.png');">
<h3 class="page-subheading">Add New Products</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>ID</label>
<form:input path="products_Id" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Name</label>
<form:input path="products_Name" class="form-control" type="text" value=""/>
<form:errors path="products_Name"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Quantity</label>
<form:input path="products_Quantity" class="form-control" type="text" value=""/>
<form:errors path="products_Quantity"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Price</label>
<form:input path="products_Price" class="form-control" type="text" value=""/>
<form:errors path="products_Price"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label>Discount</label>
<form:input path="products_Discount" class="form-control" type="text" value=""/>
<form:errors path="products_Discount"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Description</label>
<form:input path="products_Description" class="form-control" id="message" name="message"/>
<form:errors path="products_Description"/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group selector1">
<label>Category</label>
<form:select id="id_contact" class="form-control" name="id_contact" path="category.category_Name" itemValue="category_Name">
<form:option value="Choose Category"></form:option>
<form:options items="${categoryList}" itemLabel="category_Name" itemValue="category_Name"/>
</form:select>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group selector1">
<label>Sub-Category</label>
<form:select id="id_contact" class="form-control" name="id_contact" path="subcategory.subcategory_Name" itemValue="subcategory_Name">
<form:option value="Choose Sub-Category"></form:option>
<form:options items="${subCategoryList}" itemLabel="subcategory_Name" itemValue="subcategory_Name"/>
</form:select>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group selector1">
<label>Brand</label>
<form:select id="id_contact" class="form-control" name="id_contact" path="brand.brand_Name" itemValue="brand_Name">
<form:option value="Choose Brand"></form:option>
<form:options items="${brandList}" itemLabel="brand_Name" itemValue="brand_Name"/>
</form:select>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group selector1">
<label>Supplier</label>
<form:select id="id_contact" class="form-control" name="id_contact" path="supplier.supplier_Name" itemValue="supplier_Name">
<form:option value="Choose Supplier"></form:option>
<form:options items="${supplierList}" itemLabel="supplier_Name" itemValue="supplier_Name"/>
</form:select>
</div>
</div>
<div class="col-xs-12 col-md-3">
<label>Search</label>
<input ng-model="test" type="text" placeholder="Search Table" class="form-control"/>
</div>
<div class="uploader" id="uniform-fileUpload">
<form:input path="products_Image" type="file" class="form-control"></form:input>
<span class="filename" style="user-select: none;">No file selected</span>
<span class="action"  style="user-select: none;">Choose...</span>
</div>
</div>
<c:if test="${!empty products.products_Name}">
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Edit Products
</span>
</button>
</div>
</c:if>
<c:if test="${empty products.products_Name}">
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
<div align="center">
<div class="table-responsive">
<table class="table table-bordered" id="productsTable">
<tr>
<th>
<input class="btn btn-link" type="button" value="Products ID" ng-click="sortType = 'products_Id'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'products_Id' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link"  type="button" value="Category ID" ng-click="sortType = 'category.category_Id'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'category_Id' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link"  type="button" value="SubCategory ID" ng-click="sortType = 'subcategory.subcategory_Id'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'subcategory_Id' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link"  type="button" value="Supplier ID" ng-click="sortType = 'supplier.supplier_Id'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'supplier_Id' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link"  type="button" value="Brand ID" ng-click="sortType = 'brand.brand_Id'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'brand_Id' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link"  type="button" value="Products Name" ng-click="sortType = 'products_Name'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'products_Name' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link"  type="button" value="Products Description" ng-click="sortType = 'products_Description'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'products_Description' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link"  type="button" value="Quantity" ng-click="sortType = 'products_Quantity'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'products_Quantity' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link"  type="button" value="Price" ng-click="sortType = 'products_Price'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'products_Price' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link"  type="button" value="Discount" ng-click="sortType = 'products_Discount'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'products_Discount' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link" type="button" value="Edit Products"/>
</th>
<th>
<input class="btn btn-link" type="button" value="Delete Products"/>
</th>
<!-- <th>
<input class="btn btn-link" type="button" value="Add Specification"/>
</th> -->
</tr>
<tr ng-repeat="plist in productsJsonList | filter:test | orderBy:sortType:sortReverse">
<td style="text-align: center;">{{plist.products_Id}}</td>
<td style="text-align: center;">{{plist.category_Id}}</td>
<td style="text-align: center;">{{plist.subcategory_Id}}</td>
<td style="text-align: center;">{{plist.supplier_Id}}</td>
<td style="text-align: center;">{{plist.brand_Id}}</td>
<td style="text-align: center;">{{plist.products_Name}}</td>
<td style="text-align: center;">{{plist.products_Description}}</td>
<td style="text-align: center;">{{plist.products_Quantity}}</td>
<td style="text-align: center;">{{plist.products_Price}}</td>
<td style="text-align: center;">{{plist.products_Discount}}</td>
<td style="text-align: center;"><a href="editProducts-{{plist.products_Id}}" class="btn btn-link">Edit</a></td>
<td style="text-align: center;"><a href="deleteProducts-{{plist.products_Id}}" class="btn btn-link">Delete</a></td>
<%-- <td><a href="addProductSpecification-${plist.products_Id}">Add</a></td> --%>
</tr>
</table>
</div>
</div>
</div>
<%@include file="footer.jsp"%>