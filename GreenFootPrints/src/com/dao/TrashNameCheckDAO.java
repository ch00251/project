package com.dao;

import org.apache.ibatis.session.SqlSession;

public class TrashNameCheckDAO {

	public int tNameCheck(SqlSession session, String tName) {
		int check = session.selectOne("TrashNameCheckMapper.tNameCheck", tName);
		
		return check;
	}

}
