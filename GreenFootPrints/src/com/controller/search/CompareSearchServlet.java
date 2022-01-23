package com.controller.search;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.CompareSearchDTO;
import com.service.CompareSearchService;


@WebServlet("/CompareSearchServlet")
public class CompareSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CompareSearchServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search1 = request.getParameter("search1");
		System.out.println(search1);
		
		CompareSearchService service = new CompareSearchService();
		CompareSearchDTO dto = service.CompareSearch1(search1);
		
		
		request.setAttribute("search1", dto);
		System.out.println(dto + "\t" + "서블릿 dto 돌아온것");
		
		RequestDispatcher dis = request.getRequestDispatcher("compare.jsp");
		dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
