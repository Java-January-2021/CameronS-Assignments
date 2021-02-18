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
	<a id="wallLink" href="/events">All Events</a>
		<h1 id="head">${event.eventName}</h1>
		<form:form id="inputForm" action="/events/${event.id}/edit" method="post" modelAttribute="event">
		        <form:hidden value="${currentUser.id}" path="host"/>
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
<%-- 			<form id="inputForm" action="/events/${event.id}/edit" method="post"> --%>
<%-- 		      <input type="hidden" value="${currentUser.id}" name="host"/> --%>
<!-- 			<div class="formGroup"> -->
<!-- 		        <label class="formLabel">Name:</label> -->
<%--  		        <input type="text" class="formInput" name="eventName" value="${event.eventName}"/> --%>
<!-- 		    </div> -->
<!-- 		    <div class="formGroup"> -->
<!-- 		        <label class="formLabel">Location:</label> -->
<%--  		        <input type="text" class="formInput" name="eventLocation" value="${event.eventLocation}"/> --%>
<!-- 		    </div> -->
<!-- 		    <div class="formGroup"> -->
<!-- 		      	<label class="formLabel">Date:</label> -->
<%--  		        <input type="date" class="formInput" name="eventDate" value="${event.eventDate}">${event.eventDate} --%>
<!-- 		    </div> -->
<!-- 			<div class="formGroup"> -->
<!-- 				<label class="formLabel">State:</label> -->
<!-- 				<select class="formInput" name="eventState"> -->
<!-- 					<option value="CA">Californina</option> -->
<!-- 					<option value="OR">Oregon</option> -->
<!-- 					<option value="AZ">Arizona</option> -->
<!-- 					<option value="CO">Colorado</option> -->
<!-- 					<option value="TX">Texas</option> -->
<!-- 				</select> -->
<!-- 			</div> -->
<!-- 	    	<input id="button" type="submit" value="UpDate Event"/> -->
<%-- 			</form> --%>
	</div>
</body>
</html>