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
<form:form id="registrationForm" modelAttribute="supplier" action="addSupplier">
<fieldset style="padding:0 19px 21px 19px;background:url('resources/images/form-contact-shadow.png')">
<h3 class="page-subheading">Add New Supplier</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="id">ID</label>
<form:input path="supplierId" readonly="true" class="form-control" type="text" name="from" value=""/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="email">Name</label>
<form:input path="supplierName" class="form-control" type="text" value=""/>
<form:errors path="supplierName" cssStyle="color: red;"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="email">Email ID</label>
<form:input path="supplierEmailId" class="form-control" type="text" value=""/>
<form:errors path="supplierEmailId" cssStyle="color: red;"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="email">Phone Number</label>
<form:input path="supplierPhoneNumber" class="form-control" type="text" value=""/>
<form:errors path="supplierPhoneNumber" cssStyle="color: red;"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label for="message">Address</label>
<form:input path="supplierAddress" class="form-control" id="message" name="message"/>
<form:errors path="supplierAddress" cssStyle="color: red;"/>
</div>
</div>
</div>
<c:if test="${!empty supplier.supplierName}">
<div class="submit">
<button type="submit" class="btn btn-default btn-sm">
<span>
Edit Supplier
</span>
</button>
</div>
</c:if>
<c:if test="${empty supplier.supplierName}">
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
<div hidden="true" id="supplierToggle">
<div id="columns" class="container">
<h1 class="page-heading bottom-indent">
Supplier Table</h1>
<div class="row">
<div class="row" align="right">
<div class="col-xs-12 col-md-3">
<input id="searchTable" ng-model="test" type="text" placeholder="Search Table" class="form-control"/>
</div>
</div>
<div class="row" id="supplierTable" align="center">
<div class="table-responsive" style="max-width: 750px; padding-top: 2%;">
<table class="table table-bordered"> 
<tr>
<th>
<input style="text-align: center;" class="btn btn-link"  type="button" value="Supplier ID" ng-click="sortType = 'supplierId'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'supplierId' && !sortReverse"></span>
</th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Supplier Name" ng-click="sortType = 'supplierName'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'supplierName' && !sortReverse"></span></th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Supplier Address" ng-click="sortType = 'supplierAddress'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'supplierAddress' && !sortReverse"></span></th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="EmailId" ng-click="sortType = 'supplierEmailId'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'supplierEmailId' && !sortReverse"></span></th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="PhoneNumber" ng-click="sortType = 'supplierPhoneNumber'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'supplierPhoneNumber' && !sortReverse"></span></th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Edit"/>
</th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Delete"/>
</th>
</tr>
<tr ng-repeat="slist in supplierJsonList | filter:test | orderBy:sortType:sortReverse">
<td style="text-align: center;">{{slist.supplierId}}</td>
<td style="text-align: center;">{{slist.supplierName}}</td>
<td style="text-align: center;">{{slist.supplierAddress}}</td>
<td style="text-align: center;">{{slist.supplierEmailId}}</td>
<td style="text-align: center;">{{slist.supplierPhoneNumber}}</td>
<td style="text-align: center;"><a href="editSupplier-{{slist.supplierId}}" class="fa fa-pencil"> Edit</a></td>
<td style="text-align: center;"><a href="deleteSupplier-{{slist.supplierId}}" class="fa fa-trash-o"> Delete</a></td>
</tr>
</table>
</div>
</div>
</div>
</div>
</div>
</div>
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
		document.getElementById("supplierToggle").style.display = "block";
		document.getElementById("supplierToggle").style.visibility = "visible";
		document.getElementById("buttonToggle").value = "Hide List";
	}
	else
	{
		document.getElementById("supplierToggle").style.display = "none";
		document.getElementById("supplierToggle").style.visibility = "hidden";
		document.getElementById("buttonToggle").value = "Show List";
	}
}
</script>
<%@include file="footer.jsp" %>