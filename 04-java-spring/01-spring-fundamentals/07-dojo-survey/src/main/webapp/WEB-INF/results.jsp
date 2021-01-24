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
            <p class='P'>Name:<c:out value="${nameInput}">nameInput</c:out></p>
            <p class='P'>Dojo Location:<c:out value="${locationInput}">locationInput</c:out></p>
            <p class='P'>Favorite Language:<c:out value="${languageInput}">languageInput</c:out></p>
            <p class='P'>Comment:<c:out value="${commentInput}">commentInput</c:out></p>
        </div>
	</div>
</body>
</html>