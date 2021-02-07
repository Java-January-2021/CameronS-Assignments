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
		<h1 id="head">Products and Categories</h1>
		<h3 id="subHead">Many to Many Relationships</h3>
		<a class="indexLink" href="/products/show">Show All Products</a>
		<a class="indexLink" href="/categories/show">Show All Categories</a>
	</div>
</body>
</html>