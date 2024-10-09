<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="saveAddress" method="post">
		<p>Building Name/No.: <input type="text" name="buildingName"></p>
		<p>Area: <input type="text" name="area"></p>
		<p>Street: <input type="text" name="street"></p>
		<p>City: <input type="text" name="city"></p>
		<p>State: <input type="text" name="state"></p>
		<p>Country: <input type="text" name="country"></p>
		<p>PinCode: <input type="text" name="pinCode"></p>
		<input type="submit" value="Submit">
	</form>
</body>
</html>