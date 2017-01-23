<%@include file="header.jsp" %>
<div class="breadcrumb clearfix">
<ul class="container">
<li class="home">
<a class="home" href="/Foot/" title="Return to Home">
Home
</a>
</li>
<li class="last">Admin-Arena</li>
</ul>
</div>
<div id="categoryToggle">
<div id="columns" class="container">
<h1 class="page-heading bottom-indent">
Block Supplier</h1>
<div class="row">
<div class="row" align="right">
<div class="col-xs-12 col-md-3">
<input id="searchTable" ng-model="test" type="text" placeholder="SEARCH TABLE" class="form-control"/>
</div>
</div>
<div class="row" id="categoryTable" align="center">
<div class="table-responsive" style="max-width: 550px; padding-top: 2%;">
<table class="table table-bordered">
<tr>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Category Name" ng-click="sortType = 'categoryName'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'categoryName' && !sortReverse"></span>
</th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Category Description" ng-click="sortType = 'categoryDescription'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'categoryDescription' && !sortReverse"></span>
</th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Block"/>
</th>
</tr>
<tr ng-repeat="clist in categoryJsonList | filter:test | orderBy:sortType:sortReverse">
<td style="text-align: center;">{{clist.categoryName}}</td>
<td style="text-align: center;">{{clist.categoryDescription}}</td>
<td style="text-align: center;"><a href="editCategory-{{clist.categoryId}}" class="fa fa-ban"> Block</a></td>
</tr>
</table>
</div>
</div>
</div>
</div>
</div>
<div id="categoryToggle">
<div id="columns" class="container">
<h1 class="page-heading bottom-indent">
Block User</h1>
<div class="row">
<div class="row" align="right">
<div class="col-xs-12 col-md-3">
<input id="searchTable" ng-model="test" type="text" placeholder="SEARCH TABLE" class="form-control"/>
</div>
</div>
<div class="row" id="categoryTable" align="center">
<div class="table-responsive" style="max-width: 550px; padding-top: 2%;">
<table class="table table-bordered">
<tr>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Category Name" ng-click="sortType = 'categoryName'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'categoryName' && !sortReverse"></span>
</th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Category Description" ng-click="sortType = 'categoryDescription'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'categoryDescription' && !sortReverse"></span>
</th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Block"/>
</th>
</tr>
<tr ng-repeat="clist in categoryJsonList | filter:test | orderBy:sortType:sortReverse">
<td style="text-align: center;">{{clist.categoryName}}</td>
<td style="text-align: center;">{{clist.categoryDescription}}</td>
<td style="text-align: center;"><a href="editCategory-{{clist.categoryId}}" class="fa fa-ban"> Block</a></td>
</tr>
</table>
</div>
</div>
</div>
</div>
</div>
<div id="categoryToggle">
<div id="columns" class="container">
<h1 class="page-heading bottom-indent">
Allow Supplier</h1>
<div class="row">
<div class="row" align="right">
<div class="col-xs-12 col-md-3">
<input id="searchTable" ng-model="test" type="text" placeholder="SEARCH TABLE" class="form-control"/>
</div>
</div>
<div class="row" id="categoryTable" align="center">
<div class="table-responsive" style="max-width: 550px; padding-top: 2%;">
<table class="table table-bordered">
<tr>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Category Name" ng-click="sortType = 'categoryName'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'categoryName' && !sortReverse"></span>
</th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Category Description" ng-click="sortType = 'categoryDescription'; sortReverse = !sortReverse"/>
<span ng-show="sortType == 'categoryDescription' && !sortReverse"></span>
</th>
<th>
<input style="text-align: center;" class="btn btn-link" type="button" value="Add"/>
</th>
</tr>
<tr ng-repeat="clist in categoryJsonList | filter:test | orderBy:sortType:sortReverse">
<td style="text-align: center;">{{clist.categoryName}}</td>
<td style="text-align: center;">{{clist.categoryDescription}}</td>
<td style="text-align: center;"><a href="editCategory-{{clist.categoryId}}" class="fa fa-plus"> Add</a></td>
</tr>
</table>
</div>
</div>
</div>
</div>
</div>
<%@include file="footer.jsp" %>