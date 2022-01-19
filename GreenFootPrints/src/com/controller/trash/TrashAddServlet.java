package com.controller.trash;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.TrashAddDTO;
import com.service.TrashAddService;


@WebServlet("/TrashAddServlet")
public class TrashAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TrashAddServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String company = request.getParameter("company");
		String tNo = request.getParameter("tNo");
		String tName = request.getParameter("tName");
		String tExp = request.getParameter("tExp");
		String tCateEGram1 = request.getParameter("tCateEGram1");
		String tCateEGram2 = request.getParameter("tCateEGram2");
		String tCateEGram3 = request.getParameter("tCateEGram3");
		String tCateEGram4 = request.getParameter("tCateEGram4");
		String tCateEGram5 = request.getParameter("tCateEGram5");
		String tCateEGram6 = request.getParameter("tCateEGram6");
		String tCateEGram7 = request.getParameter("tCateEGram7");
		
		String tCateNGram1 = request.getParameter("tCateNGram1");
		String tCateNGram2 = request.getParameter("tCateNGram2");
		String tCateNGram3 = request.getParameter("tCateNGram3");
		String tCateNGram4 = request.getParameter("tCateNGram4");
		String tCateNGram5 = request.getParameter("tCateNGram5");
		
		
		//그나마 괜찮은 쓰레기
		int tCateEGram1Point = 3;	//종이
		int tCateEGram2Point = 1;	//병
		int tCateEGram3Point = 2;	//캔
		int tCateEGram4Point = 3;	//고철
		int tCateEGram5Point = 5;	//의류
		int tCateEGram6Point = 10;	//플라스틱
		int tCateEGram7Point = 2;	//박스
		//그나마 저장
		int tCateEGramPoint1 = 0;
		int tCateEGramPoint2 = 0;
		int tCateEGramPoint3 = 0;
		int tCateEGramPoint4 = 0;
		int tCateEGramPoint5 = 0;
		int tCateEGramPoint6 = 0;
		int tCateEGramPoint7 = 0;
		//노답 쓰레기
		int tCateNGram1Point = 15;	//종이
		int tCateNGram2Point = 12;	//병
		int tCateNGram3Point = 17;	//고철
		int tCateNGram4Point = 15;	//의류
		int tCateNGram5Point = 18;	//플라스틱
		//노답 저장
		int tCateNGramPoint1 = 0;
		int tCateNGramPoint2 = 0;
		int tCateNGramPoint3 = 0;
		int tCateNGramPoint4 = 0;
		int tCateNGramPoint5 = 0;
		
		
		
		// 그나마 쓰레기
		if(Integer.parseInt(tCateEGram1) != 0) {
			tCateEGramPoint1 = tCateEGram1Point * Integer.parseInt(tCateEGram1); 
		}	//종이
		if(Integer.parseInt(tCateEGram2) != 0) {
			tCateEGramPoint2 = tCateEGram2Point * Integer.parseInt(tCateEGram2); 
		}	//병
		if(Integer.parseInt(tCateEGram3) != 0) {
			tCateEGramPoint3 = tCateEGram3Point * Integer.parseInt(tCateEGram3); 
		}	//캔
		if(Integer.parseInt(tCateEGram4) != 0) {
			tCateEGramPoint4 = tCateEGram4Point * Integer.parseInt(tCateEGram4); 
		}	//고철
		if(Integer.parseInt(tCateEGram5) != 0) {
			tCateEGramPoint5 = tCateEGram5Point * Integer.parseInt(tCateEGram5); 
		}	//의류
		if(Integer.parseInt(tCateEGram6) != 0) {
			tCateEGramPoint6 = tCateEGram6Point * Integer.parseInt(tCateEGram6); 
		}	//플라스틱
		if(Integer.parseInt(tCateEGram7) != 0) {
			tCateEGramPoint7 = tCateEGram7Point * Integer.parseInt(tCateEGram7); 
		}	//박스
		//노답
		if(Integer.parseInt(tCateNGram1) != 0) {
			tCateNGramPoint1 = tCateEGram1Point * Integer.parseInt(tCateEGram1); 
		}	//종이
		if(Integer.parseInt(tCateNGram2) != 0) {
			tCateNGramPoint2 = tCateEGram2Point * Integer.parseInt(tCateEGram2); 
		}	//병
		if(Integer.parseInt(tCateNGram3) != 0) {
			tCateNGramPoint3 = tCateEGram3Point * Integer.parseInt(tCateEGram3); 
		}	//고철
		if(Integer.parseInt(tCateNGram4) != 0) {
			tCateNGramPoint4 = tCateEGram4Point * Integer.parseInt(tCateEGram4); 
		}	//의류
		if(Integer.parseInt(tCateNGram5) != 0) {
			tCateNGramPoint5 = tCateEGram5Point * Integer.parseInt(tCateEGram5); 
		}	//플라스틱
		
		int tScore = tCateEGramPoint1 + tCateEGramPoint2 + tCateEGramPoint3 + tCateEGramPoint4 + tCateEGramPoint5 + tCateEGramPoint6 + tCateEGramPoint7
					+tCateNGramPoint1 + tCateNGramPoint2 + tCateNGramPoint3 + tCateNGramPoint4 + tCateNGramPoint5;
		
		
		
		TrashAddDTO dto = new TrashAddDTO(company, tName, tExp, 
				tCateEGram1, tCateEGram2, tCateEGram3, tCateEGram4, tCateEGram5, tCateEGram6, tCateEGram7,
				tCateNGram1, tCateNGram2, tCateNGram3, tCateNGram4, tCateNGram5, tScore);
		System.out.println(dto);
		
		
		
		TrashAddService service = new TrashAddService();
		int n = service.trashAdd(dto);
		
		
		
		
		response.sendRedirect("main.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
