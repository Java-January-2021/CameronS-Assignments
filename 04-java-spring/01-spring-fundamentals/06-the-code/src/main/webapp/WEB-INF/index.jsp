<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Code</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
		<h1>You Must Train Harder!</h1>
		<h2>What is the code?</h2>
		<form id=inputForm action="/inputForm" method=POST>
			<input type="text" name="input">
			<button>Try Code</button>
			<p id=error><span><c:out value="${ error }" /></span></p>
		</form>
	</div>
</body>
</html>