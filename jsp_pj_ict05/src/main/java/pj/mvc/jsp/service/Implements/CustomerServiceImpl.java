package pj.mvc.jsp.service.Implements;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.dao.CustomerDao;
import pj.mvc.jsp.dao.Implements.CustomerDaoImpl;
import pj.mvc.jsp.dto.CustomerDTO;
import pj.mvc.jsp.service.CustomerService;

// 구현부
public class CustomerServiceImpl implements CustomerService {

	
	
	// ID 중복확인 처리
	@Override
	public void idConfirmAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerDao getInstance = CustomerDaoImpl.getInstance();

		getInstance.idPasswordChk(null, null);
		
		
	}

	// 회원가입 처리
	@Override
	public void signInAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("CustomerServiceImpl - signInAction()");
		CustomerDao getInstance = CustomerDaoImpl.getInstance();
		
		// 3단계. 화면에서 입력받은 값을 가져와서 DTO의 setAttribute를 통해 전달
		// DTO 생성 -> setter -> 맴버변수
		
		//1 - DTO 생성
		CustomerDTO customerdto = new CustomerDTO();
		
		//2 - setter로 담는다.
		customerdto.setUser_id(request.getParameter("user_id"));
		customerdto.setUser_password(request.getParameter("user_password"));
		customerdto.setUser_name(request.getParameter("user_name"));
		customerdto.setUser_birthday(Date.valueOf(request.getParameter("user_birthday")));
		customerdto.setUser_address(request.getParameter("user_address"));
		
		// hp은 필수가 아니므로 null값이 들어올 수 있으므로 값이 존재할 때만 받아온다.(010-1234-4567); 
		String hp = "";
		String hp1 = request.getParameter("user_hp1");
		String hp2 = request.getParameter("user_hp2");
		String hp3 = request.getParameter("user_hp3");
		
		if(!hp1.equals("") && !hp2.equals("") && !hp3.equals("")) {
			hp = hp1 + "-" + hp2 + "-" + hp3;
			customerdto.setUser_hp(hp);
		}
		
		// 이메일 부분
		String user_email = "";
		String user_email1 = request.getParameter("user_email1");
		String user_email2 = request.getParameter("user_email2");
		user_email = user_email1 + "@" + user_email2;
		customerdto.setUser_email(user_email);
		
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
		// CustomerDao getInstance = CustomerDaoImpl.getInstance();
		// 등록일 아래 문장 생략시... DB쪽에 기본값으로 sysdate
		//customerdto.setUser_regdate(new Timestamp(System.currentTimeMillis()));
		
		// 5단계. 회원가입 처리
		int insertCnt = getInstance.insertCustomer(customerdto);
		
		// 6단계. jsp로 전달을 위한 처리하기
		request.setAttribute("insertCnt", insertCnt);
	}

	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
	@Override
	public void loginAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	// 회원정보 인증처리 및 탈퇴처리(삭제)
	@Override
	public void deleteCustomerAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	// 회원정보 인증처리 및 상세페이지 조회(조회)
	@Override
	public void modifyDetailAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	// 회원정보 수정처리(수정)
	@Override
	public void modifyCustomerAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
