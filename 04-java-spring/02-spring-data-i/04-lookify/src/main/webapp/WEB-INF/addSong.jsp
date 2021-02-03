<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Song</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
		<a id="pageLink" href="/dashboard">Dashboard</a>
		<h1>Add Song</h1>
		<form:form id="inputForm" action="/songs/new" method="post" modelAttribute="song">
		<p>
	        <form:label class="formLabel" path="name">Name:</form:label>
	        <form:input class="formInput" path="name"/>
	        <form:errors class="validation" path="name"/>
	    </p>
	    <p>
	        <form:label class="formLabel" path="artist">Artist:</form:label>
	        <form:input class="formInput" path="artist"/>
	        <form:errors class="validation" path="artist"/>
	    </p>
	    <p>
	        <form:label class="formLabel" path="rating">Rating:</form:label>
	        <form:input type="number" path="rating" min="1" max="10"/>
	        <form:errors class="validation" path="rating"/>
	    </p>
	    <input id="button" type="submit" value="Submit"/>
	</form:form>
	</div>
</body>
</html>