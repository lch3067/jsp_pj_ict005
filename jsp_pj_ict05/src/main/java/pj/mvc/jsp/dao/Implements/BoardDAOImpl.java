package pj.mvc.jsp.dao.Implements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import pj.mvc.jsp.dao.BoardDAO;
import pj.mvc.jsp.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO{

	// 커넥션 풀 객체를 보관
	DataSource dataSource = null;
	
	private static BoardDAOImpl instance;
	
	public BoardDAOImpl() {};
	
	public static BoardDAOImpl getintance() {
		
		if(instance == null) {
			instance = new BoardDAOImpl();
		}
		
		return instance;
	}

	@Override
	public int insertBoard(BoardDTO boardD) {

		System.out.println("BoardDAOImpl - insertBoard()");

		Connection conn = null;

		PreparedStatement pstmt = null;
		
		int insertCnt = 0;
		
		try {
			// 1. DB 연결 => 
			conn = dataSource.getConnection();
			
			// 2. SQL 작성
			String sql ="INSERT INTO MVC_BOARD_TBL (B_NUM, B_TITLE, B_CONTENT, B_WRITER, B_PASSWORD, B_READCNT) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)"; 
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardD.getB_num());
			pstmt.setString(2, boardD.getB_title());
			pstmt.setString(3, boardD.getB_content());
			pstmt.setString(4, boardD.getB_writer());
			pstmt.setString(5, boardD.getB_password());
			pstmt.setInt(6, boardD.getB_readCnt());
			insertCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return insertCnt;
	}
	
	
}
