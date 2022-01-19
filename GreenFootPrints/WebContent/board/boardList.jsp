<%@page import="com.config.MySqlSessionFactory"%>
<%@page import="com.dao.BoardsDAO"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.dto.BoardsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.page-display ul{
		display: table;
  		margin-left: auto;
 		margin-right: auto;
	}
	.page-display ul li{
		float: left;
		list-style-type: none;
		margin-right: 10px;
	}
	.page-display ul li a{
		text-decoration: none;
		color: #000;
	}
	.page-display ul li.active a{
		text-decoration: underline;
		color: #f00;
		font-weight: bold;
	}
	.page-display ul li.muted a{
		color: #cecece;
	}
	#new{
		font-size: 16px;
	}
</style>
</head>
<body>
<%
	SqlSession s=MySqlSessionFactory.getSession();
	
	//한 페이지에 나타낼 row 의 갯수
	final int PAGE_ROW_COUNT=10;
	//하단 디스플레이 페이지 갯수
	final int PAGE_DISPLAY_COUNT=5;
	
	//보여줄 페이지의 번호
	int pageNum=1;
	//보여줄 페이지의 번호가 파라미터로 전달되는지 읽어와 본다.	
	String strPageNum=request.getParameter("pageNum");
	if(strPageNum != null){//페이지 번호가 파라미터로 넘어온다면
		//페이지 번호를 설정한다.
		pageNum=Integer.parseInt(strPageNum);
	}
	//보여줄 페이지 데이터의 시작 ResultSet row 번호
	int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
	//보여줄 페이지 데이터의 끝 ResultSet row 번호
	int endRowNum=pageNum*PAGE_ROW_COUNT;
	
	//전체 row 의 갯수를 읽어온다.
	int totalRow=BoardsDAO.getInstance().getCount(s);
	//전체 페이지의 갯수 구하기
	int totalPageCount=
			(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
	//시작 페이지 번호
	int startPageNum=
		1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
	//끝 페이지 번호
	int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
	//끝 페이지 번호가 잘못된 값이라면 
	if(totalPageCount < endPageNum){
		endPageNum=totalPageCount; //보정해준다. 
	}		
	// BoardsDTO 객체에 위에서 계산된 startRowNum 과 endRowNum 을 담는다.
	BoardsDTO dto=new BoardsDTO();
	dto.setStartRowNum(startRowNum);
	dto.setEndRowNum(endRowNum);
	
	List<BoardsDTO> list=BoardsDAO.getInstance().boardList(s, dto);
	
%>
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
			
			/*List<BoardsDTO> list=(List<BoardsDTO>)request.getAttribute("boardsList");*/
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
				<td><a href="BoardRetrieveServlet?num=<%=num%>"><%=title %></a></td>
				<td><%=userid %></td>
				<td><%=regdate %></td>
				<td><%=viewCount %></td>
			</tr>
		<% }  %>
		</tbody>
	</table>
	<br><br>
	<div class="page-display">
		<ul>
			<%if(startPageNum != 1){ %>
				<li>
					<a href="BoardListServlet?pageNum=<%=startPageNum-1 %>">&laquo;</a>
				</li>
			<%}else{ %>
				<li class="muted">
					<a href="javascript:">&laquo;</a>
				</li>
			<%} %>
			<%for(int i=startPageNum; i<=endPageNum; i++){ %>
				<%if(i == pageNum){ %>
					<li class="active">
						<a href="BoardListServlet?pageNum=<%=i %>"><%=i %></a>
					</li>
				<%}else{ %>
					<li>
						<a href="BoardListServlet?pageNum=<%=i %>"><%=i %></a>
					</li>
				<%} %>
			<%} %>
			<%if(endPageNum < totalPageCount){ %>
				<li>
					<a href="BoardListServlet?pageNum=<%=endPageNum+1 %>">&raquo;</a>
				</li>
			<%}else{ %>
				<li class="muted">
					<a href="javascript:">&raquo;</a>
				</li>
			<%} %>
			<li>
				<a id="new" href="BoardUIServlet"class="btn btn-outline-dark">새글 작성</a>
			</li>
		</ul>
	</div>
</div>
</body>
</html>