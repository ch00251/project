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

	public int boardAdd(BoardsDTO dto) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			BoardsDAO dao=new BoardsDAO();
			n=dao.boardAdd(session,dto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}

	public BoardsDTO boardsRetrieve(int num) {
		BoardsDTO dto=null;
		SqlSession session=MySqlSessionFactory.getSession();
		try {
			BoardsDAO dao=new BoardsDAO();
			dto=dao.boardsRetrieve(session,num);
		}finally {
			session.close();
		}
		return dto;
	}

}
