<%@include file="header.jsp" %>
<script>
var supplier = angular.module("supplier",[]);
supplier.controller("supplierController",function($scope)
		{
	$scope.supplierJsonList = ${supplierJsonList};
		});
</script>
<script>
function toggle()
{
	if(document.getElementById("buttonToggle").value == "Show List")
	{
		document.getElementById("supplierTable").style.display = "block";
		document.getElementById("supplierTable").style.visibility = "visible";
		document.getElementById("buttonToggle").value = "Hide List";
	}
	else
	{
		document.getElementById("supplierTable").style.display = "none";
		document.getElementById("supplierTable").style.visibility = "hidden";
		document.getElementById("buttonToggle").value = "Show List";
	}
}
</script>
<style>
#supplierTable
{
	display:none;
	max-width:800px;
}
</style>
<div ng-app="supplier" ng-controller="supplierController">
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12">
<h1 class="page-heading bottom-indent">
Supplier Form</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<form:form id="registrationForm" modelAttribute="supplier" action="addSupplier">
<fieldset style="padding:0 19px 21px 19px;background:url('resources/images/form-contact-shadow.png')">
<h3 class="page-subheading">Add New Supplier</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="id">ID</label>
<form:input path="supplier_Id" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="email">Name</label>
<form:input path="supplier_Name" class="form-control" type="text" value=""/>
<form:errors path="supplier_Name"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="email">Email ID</label>
<form:input path="supplier_EmailId" class="form-control" type="text" value=""/>
<form:errors path="supplier_EmailId"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="email">Phone Number</label>
<form:input path="supplier_PhoneNumber" class="form-control" type="text" value=""/>
<form:errors path="supplier_PhoneNumber"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label for="message">Address</label>
<form:input path="supplier_Address" class="form-control" id="message" name="message"/>
<form:errors path="supplier_Address"/>
</div>
</div>
<div class="col-xs-12 col-md-3">
<label>Search</label>
<input ng-model="test" type="text" placeholder="Search Table" class="form-control"/>
</div>
</div>
<c:if test="${!empty supplier.supplier_Name}">
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Edit Supplier
</span>
</button>
</div>
</c:if>
<c:if test="${empty supplier.supplier_Name}">
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Add Supplier
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
<table class="table table-bordered" id ="supplierTable"> 
<tr>
<th>
<input class="btn btn-link"  type="button" value="Supplier ID" ng-click="sortType = 'supplier_Id'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'supplier_Id' && !sortReverse"></span>
</th>
<th>
<input class="btn btn-link" type="button" value="Supplier Name" ng-click="sortType = 'supplier_Name'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'supplier_Name' && !sortReverse"></span></th>
<th>
<input class="btn btn-link" type="button" value="Supplier Address" ng-click="sortType = 'supplier_Address'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'supplier_Address' && !sortReverse"></span></th>
<th>
<input class="btn btn-link" type="button" value="EmailId" ng-click="sortType = 'supplier_EmailId'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'supplier_EmailId' && !sortReverse"></span></th>
<th>
<input class="btn btn-link" type="button" value="PhoneNumber" ng-click="sortType = 'supplier_PhoneNumber'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'supplier_PhoneNumber' && !sortReverse"></span></th>
<th>
<input class="btn btn-link" type="button" value="Edit Supplier"/>
</th>
<th>
<input class="btn btn-link" type="button" value="Delete Supplier"/>
</th>
</tr>
<tr ng-repeat="slist in supplierJsonList | filter:test | orderBy:sortType:sortReverse">
<td style="text-align: center;">{{slist.supplier_Id}}</td>
<td style="text-align: center;">{{slist.supplier_Name}}</td>
<td style="text-align: center;">{{slist.supplier_Address}}</td>
<td style="text-align: center;">{{slist.supplier_EmailId}}</td>
<td style="text-align: center;">{{slist.supplier_PhoneNumber}}</td>
<td style="text-align: center;"><a href="editSupplier-{{slist.supplier_Id}}" class="btn btn-link">Edit</a></td>
<td style="text-align: center;"><a href="deleteSupplier-{{slist.supplier_Id}}" class="btn btn-link">Delete</a></td>
</tr>
</table>
</div>
</div>
</div>
<%@include file="footer.jsp" %>