<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<p>Price to Pay: <c:out value="${Price}"/>
		<p>Cart Qty: <c:out value="${Quantity}"/>
		<p><input type="radio" name="paytm"><label for="paytm">Paytm</label></p>
		<p><input type="radio" name="paytm"><label for="phonepe">PhonePe</label></p>
		<p><input type="radio" name="paytm"><label for="GooglePay">Google Pay</label></p>
		<form action="address" method="post">
			<input type="submit" value="Add Address">
		</form>
		<form action="orderDetails" method="post">
			<input type="hidden" name="Price" value="${Price}">
			<input type="hidden" name="Shipping_Fee" value=40>
			<input type="hidden" name="Qty" value="${Quantity}">
			<input type="hidden" name="msg" value="${msg}">
			<input type="hidden" name="PId" value="${PId}">
			<input type="submit" value="continue">
		</form>
</body>
</html>