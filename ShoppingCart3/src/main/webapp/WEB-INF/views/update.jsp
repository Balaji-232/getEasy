<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="post">
		<pre>
			Product Id: <input type="text" name="PId" value="${product.PId}">
			Product Name: <input type="text" name="PName" value="${product.PName}">
			Product Image: <input type="text" name="PImage" value="${product.PImage}">
			Product Price: <input type="number" name="PPrice" value="${product.PPrice}">
			Product Quantity: <input type="number" name="PQuantity" value="${product.PQuantity}">
			<input type="submit" value="Add">
		</pre>
	</form>
</body>
</html>