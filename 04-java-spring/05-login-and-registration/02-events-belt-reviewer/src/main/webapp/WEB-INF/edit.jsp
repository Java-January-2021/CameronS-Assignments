<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${event.eventName}</title>
<link rel="stylesheet" href="/css/editStyle.css">
</head>
<body>
	<div id=wrapper>
	<a id="wallLink" href="/wall">All Events</a>
		<h1 id="head">${event.eventName}</h1>
		<form:form id="inputForm" action="/${event.id}/edit" method="post" modelAttribute="event">
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
	    	<input id="button" type="submit" value="UpDate Event"/>
			</form:form>
		
	</div>
</body>
</html>