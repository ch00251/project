package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {

	public int memberAdd(SqlSession session, MemberDTO dto) {
		
		int n = session.insert("MemberMapper.memberAdd", dto);
		System.out.println(n);
		return n;
	}

	public MemberDTO login(SqlSession session, HashMap<String, String> map) {
		MemberDTO dto=session.selectOne("MemberMapper.login",map);
		return dto;
	}

	public MemberDTO mypage(SqlSession session, String userid) {
		MemberDTO dto=session.selectOne("MemberMapper.mypage",userid);
		return dto;
	}

	public int memberUpdate(SqlSession session, MemberDTO mdto) {
		int n=session.update("MemberMapper.memberUpdate", mdto);
		return n;
	}

}
