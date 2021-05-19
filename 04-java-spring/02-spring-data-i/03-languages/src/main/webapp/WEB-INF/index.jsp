<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Code Languages</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id=wrapper>
	<h1>Code Languages</h1>
	<table id="langDisplay">
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${langList}" var="lang">
			<tr>
				<td><a id="nameLink" href="/languages/${lang.id}"><c:out value="${lang.name}"/></a></td>
				<td><c:out value="${lang.creator}"/></td>
				<td><c:out value="${lang.version}"/></td>
				<td><a id="nameLink" href="/languages/${lang.id}/edit">Edit</a> | <a id="nameLink" href="/languages/${lang.id}/delete">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<form:form id="inputForm" action="/languages" method="post" modelAttribute="language">
		<p>
	        <form:label class="formLabel" path="name">Name:</form:label>
	        <form:input class="formInput" path="name"/>
	        <form:errors class="validation" path="name"/>
	    </p>
	    <p>
	        <form:label class="formLabel" path="creator">Creator:</form:label>
	        <form:input class="formInput" path="creator"/>
	        <form:errors class="validation" path="creator"/>
	    </p>
	    <p>
	        <form:label class="formLabel" path="version">Version:</form:label>
	        <form:input class="formInput" path="version"/>
	        <form:errors class="validation" path="version"/>
	    </p>
	    <input id="button" type="submit" value="Submit"/>
	</form:form>
</div>
</body>
</html>