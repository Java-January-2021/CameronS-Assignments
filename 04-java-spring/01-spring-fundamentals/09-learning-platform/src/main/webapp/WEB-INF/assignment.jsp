<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fortran!</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
		<div id=navBar>
			<h1>Fortran!</h1>
			<p class=navButton><a class=pageLink href="/m/38/0553/0733">Set UP</a></p><span> | </span>
			<p class=navButton><a class=pageLink href="/m/38/0483/0345">Forms</a></p><span> | </span>
			<p class=navButton><a class=pageLink href="/m/38/0553/0342">Cards</a></p><span> | </span>
			<p class=navButton><a class=pageLink href="/m/26/0553/0348">Advanced</a></p><span> | </span>
			<p class=navButton><a class=pageLink href="/m/26/0483/2342">Binary</a></p><span> | </span>
			<p class=navButton><a class=pageLink href="/">Go Back</a></p>
		</div>
		<div id=lessonPlaceholder>
		<input type="checkbox">Assignment Complete
			<p><c:out value="${filler}"></c:out></p>
		</div>
	</div>
</body>
</html>