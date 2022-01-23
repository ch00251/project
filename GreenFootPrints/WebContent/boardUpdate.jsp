<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<jsp:include page="common/top.jsp" flush="true"/><br>
<jsp:include page="common/menu.jsp" flush="true"/>
<hr style="border:solid 5px #00a000;" width = 100% >
<br>
<jsp:include page="board/boardUpdate.jsp" flush="true"/>
</div>
</body>
</html>