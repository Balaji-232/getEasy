<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="list_All">List_All</a>
	<form action="addhome" method="post">
		<pre>
			Product Id: <input type="text" name="PId">
			Product Name: <input type="text" name="PName">
			Product Image: <input type="text" name="PImage">
			Product Price: <input type="number" name="PPrice">
			Product Quantity: <input type="number" name="PQuantity">
			Selling Company: <input type="text" name="seller">
			Seller Email: <input type="text" name="sellerEmail">
			<input type="submit" value="Add">
		</pre>
	</form>
	
</body>
</html>