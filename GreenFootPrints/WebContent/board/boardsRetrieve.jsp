<%@page import="java.util.List"%>
<%@page import="com.dto.CommentDTO"%>
<%@page import="com.dto.MemberDTO"%>
<%@page import="com.dao.BoardsDAO"%>
<%@page import="com.dto.BoardsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.bottom{
		display: table;
  		margin-left: auto;
 		margin-right: auto;
	}
	.comments{
		display: table;
  		margin-left: auto;
 		margin-right: auto;
	}
	.bottom .btn{
		margin:10px;
	}
	ul{
		margin:0; 
		padding:0;
	}
	li{
		display: inline;
	}
	th{
		width: 10%;
		background-color: #93bf85;
	}
	.contents{
		height: 200px;
	}
	textarea{
		width: 800px;
		height: 50px;
	}
</style>
</head>
<body>
<div class="container">
<%
	BoardsDTO dto=(BoardsDTO)request.getAttribute("dto");
	int num=dto.getNum();
	String userid=dto.getUserid();
	String title=dto.getTitle();
	String content=dto.getContent();
	String regdate=dto.getRegdate();
	int viewCount=dto.getViewCount();
%>
<p style="display:table; margin-left: auto; margin-right: auto;">글 상세 페이지</p>
<table width="80%" border="1" style="display:table;margin-left: auto; margin-right: auto;" >
	<tr>
		<th>제목</th>
		<td><%=title %></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><%=userid%></td>
	</tr>
	<tr>
		<td colspan="2">
			<ul>
			  <li>
			  	<strong>작성일</strong>
			  	<span><%=regdate %></span>
			  </li>
			  <li>
			  	<strong>조회수</strong>
			  	<span><%=viewCount %></span>
			  </li>		  
			</ul>
		</td>
	</tr>
	<tr>
		<td colspan="2"><div class="contents"><%=content %></div></td>
	</tr>
</table>
<div class="comments">
	<%
		List<CommentDTO> list=(List<CommentDTO>)request.getAttribute("cList");
		System.out.println("clist:"+list);
		for(int i=0; i<list.size(); i++){
			CommentDTO d=list.get(i);
			String writer=d.getWriter();
			String con=d.getContent();			
	%>
	<table>
		<tr>
			<th><%=writer %></th>
			<td><%=con %></td>
		</tr>
	</table>
	<%} %>
	<!-- 원글에 댓글을 작성할수 있는 폼 -->
	<div class="comment_form">
		<form action="CommentInsertServlet" method="post">
		<input type="hidden" value="<%=userid %>" name="userid">
		<input type="hidden" value="<%=num %>" name="num">
			<!-- 댓글의 그룹번호는 원글의 글번호가 된다.  -->
		<input type="hidden" name="ref_group" value="<%=num%>"/>
			<!-- 댓글의 대상자는 원글의 작성자가 된다. -->
		<input type="hidden" name="target_id" value="<%=userid%>"/>
		<textarea name="content"></textarea>
		<button style="margin-bottom:40px; " class="btn btn-outline-dark" type="submit">등록</button>
		</form>
	</div>
</div>
<div class="bottom">
<%
	MemberDTO d=(MemberDTO)session.getAttribute("login");
	String id=d.getUserid();
	System.out.println(userid);
	if(id.equals(userid)){ %>
		<a class="btn btn-outline-dark" href="BoardListServlet">목록 보기</a>
		<a class="btn btn-outline-dark" href="boardUpdate.jsp?num=<%=num%>">수정하기</a>
		<a class="btn btn-outline-dark" href="BoardDelServlet?num=<%=num %>">삭제하기</a>
	<%}else{%>
		<a class="btn btn-outline-dark" href="BoardListServlet">목록 보기</a>
	<%}%>
</div>
</div>
</body>
</html>