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
<p style="display:table;margin-left: auto; margin-right: auto;">글 상세 페이지</p>
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
<div class="container">
	<div class="form-group">
		<form method="post" encType = "multipart/form-data" action="commentAction.jsp?bbsID=<%= userid %>&boardID=<%=userid%>">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<tr>
					<td style="border-bottom:none;" valign="middle"><br><br><%= userid %></td>
					<td><input type="text" style="height:100px;" class="form-control" placeholder="상대방을 존중하는 댓글을 남깁시다." name = "commentText"></td>
					<td><br><br><input type="submit" class="btn-primary pull" value="댓글 작성"></td>
				</tr>
			</table>
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