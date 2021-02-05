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
		<div id="displayDiv">
		<c:choose>
			<c:when test="${person.license !=null }">			
			<h3 class="displayHead">License Number:</h3>
			<p class="displayInfo">0000000<c:out value="${person.license.id}"/></p>
			<h3 class="displayHead">Exp. Date:</h3>
			<p class="displayInfo"><c:out value="${expDate}"/></p>
			<h3 class="displayHead">State:</h3>
			<p class="displayInfo"><c:out value="${person.license.state}"/></p>
			</c:when>
			<c:otherwise>
			<a id="addLicenseLink" href="/license/new">Add License</a>
			</c:otherwise>
		</c:choose>
		</div>
	</div>
</body>
</html>