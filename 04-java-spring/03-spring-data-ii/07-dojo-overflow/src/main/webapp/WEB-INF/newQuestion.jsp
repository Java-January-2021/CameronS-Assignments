<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Question</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<a  class="indexLink" href="/">Main</a> | <a class="additionalLink" href="/dashboard">Dashboard</a>
		<h1 id="head">What is your Question?</h1>
		<hr>
		<c:forEach items="${errors}" var="err">
		<h4>${err}</h4>
		</c:forEach>
		<hr>
		<form id="inputForm" action="/questions/new" method="post">
		<div class="formDiv">
	        <label class="formLabel" for="question">Question:</label>
	        <input id="questionInput" type="text" name="question"/>
	    </div>
	    <div class="formDiv">
	        <label class="formLabel" for="tags">Tag:</label>
	        <input class="formInput" type="text" name="tags"/>
	    </div>
	    <input id="button" type="submit" value="Submit"/>
	</form>
	</div>
</body>
</html>