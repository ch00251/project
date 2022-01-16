<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String mesg=(String)session.getAttribute("boardAdd");
	
	if(mesg!=null){//회원가입 정보 있음
		%>		
		<script type="text/javascript">
			alert("<%=mesg%>");
		</script>
		<%	
		session.removeAttribute("boardAdd");
	} 
%>
</head>
<body>
<div class="container">
<jsp:include page="common/top.jsp" flush="true"/><br>
<jsp:include page="common/menu.jsp" flush="true"/>
<hr>
<br>
<jsp:include page="board/boardList.jsp" flush="true"/>
</div>
</body>
</html>