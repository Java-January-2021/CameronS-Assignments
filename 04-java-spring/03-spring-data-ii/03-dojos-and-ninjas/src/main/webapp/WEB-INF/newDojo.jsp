<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a Dojo</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<a id="pageLink" href="/">Dashboard</a>
		<h1 id="title2">New Dojo</h1>
		<form:form id="inputForm" action="/dojo/new" method="post" modelAttribute="dojo">
		<div class="formDiv">
	        <form:label class="formLabel" path="name">Name:</form:label>
	        <form:input class="formInput" path="name"/>
	        <form:errors class="validation" path="name"/>
	    </div>
	    <input id="button" type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>