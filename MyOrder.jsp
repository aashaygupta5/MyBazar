<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Header.jsp" %>

<div class="container">
<table class="table">
<tr>
	<td colspan="6"><center><h3> Your Order </h3></center></td>
</tr>
<tr>
	<td> SL # </td>
	<td> Product Name </td>
	<td> Quantity </td>
	<td> Price </td>
	<td> Total Price </td>
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
	<td><${cartItem.quantity}></td>
	<td>${cartItem.price}</td>
	<td>${cartItem.quantity * cartItem.price}</td>
</tr>
</form>
</c:forEach>
</c:if>
<tr bgcolor="red">
	<td colspan="4"> Total Purchase Amount </td>
	<td colspan="2">${totalPurchaseAmount}</td>
</tr>
<tr bgcolor="lightblue">
	<td colspan="3"><a href="<c:url value="/continueShopping"/>" class="btn btn-info"> Continue Shopping </a></td>
	<td colspan="2"><a href="<c:url value="/payment"/>" class="btn btn-info"> Payment </a></td>
</tr>
</table>
</div>