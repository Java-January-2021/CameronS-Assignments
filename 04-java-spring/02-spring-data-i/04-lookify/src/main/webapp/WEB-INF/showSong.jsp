<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${song.name}"/> Info</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
		<a id="pageLink" href="/dashboard">Dashboard</a>
		<h1><c:out value="${song.name}"/></h1>
		<h2 class="info"><span class="infoHead">Artist:</span> <c:out value="${song.artist}"/></h2>
		<h2 class="info"><span class="infoHead">Rating:</span> <c:out value="${song.rating}"/></h2>
		<a id="pageLink" href="/song/${song.id}/delete">Delete</a>
	</div>
</body>
</html>