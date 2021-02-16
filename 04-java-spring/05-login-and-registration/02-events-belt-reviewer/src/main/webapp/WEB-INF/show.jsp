<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${event.eventName}</title>
<link rel="stylesheet" href="/css/dashStyle.css">
</head>
<body>
	<div id=wrapper>
	<a id="logOutLink" href="/wall">All Events</a>
		<div id="infoDiv">
		<h1 id="head">${event.eventName}</h1>
		<h3>Host: ${event.user.firstName}</h3>
		<h3>Date: ${event.eventDate}</h3>
		<h3>Locatoin: ${event.eventLocation}</h3>
		<h2>Attendees: ${aCount}</h2>
		<table id="aTable">
		<tbody>
		<c:forEach items="${attendees}" var="user">
			<tr>
			<td>${user.firstName} ${user.lastName}</td>
			<td>${user.location}</td>
			</tr>
		</c:forEach>
		</tbody>
		</table>
		</div>
		<div id="messageDiv">
		<c:forEach items="messages" var="m">
<%-- 		 <p>${m.messageContent}</p> --%>
		</c:forEach>
		</div>
	</div>
</body>
</html>