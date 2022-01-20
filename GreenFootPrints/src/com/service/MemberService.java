package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;


public class MemberService {

	public int memberAdd(MemberDTO dto) {
		
		SqlSession session = MySqlSessionFactory.getSession();
		
		int n = 0;
		
		try {
			MemberDAO dao = new MemberDAO();
			n = dao.memberAdd(session, dto);
			System.out.println(n);
			session.commit();
		} 
		catch (Exception e) {
			
		}
		finally {
			session.close();
		}
		return n;
	}

	

}
