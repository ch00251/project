package com.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CommentDAO;
import com.dto.CommentDTO;
import com.dto.MemberDTO;
import com.service.CommentService;

/**
 * Servlet implementation class CommentInsertServlet
 */
@WebServlet("/CommentInsertServlet")
public class CommentInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		MemberDTO mdto=(MemberDTO)session.getAttribute("login");
		
		
		int num=Integer.parseInt(request.getParameter("num"));//글번호
		String userid=mdto.getUserid();//작성자아이디
		int ref_group=Integer.parseInt(request.getParameter("ref_group"));
		String target_id=request.getParameter("target_id");//대상자아이디
		String content=request.getParameter("content");
		String comment_group=request.getParameter("comment_group");	
		System.out.println(num+"\t"+userid+"\t"+ref_group+"\t"+target_id+"\t"+content+"\t"+comment_group);
		CommentService service=new CommentService();
		int seq=service.getSequence();
		CommentDTO dto=new CommentDTO();
		dto.setNum(seq);
		dto.setWriter(userid);
		dto.setTarget_id(target_id);
		dto.setContent(content);
		dto.setRef_group(ref_group);
		
		if(comment_group==null) {//원글의 댓글인 경우
			//댓글의 글번호가 댓글의 그룹 번호가 된다.
			dto.setComment_group(seq);
		}else {//댓글의 댓글인 경우
			//comment_group 번호가 댓글의 그룹번호가 된다.
			dto.setComment_group
				(Integer.parseInt(comment_group));
		}
		int n=service.commentInsert(dto);
		System.out.println(n);
		session.setAttribute("cDTO", dto);
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
