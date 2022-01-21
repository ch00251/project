package com.exam.controller;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.exam.dao.BbsDao;

public class BbsDeleteController extends HttpServlet {

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
		bbsDao.del(Integer.parseInt(bbsId));

		resp.sendRedirect("bbs.do");
	}
	
}