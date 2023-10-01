<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="van"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Category</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr class="table-primary">
					<th scope="col">Id</th>
					<th scope="col">Name</th>
				</tr>
			</thead>
			<tbody>
				<van:forEach var="item" items="${listcate}">
					<tr>
						<td><a
							href="/Website_Tuan2_Hello/findOne?cateID=${item.getCateID()}">${item.getCateID()}</a></td>
						<td>${item.getCateName() }</td>	
					</tr>
				</van:forEach>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>