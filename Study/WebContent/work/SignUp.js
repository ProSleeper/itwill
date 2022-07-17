class CheckBirth {
    constructor() {
        this.date = new Date();

        this.inputYear = null;
        this.selectMonth = null;
        this.inputDay = null;

        this.resultYear = null;
        this.resultMonth = null;
        this.resultDay = null;

        this.alertMSG_Year = [];
        this.alertMSG_Day = [];

        this.alertMSG_Year[0] = "태어난 년도 4자리를 정확하게 입력하세요.";
        this.alertMSG_Year[1] = "정말이세요?";

        this.alertMSG_Day[0] = "생년월일을 다시 확인해주세요.";
        this.alertMSG_Day[1] = "태어난 일(날짜) 2자리를 정확하게 입력하세요.";
    }

    year(pYear) {
        const regex = /^[0-9]{4}$/;
        if (!regex.test(pYear)) {
            // infoText.innerText = "태어난 년도 4자리를 정확하게 입력하세요.";
            return 0;
        } else if (Number(pYear) <= this.date.getFullYear() - 100) {
            // infoText.innerText = "정말이세요?";
            return 1;
        } else {
            // infoText.innerText = "";
            return 2;
        }
    }

    month(pMonth) {
        if (pMonth == 0) {
            // infoText.innerText = "태어난 월을 선택하세요.";
            return 1;
        } else {
            // infoText.innerText = "";
            return 2;
        }
    }

    day(pYear, pMonth, pDay) {
        var lastDayOfMonth = new Date(pYear, pMonth, 0).getDate(); //이렇게 하면 해당 년도의 월의 마지막 날을 반환해줌.

        if (this.year(pYear) != 2 || this.month(pMonth) != 2) {
            return 0;
        } else if (pDay < 1 || pDay > lastDayOfMonth) {
            return 1;
        } else {
            return 2;
        }

        /* 
            조건
            1. 년도와 월 둘중 하나라도 제대로 안되어있다면.
            2. 입력한 숫자가 선택한 년+월+일 값을 벗어났다면
            3. 제대로 입력된 값
        */
    }

    check() {
        this.inputYear = Number(document.getElementById("inputbox_Birth_Year").value);
        this.selectMonth = Number(document.getElementById("select_Birth_Month").value);
        this.inputDay = Number(document.getElementById("inputbox_Birth_Day").value);

        this.resultYear = this.year(this.inputYear);
        this.resultMonth = this.month(this.selectMonth);
        this.resultDay = this.day(this.inputYear, this.selectMonth, this.inputDay);

        var infoText = document.getElementById("alert_text_Birth");
        infoText.style = "display: default; color: red";
        infoText.innerText = "";

        if (this.resultYear != 2) {
            infoText.innerText = this.alertMSG_Year[this.resultYear];
        } else if (this.resultMonth != 2) {
            infoText.innerText = "태어난 월을 선택하세요.";
        } else if (this.resultDay != 2) {
            infoText.innerText = this.alertMSG_Day[this.resultDay];
        }
    }
}

let chkBirth = new CheckBirth();

/* 
    1. 숫자 4자리여야한다.
     -태어난 년도 4자리를 정확하게 입력하세요.
    2. 현재 년도(2022년을 기준으로 -100년까지만 올바른 가입이다.
     -100년, 즉 1922년생까지 가입은 정말이세요? 를 보여줌. 1923년생부터 메세지 안뜸    
     -정말이세요? 
    


*/

// 생일은 현재를 기준으로 딱 (100년 - 하루)까지는 아무 메세지도 없고(형식이 맞다면)
// 100년이상이면 정말이세요? 라고 물어봄
// 년은
// 윤년도 다 따진다.
// 만 14세 미만 어린이는 보호자 동의가 필요합니다.
// 만나이 계산은 오늘을 기준으로 -14년 +1일을 하면 그떄까지는 만나이다.
// 14세 미만은 보호자의 동의가 필요하다.

class CellPhone {
    constructor() {
        this.selectCountry = null;
        this.selectMonth = null;
        this.inputDay = null;

        this.resultYear = null;
        this.resultMonth = null;
        this.resultDay = null;

        this.alertMSG_Year = [];
        this.alertMSG_Day = [];

        this.alertMSG_Year[0] = "태어난 년도 4자리를 정확하게 입력하세요.";
        this.alertMSG_Year[1] = "정말이세요?";

        this.alertMSG_Day[0] = "생년월일을 다시 확인해주세요.";
        this.alertMSG_Day[1] = "태어난 일(날짜) 2자리를 정확하게 입력하세요.";
    }

    country(pCountryNumber) {
        if (pCountryNumber.value.length == 0) {
            this.selectCountry = 1;
        } else {
            this.selectCountry = 0;
        }

        console.log(this.selectCountry);
        //너무 조건이 많아서 그냥 한국일때 국내 번호 체계인지만 확인
        //1이면 한국 0이면 타국
    }
    number(pPhoneNumber) {
        var infoText = document.getElementById("alert_text_Number");
        infoText.style = "display: default; color: red";

        if (pPhoneNumber.value.length == 0) {
            infoText.innerText = "필수 정보입니다.";
        } else {
            infoText.innerText = "";
        }
    }

