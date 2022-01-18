package com.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;


@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberAddServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String username = request.getParameter("username");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		MemberDTO dto = new MemberDTO(userid, passwd, username, phone1, phone2, phone3, email1, email2);
		
		MemberService service = new MemberService();
		int n = service.memberAdd(dto);
		
		HttpSession session = request.getSession();
		
		if(n > 0) {
			session.setAttribute("memberAdd", "가입 성공");
		}
		
		response.sendRedirect("main.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
