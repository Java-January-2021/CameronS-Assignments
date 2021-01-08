<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Ninja Gold</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1>Ninja Gold</h1>
<h3>Your Gold: <c:out value="${totalGold}"/></h3>



<c:forEach items="${myBuildings}" var="building">
<div class="building">
<h3><c:out value="${building.getName()}" /></h3>
<p>(earns <c:if test="${building.getCanLose()}"> / Loses</c:if><c:out value="${building.getMin()}" />- <c:out value="${building.getMax()}" /> gold)</p>
<form method="post" action="/getGold">
<input type="hidden" name="building" value="<c:out value="${building.getName()}" />">
<button>Find Gold!</button>
</form>
</div>
</c:forEach>

<h3>Activities:</h3>
<div class="activities">

<c:forEach var="activity" items="${activityLog }">


<p class='${activity.contains("lost")? "red":"green"}'><c:out value="${activity}"/></p>
</c:forEach>
</div>
</body>
</html>
