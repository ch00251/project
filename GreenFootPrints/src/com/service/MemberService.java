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

	public int idCheck(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		int count = 0;
		try {
			 MemberDAO dao = new MemberDAO();
			count = dao.idCheck(session, userid);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return count;
	}

<<<<<<< HEAD
	

=======
	public MemberDTO mypage(String userid) {
		SqlSession session=MySqlSessionFactory.getSession();
		MemberDTO dto=null;
		try {
			MemberDAO dao=new MemberDAO();
			dto=dao.mypage(session,userid);
		}finally {
			session.close();
		}
		return dto;
	}

	public int memberUpdate(MemberDTO mdto) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			MemberDAO dao=new MemberDAO();
			n=dao.memberUpdate(session,mdto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
>>>>>>> branch 'CWC' of https://github.com/ch00251/project.git
}
