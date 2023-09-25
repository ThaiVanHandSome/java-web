<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="van" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<van:forEach var="item" items="${listcate}">
		<a href="/Website_Tuan2_Hello/findOne?cateID=${item.cateID}">${item.cateID}</a>
		<t>
		${item.cateName }
		<br>
	</van:forEach>
</body>
</html>