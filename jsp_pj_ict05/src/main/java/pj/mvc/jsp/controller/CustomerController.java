package pj.mvc.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.service.CustomerService;
import pj.mvc.jsp.service.Implements.CustomerServiceImpl;


// 모든 고객의 요구사항은 여기로 들어온다. .do로 들어온다.
// http://localhost/jsp_pj_ict05/*.do
@WebServlet("*.do")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public CustomerController() {}

    // 1단계. 웹브라우저가 전송한 HTTP 전송을 받음
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		action(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void action(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 2단계. 클라이언트 요청 분석
		request.setCharacterEncoding("UTF-8");

		
		// http://localhost/jsp_pj_ict05/*.do <=== URL
		// 				   /jsp_pj_ict05/*.do <=== URI
		// 				   /jsp_pj_ict05 <=== ContextPath
		// 							    /*.do <=== 최종 url
		
		// viewPage에서 앞 /는 webapp을 의미한다.
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = uri.substring(contextPath.length());
		
		CustomerService cuService = new CustomerServiceImpl();
		
		String viewPage = "";
		
		// 첫페이지
		if(url.equals("/main.do")) {
			System.out.println("<<< url ===> /main.do >>>");
			
			viewPage = "/common/main.jsp";
		
		} 
		
		// [중복확인]
		// 아이디 중복시 처리
		else if (url.equals("/idConfirmAction.do")){
			System.out.println("<<< url ===> /idConfirmAction.do >>>");
			
			cuService.idConfirmAction(request, response);
			
			viewPage = "/customer/join/idConfirmAction.jsp";
		}
		
		// [회원가입]
		// 회원가입 페이지로 이동
		else if(url.equals("/join.do")) {
			System.out.println("<<< url ===> /join.do >>>");
			
			// 없을 경우 404 보여짐
			viewPage = "/customer/join/join.jsp";
			
		}
		
		// 회원가입 버튼 클릭시
		else if(url.equals("/joinAction.do")) {
			System.out.println("<<< url ===> /joinAction.do >>>");
			
			cuService.signInAction(request, response);
			
			viewPage = "/customer/join/joinAction.jsp";
			
		}
		
		// [로그인 화면]
		else if(url.equals("/login.do")) {
			System.out.println("<<< url ===> /login.do >>>");
			
			viewPage = "/customer/login/login.jsp";
			
		}
		
		// [로그인 처리]
		else if (url.equals("/loginAction.do")){
			System.out.println("<<< url ===> /loginAction.do >>>");
			
			cuService.loginAction(request, response);
			
			viewPage = "/customer/login/loginAction.jsp";
			
		} 
		
		// [로그아웃 처리]
		else if (url.equals("/logout.do")) {
			System.out.println("<<< url ===> /logout.do >>>");
			
			// 세션삭제
			request.getSession().invalidate();
			
			viewPage = "/common/main.jsp";
			
		} 
		
		// [회원수정] -----------------------------		
		// 회원수정 - 인증화면
		else if (url.equals("/modifyCustomer.do")) {
			System.out.println("<<< url ===> /modifyCustomer.do >>>");
			
			viewPage = "/customer/mypage/customerInfo/modifyCustomer.jsp";
		}
		
		// [회원상세페이지]
		// 회원수정 - 상세페이지
		else if (url.equals("/modifyDetailAction.do")) {
			System.out.println("<<< url ===> /modifyDetailAction.do >>>");
			
			cuService.modifyDetailAction(request, response);
			
			viewPage = "/customer/mypage/customerInfo/modifyDetailAction.jsp";
		}
		
		// [회원상세처리]
		// 회원수정 - 수정처리
		else if (url.equals("/modifyCustomerAction.do")) {
			System.out.println("<<< url ===> /modifyCustomerAction.do >>>");
			
			cuService.modifyCustomerAction(request, response);
			
			viewPage = "/customer/mypage/customerInfo/modifyCustomerAction.jsp";
		}
		
		else if(url.equals("/deleteCustomer.do")) {
			System.out.println("<<< url ===> /deleteCustomer.do >>>");
			
			viewPage = "/customer/mypage/customerInfo/deleteCustomer.jsp";
			
		}
		
		else if(url.equals("/deleteCustomerAction.do")) {
			System.out.println("<<< url ===> /deleteCustomerAction.do >>>");
			
			cuService.deleteCustomerAction(request, response);
			
			viewPage = "/customer/mypage/customerInfo/deleteCustomerAction.jsp";
			
		}
		
		// RequestDispatcher : 서블릿 또는 JSP 요청을 받은 후, 다른 컴포넌트로 요청을 위임하는 클래스이다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
