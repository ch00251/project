package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardsDAO;
import com.dao.CommentDAO;
import com.dto.BoardsDTO;
import com.dto.CommentDTO;

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

	public int addViewCount(int num) {
		int n=0;
		SqlSession session=MySqlSessionFactory.getSession();
		try {
			BoardsDAO dao=new BoardsDAO();
			n=dao.addViewCount(session,num);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	//글 전체갯수 리턴
	public int getCount() {
		int n=0;
		SqlSession session=MySqlSessionFactory.getSession();
		try {
			BoardsDAO dao=new BoardsDAO();
			n=dao.getCount(session);
		}finally {
			session.close();
		}
		return n;
	}

	public int boardUpdate(BoardsDTO d) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			BoardsDAO dao=new BoardsDAO();
			n=dao.boardUpdate(session,d);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}

	public int boardDel(int num) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			BoardsDAO dao = new BoardsDAO();
			n = dao.boardDel(session, num);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	public List<CommentDTO> getList(int ref_group) {
		SqlSession session=MySqlSessionFactory.getSession();
		List<CommentDTO> list=null;
		try {
			CommentDAO dao=new CommentDAO();
			list=dao.getList(session,ref_group);
		}finally {
			session.close();
		}
		return list;
	}
}
