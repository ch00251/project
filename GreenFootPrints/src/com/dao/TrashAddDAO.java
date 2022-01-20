package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.TrashAddDTO;

public class TrashAddDAO {

	public int trashAdd(SqlSession session, TrashAddDTO dto) {
		
		int n = session.insert("trashAdd", dto);
		
		return n;
	}

}
