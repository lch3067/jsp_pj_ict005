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
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = uri.substring(contextPath.length());
		
		CustomerService cuService = new CustomerServiceImpl();
		
		String viewPage = "";
		
		// 첫페이지
		if(url.equals("/main.do") || url.equals("/*.do")) {
			System.out.println("<<< url ===> /main.do >>>");
			
			viewPage = "/common/main.jsp";
			
		}
		
		// [회원가입]
		// 회원가입 페이지로 이동
		else if(url.equals("/join.do")) {
			System.out.println("<<< url ===> /join.do >>>");
			
			viewPage = "/customer/join/join.jsp";
			
		}
		
		// 회원가입 버튼 클릭시
		else if(url.equals("/joinAction.do")) {
			System.out.println("<<< url ===> /joinAction.do >>>");
			
			cuService.signInAction(request, response);
			
			viewPage = "/customer/join/joinAction.jsp";
			
		}
		
		// [로그인]
		else if(url.equals("/login.do")) {
			
			viewPage = "/customer/login/login.jsp";
			
		}
		
		// RequestDispatcher : 서블릿 또는 JSP 요청을 받은 후, 다른 컴포넌트로 요청을 위임하는 클래스이다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
