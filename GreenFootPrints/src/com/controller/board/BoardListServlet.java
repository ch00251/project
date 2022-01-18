package com.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardsDTO;
import com.service.BoardsService;

@WebServlet("/BoardListServlet")
public class BoardListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardsService service=new BoardsService();
		BoardsDTO dto=new BoardsDTO();
		List<BoardsDTO> list=service.boardList(dto);
		System.out.println(list);
		request.setAttribute("boardsList", list);
		RequestDispatcher dis=request.getRequestDispatcher("boardList.jsp");
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
