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
	href="/jsp_pj_ict05/resources/css/customer/join.css">
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
<script src="/jsp_pj_ict05/resources/js/customer/join.js" defer></script>
</head>
<body>
	<%
		System.out.println("<<< 회원가입 처리 화면 >>>");
	%>
	<div class="wrap">
		<!-- Header 시작 -->
		<%@ include file="../../common/header.jsp"%>
		<!-- Header 끝 -->

		<!-- 컨텐츠 시작 -->
		<%
		int insertCnt = (Integer) request.getAttribute("insertCnt");
		if (insertCnt == 1) {
		%>
		<script type="text/javascript">
			alert("회원가입 성공");
			window.location = "/jsp_pj_ict05/login.do";
		</script>
		<%
		} else {
		%>
		<script type="text/javascript">
			alert("회원가입 실패");
			window.location = "/jsp_pj_ict05/join.do";
		</script>
		<%
		}
		%>
		<!-- 컨텐츠 끝 -->

		<!-- Footer 시작 -->
		<%@ include file="../../common/footer.jsp"%>
		<!-- Footer 시작 -->
	</div>
</body>
</html>