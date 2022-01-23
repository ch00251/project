package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CompareSearchDTO;

public class CompareSearchDAO {

	public CompareSearchDTO CompareSearch1(SqlSession session, String search1) {
		CompareSearchDTO dto = new CompareSearchDTO();
		
		List<CompareSearchDTO> list = session.selectList("CompareSearchMapper.compareSearch", search1);
		System.out.println(list);
		
		return dto;
	}

	public CompareSearchDTO CompareSearch1(SqlSession session, HashMap<String, String> map) {
		
		CompareSearchDTO dto = new CompareSearchDTO();
		
		List<CompareSearchDTO> list = session.selectList("CompareSearchMapper.compareSearch", map);
		System.out.println(list);
		
		return dto;
	}

	

	


}
