<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${person.firstName}'s Info</title>
<link rel="stylesheet" href="/css/styleInfo.css">
</head>
<body>
	<div id=wrapper>
	 	<a id="addPersonLink" href="/person/new">Add Person</a>
		<h1>${person.firstName} ${person.lastName}</h1>
		<c:choose>
			<c:when test="${person.license !=null }">			
			<h3>License Number:</h3>
			<p><c:out value="${person.number}"/></p>
			<h3>Exp. Date:</h3>
			<p><c:out value="${person.expirationDate}"/></p>
			<h3>State:</h3>
			<p><c:out value="${person.state}"/></p>
			</c:when>
			<c:otherwise>
			<a id="addLicenseLink" href="/license/new">Add License</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>