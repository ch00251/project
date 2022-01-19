package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.TrashAddDAO;
import com.dto.TrashAddDTO;

public class TrashAddService {

	
	
	public int trashAdd(TrashAddDTO dto) {
		
		SqlSession session = MySqlSessionFactory.getSession();
		
		int n = 0;
		
		try {
			TrashAddDAO dao = new TrashAddDAO();
			n = dao.trashAdd(session, dto);
			
			
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return n;
	}
	
	
	

}
