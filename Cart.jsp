<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Header.jsp" %>

<div class="container">
<table class="table">
<tr>
	<td colspan="6"><center><h3> Shopping Cart </h3></center></td>
</tr>
<tr>
	<td> SL # </td>
	<td> Product Name </td>
	<td> Quantity </td>
	<td> Price </td>
	<td> Total Price </td>
	<td> Operation </td>
</tr>
<c:if test="${empty cartItems}">
<tr><td colspan="6"><center> Your Cart Is Empty! </center></td></tr>
</c:if>
<c:if test="${not empty cartItems}">
<c:forEach items="${cartItems}" var="cartItem">
<form action="<c:url value="/updateCartItem/${cartItem.cartItemId}"/>" method="get">
<tr>
	<td></td>
	<td>${cartItem.productName}</td>
	<td><input type="text" value="${cartItem.quantity}"/></td>
	<td>${cartItem.price}</td>
	<td>${cartItem.quantity * cartItem.price}</td>
	<td>
		<input type="submit" value="Update" class="btn btn-info"/>
		<a href="<c:url value="/deleteCartItem/${cartItem.cartItemId}"/>" class="btn btn-danger"></a>
	</td>
</tr>
</form>
</c:forEach>
</c:if>
<tr bgcolor="red">
	<td colspan="4"> Total Purchase Amount </td>
	<td colspan="2">${totalPurchaseAmount}</td>
</tr>