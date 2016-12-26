<%@include file="header.jsp" %>
<style>
th
{
	padding:0 2px 0 2px; 
}
td
{
	padding: 0 1.5px 0 1.5px;
	text-align: center;
}
</style>
<div align="center">
<form:form modelAttribute="productsSpecification"  action="addproductsspecification">
<form:input path="products_Id" type="hidden"/>
<form:input path="color" placeholder="Color"/>
<form:input path="design" placeholder="Design"/>
<form:input path="last" placeholder="Last"/>
<form:input path="upper" placeholder="Upper"/>
<form:input path="linning" placeholder="Linning"/>
<form:input path="sole" placeholder="Sole"/>
<form:input path="heel" placeholder="Heel"/>
<form:select path="products.products_Name" itemValue="products_Name">
<form:options items="${productsList}" itemLabel="products_Name" itemValue="products_Name"/>
</form:select>
<c:if test="${!empty productsSpecification.products_Name}">
<input type="submit" value="Edit Products"/>
</c:if>
<c:if test="${empty products.products_Name}">
<input type="submit" value="Add Products"/>
</c:if>
</form:form>
<table>
<tr>
<th>Products ID</th>
<th>Category ID</th>
<th>SubCategory Id</th>
<th>Supplier Id</th>
<th>Brand Id</th>
<th>Products Name</th>
<th>Products Description</th>
<th>Quantity</th>
<th>Price</th>
<th>Discount</th>
<th>Edit Products</th>
<th>Delete Products</th>
</tr>
<c:forEach var="plist" items="${productsList}">
<tr>
<td>${plist.products_Id}</td>
<td>${plist.category_Id}</td>
<td>${plist.subcategory_Id}</td>
<td>${plist.supplier_Id}</td>
<td>${plist.brand_Id}</td>
<td>${plist.products_Name}</td>
<td>${plist.products_Description}</td>
<td>${plist.products_Quantity}</td>
<td>${plist.products_Price}</td>
<td>${plist.products_Discount}</td>
<td><a href="editProducts-${plist.products_Id}">Edit</a></td>
<td><a href="deleteProducts-${plist.products_Id}">Delete</a></td>
</tr>
</c:forEach>
</table>
</div>
<%@include file="footer.jsp"%>