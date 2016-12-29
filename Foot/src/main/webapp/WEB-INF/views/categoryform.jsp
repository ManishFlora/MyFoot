<%@include file="header.jsp" %>
<script>
var category = angular.module("category",[]);
category.controller("categoryController",function($scope)
		{
	$scope.categoryJsonList = ${categoryJsonList};
		});
</script>
<script>
function toggle()
{
if(document.getElementById("buttonToggle").value == "Show List")
{
document.getElementById("categoryTable").style.display = "block";
document.getElementById("categoryTable").style.visibility = "visible";
document.getElementById("searchTable").readOnly = false;
document.getElementById("buttonToggle").value = "Hide List";
}
else
{
document.getElementById("categoryTable").style.display = "none";
document.getElementById("categoryTable").style.visibility = "hidden";
document.getElementById("searchTable").readOnly = true;
document.getElementById("buttonToggle").value = "Show List";
}
}
</script>
<style>
#categoryTable
{
display:none;
max-width:635px;
}
</style>
<div ng-controller="categoryController" ng-app="category">
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12">
<h1 class="page-heading bottom-indent">Category Form</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<form:form id="registrationForm" modelAttribute="category" action="addCategory">
<fieldset style="padding:0 19px 21px 19px;background:url(resources/images/form-contact-shadow.png">
<h3 class="page-subheading">Add New Category</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="id">ID</label>
<form:input path="categoryId" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="email">Name</label>
<form:input path="categoryName" class="form-control" type="text" value=""/>
<form:errors path="categoryName"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label for="message">Description</label>
<form:input path="categoryDescription" class="form-control" id="message" name="message"/>
<form:errors path="categoryDescription"/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<label>Search</label>
<input readonly="true" id="searchTable" ng-model="test" type="text" placeholder="Search Table" class="form-control"/>
</div>
</div>
<c:if test="${!empty category.categoryName}">
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Edit Category
</span>
</button>
</div>
</c:if>
<c:if test="${empty category.categoryName}">
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Add Category
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
<div class = "table-responsive" id="categoryTable">
<table class="table table-bordered">
<tr>
<th>
<input class="btn btn-link" type="button" value="Category ID" ng-click="sortType = 'categoryId'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'categoryId' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link" type="button" value="Category Name" ng-click="sortType = 'categoryName'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'categoryName' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link" type="button" value="Category Description" ng-click="sortType = 'categoryDescription'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'categoryDescription' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link" type="button" value="Edit Category"/>
</th>
<th>
<input class="btn btn-link" type="button" value="Delete Category"/>
</th>
</tr>
<tr ng-repeat="clist in categoryJsonList | filter:test | orderBy:sortType:sortReverse">
<td style="text-align: center;">{{clist.categoryId}}</td>
<td style="text-align: center;">{{clist.categoryName}}</td>
<td style="text-align: center;">{{clist.categoryDescription}}</td>
<td style="text-align: center;"><a href="editCategory-{{clist.categoryId}}" class="btn btn-link">Edit</a></td>
<td style="text-align: center;"><a href="deleteCategory-{{clist.categoryId}}" class="btn btn-link">Delete</a></td>
</tr>
</table>
</div>
</div>
</div>
<%@include file="footer.jsp" %>