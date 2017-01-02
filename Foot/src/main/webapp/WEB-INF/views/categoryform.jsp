<%@include file="header.jsp" %>
<div ng-controller="categoryController" ng-app="category">
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12">
<h1 class="page-heading bottom-indent">Category Form</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<form:form id="registrationForm" method="post" modelAttribute="category" action="addCategory">
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
<form:errors cssStyle="color: red;" path="categoryName"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label for="message">Description</label>
<form:input path="categoryDescription" class="form-control" id="message" name="message"/>
<form:errors cssStyle="color: red;" path="categoryDescription"/>
</div>
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
<div hidden="true" id="categoryToggle">
<div id="columns" class="container">
<h1 class="page-heading bottom-indent">
Category Table</h1>
<div class="row">
<div class="row" align="right">
<div class="col-xs-12 col-md-3">
<input id="searchTable" ng-model="test" type="text" placeholder="Search Table" class="form-control"/>
</div>
</div>
<div class="row" id="categoryTable" align="center">
<div class="table-responsive" style="max-width: 550px; padding-top: 2%;">
<table class="table table-bordered">
<tr>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Category ID" ng-click="sortType = 'categoryId'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'categoryId' && !sortReverse"></span>
</th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Category Name" ng-click="sortType = 'categoryName'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'categoryName' && !sortReverse"></span>
</th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Category Description" ng-click="sortType = 'categoryDescription'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'categoryDescription' && !sortReverse"></span>
</th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Edit"/>
</th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Delete"/>
</th>
</tr>
<tr ng-repeat="clist in categoryJsonList | filter:test | orderBy:sortType:sortReverse">
<td style="text-align: center;">{{clist.categoryId}}</td>
<td style="text-align: center;">{{clist.categoryName}}</td>
<td style="text-align: center;">{{clist.categoryDescription}}</td>
<td style="text-align: center;"><a href="editCategory-{{clist.categoryId}}" class="fa fa-pencil"> Edit</a></td>
<td style="text-align: center;"><a href="deleteCategory-{{clist.categoryId}}" class="fa fa-trash-o"> Delete</a></td>
</tr>
</table>
</div>
</div>
</div>
</div>
</div>
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
document.getElementById("categoryToggle").style.display = "block";
document.getElementById("categoryToggle").style.visibility = "visible";
document.getElementById("buttonToggle").value = "Hide List";
}
else
{
document.getElementById("categoryToggle").style.display = "none";
document.getElementById("categoryToggle").style.visibility = "hidden";
document.getElementById("buttonToggle").value = "Show List";
}
}
</script>
<%@include file="footer.jsp" %>