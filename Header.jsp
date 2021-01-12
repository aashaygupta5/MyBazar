<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" contents="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
mycontainer
{
background-color:orange;
}
</style>
</head>

<body>

<div id="mycontainer" class="container"> social icon </div>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
		<a class="navbar-brand" href="#">MyBazar</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="home">Home</a></li>
			<c:if test="${!sessionScope.loggedIn}">
				<li><a href="login">Login</a></li>
				<li><a href="register">Register</a></li>
				<li><a href="contactus">Contact Us</a></li>
				<li><a href = "aboutus">About Us</a></li>
			</c:if>
			<c:if test="${sessionScope.loggedIn}">
				<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
					<li><a href = "category">Manage Category</a></li>
					<li><a href = "product">Manage Product</a></li>
				</c:if>
				<c:if test="${sessionScope.role='ROLE_USER'}">
					<li><a href="productDisplay">Display Product</a></li>
				</c:if>
			</c:if>
		</ul>
	</div>
	<div class="nav navbar-nav navbar-right">
		<font color="white" face="calibri" size="3">Welcome:</font>
		<a href="/logout"><font color="white" face="calibri" size="2">LOGOUT</font></a>
	</div>
</nav>


</body>
</html>