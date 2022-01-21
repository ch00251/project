<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 상세 화면입니다.</title>
<%
	String m=(String)session.getAttribute("updateBoard");

	if(m!=null){//회원가입 정보 있음
%>		
	<script type="text/javascript">
		alert("<%=m%>");
	</script>
<%	
	session.removeAttribute("updateBoard");
	} 
%>
</head>
<body>
<div class="container">
<jsp:include page="common/top.jsp" flush="true"/><br>
<jsp:include page="common/menu.jsp" flush="true"/>
<hr style="border:solid 5px #00a000;" width = 100% >
<jsp:include page="board/boardsRetrieve.jsp" flush="true"/>
</div>
</body>
</html>