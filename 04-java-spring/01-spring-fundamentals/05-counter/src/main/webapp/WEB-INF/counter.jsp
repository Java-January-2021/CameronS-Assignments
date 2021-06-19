<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Counter APP</title>
<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div id=wrapper>
	<c:choose>
		<c:when test="${count == null}" >
			<h2 class ="head">The count has been reset</h2>
		</c:when>
		<c:otherwise>
			<h2 class ="head">You have visited <c:out value="${count}"/> times.</h2>
		</c:otherwise>
	</c:choose>
	<div id=divLink>
		<a class=pageLink href="/">Visit Again</a><p>|</p><a class=pageLink href="/twice">Visit Twice</a><p>|</p><a class=pageLink href="/reset">Reset Count</a>
	</div>
	</div>
</body>
</html>