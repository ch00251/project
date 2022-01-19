package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.BoardsDTO;

public class BoardsDAO {
	//페이징 처리 준비
	private static BoardsDAO dao;
	
	public static BoardsDAO getInstance() {
		if(dao==null) {
			dao=new BoardsDAO(); 
		}
		return dao;
	}
	
	public List<BoardsDTO> boardList(SqlSession session, BoardsDTO dto) {
		List<BoardsDTO> list=session.selectList("BoardsMapper.boardList",dto);
		return list;
	}

	public int boardAdd(SqlSession session, BoardsDTO dto) {
		int n=session.insert("BoardsMapper.boardAdd",dto);
		return n;
	}

	public BoardsDTO boardsRetrieve(SqlSession session, int num) {
		BoardsDTO dto=session.selectOne("BoardsMapper.boardsRetrieve", num);
		return dto;
	}

	public int addViewCount(SqlSession session, int num) {
		int n=session.update("BoardsMapper.addViewCount", num);
		return n;
	}

	public int getCount(SqlSession session) {
		int n=session.selectOne("BoardsMapper.getCount");
		return n;
	}

	public int boardUpdate(SqlSession session, BoardsDTO d) {
		int n=session.update("BoardsMapper.boardUpdate", d);
		return n;
	}

}
