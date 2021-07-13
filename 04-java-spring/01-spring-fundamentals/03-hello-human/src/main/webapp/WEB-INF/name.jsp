<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello... <c:out value="${name}"/> <c:out value="${lastName}"/></title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
		<h1 class=greeting>Hello <c:out value="${name}"/> <c:out value="${lastName}"/></h1>
		<h2 class=greeting>Welcome to Spring Boot!</h2>
	</div>
</body>
</html>