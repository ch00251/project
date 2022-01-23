package com.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MemberService;


@WebServlet("/MemberIdCheckServlet")
public class MemberIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberIdCheckServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		MemberService service = new MemberService();
		int count = service.idCheck(userid);//중복 count 	
		response.setContentType("text/html;charset=UTF-8");	
		System.out.println(count);
		
		
		PrintWriter out = response.getWriter();
		String mesg = "";
		
		
		if(count == 1) {
			mesg = "중복된 아이디입니다.";	
			System.out.println(count);
		}
		else {
			mesg = "등록 가능합니다.";	
			System.out.println(count);
		}
		
		
		
		out.print(mesg);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
