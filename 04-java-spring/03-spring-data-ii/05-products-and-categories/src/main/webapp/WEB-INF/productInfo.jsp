<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${product.name}</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<a id="indexLink" href="/">Home</a> | <a class="link" href="/products/show">All Products</a>
		<h1 id="head">${product.name}</h1>
		<div id="catByProd">
		<table>
		<thead>
			<tr>
				<th><h2 class="subHead">Categories</h2></th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categories}" var="category">
			<tr>
				<td><a class="link" href="/category/${category.id}">${category.name}</a></td>
				<td><a class="link" href="/${product.id}/${category.id}/removecategory">Remove</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div id="productInverseDiv">
	<h2 class="subHead">Add Category:</h2>
		<div id="addCatDiv">
			<form id="inputForm" action="/product/${product.id}" method="post">
				<div class="formDiv">
				<select class="formInput" name="category">
					<c:forEach items="${notInCategories}" var="category">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
				</div>
				<div class="formDiv">
				<input id="button" type="submit" value="Add"/>
				</div>
			</form>
		</div>
	</div>
	</div>
</body>
</html>