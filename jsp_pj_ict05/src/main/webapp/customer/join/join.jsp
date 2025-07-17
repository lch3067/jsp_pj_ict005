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
<script src="/jsp_pj_ict05/resources/js/customer/join.js" defer></script>
</head>
<body>
	<div class="wrap">
		<!-- Header 시작 -->
		<%@ include file="../../common/header.jsp"%>
		<!-- Header 끝 -->

		<!-- 컨텐츠 시작 -->
		<div id="container">
			<div id="contents">
				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<h1 align="center">회원가입창</h2>
				</div>
				
				<!-- 상단 중앙2 시작 -->
				<div id=section2">
					<div id="s2_inner">
						<!-- join 시작 -->
						<div class="join">
							<form name="inputform" action="joinAction.do" method="post"
								onsubmit="return singleCheck()">
								<table>
									<tr>
										<th><label for="user_id" />* 아이디</th>
										<td><input type="text" id="user_id" name="user_id"
											class="input" size="20" placeholder="공백없이 20자 이내로 작성"
											required autofocus> <input type=button name="dubChk"
											value="중복확인" style="margin-left: 10px" onclick="confirmId()">
										</td>
									</tr>
									<tr>
										<th><label for="user_password" />* 비밀번호</th>
										<td><input type="password" id="user_password"
											name="user_password" class="input" size="20"
											placeholder="공백없이 20자 이내로 작성" required autofocus></td>
									</tr>
									<tr>
										<th><label for="re_password" />* 비밀번호(확인)</th>
										<td><input type="password" id="re_password"
											name="re_password" class="input" size="20"
											placeholder="비밀번호 재입력" required autofocus></td>
									</tr>
									<tr>
										<th><label for="user_name" />* 이름</th>
										<td><input type="text" id="user_name" name="user_name"
											class="input" size="20" placeholder="이름 작성"
											required autofocus> 
										</td>
									</tr>
									<tr>
										<th><label/>* 생년월일</th>
										<td><input type="date" name="user_birthday"
											class="input" size="8" placeholder="-없이 생년월일 6자리 입력"
											required autofocus> 
										</td>
									</tr>
									<tr>
										<th><label for="user_address" />* 주소</th>
										<td><input type="text" id="user_address" name="user_address"
											class="input" size="8" placeholder="주소 작성해주세요."
											required autofocus> 
										</td>
									</tr>
									<tr>
										<th><label for="user_hp1" />휴대폰 번호</th>
										<td>
											<input type="text" id="user_hp1" name="user_hp1" class="input" size="3"  style="width: 100px">
											-
											<input type="text" id="user_hp2" name="user_hp2" class="input" size="4"  style="width: 100px">
											-
											<input type="text" id="user_hp3" name="user_hp3" class="input" size="4" style="width: 100px">
										</td>
									</tr>
									<tr>
										<th><label for="user_email1" />* 이메일</th>
										<td>
											<input type="text" id="user_email1" name="user_email1" class="input" size="20" style="width:100px" required>
											@
											<input type="text" name="user_email2" class="input" size="20" style="width:100px" required>
											<select class="input" name="user_email3" style="width:100px" onchange="selectEmailChk()">
												<option value="0">직접입력</option>
												<option value="naver.com">네이버</option>
												<option value="google.com">구글</option>
												<option value="daum.net">다음</option>
												<option value="nate.com">네이트</option>
											</select>
										</td>
									</tr>
									
									<tr>
										<td colspan="2" style="border-botton: none">
										<br>
										<div align="right">
											<input class="inputButton" type="submit" value="회원가입">
											<input class="inputButton" type="reset" value="취소"> 
											<input class="inputButton" type="button" value="가입취소" onclick="window.location='main.do'"> 
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
		<%@ include file="../../common/footer.jsp"%>
		<!-- Footer 시작 -->
	</div>
</body>
</html>