<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top Ten</title>
<link rel="stylesheet" href="/css/dashStyle.css">
</head>
<body>
	<div id=wrapper>
	<a id="pageLink" href="/dashboard">Dashboard</a>
		<h1>Top Ten</h1>
		<table id="songDisplay">
		<thead>
			<tr>
				<th>Name</th>
				<th>Artist</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<c:forEach items="${songs}" var="song">
			<tr>
				<td><a class="link" href="/song/${song.id}"><c:out value="${song.name}"/></a></td>
				<td><c:out value="${song.artist}"/></td>
				<td><c:out value="${song.rating}"/></td>
				<td><a class="link" href="/song/${song.id}/delete">Delete</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>