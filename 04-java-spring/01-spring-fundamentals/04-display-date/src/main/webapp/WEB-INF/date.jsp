<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date</title>
<link rel="stylesheet" href="/css/style.css"/>
<script type="text/javascript" src="js/date.js"></script>
</head>
<body>
<div id=wrapper>
	<a id=indexLink href="/">Go Back</a>
	<h1 id=date> <c:out value="${date}"/> </h1>
</div>
</body>
</html>