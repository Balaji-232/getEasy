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
	<form action="pay" method="post">
	<p>Total Quantity: <c:out value="${Qty}" /></p>
	<p>Items Price: <c:out value="${Price}"/></p>
	<p>Shipping Fee: <c:out value="${Sfee}"/></p>
	<c:set var="Total_Price" value="${Price+Sfee }"/>
	<p>Total Price: <c:out value="${Total_Price}"/></p>
	<p>Promotion Applied: <c:out value="-${Sfee}"/></p>
	<c:set var="Final_Price" value="${Total_Price-Sfee }"/>
	<p>Amount to be paid: <c:out value="${Final_Price}"/>
	<p><label for="addr">Select Address: </label></p>
	<c:forEach items="${addresses}" var="address">
		<input type="checkbox" name="addr" value="${address.buildingName}, ${address.area}, ${address.street}, ${address.city}, ${address.state}, ${address.country}- ${address.pinCode}" label=addr>
		<textarea id="${address.buildingName}" rows=4 cols=75><c:out value= "${address.buildingName}, ${address.area}, ${address.street}, ${address.city}, ${address.state}, ${address.country}- ${address.pinCode}"/></textarea>	
	</c:forEach>
	<input type="hidden" name="FinalPrice" value="${Final_Price}">
	<input type="hidden" name="msg" value="${msg}">
	<input type="hidden" name="PId" value="${PId}">
	<p><input type="submit" value="Place Order and Pay"></p>
	</form>
</body>
</html>