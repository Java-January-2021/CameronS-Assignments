<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add License</title>
<link rel="stylesheet" href="/css/styleNewLicense.css">
</head>
<body>
	<div id=wrapper>
	<a id="addPersonLink" href="/person/new">Add Person</a>
		<h1>New License</h1>
		<c:forEach items="${errors}" var="err">
		<hr>
		<h4 class="validation">${err}</h4>
		<hr>
		</c:forEach>
		<div id="inputDiv">
			<form:form id="inputForm" action="/license/add" method="post" modelAttribute="license">
				<div class="formDiv">
					<form:label class="formLabel" path="person">Person:</form:label>
					<form:select class="formInput" path="person">
						<c:forEach items="${allPeople}" var="person">
							<c:choose>
							<c:when test="${person.license ==null }">
							<form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
							</c:when>
							</c:choose>
						</c:forEach>
					</form:select>
					<form:errors class="validation" path="person"></form:errors>
				</div>
				<div class="formDiv">
					<form:label class="formLabel" path="expirationDate">Exp. Date:</form:label>
					<form:input type="date" class="formInput" path="expirationDate"/>
					<form:errors class="validation" path="expirationDate"></form:errors>
				</div>
				<div class="formDiv">
					<form:label class="formLabel" path="state">State:</form:label>
					<form:input class="formInput" path="state"/>
					<form:errors class="validation" path="state"></form:errors>
				</div>
				<div class="formDiv">
					<input id="button" type="submit" value="Submit"/>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>