<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<%@ include file="setting.jsp" %>
</head>
<body>
	<!-- 시맨틱 코드  -->
	<!-- header 시작 -->
	<!-- 요청 : url, 버튼, 링크 -->

	<nav class="navbar">
		<!-- 타이틀  -->
		<ul class="navbar_title">
			<li><i class="fa-solid fa-plane-departure"></i></li>
		</ul>

		<!-- 메뉴  -->
		<!-- 
			회원정보, 로그인 => *.do로 진입(Controller) =>
				-> 하나의 업무안에서 여러개를 처리하기 위해서(다형성)
				-> 여러 페이지를 하나의 분기즉, 서블릿안에서 처리하기 위해서 다형성 적용
			게시판은 => *.bo로 진입(Controller) => 
			상품 => *.po로 진입(Controller) =>
		 -->
		<ul class="navbar_menu">
			<li><a href="/jsp_pj_ict05/main.do">HOME</a></li>
			<li><a href="#">제품소개</a></li>
			<li><a href="#">Q&A</a></li>
		</ul>

		<!-- 아이콘  -->
		<ul class="navbar_icons">
			<li><a href="#"><i class="fa-brands fa-twitter"></i></a></li>
			<li><a href="#"><i class="fa-brands fa-facebook"></i></a></li>
			<!-- Controller(Servlet)이랑 연결 -->
			<li><a href="/jsp_pj_ict05/login.do">LOGIN</a></li>
			<li><a href="/jsp_pj_ict05/join.do">JOIN</a></li>
			<li><a href="#"><i class="fa-solid fa-cart-shopping"></i></a></li>
			<li><a href="#"><i class="fa-solid fa-user"></i></a></li>
		</ul>

		<!-- 반응형 웹 - (1).햄버거 아이콘 : https://fontawesome.com/ => 돋보기 => 기본이 free > bars 선택 -->
		<a href="#" class="navbar_toggleBtn"><i class="fa-solid fa-bars"></i>
		</a>
	</nav>

	<!-- header 끝 -->

</body>
</html>