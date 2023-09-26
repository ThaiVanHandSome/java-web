<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Category</title>
</head>
<body>
	<form action="insert" method="post">
		<label>Name</label>
		<input type="text" name="cateName"/>
		<label>Image</label>
		<input type="text" name="image"/>
		<button type="submit">
			Add
		</button>
	</form>
</body>
</html>