    certificationNumber(pPhoneNumber) {
        var infoText = document.getElementById("alert_text_Number");
        infoText.style = "display: default; color: red";

        var inputPhoneObj = document.getElementById(pPhoneNumber);
        var inputNumber = String(inputPhoneObj.value);

        inputNumber = inputNumber.replaceAll("-", "");
        inputPhoneObj.value = inputNumber;

        const rand_9999 = Math.floor(Math.random() * 9000 + 1000);
        console.log(rand_9999);

        alert("[Web발신]\n[네이버] 인증번호[" + String(rand_9999) + "]를 입력해\n주세요.");
    }

    //01 1,6,7,8,9만 가운데 3자리가 됨
    //010은 가운데 3자리 안됨.
    //형식이 맞으면 사이의 -는 자동 없애줌.
    //- 두개중에 하나만 있어도 자동 없애줌
    //검사 안해주는 조건도 있네 맨 앞에 = 하니까 없애주지도 않고 인증도 안됨.
    //모든 -는 없애줌!

    sendCertificationNumber() {
        alert("인증번호 받기 버튼");
    }

    // 전화번호 입력과 입력받기가 하나의 경고메시지 공유
    // 인증번호가 하나의 경고메세지 공유
    // 나라가 다르면 "전화번호를 다시 확인해주세요."(전화번호 경고메세지에) 출력
    // <!-- 형식에 맞지 않으면(알파벳,숫자자리부족) -->
    // <!-- 형식에 맞지 않는 번호입니다.(인증번호 입력하는 곳 아래에 뜸(이때는 글씨만 빨간색)) -->
}

let chkPhone = new CellPhone();

class PassWord {
    constructor() {
        this.originPW = null;
    }
    check(pInputPW) {
        this.originPW = pInputPW.value;
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

    reconfirm(pInputRePW) {
        var reconfirmPW = pInputRePW.value;
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
        if (event.key == "CapsLock") {
            //네이버와 동일한 구현을 위한 코드
            return;
        }
        var infoText = document.getElementById(alert_text);
        infoText.style = "display: default; color: red";

        if (event.getModifierState("CapsLock")) {
            infoText.innerText = "Caps Lock 이 켜져 있습니다.";
        } else {
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
function checkID(pInputID) {
    // alert(params);
    infoText = document.getElementById("alert_text_ID");

    infoText.style = "display: default; color: red";
    // var inputText = String(document.getElementById("inputbox_ID").value);
    const regex = /^[0-9a-z]{1}[0-9a-z_-]{4,19}$/;

    if (pInputID.value.length == 0) {
        infoText.innerText = "필수 정보입니다.";
    } else if (/*db적용시 중복값 체크*/ null) {
        alert("중복값 체크");
    } else if (!regex.test(pInputID.value)) {
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

function checkGender(selectGender) {
    console.log(selectGender.value);
    infoText = document.getElementById("alert_text_Gender");
    infoText.style = "display: default; color: red";
    if (selectGender.value.length == 0) {
        infoText.innerText = "필수 정보입니다.";
    } else {
        infoText.innerText = "";
    }
    // 성별은 기본 상태에서는 괜찮지만
    // 다른 것을 선택한 후 다시 선택을 하면 필수 정보입니다. 라고 뜸
    // 유일한 변동은 가입버튼 누를때 선택 안
}

function checkEmail(pInputEmail) {
    infoText = document.getElementById("alert_text_Email");
    infoText.style = "display: default; color: red";
    const regex = /^[0-9a-zA-Z\!\#\$\%\^\&\*\(\)\_\+\-\=\~\₩\{\}\'\<\>\.\/\?\|]+\@[0-9a-zA-Z\.]+\.{1}[0-9a-zA-Z]+[a-zA-Z]{1}$/;

    if (regex.test(pInputEmail.value) || pInputEmail.value == "") {
        infoText.innerText = "";
    } else {
        infoText.innerText = "이메일 주소를 다시 확인해주세요.";
    }

    // <!-- 100칸 -->
    // <!-- e메일 형식에 맞지 않으면 -->
    // <!-- 이메일 주소를 다시 확인해주세요. -->
    // <!-- 형식만 맞으면 중복이어도 상관없나보다. 선택사항이라서 -->
    // <!-- _____@naver.com 이어도 오류는 안남 -->
    // @뒷 부분은 무조건 알파벳으로 끝나야 함.
    // @뒤에 .이 몇개 있어도 상관 없음.
    // 맨 첫글자는 @,한글 자음 안됨
    // @딱 한번만 들어가야함.
    // @뒤에는 영어 + 숫자만 가능
    // 세미콜론":" "안됨 ,안됨 대괄호 안됨. @ 앞에
}

function signUpClick() {
    alert("가입하기 버튼");
}

//각 텍스트 클릭시 해당 inputbox로 focus 해줌.
function setFocus(params) {
    document.getElementById(params).focus();
}
