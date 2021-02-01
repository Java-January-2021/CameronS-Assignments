<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit <c:out value="${lang.name}"/> Info</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
		<h1><c:out value="${lang.name}"/></h1>
		<a id="pageLink" href="/languages">Go Back</a>
		<form:form id="inputForm" action="/languages/${lang.id}/edit" method="post" modelAttribute="language">
			<p>
		        <form:label path="name">Name:</form:label>
		        <form:input path="name" value="${lang.name}"/>
		        <form:errors class="validation" path="name"/>
		    </p>
		    <p>
		        <form:label path="creator">Creator:</form:label>
		        <form:input path="creator" value="${lang.creator}"/>
		        <form:errors class="validation" path="creator"/>
		    </p>
		    <p>
		        <form:label path="version">Version:</form:label>
		        <form:input path="version" value="${lang.version}"/>
		        <form:errors class="validation" path="version"/>
		    </p>
		    <input id="button" type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>