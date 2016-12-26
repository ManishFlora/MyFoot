<%@include file="header.jsp" %>
<script>
var subCategory = angular.module("subCategory",[]);
subCategory.controller("subCategoryController",function($scope)
		{
	$scope.subCategoryJsonList = ${subCategoryJsonList}
		});
</script>
<script>
function toggle()
{
	if(document.getElementById("buttonToggle").value == "Show List")
	{
		document.getElementById("subCategoryTable").style.display = "block";
		document.getElementById("subCategoryTable").style.visibility = "visible";
		document.getElementById("buttonToggle").value = "Hide List";
	}
	else
	{
		document.getElementById("subCategoryTable").style.display = "none";
		document.getElementById("subCategoryTable").style.visibility = "hidden";
		document.getElementById("buttonToggle").value = "Show List";
	}
}
</script>
<style>
#subCategoryTable
{
	display:none;
	max-width:800px;
}
</style>
<div  ng-app="subCategory" ng-controller="subCategoryController">
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12">
<h1 class="page-heading bottom-indent">
Sub-Category Form</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<form:form id="registrationForm" modelAttribute="subCategory" action="addsubcategory">
<fieldset style="padding:0 19px 21px 19px;background:url('resources/images/form-contact-shadow.png')">
<h3 class="page-subheading">Add New Sub-Category</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<div class="form-group selector1">
<form:label path="category.category_Name">Category</form:label>
<form:select id="id_contact" class="form-control" name="id_contact" path="category.category_Name" itemValue="category_Name">
<form:option value="Choose Category"></form:option>
<form:options items="${categoryList}" itemLabel="category_Name" itemValue="category_Name"/>
</form:select>
</div>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="id">ID</label>
<form:input path="subcategory_Id" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="email">Name</label>
<form:input path="subcategory_Name" class="form-control" type="text" value=""/>
<form:errors path="subcategory_Name"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label for="message">Description</label>
<form:input path="subcategory_Description" class="form-control"/>
<form:errors path="subcategory_Description"/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<label>Search</label>
<input ng-model="test" type="text" placeholder="Search Table" class="form-control"/>
</div>
</div>
<c:if test="${!empty subCategory.subcategory_Name}">
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Edit Sub-Category
</span>
</button>
</div>
</c:if>
<c:if test="${empty subCategory.subcategory_Name}">
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Add Sub-Category
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
<table class="table table-bordered" id="subCategoryTable">
<tr>
<th>
<input class="btn btn-link"  type="button" value="Category ID" ng-click="sortType = 'category.category_Id'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'category_Id' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link"  type="button" value="SubCategory ID" ng-click="sortType = 'subcategory_Id'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'subcategory_Id' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link" type="button" value="SubCategory Name" ng-click="sortType = 'subcategory_Name'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'subcategory_Name' && !sortReverse"></span></th>
<th>
<input class="btn btn-link" type="button" value="SubCategory Description" ng-click="sortType = 'subcategory_Description'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'subcategory_Description' && !sortReverse"></span></th>
<th>
<input class="btn btn-link" type="button" value="Edit SubCategory"/>
</th>
<th>
<input class="btn btn-link" type="button" value="Delete SubCategory"/>
</th>
</tr>
<tr ng-repeat="sclist in subCategoryJsonList | filter:test | orderBy:sortType:sortReverse">
<td style="text-align: center;">{{sclist.category_Id}}</td>
<td style="text-align: center;">{{sclist.subcategory_Id}}</td>
<td style="text-align: center;">{{sclist.subcategory_Name}}</td>
<td style="text-align: center;">{{sclist.subcategory_Description}}</td>
<td style="text-align: center;"><a href="editSubCategory-{{sclist.subcategory_Id}}" class="btn btn-link">Edit</a></td>
<td style="text-align: center;"><a href="deleteSubCategory-{{sclist.subcategory_Id}}" class="btn btn-link">Delete</a></td>
</tr>
</table>
</div>
</div>
</div>
<%@include file="footer.jsp"%>