<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question #${question.id}</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<a  class="indexLink" href="/">Main</a> | <a class="additionalLink" href="/dashboard">Dashboard</a>
		<h1 id="head">${question.question}</h1>
		<div id="tagsDisplay">
		<h2 id="qDisplayHead">Tags:</h2>
			<c:forEach items="${question.tags}" var="tag">
				<p class="qDisplayTag">${tag.subject}</p>
			</c:forEach>
		</div>
		<table id="answerDisplay">
		<thead>
			<tr>
				<th class="tableHead"><h3>Answers</h3></th>
<!-- 			<th class="tableHead">Actions</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${question.answers}" var="answers">
			<tr>
				<td class="answerTd">${answers.answer}</td>
<!-- 			<td><a class="tableLink" href="">Delete</a> | <a class="tableLink" href="">Update</a></td> -->
			</tr>
			</c:forEach>
		</tbody>
		</table>
		<form:form id="answerForm" action="/question/${question.id}" method="post" modelAttribute="answer">
		        <form:errors id="validations" path="answer"/>
		    <div class="formDiv">
		        <form:label path="answer">Answer</form:label>
		        <form:input  class="answerInput" path="answer"/>
		    </div>
		    <input id="button" type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>