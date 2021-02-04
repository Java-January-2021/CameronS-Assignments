<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify Dash Board</title>
<link rel="stylesheet" href="/css/dashStyle.css">
</head>
<body>
	<div id=wrapper>
	<a id="pageLink" href="/songs/new">Add New</a>
	<a id="pageLink" href="/topTen">Top Songs</a>
	<div id="inputForm">
	<form action="/search" method="post">
	<input type="text" name="artist">
	<input id="button" type="submit" value="Search"/>
	</form>
	</div>
	<h1>Songs</h1>
	<table id="songDisplay">
		<thead>
			<tr>
				<th>Name</th>
				<th>Artist</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${songList}" var="song">
			<tr>
				<td><a class="link" href="/song/${song.id}"><c:out value="${song.name}"/></a></td>
				<td><c:out value="${song.artist}"/></td>
				<td><c:out value="${song.rating}"/></td>
				<td><a class="link" href="/song/${song.id}/delete">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>