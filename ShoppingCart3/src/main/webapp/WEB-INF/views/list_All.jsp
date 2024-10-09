<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="view">AddProduct</a>
	<form action="" method="get">
		<table>
			<tr>
				<th>Name</th>
				<th>Image</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.PName}</td>
					<td>${product.PImage}</td>
					<td>${product.PPrice}</td>
					<td>${product.PQuantity}</td>
					<td><a href="getProductById?id=${product.PId }">update</a></td>
					<td><a href="deleteProduct?id=${product.PId }">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>