<%@page import="com.dto.BoardsDTO"%>
<%@page import="java.util.List"%>
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
<p>자유게시판 목록 입니다</p>
	<table width="100%" >
		<thead>
			<tr>
				<th>글 번호</th>
				<th width="50%">제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
		<%
			//추가
			
			List<BoardsDTO> list=(List<BoardsDTO>)request.getAttribute("boardsList");
			for(int i=0; i<list.size(); i++){
				BoardsDTO d=list.get(i);
				int num=d.getNum();
				String userid=d.getUserid();
				String title=d.getTitle();
				String regdate=d.getRegdate(); 
				int viewCount=d.getViewCount();
			
		%>
			<tr>
				<td><%=num %></td>
				<td><%=title %></td>
				<td><%=userid %></td>
				<td><%=regdate %></td>
				<td><%=viewCount %></td>
			</tr>
		<% }  %>
		</tbody>
	</table>
	<a id="new" href="BoardUIServlet"class="btn btn-outline-dark">새글 작성</a>
</div>
</body>
</html>