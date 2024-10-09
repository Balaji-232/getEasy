<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<form action="search" method="post">
		<input type="text" name="search" value="${search}" placeholder="Search here....">
		<input type="submit" value="Search">
	</form>
	
		<c:forEach items="${products}" var="product">
				<p><a href="/product?id=${product.PId }"><img src="${product.PImage}" alt="Image"></a></p>
				<p>${product.PName}</p>
				<p>${product.seller}</p>
				<p>${product.PPrice}</p>
				<p>Rating: ${product.pRating}</p>
				<form action="cart" method="post">
					<input type="hidden" name="PId" value="${product.PId}">
					<input type="hidden" name="PImage" value="${product.PImage}">
					<input type="hidden" name="PName" value="${product.PName}">
					<input type="hidden" name="PPrice" value="${product.PPrice}">
					<input type="hidden" name="Pseller" value="${product.seller}">
					<input type="hidden" name="PQuantity" value=1>
					<input type="submit" value="Add to cart">
				</form>
				<form action="payment1" method="post">
					<input type="hidden" name="PId" value="${product.PId}">
					<input type="hidden" name="PName" value="${product.PName}">
					<input type="hidden" name="TPrice" value="${product.PPrice}">
					<input type="hidden" name="TQty" value="${product.PQuantity}">
					<input type="hidden" name="Pseller" value="${product.seller}">
					<input type="submit" value="Buy">
				</form>
		</c:forEach>
</body>
</html>