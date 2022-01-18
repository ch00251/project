package com.exam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.exam.dao.BbsDao;
import com.exam.dto.BbsDto;

public class BbsViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bbsId = req.getParameter("bbsId");
		BbsDao bbsDao = BbsDao.getInstance();
		BbsDto bbsDto = new BbsDto();
		bbsDao.hitUpdate(bbsId);
		bbsDto = bbsDao.selectById(bbsId);
		
		req.setAttribute("bbsview", bbsDto);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/bbsview.jsp");
		rd.forward(req, resp);
	}
	
}