<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Survey Results</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id=wrapper>
	<a href="/" id=pageLink>Go Back</a>
	<div id=formInfo>
		<h2>Submitted Info</h2>
		<p>Name:	<span class=span><c:out value="${username}"/></span></p>
		<p>Dojo Location:	<span class=span><c:out value="${location}"/></span></p>
		<p>Favorite Language:	<span class=span><c:out value="${language}"/></span></p>
		<p>Comment:</p><textarea id=commentOut  rows=4 cols=23 ><c:out value="${comment}"/></textarea>
	</div>
</div>
</body>
</html>