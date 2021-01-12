<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head></head>
<body>
<c:if test="${flag}">
<form action ="<c:url value="/UpdateCategory"/>" method ="post">
<table>
	<tr>
		<td>Category Id</td>
		<td><input type="text" name="catid" value="${categoryData.categoryId}" readonly/></td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><input type ="text" name="catName" value="${categoryData.categoryName}"/></td>
	</tr>
	<tr>
		<td>Category Desc</td>
		<td><input type="text" name="catDesc" value="${category.categoryDesc}"/></td>
	</tr>
	<tr>
		<td colspan="2">
		<center>
		<input type ="submit" value="SUBMIT"/>
		</center>
		</td>
	</tr>
</table>
</form>
</c:if>

<form action ="<c:url value="/InsertCategory"/>" method="post">
<table>
	<tr>
		<td>Category Name</td>
		<td><input type ="text" name="catName"/></td>
	</tr>
	<tr>
		<td>Category Desc</td>
		<td><input type="text" name="catDesc"/></td>
	</tr>
</table>

<table align="center">
	<tr bgcolor="pink">
		<td>Category Id </td>
		<td>Category Name</td>
		<td>Category Description</td>
	</tr>

<c:forEach items ="$[CategoryList]" var="category">

	<tr>
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDesc}</td>
		<td>
			<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
			<a href="<c:url value="/editCategory/${category.categoryId}"/>">Edit</a>
	</tr>
</c:forEach>
</table>


</body>
</html>