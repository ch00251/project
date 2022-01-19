<%@page import="com.dao.BoardsDAO"%>
<%@page import="com.dto.BoardsDTO"%>
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
<p>글 상세 페이지</p>
<%
	BoardsDTO dto=(BoardsDTO)request.getAttribute("dto");
	int num=dto.getNum();
	String userid=dto.getUserid();
	String title=dto.getTitle();
	String content=dto.getContent();
	String regdate=dto.getRegdate();
	int viewCount=dto.getViewCount();
%>
<table width="90%">
	<tr>
		<th>글번호</th>
		<td><%=num %></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><%=userid%></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><%=title %></td>
		<th>조회수</th>
		<td><%=viewCount %></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><div class="contents"><%=content %></div></td>
	</tr>
	<tr>
		<th>등록일</th>
		<td><%=regdate %></td>
	</tr>
</table>
<a href="BoardListServlet">목록 보기</a>
</div>
</body>
</html>