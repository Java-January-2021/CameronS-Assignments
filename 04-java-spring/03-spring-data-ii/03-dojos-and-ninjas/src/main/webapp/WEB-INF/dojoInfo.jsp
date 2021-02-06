<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome!</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<a id="pageLink" href="/">Dashboard</a>
		<h1 id="title2"><c:out value="${dojo.name}"/></h1>
		<table id="ninjaDisplay">
		<thead>
			<tr>
				<th class="tableHead">First Name</th>
				<th class="tableHead">Last Name</th>
				<th class="tableHead">Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ninjas}" var="ninja">
			<tr>
				<td><c:out value="${ninja.firstName}"/></td>
				<td><c:out value="${ninja.lastName}"/></td>
				<td><c:out value="${ninja.age}"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>