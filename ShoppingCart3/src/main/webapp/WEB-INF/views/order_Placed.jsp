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
	<h3>Transaction is successful</h3>
	<p>Your order is placed and total paid amount = <c:out value="${FinalPrice}"/></p>
	<p>Going to Deliver to below Address:</p>
	<p><c:out value="${addr}"/></p>
</body>
</html>