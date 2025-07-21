<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형 웹 -->
<meta name="viewport" =content="width=device-width, initial-scale=1">
<title>main</title>

<!-- css 작성 -->
<link rel="stylesheet"
	href="/jsp_pj_ict05/resources/css/common/header.css">
<link rel="stylesheet"
	href="/jsp_pj_ict05/resources/css/customer/modify.css">
<link rel="stylesheet"
	href="/jsp_pj_ict05/resources/css/common/footer.css">

<!-- js 작성 -->
<!-- 최신 Font Awesome CDN (2024 기준) -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"> -->
<script src="https://kit.fontawesome.com/b435fbc087.js"
	crossorigin="anonymous"></script>
<!-- (3-4). 자바스크립트 소스 연결 -->
<!-- defer : html을 다 읽은 후에 자바스크립트를 실행한다. 페이지가 모두 로드된 후에 해당 외부 스크립트가 실행된다. -->
<script type="text/javascript" src="/jsp_pj_ict05/resources/js/common/main.js" defer></script>
</head>
<body>
	<%
		System.out.println("<<< 회원탈퇴 - 인증화면 >>>");
	%>
	<div class="wrap">
		<!-- Header 시작 -->
		<%@ include file="../../../common/header.jsp"%>
		<!-- Header 끝 -->

		<!-- 컨텐츠 시작 -->
		<div id="container">
			<div id="contents">
				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<h1 align="center"> 회원탈퇴 - 인증화면 </h2>
				</div>
				
				<!-- 상단 중앙2 시작 -->
				<div id=section2">
					<div id="s2_inner">
						<!-- join 시작 -->
						<div class="join">
							<form name="passwordform" action="deleteCustomerAction.do" method="post"> <!-- 삭제페이지 요청 -->
								
								<%
								
									String sessionID = (String)request.getSession().getAttribute("sessionID");
							
								%>
								<table>
									<tr>
										<th colspan="2" align="center"><label for="user_id" />
											<span style="color: #FF82AA"><b> <%= sessionID %></b></span>님 비밀번호를 입력하세요.!!
											<input type="password" id="user_password" name="user_password" class="input" size="20" placeholder="공백없이 20자 이내로 작성" required autofocus>
										</th>
									</tr>
									
									
									<tr>
										<td colspan="2" style="border-botton: none">
										<br>
										<div align="right">
											<input class="inputButton" type="submit" value="회원탈퇴">
											<input class="inputButton" type="button" value="취소" onclick="window.location='main.do'"> 
										</div>
									</tr>
								</table>

							</form>
						</div>
						<!-- join 끝 -->
					</div>
				</div>
				<!-- 상단 중앙 끝 -->
			</div>
		</div>
		<!-- 컨텐츠 끝 -->

		<!-- Footer 시작 -->
		<%@ include file="../../../common/footer.jsp"%>
		<!-- Footer 시작 -->
	</div>
</body>
</html>