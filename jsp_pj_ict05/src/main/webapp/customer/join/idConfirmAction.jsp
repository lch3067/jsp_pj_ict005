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
<script type="text/javascript"
	src="/jsp_pj_ict05/resources/js/customer/join.js" defer></script>
</head>
<body>
	<%
		System.out.println("<<< 회원인증 화면 >>>");
	%>
	<div class="wrap">
		<!-- 컨텐츠 시작 -->
		<div id="container">
			<div id="contents">
				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<h1 align="center">
						ID 중복확인
						</h2>
				</div>

				<!-- 상단 중앙2 시작 -->
				<div id=section2">
					<div id="s2_inner">
						<!-- join 시작 -->
						<div class="join">
							<form name="confirmform" action="idConfirmAction.do"
								method="post">

								<%
								int selectCnt = (Integer) request.getAttribute("selectCnt");
								String strId = (String) request.getAttribute("strId");

								// id 중복일 떄, id를 입력받아 다시 중복체크
								if (selectCnt == 1) {
								%>

								<!-- id 중복일 때, id를 입력받아 다시 중복체크 -->
								<table align="center" width="500px">
									<tr>
										<th colspan="2"><span> <%=strId%>는 사용할 수 없습니다.
										</span></th>
									</tr>

									<tr>
										<th><label for="user_id" />* 아이디</th>
										<td><input type="text" id="user_id" name="user_id"
											class="input" size="20" placeholder="공백없이 20자 이내로 작성"
											required autofocus></td>
									</tr>


									<tr>
										<td colspan="2" style="border-botton: none"><br>
											<div align="right">
												<input class="inputButton" type="submit" value="확인">
												<input class="inputButton" type="reset" value="초기화">
											</div>
									</tr>
								</table>
								<%
								} else {
								%>
								<table align="center" width="500px">
									<tr>
										<th colspan="2"><span> <%=strId%>는 사용할 수 있습니다.
										</span></th>
									</tr>

									<tr>
										<td colspan="2" style="border-botton: none"><br>
											<div align="right">
												<input class="inputButton" type="button" value="확인"
													onclick="setUserId('<%=strId%>')">
											</div>
									</tr>
								</table>
								<%
								}
								%>

								<!-- id 중복아닐 때 확인 후 창닫기 -->

							</form>
						</div>
						<!-- join 끝 -->
					</div>
				</div>
				<!-- 상단 중앙 끝 -->
			</div>
		</div>
		<!-- 컨텐츠 끝 -->
	</div>
</body>
</html>