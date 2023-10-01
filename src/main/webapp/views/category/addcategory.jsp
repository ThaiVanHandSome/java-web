<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Category</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<body>
	<!-- <form action="insert" method="post">
		<label>Name</label> <input type="text" name="cateName" /> <label>Image</label>
		<input type="text" name="image" />
		<button type="submit">Add</button>
	</form> -->
	<div class="container">
		<form action="insert" method="post">
			<div class="form-group">
				<label>Name</label> <input name="cateName" class="form-control"
					placeholder="Enter name...">
			</div>
			<div class="form-group">
				<label>Image</label> <input name="image" class="form-control"
					placeholder="Enter image...">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>