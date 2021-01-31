<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book!</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
		<p>Title: <c:out value="${book.title}"/></p>
		<p>Description: <c:out value="${book.description}"/></p>
		<p>Written In: <c:out value="${book.language}"/></p>
		<p>Written By: <c:out value="${book.author}"/></p>
		<p>It is <c:out value="${book.numberOfPages}"/> pages long.</p>
		<a id="pageLink" href="/edit/${book.id}">Edit Book</a>
		<a id="pageLink" href="/books">Go Back</a>
	</div>
</body>
</html>