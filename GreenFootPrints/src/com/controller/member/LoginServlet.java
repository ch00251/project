package com.controller.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		String passwd=request.getParameter("passwd");
		//System.out.println(userid+"\t"+passwd);
		//로그인 후 main으로 이동
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("userid",userid);
		map.put("passwd",passwd);
		MemberService service=new MemberService();
		MemberDTO dto=service.login(map);
		System.out.println(dto);
		
		//dto가 null이 아닌 경우는 => 회원
		String nextPage=null;
		if(dto!=null) {//회원인 경우
			nextPage="main";//MainServlet
			HttpSession session=request.getSession();
			session.setAttribute("login", dto);//인증할 때 사용
			session.setMaxInactiveInterval(60*60);//session을 1시간동안 설정
		}else {//회원이 아닌 경우
			nextPage="LoginUIServlet";//다시 로그인창으로 돌아가게
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
