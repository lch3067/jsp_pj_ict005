/**
 * 
 */

// 회원가입, 수정시 이메일
function modify_selectEmailChk(selectElem) {
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

// 2. modifyDetailAction.jsp - onSubmit시 - 회원가입페이지 필수 체크
function modifyCheck() {

	// 비밀번호 불일치 => 과제
	if (document.inputform.user_password.value != document.inputform.re_password.value) {
		alert("비밀번호가 불이치합니다.");
		return false;
	}

}

