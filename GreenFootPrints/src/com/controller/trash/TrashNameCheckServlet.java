package com.controller.trash;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.TrashNameCheckService;


@WebServlet("/TrashNameCheckServlet")
public class TrashNameCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TrashNameCheckServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");	//응답 한글처리
		String tName = request.getParameter("tName");
		
		
		TrashNameCheckService service = new TrashNameCheckService();
		int check = service.tNameCheck(tName);
		
		PrintWriter out = response.getWriter();
		String mesg = "";
		
		
		if(check == 1) {
			mesg = "중복된 제품 입니다.";	
		}
		else {
			mesg = "등록 가능합니다.";	
		}
		
		
		
		out.print(mesg);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
