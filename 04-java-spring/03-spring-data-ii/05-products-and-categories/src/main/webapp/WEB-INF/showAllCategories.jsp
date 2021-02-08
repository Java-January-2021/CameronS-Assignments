<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<a id="indexLink" href="/">Home</a>
		<h1 id="head">All Categories</h1>
		<a class="indexLink" href="/categories/new">Create a Category</a>
		<table id="categoryDisplay">
		<thead>
			<tr>
				<th>Name</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categories}" var="category">
			<tr>
				<td><a class="link" href="/category/${category.id}">${category.name}</a></td>
				<td><a class="link" href="/category/${category.id}/delete">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>