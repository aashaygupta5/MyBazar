<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="ProductInsert" modelAttribute="product" method="post" enctype="multipart/form-data">

<table style="text-align: center;" style="border-spacing: 3;">

<tr>
	<td colspan="2"> Product Manage </td>
</tr>
<tr>
	<td> Product Name </td>
	<td><form:input path="productName"/></td>
</tr>
<tr>
	<td> Product Description </td>
	<td><form:input path="productDesc"/></td>
</tr>
<tr>
	<td> Price </td>
	<td><form:input path="price"/></td>
</tr>
<tr>
	<td> Stock </td>
	<td><form:input path="stock"/></td>
</tr>
<tr>
	<td> Category </td>
	<td><form:select path="categoryId">
			<form:option value="0" label="--Select List--"/>
			<form:options items="${categoryList}"/>
		</form:select>
	</td>
</tr>
<tr>
	<td> Supplier </td>
	<td><form:input path="supplierId"/></td>
</tr>

<tr>
	<td> Product Image</td>
	<td><form:input type="file" path="pimage"/></td>
</tr>

<tr>
	<td colspan="2">
		<center><input type="submit" value="Save" class="btn btn-info"/></center>
	</td>
</tr>	
</table>
</form:form>

<table align="center" class="table-bordered">
	<tr bgcolor="pink">
	<td>Product Id</td>

</tr>
</table>