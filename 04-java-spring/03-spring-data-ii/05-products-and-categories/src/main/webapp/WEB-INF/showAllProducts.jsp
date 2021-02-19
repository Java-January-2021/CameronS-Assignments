<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<a id="indexLink" href="/">Home</a>
		<h1 id="head">All Products</h1>
		<a class="indexLink" href="/products/new">Create A Product</a>
		<table id="productDisplay">
		<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
			<tr>
				<td><a class="link" href="/product/${product.id}">${product.name}</a></td>
				<td>${product.description}</td>
				<td>$${product.price}</td>
				<td><a class="link" href="/product/${product.id}/delete">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>