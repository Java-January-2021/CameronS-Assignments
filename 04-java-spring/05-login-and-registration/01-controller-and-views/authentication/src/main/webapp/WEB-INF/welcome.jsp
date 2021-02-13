<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome ${user.firstName}!</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<a id="logOutLink" href="/logOutUser">Log Out</a>
		<h1 id="head">Hello ${user.firstName} ${user.lastName}</h1>
		<h2 class="subHead">${user.email}</h2>
	</div>
</body>
</html>