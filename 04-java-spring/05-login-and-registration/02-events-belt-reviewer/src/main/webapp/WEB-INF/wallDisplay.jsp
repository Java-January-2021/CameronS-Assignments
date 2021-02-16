<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome, ${currentUser.firstName}</title>
<link rel="stylesheet" href="/css/wallStyle.css">
</head>
<body>
	<div id=wrapper>
		<a id="logOutLink" href="/logOutUser">Log Out</a>
		<h1 id="head">Hello, ${currentUser.firstName} ${currentUser.lastName}!</h1>
		<div id="stateEventTable">
			<h2 class="subHead">Events in ${currentUser.state}</h2>
			<table>
			<thead>
			<tr>
			<th class="tHead">Name</th>
			<th class="tHead">Date</th>
			<th class="tHead">Location</th>
			<th class="tHead">Host</th>
			<th class="tHead">Action/Status</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${inStateEvents}" var="event">
				<tr>
				<td class="tData"><a id="iLink" href="/${event.id}/info">${event.eventName}</a></td>
				<td class="tData">${event.eventDate}</td>
				<td class="tData">${event.eventLocation}</td>
				<td class="tData">${event.user.firstName}</td>
				<c:choose>
					<c:when test="${currentUser.id == event.user.id}">
					<td><a class="tLink" href="/deleteEvent">Delete</a> | <a class="tLink" href="/editEvent">Edit</a></td>
					</c:when>	
					<c:otherwise>
					<c:choose>
						<c:when test="">
						<td><a class="tLink" href="">Join</a></td>
						</c:when>
						<c:otherwise>
						<td><a class="tLink" href=""> UnJoin</a></td>
						</c:otherwise>
					</c:choose>
					</c:otherwise>		
				</c:choose>
				</tr>
			</c:forEach>
			</tbody>
			</table>
		</div>
		<div id="otherEventTable">
			<h2 class="subHead">Events Not In ${currentUser.state}</h2>
			<table>
			<thead>
			<tr>
			<th class="tHead">Name</th>
			<th class="tHead">Date</th>
			<th class="tHead">Location</th>
			<th class="tHead">State</th>
			<th class="tHead">Host</th>
			<th class="tHead">Status</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${otherStateEvents}" var="event">
				<tr>
				<td><a id="iLink" href="/${event.id}/info">${event.eventName}</a></td>
				<td class="tData">${event.eventDate}</td>
				<td class="tData">${event.eventLocation}</td>
				<td class="tData">${event.eventState}</td>
				<td class="tData">${event.user.firstName}</td>
				<c:choose>
					<c:when test="">
					<td><a class="tLink" href="">Join</a></td>
					</c:when>
					<c:otherwise>
					<td>Joined |<a class="tLink" href=""> Cancel</a></td>
					</c:otherwise>
				</c:choose>
				</tr>
			</c:forEach>
			</tbody>
			</table>
		</div>
		<div id="eventForm">
			<h2 class="subHead">Create An Event</h2>
			<form:form id="inputForm" action="/add" method="post" modelAttribute="event">
		        <form:hidden value="${currentUser.id}" path="user"/>
		        <form:errors class="validation" path="eventName"/>
			<div class="formGroup">
		        <form:label class="formLabel" path="eventName">Name:</form:label>
		        <form:input class="formInput" path="eventName"/>
		    </div>
		        <form:errors class="validation" path="eventLocation"/>
		    <div class="formGroup">
		        <form:label class="formLabel" path="eventLocation">Location:</form:label>
		        <form:input class="formInput" path="eventLocation"/>
		    </div>
		        <form:errors class="validation" path="eventDate"/>
		    <div class="formGroup">
		        <form:label class="formLabel" path="eventDate">Date:</form:label>
		        <form:input type="date" path="eventDate"/>
		    </div>
		    <form:errors class="validation" path="eventState"/>
				<div class="formGroup">
					<form:label path="eventState">State:</form:label>
					<form:select class="formInput" path="eventState">
						<form:option value="CA">Californina</form:option>
						<form:option value="OR">Oregon</form:option>
						<form:option value="AZ">Arizona</form:option>
						<form:option value="CO">Colorado</form:option>
						<form:option value="TX">Texas</form:option>
					</form:select>
				</div>
	    	<input id="button" type="submit" value="Create Event"/>
			</form:form>
		</div>
	</div>
</body>
</html>