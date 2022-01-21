package com.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.BoardsService;

/**
 * Servlet implementation class BoardDelServlet
 */
@WebServlet("/BoardDelServlet")
public class BoardDelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberDTO dto=(MemberDTO)session.getAttribute("login");
		String nextPage=null;
		if(dto!=null) {
			String num=request.getParameter("num");
			System.out.println(num);
			BoardsService service=new BoardsService();
			int n=service.boardDel(Integer.parseInt(num));
			session.setAttribute("deleteBoard", "글을 삭제했습니다.");
			nextPage="BoardListServlet";
		}else {
			  nextPage = "LoginUIServlet";
			  session.setAttribute("mesg", "회원만 이용 가능합니다.");
		  }
		
		 response.sendRedirect(nextPage);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
