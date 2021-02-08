<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<a id="indexLink" href="/">Home</a>
		<h1 id="head">New Product</h1>
		<form:form id="productForm" action="/products/new" method="post" modelAttribute="product">
		<div class="formDiv">
	        <form:label class="formLabel" path="name">Name:</form:label>
	        <form:input class="formInput" path="name"/>
	        <form:errors class="validation" path="name"/>
	    </div>
	    <div class="formDiv">
	        <form:label class="formLabel" path="description">Description:</form:label>
	        <form:input class="formInput" path="description"/>
	        <form:errors class="validation" path="description"/>
	    </div>
	    <div class="formDiv">
	        <form:label class="formLabel" path="price">Price:</form:label>
	        <form:input class="formInput" path="price"/>
	        <form:errors class="validation" path="price"/>
	    </div>
	    <input id="button" type="submit" value="Submit"/>
	</form:form>
	<a class="indexLink" href="/products/show">Show All Products</a>
	</div>
</body>
</html>