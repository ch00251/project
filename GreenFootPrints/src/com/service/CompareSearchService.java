package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CompareSearchDAO;
import com.dto.CompareSearchDTO;

public class CompareSearchService {

	public CompareSearchDTO CompareSearch1(String search1) {
		SqlSession session = MySqlSessionFactory.getSession();
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("search1", search1);
		
		CompareSearchDAO dao = new CompareSearchDAO();
		CompareSearchDTO dto = null;
		
		try {
			dto = dao.CompareSearch1(session, map);
			System.out.println(dto.getList());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return dto;
		
	}

	

	
	
}
