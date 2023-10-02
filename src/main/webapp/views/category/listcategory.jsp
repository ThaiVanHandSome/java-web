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
		<van:if test="${message != null || error != null}">
			<div class="modal fade" role="dialog" aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h1 class="modal-title">
								<van:if test="${message != null}">${message }</van:if>
								<van:if test="${error != null}">${error }</van:if>
							</h1>
						</div>
					</div>
				</div>
			</div>
		</van:if>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr class="table-primary">
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<van:forEach var="item" items="${listcate}">
					<tr>
						<td>${item.getCateID() }</td>
						<td>${item.getCateName() }</td>
						<td><a
							href="/Website_Tuan2_Hello/category/update?id=${item.getCateID()}">Update</a>
							<a
							href="/Website_Tuan2_Hello/category/delete?id=${item.getCateID()}">Delete</a>
						</td>
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