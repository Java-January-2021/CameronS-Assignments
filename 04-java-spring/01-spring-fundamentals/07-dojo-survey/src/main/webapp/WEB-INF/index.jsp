<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
		<h1>Dojo Survey</h1>
		<div id=formInput>
			<form action="/result" method="post">
				<p>Your Name: <input id=nameInput name="username" type="text"></p>
	            <p>Dojo Location: <select name="locationInput" id="locationInput">
	                <option value="san jose">San Jose</option>
	                <option value="tulsa">Tulsa</option>
	                <option value="seattle">Seattle</option>
	                <option value="oakland">Oakland</option>
	                <option value="boise">Boise</option>
	                <option value="chicago">Chicago</option>
	            </select></p>
	            <p>Favorite Language: <select name="languageInput" id="languageInput">
	                <option value="java">Java</option>
	                <option value="ruby">Ruby</option>
	                <option value="c#">C#</option>
	                <option value="python">Python</option>
	                <option value="javascript">JavaScript</option>
	                <option value="html">HTML</option>
	                <option value="css">CSS</option>
	            </select></p>
	            <p id=comment>Comment (Optional): </p>
	            <textarea id=commentInput name="commentInput" rows=10 cols=40 ></textarea>
	            <button id=button>Submit</button>
        	</form>	
		</div>
	</div>
</body>
</html>