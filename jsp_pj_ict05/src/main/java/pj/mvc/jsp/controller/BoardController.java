package pj.mvc.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.service.BoardService;
import pj.mvc.jsp.service.Implements.BoardServiceImpl;

@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		action(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 2단계. 클라이언트 요청 분석
		request.setCharacterEncoding("UTF-8");

		// http://localhost/jsp_pj_ict05/*.do <=== URL
		// /jsp_pj_ict05/*.do <=== URI
		// /jsp_pj_ict05 <=== ContextPath
		// /*.do <=== 최종 url
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = uri.substring(contextPath.length());

		BoardService bService = new BoardServiceImpl();

		String viewPage = "";

		if (url.equals("/board.bo")) {
			
			viewPage = "/customer/board/board.jsp";
		}

		// RequestDispatcher : 서블릿 또는 JSP 요청을 받은 후, 다른 컴포넌트로 요청을 위임하는 클래스이다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}
