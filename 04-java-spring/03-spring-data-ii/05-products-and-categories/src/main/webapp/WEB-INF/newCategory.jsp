<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<a id="indexLink" href="/">Home</a>
		<h1 id="head">New Category</h1>
		<form:form id="categoryForm" action="/categories/new" method="post" modelAttribute="category">
		<div class="formDiv">
	        <form:label class="formLabel" path="name">Name:</form:label>
	        <form:input class="formInput" path="name"/>
	        <form:errors class="validation" path="name"/>
	    </div>
	    <input id="button" type="submit" value="Submit"/>
	</form:form>
	<a class="indexLink" href="/categories/show">Show All Categories</a>
	</div>
</body>
</html>