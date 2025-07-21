package pj.mvc.jsp.service.Implements;

import java.io.IOException;
import java.sql.Clob;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import pj.mvc.jsp.dao.BoardDAO;
import pj.mvc.jsp.dao.Implements.BoardDAOImpl;
import pj.mvc.jsp.dto.BoardDTO;
import pj.mvc.jsp.service.BoardService;

public class BoardServiceImpl implements BoardService {

	@Override
	public int insertBoard(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("BoardServiceImpl - insertBoard()");
		BoardDAO getintance = BoardDAOImpl.getintance();

		BoardDTO boardDTO = new BoardDTO();

		boardDTO.setB_num(Integer.parseInt(request.getParameter("b_num")));
		boardDTO.setB_title(request.getParameter("b_title"));
		boardDTO.setB_content(request.getParameter("b_content"));
		boardDTO.setB_writer(request.getParameter("b_writer"));
		boardDTO.setB_password(request.getParameter("b_password"));
		boardDTO.setB_readCnt(Integer.parseInt(request.getParameter("b_readCnt")));

		int insertRst = getintance.insertBoard(boardDTO);

		return insertRst;
	}

}
