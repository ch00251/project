package com.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BoardsDAO;
import com.dto.BoardsDTO;
import com.service.BoardsService;

/**
 * Servlet implementation class BoardRetrieveServlet
 */
@WebServlet("/BoardRetrieveServlet")
public class BoardRetrieveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		int num=Integer.parseInt(request.getParameter("num"));
		
		BoardsDTO dto=null;
		BoardsService service=new BoardsService();
		dto=service.boardsRetrieve(num);
		//조회수 1증가
		int n=service.addViewCount(num);
		request.setAttribute("dto",dto);
		session.setAttribute("dto", dto);
		RequestDispatcher dis=request.getRequestDispatcher("boardsRetrieve.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
