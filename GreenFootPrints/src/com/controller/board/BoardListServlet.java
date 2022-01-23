package com.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.BoardsDTO;
import com.dto.MemberDTO;
import com.service.BoardsService;

@WebServlet("/BoardListServlet")
public class BoardListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberDTO d=(MemberDTO)session.getAttribute("login");
		if(d!=null) {
			BoardsService service=new BoardsService();
			BoardsDTO dto=new BoardsDTO();
			List<BoardsDTO> list=service.boardList(dto);
			//System.out.println(list);
			//글 전체 갯수 리턴(페이징 처리사용)
			int n=service.getCount();
			System.out.println(n);
			request.setAttribute("boardsList", list);
			RequestDispatcher dis=request.getRequestDispatcher("boardList.jsp");
			dis.forward(request, response);
		}else {
			session.setAttribute("mesg", "회원만 이용 가능합니다.");
			response.sendRedirect("LoginUIServlet");
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
