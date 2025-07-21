package pj.mvc.jsp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface BoardService {

	// 게시판 입력하기
	public int insertBoard(HttpServletRequest request, HttpServletResponse response);
	
}
