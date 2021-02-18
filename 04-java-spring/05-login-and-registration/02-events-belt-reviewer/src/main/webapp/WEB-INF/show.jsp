<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${event.eventName}</title>
<link rel="stylesheet" href="/css/showStyle.css">
</head>
<body>
	<div id=wrapper>
	<a id="wallLink" href="/events">All Events</a>
		<h1 id="head">${event.eventName}</h1>
		<div id="infoDiv">
		<h3 class="displaySubHead">Host:<span class="displayInfo"> ${event.host.firstName}</span></h3>
		<h3 class="displaySubHead">Date:<span class="displayInfo"> ${event.eventDate}</span></h3>
		<h3 class="displaySubHead">Location:<span class="displayInfo"> ${event.eventLocation}</span></h3>
		<h2 class="displaySubHead">Attendees:<span id="displayCount"> ${aCount}</span></h2>
		<table id="aTable">
		<tbody>
		<c:forEach items="${attendees}" var="user">
			<tr>
			<td class="nData">${user.firstName} ${user.lastName}</td>
			<td class="lData">${user.location}</td>
			</tr>
		</c:forEach>
		</tbody>
		</table>
		</div>
		<div id="messageDiv">
		<c:forEach items="${messages}" var="m">
		 <p id="mDisplay">${m.user.firstName}: ${m.messageContent}</p>
		</c:forEach>
		</div>
		<div id="addMessage">
		<h4 id="mInputHead">Add A Message:</h4>
<%-- 		<form:form method="post" action="/addMessage/${event.id}" modelAttribute="message"> --%>
<%-- 		<form:hidden value="${event.id}" path="event"/> --%>
<%-- 		<form:hidden value="${currentUser.id}" path="user"/> --%>
<%-- 		<form:input class="messInput" path="messageContent"/> --%>
<!-- 		<input id="button" type="submit" value="Submit"/> -->
<%-- 		</form:form> --%>
			<form action="/events/${event.id}" method="post">
			<input type="hidden" value="${event.id}" name="event"/>
			<input type="hidden"value="${currentUser.id}" name="host"/>
			<input type="text" class="messInput" name="messageContent"/>
			<input id="button" type="submit" value="Submit"/>
			</form>
		</div>
	</div>
</body>
</html>