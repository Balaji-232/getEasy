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
	<p><img src="${product.PImage}" alt="Image"></p>
				<p>${product.PName}</p>
				<p>${product.seller}</p>
				<p>${product.PPrice}</p>
				<form action="review" method="post">
					<input type="hidden" name="PId" value="${product.PId}">
					<c:forEach items="${reviews}" var="review">
						<c:set var="sum" value="${TotalSum+review.rating }"/>
						<c:set var="Tsum" value="${Tsum+sum }"/>
						<c:set var="count" value="${count+1 }"/>
					</c:forEach>
					<c:set var="Trat" value="${Tsum/count}" />
					<p>Rating: ${Trat}</p>
					<input type="hidden" name="Trat" value="${Trat}">
					<p><input type="submit" value="Add Review"></p>
				</form>
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
				<form>
					<h3>Reviews:</h3>
    				<c:forEach items="${reviews}" var="review">
      			       <p>Rating: ${review.rating}</p>
                       <p>Review: ${review.review}</p>
                   </c:forEach>
				</form>
</body>
</html>