<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<%-- <form action="update" method="post" >
		<label>Name</label> <input type="text" name="cateName"  value="${cate.cateName }"/> <label>Image</label>
		<input type="text" name="image" value="${cate.image }"/>
		<button type="submit">Update Category</button>
	</form> --%>
	<div class="container">
		<form action="insert" method="post">
			<div class="form-group">
				<label>Name</label> <input name="cateName" value="${cate.getCateName() }" class="form-control"
					placeholder="Enter name...">
			</div>
			<div class="form-group">
				<label>Image</label> <input name="image" value="${cate.getImage() }" class="form-control"
					placeholder="Enter image...">
			</div>
			<button type="submit" class="btn btn-primary">Update</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>