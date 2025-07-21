package pj.mvc.jsp.dao.Implements;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.naming.Context;
import javax.sql.DataSource; // 2개가 존재하기 때문에 주의

import pj.mvc.jsp.dao.CustomerDAO;
import pj.mvc.jsp.dto.CustomerDTO;

// 구현부
public class CustomerDaoImpl implements CustomerDAO {

	// 커넥션 풀 객체를 보관
	DataSource dataSource = null;

	// 싱글톤 : 하나의 객체 생성만 보장
	private static CustomerDaoImpl instance;

	// 디폴트 생성자
	// 커넥션폴(DBCP : DataBase Connection Pool 방식) - context.xml에 설정
	// 미리 준비해둠 그러다가 다쓰면, 다시 반납하는 것
	public CustomerDaoImpl() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_pj_ict05");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// 1. jdbc 드라이버 로딩
	// Class.forName(); => 지정한 클래스 정보를 담고 있는 클래스 인스턴스를 구해주는 기능을 제공하는 메서드
	// Class.forName("oracle.jdbc.driver.OracleDriver");
	// DB연결위한 정보
	// String dbUrl = "jdbc:oracle:thin:@//localhost:1521/XE"; // Url
	// String dbID = "SCOTT_05"; // 계정
	// String dbPassword = "tiger"; // 비밀번호

	public static CustomerDaoImpl getInstance() {
		if (instance == null) {
			instance = new CustomerDaoImpl();
		}
		return instance;
	}

