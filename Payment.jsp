<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Header.jsp" %>

<div class="container">
<table class="table">
<tr>
	<td colspan="6"><center><h3> Your Order </h3></center></td>
</tr>
<tr bgcolor="pink">
	<td colspan="4"> Total Purchase Amount </td>
	<td>INR.${totalPurchaseAmount}</td>
</tr>
</table>

<br/><br/><br/>

<div class="container">
<table class="table" align="center" width="50%">

<tr>
	<td> colspan="2"> Payment Options </td>
</tr>

	<td colspan="2">
		<input type="radio" name="paymenttype" value="CC"/>Credit Card
		<input type="radio" name="paymenttype" value="COD"/>Cash On Delivery
	</td>
</tr>
<tr>
	<td> Card No: </td>
	<td><input type="text" name="cardno" required/></td>
</tr>
<tr>
	<td> CVV </td>
	<td><input type="text" name="cvv"/></td>
</tr>
<tr>
	<td> Valid Upto </td>
	<td><input type="text" name="valid"/></td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="Payment"/>
	</td>
</tr>
</table>
</div>
</div>