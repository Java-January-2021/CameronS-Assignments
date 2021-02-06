<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a Ninja</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<a id="pageLink" href="/">Dashboard</a>
		<h1 id="title2">New Ninja</h1>
		<form:form id="inputForm" action="/ninja/new" method="post" modelAttribute="ninja">
		<div class="formDiv">
	        <form:label class="formLabel" path="firstName">First Name:</form:label>
	        <form:input class="formInput" path="firstName"/>
	        <form:errors class="validation" path="firstName"/>
	    </div>
	    <div class="formDiv">
	        <form:label class="formLabel" path="lastName">Last Name:</form:label>
	        <form:input class="formInput" path="lastName"/>
	        <form:errors class="validation" path="lastName"/>
	    </div>
	    <div class="formDiv">
	        <form:label class="formLabel" path="age">Age:</form:label>
	        <form:input type="number" path="age" min="1" max="150"/>
	        <form:errors class="validation" path="age"/>
	    </div>
	    <div class="formDiv">
	    	<form:select class="formInput" path="dojo">
				<c:forEach items="${allDojos}" var="dojo">
					<form:option value="${dojo.id}">${dojo.name}</form:option>
				</c:forEach>
			</form:select>
	    </div>
	    <input id="button" type="submit" value="Submit"/>
	</form:form>
	</div>
</body>
</html>