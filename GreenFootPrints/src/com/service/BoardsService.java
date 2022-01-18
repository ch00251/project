package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardsDAO;
import com.dto.BoardsDTO;

public class BoardsService {

	public List<BoardsDTO> boardList(BoardsDTO dto) {
		SqlSession session=MySqlSessionFactory.getSession();
		List<BoardsDTO> list=null;
		try {
			BoardsDAO dao=new BoardsDAO();
			list=dao.boardList(session,dto);
		}finally {
			session.close();
		}
		return list;
	}

}
