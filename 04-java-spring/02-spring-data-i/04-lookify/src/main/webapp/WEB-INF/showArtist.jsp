<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${artist}"/></title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
		<a id="pageLink" href="/dashboard">Dashboard</a>
		<h1>Songs by <c:out value="${artist}"/></h1>
		<table id="songDisplay">
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${songList}" var="song">
			<tr>
				<td><a class="link" href="/song/${song.id}"><c:out value="${song.name}"/></a></td>
				<td><c:out value="${song.rating}"/></td>
				<td><a class="link" href="/">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>