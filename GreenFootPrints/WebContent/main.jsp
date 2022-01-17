<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GreenFootPrints</title>
	</head>
	<body>
	<h1>메인.jsp</h1>
		<div class="container">
		<jsp:include page = "common/top.jsp" flush = "true"></jsp:include>
		<br>
		<jsp:include page = "common/menu.jsp" flush = "true"></jsp:include>
		<hr style="border:solid 5px #00a000;" width = 90% >
		<br>
		<br>
	    <jsp:include page = "common/search.jsp" flush = "true"></jsp:include>
	    </div>
	</body>
</html>