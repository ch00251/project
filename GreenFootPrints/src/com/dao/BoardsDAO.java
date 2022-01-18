package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.BoardsDTO;

public class BoardsDAO {

	public List<BoardsDTO> boardList(SqlSession session, BoardsDTO dto) {
		List<BoardsDTO> list=session.selectList("BoardsMapper.boardList",dto);
		return list;
	}

}
