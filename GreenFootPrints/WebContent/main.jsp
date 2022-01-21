<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GreenFootPrints</title>
	</head>
	<body>
		<div class="container">
		<jsp:include page = "common/top.jsp" flush = "true"></jsp:include>
		<br>
		<jsp:include page = "common/menu.jsp" flush = "true"></jsp:include>
		<hr style="border:solid 5px #00a000;" width = "100%" >
		<br>
		<br>
	    <jsp:include page = "common/search.jsp" flush = "true"></jsp:include>
	    </div>


	<c:if test="${sessionID == null }">
	
	</c:if>
	<c:if test="${sessionID != null }">
	${sessionID }

	</c:if>
</body>
</html>