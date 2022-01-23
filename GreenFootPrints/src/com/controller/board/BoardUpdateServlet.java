package com.controller.board;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.BoardsDTO;
import com.dto.MemberDTO;
import com.service.BoardsService;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/BoardUpdateServlet")
public class BoardUpdateServlet extends HttpServlet implements Servlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberDTO dto=(MemberDTO)session.getAttribute("login");
		if(dto!=null) {
			request.setCharacterEncoding("utf-8");
			String userid=request.getParameter("userid");
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			BoardsDTO d=new BoardsDTO();
			d.setUserid(userid);
			d.setTitle(title);
			d.setContent(content);
			BoardsService service=new BoardsService();
			int n=service.boardUpdate(d);
			System.out.println(n);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
