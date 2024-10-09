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
	<form action="saveRew" method="post">
    <h2>Review</h2>
    <h3>Total Rating: ${Trat}</h3>
    <h5>Select your rating between 1 and 5 (1-> Poor 5-> Excellent)</h5>
    <input type="hidden" name="Rid" value="${Pid}">
    <p>
        <input type="radio" id="1" name="rating" value="1"><label for="1">1</label>
        <input type="radio" id="2" name="rating" value="2"><label for="2">2</label>
        <input type="radio" id="3" name="rating" value="3"><label for="3">3</label>
        <input type="radio" id="4" name="rating" value="4"><label for="4">4</label>
        <input type="radio" id="5" name="rating" value="5"><label for="5">5</label>
    </p>
    <h5><label for="review">Add Your Review</label></h5>
    <textarea id="review" name="review" rows="4" cols="50"></textarea>
    <p><input type="submit" value="Add Review"></p>
	</form>
</body>
</html>