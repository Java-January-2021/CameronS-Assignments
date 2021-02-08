<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${category.name}</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<a id="indexLink" href="/">Home</a> | <a class="link" href="/categories/show">All Categories</a>
		<h1 id="head">${category.name}</h1>
		<div id="prodByCat">
		<table>
		<thead>
			<tr>
				<th><h2 class="subHead">Products</h2></th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
			<tr>
				<td><a class="link" href="/product/${product.id}">${product.name}</a></td>
				<td><a class="link" href="/${category.id}/${product.id}/removeproduct">Remove</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div id="categoryInverseDiv">
	<h2 class="subHead">Add Products:</h2>
		<div id="addCatDiv">
			<form id="inputForm" action="/category/${category.id}" method="post">
				<div class="formDiv">
				<select class="formInput" name="product">
					<c:forEach items="${notInCategories}" var="product">
						<option value="${product.id}">${product.name}</option>
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