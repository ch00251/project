package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CommentDTO;

public class CommentDAO {

	public int commentInsert(SqlSession session, CommentDTO dto) {
		int n=session.insert("CommentMapper.insert",dto);
		return n;
	}

	public List<CommentDTO> getList(SqlSession session, int ref_group) {
		List<CommentDTO> list=session.selectList("CommentMapper.getList",ref_group);
		return list;
	}

	public int getSequence(SqlSession session) {
		int seq=session.selectOne("CommentMapper.getSequence");
		return seq;
	}

}
