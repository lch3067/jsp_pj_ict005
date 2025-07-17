package pj.mvc.jsp.dao.Implements;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.sql.DataSource; // 2개가 존재하기 때문에 주의

import pj.mvc.jsp.dao.CustomerDao;
import pj.mvc.jsp.dto.CustomerDTO;

// 구현부
public class CustomerDaoImpl implements CustomerDao {

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

		return 0;

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
			String sql ="INSERT INTO MVC_CUSTOMER_TBL (USER_ID, USER_PASSWORD, USER_NAME, USER_BIRTHDAY, USER_ADDRESS, USER_HP, USER_EMAIL) "
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
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return insertCnt;

	}

	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
	@Override
	public int idPasswordChk(String strId, String strPassword) {

		return 0;

	}

	// 회원정보 인증처리 및 탈퇴처리(삭제)
	@Override
	public int deleteCustomer(String strId) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 회원정보 인증처리 및 상세페이지 조회(조회)
	@Override
	public CustomerDTO getCustomerDetail(String strId) {
		// TODO Auto-generated method stub
		return null;
	}

	// 회원정보 수정처리(수정)
	@Override
	public int updateCustomer(CustomerDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
