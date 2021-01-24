<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome!</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
		<a href="/" id=pageLink>Go Back</a>
	<div id=formInfo>
		<h2 id=javaFun>Java Rocks <c:out value="${username}"/>'s Socks!!</h2>
	</div>
	</div>
</body>
</html>