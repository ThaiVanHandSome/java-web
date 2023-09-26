<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<form action="update" method="post" >
		<label>Name</label> <input type="text" name="cateName"  value="${cate.cateName }"/> <label>Image</label>
		<input type="text" name="image" value="${cate.image }"/>
		<button type="submit">Update Category</button>
	</form>
</body>
</html>