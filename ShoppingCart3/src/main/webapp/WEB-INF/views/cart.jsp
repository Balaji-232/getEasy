<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
	<c:set var="Tsum" value="0"/>
	<c:forEach items="${cartProducts}" var="product">	
		<p><img src="${product.PImage}" alt="Image"></p>
		<p>ProductName: ${product.PName}</p>
		<p>Product Seller: ${product.seller}</p>
		<p>Product Price: ${product.PPrice}</p>
		<p>Product Quantity: ${product.PQuantity}</p>
		<c:set var="sum" value="${TotalSum+product.PPrice }"/>
		<c:set var="Tsum" value="${Tsum+sum }"/>
		<c:set var="qty" value="${Totalqty+product.PQuantity }"/>
		<c:set var="Tqty" value="${Tqty+qty }"/>
	<form action="cartIncrease" method="post">
		<input type="hidden" name="CId" value="${product.CId}">
		<input type="submit" value="+">
	</form>
	<form action="cartDecrease" method="post">
		<input type="hidden" name="CId" value="${product.CId}">
		<input type="submit" value="-">
	</form>
	</c:forEach>
	
	<c:if test="${Tsum==0}">
				<h2>Cart is empty</h2>
	</c:if>
	<c:if test="${Tsum!=0}">
				<h2>Cart Total Price:${Tsum}</h2>
				<h2>Cart Total Quantity:${Tqty}</h2>
				<form action="payment" method="post">
					<input type="hidden" name="TPrice" value="${Tsum}">
					<input type="hidden" name="TQty" value="${Tqty}">
					<h2><input type="submit" value="Buy Now"></h2>
				</form>
	</c:if>
</body>
</html>