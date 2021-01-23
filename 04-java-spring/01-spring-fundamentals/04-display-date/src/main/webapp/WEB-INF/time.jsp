<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Time</title>
<link rel="stylesheet" href="/css/style.css"/>
<script type="text/javascript" src="js/time.js"></script>
</head>
<body>
<div id=wrapper>
	<a id=indexLink href="/">Go Back</a>
	<h1 id=date> <c:out value="${timeNow}"/> </h1>
</div>
</body>
</html>