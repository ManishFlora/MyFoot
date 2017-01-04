<%@include file="header.jsp" %>
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
<fieldset style="padding:0 19px 21px 19px; background:url('resources/images/form-contact-shadow.png')">
<h3 class="page-subheading">Add New Sub-Category</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="id">ID</label>
<form:input path="subCategoryId" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="email">Name</label>
<form:input path="subCategoryName" class="form-control" type="text" value=""/>
<form:errors cssStyle="color: red;" path="subCategoryName"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label for="message">Description</label>
<form:input path="subCategoryDescription" class="form-control"/>
<form:errors path="subCategoryDescription" cssStyle="color: red;"/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group selector1">
<form:label path="category.categoryName">Category</form:label>
<form:select id="id_contact" class="form-control" name="id_contact" path="category.categoryName" itemValue="category_Name">
<form:option value="Choose Category"></form:option>
<form:options items="${categoryList}" itemLabel="categoryName" itemValue="categoryName"/>
</form:select>
</div>
</div>
</div>
<c:if test="${!empty subCategory.subCategoryName}">
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Edit Sub-Category
</span>
</button>
</div>
</c:if>
<c:if test="${empty subCategory.subCategoryName}">
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
<div hidden="true" id="subCategoryToggle">
<div id="columns" class="container">
<h1 class="page-heading bottom-indent">
Sub-Category Table</h1>
<div class="row">
<div class="row">
<div class="col-xs-12 col-md-3">
<input id="searchTable" ng-model="test" type="text" placeholder="Search Table" class="form-control"/>
</div>
</div>
<div class="row" id="subCategoryTable" align="center">
<div class="table-responsive" style="max-width: 800px; padding-top: 2%;">
<table class="table table-bordered">
<tr>
<th>
<input style="text-align: center;" class="btn btn-link"  type="button" value="Category ID" ng-click="sortType = 'category.categoryId'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'categoryId' && !sortReverse"></span>
</th>
<th>
<input style="text-align: center;" class="btn btn-link"  type="button" value="SubCategory ID" ng-click="sortType = 'subCategoryId'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'subcategoryId' && !sortReverse"></span>
</th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="SubCategory Name" ng-click="sortType = 'subCategoryName'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'subCategoryName' && !sortReverse"></span></th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="SubCategory Description" ng-click="sortType = 'subCategoryDescription'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'subCategoryDescription' && !sortReverse"></span></th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Edit"/>
</th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Delete"/>
</th>
</tr>
<tr ng-repeat="sclist in subCategoryJsonList | filter:test | orderBy:sortType:sortReverse">
<td style="text-align: center;">{{sclist.categoryId}}</td>
<td style="text-align: center;">{{sclist.subCategoryId}}</td>
<td style="text-align: center;">{{sclist.subCategoryName}}</td>
<td style="text-align: center;">{{sclist.subCategoryDescription}}</td>
<td style="text-align: center;"><a href="editSubCategory-{{sclist.subCategoryId}}" class="fa fa-pencil"> Edit</a></td>
<td style="text-align: center;"><a href="deleteSubCategory-{{sclist.subCategoryId}}" class="fa fa-trash-o"> Delete</a></td>
</tr>
</table>
</div>
</div>
</div>
</div>
</div>
</div>
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
		document.getElementById("subCategoryToggle").style.display = "block";
		document.getElementById("subCategoryToggle").style.visibility = "visible";
		document.getElementById("subCategoryToggle").style.align = "center";
		document.getElementById("buttonToggle").value = "Hide List";
	}
	else
	{
		document.getElementById("subCategoryToggle").style.display = "none";
		document.getElementById("subCategoryToggle").style.visibility = "hidden";
		document.getElementById("subCategoryToggle").style.align = "center";
		document.getElementById("buttonToggle").value = "Show List";
	}
}
</script>
<%@include file="footer.jsp"%>