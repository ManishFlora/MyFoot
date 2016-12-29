<%@include file="header.jsp" %>
<script>
var brand = angular.module("brand",[]);
brand.controller("brandController",function($scope)
		{
	$scope.brandJsonList = ${brandJsonList};
		});
</script>
<script>
function toggle()
{
	if(document.getElementById("buttonToggle").value == "Show List")
	{
		document.getElementById("brandTable").style.display = "block";
		document.getElementById("brandTable").style.visibility = "visible";
		document.getElementById("buttonToggle").value = "Hide List";
	}
	else
	{
		document.getElementById("brandTable").style.display = "none";
		document.getElementById("brandTable").style.visibility = "hidden";
		document.getElementById("buttonToggle").value = "Show List";
	}
}
</script>
<style>
#brandTable
{
	display:none;
	max-width:600px;
}
</style>
<div  ng-app="brand" ng-controller="brandController">
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12">
<h1 class="page-heading bottom-indent">
Brand Form</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<form:form id="registrationForm" modelAttribute="brand" action="addBrand">
<fieldset style="padding:0 19px 21px 19px;background:url('resources/images/form-contact-shadow.png') ">
<h3 class="page-subheading">Add New Brand</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="id">ID</label>
<form:input path="brandId" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="email">Name</label>
<form:input path="brandName" class="form-control" type="text" value=""/>
<form:errors path="brandName"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label>Description</label>
<form:input path="brandDescription" class="form-control"/>
<form:errors path="brandDescription"/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<label>Search</label>
<input ng-model="test" type="text" placeholder="Search Table" class="form-control"/>
</div>
</div>
<c:if test="${!empty brand.brandName}">
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Edit Brand
</span>
</button>
</div>
</c:if>
<c:if test="${empty brand.brandName}">
<button type="submit" class="btn btn-default btn-sm">
<span>
Add Brand
</span>
</button>
<input type="button" onclick="toggle();" id="buttonToggle" class="btn btn-default btn-sm" value="Show List">
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
<table class="table table-bordered" id="brandTable">
<tr>
<th>
<input class="btn btn-link" type="button" value="Brand  ID" ng-click="sortType = 'brandId'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'brandId' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link" type="button" value="Brand Name" ng-click="sortType = 'brandName'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'brandName' && !sortReverse"></span></th>
<th>
<input class="btn btn-link" type="button" value="Brand Description" ng-click="sortType = 'brandDescription'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'brandDescription' && !sortReverse"></span></th>
<th>
<input class="btn btn-link" type="button" value="Edit Brand"/>
</th>
<th>
<input class="btn btn-link" type="button" value="Delete Brand"/>
</th>
</tr>
<tr ng-repeat="blist in brandJsonList | filter:test | orderBy:sortType:sortReverse">
<td style="text-align: center;">{{blist.brandId}}</td>
<td style="text-align: center;">{{blist.brandName}}</td>
<td style="text-align: center;">{{blist.brandDescription}}</td>
<td style="text-align: center;"><a href="editBrand-{{blist.brandId}}">Edit</a></td>
<td style="text-align: center;"><a href="deleteBrand-{{blist.brandId}}">Delete</a></td>
</tr>
</table>
</div>
</div>
</div>
<%@include file="footer.jsp" %>