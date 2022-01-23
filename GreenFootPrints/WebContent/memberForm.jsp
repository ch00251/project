<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page = "common/top.jsp" flush = "true"></jsp:include>
	<br>
	<jsp:include page = "common/menu.jsp" flush = "true"></jsp:include>
	<hr style="border:inset 5px green;" width = 90% >
	<jsp:include page="./member/memberForm.jsp"></jsp:include>
</body>
</html>