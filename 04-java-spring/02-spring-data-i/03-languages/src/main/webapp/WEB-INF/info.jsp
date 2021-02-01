<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${lang.name}"/> Info</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<a id="pageLink" href="/languages">Go Back</a>
		<h1><c:out value="${lang.name}"/></h1>
		<h2>Creator: <c:out value="${lang.creator}"/></h2>
		<h2>Version: <c:out value="${lang.version}"/></h2>
		<a id="pageLink" href="/languages/${lang.id}/edit">Edit</a>
		<a id="pageLink" href="/languages/${lang.id}/delete">Delete</a>
	</div>
</body>
</html>