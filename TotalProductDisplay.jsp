<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@Include="Header.jsp"%>

<div class="container">
<table class="table" border="1">

<tr>
	<td rowspan="9">
		<img src:"<c:url value="/resources/images/${product.productId}.jpg"/>" width="150" height="150">
	</td>
</tr>
<tr>
	<td>Product ID</td>
	<td>${product.productId}</td>
</tr>
<tr>
	<td>Product Name</td>
	<td>${product.productName}</td>
</tr>
<tr>
	<td>Price</td>
	<td>${product.price}</td>
</tr>
<tr>
	<td>Supplier ID</td>
	<td>${product.supplierId}</td>
</tr>
<tr>
	<td>Stock</td>
	<td>${product.stock}</td>
</tr>
<tr>
	<td>Category Id</td>
	<td>${product.categoryId}</td>
</tr>
</table>
</div>
	