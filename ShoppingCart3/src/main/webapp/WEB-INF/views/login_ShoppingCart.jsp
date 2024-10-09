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
	<form action="home" method="post">
		<h4>UserName: <input type="text" name="Email"></h4>
		<h4>Password: <input type="text" name="Password"></h4>
		<input type="submit" value="Login">
	</form>
	<form action="signUp" method="post">
		<input type="submit" value="SignUp">
	</form>
	<c:out value="${msg}"></c:out>
</body>
</html>