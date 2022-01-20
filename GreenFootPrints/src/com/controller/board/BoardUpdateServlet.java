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
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/BoardUpdateServlet")
public class BoardUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		request.setCharacterEncoding("utf-8");
		int num=Integer.parseInt(request.getParameter("num"));
		String userid=request.getParameter("userid");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String regdate=request.getParameter("regdate");
		int viewCount=Integer.parseInt(request.getParameter("viewCount"));
		int startRowNum=Integer.parseInt(request.getParameter("startRowNum"));
		int endRowNum=Integer.parseInt(request.getParameter("endRowNum"));
		System.out.println(num+"\t"+userid+"\t"+title+"\t"+content+"\t"+regdate+"\t"+viewCount+"\t"+startRowNum+"\t"+endRowNum);
		
		BoardsDTO d=new BoardsDTO(num, userid, title, content,regdate,viewCount, startRowNum,endRowNum);
		session.setAttribute("dd", d);
		 		 
		BoardsService service=new BoardsService();		
		int n=service.boardUpdate(d);
		System.out.println("수정갯수:"+n);
		System.out.println(num);
		response.sendRedirect("BoardRetrieveServlet?num="+num);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
