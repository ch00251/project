package com.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.BoardsDTO;
import com.service.BoardsService;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/BoardInsertServlet")
public class BoardInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//꼭!!!!!!!!!! 작성하기...ㅎ
		String userid=request.getParameter("userid");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String regdate=request.getParameter("regdate");
		
		BoardsDTO dto=new BoardsDTO();
		dto.setUserid(userid);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setRegdate(regdate);
		BoardsService service=new BoardsService();
		int n=service.boardAdd(dto);
		System.out.println(n);
		
		HttpSession session=request.getSession();
		if(n>0) {
			session.setAttribute("boardAdd","작성 완료");//게시판 등록 성공 알림
		};
		session.setMaxInactiveInterval(60*30);
		response.sendRedirect("BoardListServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
