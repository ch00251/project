<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String m=(String)session.getAttribute("boardAdd");

	if(m!=null){//회원가입 정보 있음
%>		
	<script type="text/javascript">
		alert("<%=m%>");
	</script>
<%	
	session.removeAttribute("boardAdd");
	} 
%>
<%
	String mesg=(String)session.getAttribute("deleteBoard");

	if(mesg!=null){//회원가입 정보 있음
%>		
	<script type="text/javascript">
		alert("<%=mesg%>");
	</script>
<%	
	session.removeAttribute("deleteBoard");
	} 
%>
</head>
<body>
<div class="container">
<jsp:include page="common/top.jsp" flush="true"/><br>
<jsp:include page="common/menu.jsp" flush="true"/>
<hr style="border:solid 5px #00a000;" width = 100% >
<br>
<jsp:include page="board/boardList.jsp" flush="true"/>
</div>
</body>
</html>