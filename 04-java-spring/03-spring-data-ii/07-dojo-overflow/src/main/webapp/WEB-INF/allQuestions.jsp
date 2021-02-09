<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Questions Dashboard</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<a class="indexLink" href="/">Main</a>
		<h1 id="head">Questions Dashboard</h1>
		<table id="questionDisplay">
		<thead>
			<tr>
				<th class="tableHead">Question</th>
				<th class="tableHead">Tags</th>
				<th class="tableHead">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allQuestions}" var="question">
			<tr>
				<td>${question.question}</td>
				<td>${question.tags}</td>
				<td><a class="tableLink" href="">Delete</a> | <a class="tableLink" href="">Update</a></td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
		<a class="indexLink" href="/questions/new">Ask a Question</a>
	</div>
</body>
</html>