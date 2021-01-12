<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@Include file="Header.jsp"%>


<c:forEach items="${productList}" var="product">
<div class="row">
	<div class="col-sm-6 col-md-4">
		<div class="thumbnail">
		<h4>
			<span data-toggle="tooltip" title="Bootstrap version">${product.productName}</span>
		</h4>
		<img src:"<c:url value="/resources/images/${product.productId}.jpg"/>" width="150" height="150"></div>
		<a href = "http://bootsnipp.com/snippets/featured/post-thumbnail-list"
			class = "btn btn-primary col-xs-12" role="button">Click for Large</a>
			<div class="clearfix"></div>
		</div>
	</div>
</c:forEach>

</body>
</html>