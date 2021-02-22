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
	<a class="indexLink" href="/">Main</a> | <a class="additionalLink" href="/questions/new">Ask a Question</a>
		<h1 id="head">Questions Dashboard</h1>
		<table id="questionDisplay">
		<thead>
			<tr>
				<th class="tableHead">Actions</th>
				<th class="tableHead">Question</th>
				<th class="tableHead">Tags</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allQuestions}" var="question">
			<tr>
				<td><a class="tableLink" href="/${question.id}/delete">Delete</a>
				<td class="questionTd"><a id="infoLink" href="/question/${question.id}">${question.question}</a></td>
				<c:forEach items="${question.tags}" var="tag">
					<td class="tagTd">${tag.subject}</td>
				</c:forEach>
			</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
</body>
</html>