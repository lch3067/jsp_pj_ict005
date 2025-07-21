/**
 * 
 */



// 아이디 중복확인 버튼 클릭시
// 1. 아이디 중복확인 페이지 open
function confirmId() {
	if (!document.inputform.user_id.value) {
		alert("아이디를 입력하세요.");
		document.inputform.user_id.focus();
		return false;
	}
	//중복확인 버튼 클릭시 컨트롤러 url을 전달, 컨트롤러에 소스 추가
	let url = "/jsp_pj_ict05/idConfirmAction.do?user_id=" + document.inputform.user_id.value;
	window.open(url, "confirm", "menubar=no, width=500, height=400");
}

// 회원가입, 수정시의 이메일
function selectEmailChk(selectElem) {

	const email2 = document.getElementById('user_email2');
	const value = selectElem.value;
	console.log(value);
	if (value === '0') {
		email2.value = '';
		email2.focus();
	} else {
		email2.value = value;
	}

}

// 회원가입, 수정시 이메일
function detail_selectEmailChk(selectElem) {
	const email2 = document.getElementById('user_email2');
	const value = selectElem.value;
	console.log(value);
	if (value === '0') {
		email2.value = '';
		email2.focus();
	} else {
		email2.value = value;
	}
}

// 2. join.jsp - onSubmit시 - 회원가입페이지 필수 체크

// onSubmit(제출)
function singleCheck() {
	/* 2-1. 중복확인 버튼 안 눌렀을때 0으로 설정
		<input type="hidden" name="hiddenUserid" value="0">
		hiddenUserid : 중복확인 버튼 안눌렀을때 체크(0: 클릭안함, 1:클릭함)
	*/

	/* 2-2. 중복확인 버튼 클릭하지 않는 경우 "중복확인 해주세요.!!" 메시지 띄운다.*/
	if (document.inputform.hiddenUserid.value == "0") {
		alert("중복확인 해주세요.!!");
		document.inputform.dubChk.focus();
		return false;
	}

	// 비밀번호 불일치 => 과제
	if (document.inputform.user_password.value != document.inputform.re_password.value) {
		alert("비밀번호가 불이치합니다.");
		return false;
	}
}

// 3. 사용가능한 id를 찾은 경우 => 자식창에서 부모창으로 user_id을 전달
/*
	opener : window 객체의 open() 메서드로 열린 자식창(=증복확인창)에서 부모창(=회원가입창)에 접근할 때 사용
	hiddenUserId : 증복확인 버튼 안눌렀을때 체크(0: 클릭안함, 1: 클릭함)
	selft.close() // 자식창 닫기
*/
function setUserId(userid) {

	opener.document.inputform.user_id.value = userid;
	opener.document.inputform.hiddenUserid.value = "1";
	self.close();

}


