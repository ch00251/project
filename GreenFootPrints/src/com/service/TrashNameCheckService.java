package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.TrashNameCheckDAO;

public class TrashNameCheckService {

	public int tNameCheck(String tName) {
		
		SqlSession session = MySqlSessionFactory.getSession();
		int check = 0;
		
		try {
			TrashNameCheckDAO dao = new TrashNameCheckDAO();
			check = dao.tNameCheck(session, tName);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return check;
	}

}