	// ID 중복확인 처리
	@Override
	public int useridCheck(String strId) {

		System.out.println("CustomerDAOImpl - useridCheck()");

		// Oracle 연결을 위한 Connection 객체로, 연결정보를 담는다.
		Connection conn = null;

		// 질의응답을 위한 PreparedStatement 객체 생성(SQL 문장)
		PreparedStatement pstmt = null;

		// SQL 실행결과(SELECT절에서만 사용)
		ResultSet rs = null;

		int selectCnt = 0;

		try {

			// 1. DB 연결 =>
			conn = dataSource.getConnection();

			// 2. SQL 작성
			String sql = "SELECT USER_ID "
					+ "FROM MVC_CUSTOMER_TBL "
					+ "WHERE USER_ID = ?";

			// 3. 준비(설정)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);

			// 4. 실행
			rs = pstmt.executeQuery();

			// 5. 존재하면 1, 아니면 0
			if (rs.next()) {
				selectCnt = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return selectCnt;

	}

	// 회원가입 처리
	@Override
	public int insertCustomer(CustomerDTO dto) {

		System.out.println("CustomerDAOImpl - insertCustomer()");

		// Oracle 연결을 위한 Connection 객체로, 연결정보를 담는다.
		Connection conn = null;

		// 질의응답을 위한 PreparedStatement 객체 생성(SQL 문장)
		PreparedStatement pstmt = null;

		int insertCnt = 0;

		try {

			// 1. DB 연결 =>
			conn = dataSource.getConnection();

			// 2. SQL 작성
			String sql = "INSERT INTO MVC_CUSTOMER_TBL "
					+ "(USER_ID, USER_PASSWORD, USER_NAME, USER_BIRTHDAY, USER_ADDRESS, USER_HP, USER_EMAIL) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getUser_password());
			pstmt.setString(3, dto.getUser_name());
			pstmt.setDate(4, dto.getUser_birthday());
			pstmt.setString(5, dto.getUser_address());
			pstmt.setString(6, dto.getUser_hp());
			pstmt.setString(7, dto.getUser_email());
			insertCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return insertCnt;

	}

	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
	@Override
	public int idPasswordChk(String sessionID, String strPassword) {

		System.out.println("CustomerDAOImpl - idPasswordChk()");

		// Oracle 연결을 위한 Connection 객체로, 연결정보를 담는다.
		Connection conn = null;

		// 질의응답을 위한 PreparedStatement 객체 생성(SQL 문장)
		PreparedStatement pstmt = null;

		// SQL 실행결과(SELECT절에서만 사용)
		ResultSet rs = null;

		int selectCnt = 0;

		try {

			// 1. DB 연결 =>
			conn = dataSource.getConnection();

			// 2. SQL 작성
			String sql = "SELECT USER_ID "
					+ "FROM MVC_CUSTOMER_TBL "
					+ "WHERE USER_ID = ? "
					+ "AND USER_PASSWORD = ?";

			// 3. 준비(설정)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sessionID);
			pstmt.setString(2, strPassword);
			// 4. 실행
			rs = pstmt.executeQuery();

			// 5. 존재하면 1, 아니면 0
			if (rs.next()) {
				selectCnt = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return selectCnt;

	}

	// 회원정보 인증처리 및 탈퇴처리(삭제)
	@Override
	public int deleteCustomer(String sessionID) {
		
		System.out.println("CustomerDAOImpl - idPasswordChk()");

		// Oracle 연결을 위한 Connection 객체로, 연결정보를 담는다.
		Connection conn = null;

		// 질의응답을 위한 PreparedStatement 객체 생성(SQL 문장)
		PreparedStatement pstmt = null;

		// SQL 실행결과(SELECT절에서만 사용)
		ResultSet rs = null;

		int deleteCnt = 0;

		try {

			// 1. DB 연결 =>
			conn = dataSource.getConnection();

			// 2. SQL 작성
			String sql = "DELETE FROM MVC_CUSTOMER_TBL "
					+ "WHERE USER_ID = ? ";

			// 3. 준비(설정)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sessionID);
			
			// 4. 실행 (성공이면 1, 실패면 0)
			deleteCnt = pstmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deleteCnt;
	}

	// 회원정보 인증처리 및 상세페이지 조회(조회)
	@Override
	public CustomerDTO getCustomerDetail(String sessionID) {
		
		System.out.println("CustomerDAOImpl - getCustomerDetail()");
		
		// 반환할 타입으로 쓰려고 객체 생성
		CustomerDTO cuDto = new CustomerDTO();
		
		// Oracle 연결을 위한 Connection 객체로, 연결정보를 담는다.
		Connection conn = null;

		// 질의응답을 위한 PreparedStatement 객체 생성(SQL 문장)
		PreparedStatement pstmt = null;

		// SQL 실행결과(SELECT절에서만 사용)
		ResultSet rs = null;

		try {

			// 1. DB 연결 =>
			conn = dataSource.getConnection();

			// 2. SQL 작성
			String sql = "SELECT USER_ID, USER_PASSWORD, USER_NAME, USER_BIRTHDAY, USER_ADDRESS, USER_HP,"
					+ "USER_EMAIL, USER_REGDATE FROM MVC_CUSTOMER_TBL WHERE USER_ID = ?";

			// 3. 준비(설정)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sessionID);
			// 4. 실행
			rs = pstmt.executeQuery();

			// 5. 존재하면 1, 아니면 0
			// 1건이면 if / 그렇지 않으면, while(여러건일 경우)
			while(rs.next()) {
				cuDto.setUser_id(rs.getString("USER_ID"));
				cuDto.setUser_password(rs.getString("USER_PASSWORD"));
				cuDto.setUser_name(rs.getString("USER_NAME"));
				cuDto.setUser_birthday(rs.getDate("USER_BIRTHDAY"));
				cuDto.setUser_address(rs.getString("USER_ADDRESS"));
				cuDto.setUser_hp(rs.getString("USER_HP"));
				cuDto.setUser_email(rs.getString("USER_EMAIL"));
				cuDto.setUser_regdate(Timestamp.valueOf(rs.getString("USER_REGDATE")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cuDto;
	}

	// 회원정보 수정처리(수정)
	@Override
	public int updateCustomer(CustomerDTO dto) {
		System.out.println("CustomerDAOImpl - insertCustomer()");

		// Oracle 연결을 위한 Connection 객체로, 연결정보를 담는다.
		Connection conn = null;

		// 질의응답을 위한 PreparedStatement 객체 생성(SQL 문장)
		PreparedStatement pstmt = null;

		int updateCnt = 0;

		try {

			// 1. DB 연결 =>
			conn = dataSource.getConnection();

			// 2. SQL 작성
			String sql = "UPDATE MVC_CUSTOMER_TBL "
			           + "SET USER_PASSWORD = ?, "
			           + "USER_NAME = ?, "
			           + "USER_BIRTHDAY = ?, "
			           + "USER_ADDRESS = ?, "
			           + "USER_HP = ?, "
			           + "USER_EMAIL = ?, "
			           + "USER_REGDATE = ? "
			           + "WHERE USER_ID = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_password());
			pstmt.setString(2, dto.getUser_name());
			pstmt.setDate(3, dto.getUser_birthday());
			pstmt.setString(4, dto.getUser_address());
			pstmt.setString(5, dto.getUser_hp());
			pstmt.setString(6, dto.getUser_email());
			pstmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(8, dto.getUser_id());
			
			// 3. 실행
			updateCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateCnt;
	}

}
