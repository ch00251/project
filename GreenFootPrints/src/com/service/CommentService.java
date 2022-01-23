package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardsDAO;
import com.dao.CommentDAO;
import com.dto.CommentDTO;

public class CommentService {

	public int commentInsert(CommentDTO dto) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			CommentDAO dao=new CommentDAO();
			n=dao.commentInsert(session,dto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}

	public int getSequence() {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			CommentDAO dao=new CommentDAO();
			n=dao.getSequence(session);
		}finally {
			session.close();
		}
		return n;
	}
}
