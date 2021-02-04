<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add People</title>
<link rel="stylesheet" href="/css/styleNewPerson.css">
</head>
<body>
	<div id=wrapper>
		<a id="addLicenseLink" href="/license/new">New License</a>
		<h1>New Person</h1>
		<div id="inputDiv">
			<form:form id="inputForm" action="/person/add" method="post" modelAttribute="person">
				<div class="formDiv">
					<form:label class="formLabel" path="firstName">First Name:</form:label>
					<form:input class="formInput" path="firstName"/>
					<form:errors class="validation" path="firstName"></form:errors>
				</div>
				<div class="formDiv">
					<form:label class="formLabel" path="lastName">Last Name:</form:label>
					<form:input class="formInput" path="lastName"/>
					<form:errors class="validation" path="lastName"></form:errors>
				</div>
				<div class="formDiv">
					<input id="button" type="submit" value="Submit"/>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>