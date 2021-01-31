<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books!</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id=wrapper>
<h1>All Books</h1>
<table id="booksTable">
    <thead>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Description</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${books}" var="book">
        <tr>
            <td><a id="infoLink" href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.description}"/></td>
            <td class="bookDisplay"><c:out value="${book.language}"/></td>
            <td class="bookDisplay"><c:out value="${book.numberOfPages}"/></td>
            <td><a id="deleteLink" href="/delete/${book.id}">Delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a id="pageLink" href="/books/new">New Book</a>
</div>
</body>
</html>