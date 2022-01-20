<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쓰레기 등록하기</title>
</head>
<body>
	<jsp:include page = "common/top.jsp" flush = "true"></jsp:include>
	<br>
	<jsp:include page = "common/menu.jsp" flush = "true"></jsp:include>
	<hr style="border:inset 5px green;" width = 90% >
	<jsp:include page="./trashAdd/trashAddForm.jsp"></jsp:include>
</body>
</html>