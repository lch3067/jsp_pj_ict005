package pj.mvc.jsp.dao;

import pj.mvc.jsp.dto.BoardDTO;

public interface BoardDAO {

	// 게시판 입력하기
	public int insertBoard(BoardDTO boardD);
	
}
