class CheckBirth {
    Year() {
        alert("연도 확인");
    }

    Month() {
        alert("월 확인");
    }

    Day() {
        alert("일 확인");
    }
}

class CellPhone {
    country() {
        alert("국가 확인");
    }
    number() {
        alert("전화번호 확인");
    }

    certificationNumber() {
        alert("인증번호 확인");
    }

    sendCertificationNumber() {
        alert("인증번호 받기 버튼");
    }
}

class PassWord {
    constructor() {
        this.originPW = null;
    }
    check(pInputBoxText) {
        this.originPW = pInputBoxText.value;
        var infoText = document.getElementById("alert_text_PW");
        infoText.style = "display: default; color: red";

        //실제로는 조건이 아주 복잡한 것 같다.
        //문서로 정리되어있으면 몰라도 그걸 일일히 찾는 건 시간낭비 같다.
        //그냥 아래 조건정도만 체크하자
        const regex = /^[\w\~\`\!\@\#\$\%\^\&\*\(\)\=\+\|\.\<\,\>\/\?\"\'\:\;\[\]\{\}]{8,16}$/;
        if (this.originPW.length == 0) {
            infoText.innerText = "필수 정보입니다.";
        } else if (!regex.test(this.originPW)) {
            infoText.innerText = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
        } else {
            infoText.innerText = "";
            // 여기서 자물쇠 부분을 바꿔주면 될듯
            // 자세한 판단방법은 나도 모르니 그냥 내가 알아서~
        }

        /*
    CAPS LOCK 켜져있으면 켜져 있다고 알려줌
    알려주는 조건은 문자 입력시에만인듯. 숫자 입력하니까 메세지 사라짐
    그러다가 다시 문자 입력하면 알려줌
    1A1A입력하면 나왔다가 사라졌다가 반복함
    Caps Lock 이 켜져 있습니다.

    *아이콘* 
    1.기본: 회색 점표시 자물쇠(문자는 없음)
    2.마우스 클릭 후 focus를 잃었을 때
    -필수 정보입니다.
    2.사용불가: 빨간 점표시 자물쇠(자물쇠 왼쪽 "사용불가" 적힘)
    -8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.
    3.보통: 연한 주황색 자물쇠(자물쇠 왼쪽 "보통" 적힘)(이 조건은 비밀번호로 사용은 가능한듯)
    4.위험: 진한 주황색 자물쇠(자물쇠 왼쪽 "위험" 적힘)
    -8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.
    5.안전: 녹색 자물쇠(자물쇠 왼쪽 "안전" 적힘)
    */
    }

    reconfirm(pInputBoxText) {
        var reconfirmPW = pInputBoxText.value;
        var infoText = document.getElementById("alert_text_CPW");
        infoText.style = "display: default; color: red";

        //실제로는 조건이 아주 복잡한 것 같다.
        //문서로 정리되어있으면 몰라도 그걸 일일히 찾는 건 시간낭비 같다.
        //그냥 아래 조건정도만 체크하자
        if (reconfirmPW.length == 0) {
            infoText.innerText = "필수 정보입니다.";
        } else if (this.originPW != reconfirmPW) {
            infoText.innerText = "비밀번호가 일치하지 않습니다.";
        } else {
            infoText.innerText = "";
            // 여기서 자물쇠 부분을 바꿔주면 될듯
            // 자세한 판단방법은 나도 모르니 그냥 내가 알아서~
        }
    }

    isCapsLockOn(event, alert_text) {
        if (event.key == "CapsLock") {    //네이버와 동일한 구현을 위한 코드
            return;
        }
        var infoText = document.getElementById(alert_text);
        infoText.style = "display: default; color: red";

        if (event.getModifierState("CapsLock")) {
            infoText.innerText = "Caps Lock 이 켜져 있습니다.";
        }
        else {
            infoText.innerText = "";
        }
    }
}

let chkPW = new PassWord();

// 아래 테스트 방식으로 경고 만들면 될듯.
function test() {
    document.getElementById("alert_text_ID").style = "display: default; color: rd";
}

function test2() {
    document.getElementById("alert_text_ID").style = "display: none;";
}
function checkID(pInputBoxText) {
    // alert(params);
    infoText = document.getElementById("alert_text_ID");

    infoText.style = "display: default; color: red";
    // var inputText = String(document.getElementById("inputbox_ID").value);
    const regex = /^[0-9a-z]{1}[0-9a-z_-]{4,19}$/;

    if (pInputBoxText.value.length == 0) {
        infoText.innerText = "필수 정보입니다.";
    } else if (/*db적용시 중복값 체크*/ null) {
        alert("중복값 체크");
    } else if (!regex.test(pInputBoxText.value)) {
        infoText.innerText = "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
    } else {
        infoText.style = "display: default; color: green";
        infoText.innerText = "멋진 아이디네요!";
    }

    // 아이디의 입력 조건
    // 1. 형식이 맞지 않을 때
    //  -5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.
    // 2. 중복이거나 탈퇴한 아이디일 때
    // 	-이미 사용중이거나 탈퇴한 아이디입니다.
    // 3. 사용 가능할 때
    // 	-멋진 아이디네요!
    // 4. 포커스가 왔다가 나갔는데 아무 값이 없을 때
    //  -필수 정보입니다.
}

function checkName(pInputBoxText) {
    var infoText = document.getElementById("alert_text_Name");
    infoText.style = "display: default; color: red";

    //실제로는 조건이 아주 복잡한 것 같다.
    //문서로 정리되어있으면 몰라도 그걸 일일히 찾는 건 시간낭비 같다.
    //그냥 아래 조건정도만 체크하자
    const regex = /^[0-9a-zA-Z가-힣]{1,40}$/;
    if (pInputBoxText.value.length == 0) {
        infoText.innerText = "필수 정보입니다.";
    } else if (!regex.test(pInputBoxText.value)) {
        infoText.innerText = "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)";
    } else {
        infoText.innerText = "";
    }
}


// <!-- 40칸 -->
//                 <!-- 이름에 숫자가 잔뜩들어가도 딱히 뭐라 메세지가 없는 걸 보면 -->
//                 <!-- 한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가) -->

function checkGender() {
    alert("성별 확인");
}

function checkEmail() {
    alert("이메일 확인");
}

function signUpClick() {
    alert("가입하기 버튼");
}

//각 텍스트 클릭시 해당 inputbox로 focus 해줌.
function setFocus(params) {
    document.getElementById(params).focus();
}
