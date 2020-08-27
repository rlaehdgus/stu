<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<div class="wrap">
	<div class="form-wrap">
		<div class="button-wrap">
			<div id="btn" style="left: -3px;"></div>
			<button type="button" class="togglebtn" onclick="login()">LOG IN</button>
			<button type="button" class="togglebtn" onclick="register()">REGISTER</button>
		</div>
		<div class="social-icons">
			<a href="#"><img src="/assets/img/fb.png" alt="facebook"></a>
			<a href="#"><img src="/assets/img/kao.png" alt="kakao"></a>
			<a href="#"><img src="/assets/img/gl.png" alt="google"></a>
		</div>
		<form id="login" action="" class="input-group">
			<input type="text" id="id" class="input-field" placeholder="User ID" required>
			<input type="password" id="pass" class="input-field" placeholder="Enter Password" required>
			<input type="checkbox" class="checkbox"><span>Remember Password</span>
			<button class="submit">Login</button>
		</form>
		<form id="register" action="/register" class="input-group" method="POST">
			<input type="text" id="id" name="id" class="input-field" placeholder="Your ID" required>
			<input type="password" id="pass" name="pass" class="input-field" placeholder="Your Password" required>
			<input type="text" id="name" name="name" class="input-field" placeholder="Your Full name" required>
			<input type="text" id="phone" name="phone" class="input-field" placeholder="Your Phone" required>
			<input type="text" id="birth" name="birth" class="input-field" placeholder="Your Birth" required>
			<input type="text" id="zipCode" name="zipCode" class="input-field" placeholder="Your Zip Code" required>
			<button type="button" class="juso-btn" onclick="DaumPostcode()">우편번호</button>
			<input type="text" id="addr" name="addr" class="input-field" placeholder="Your Juso" required>
			<input type="text" id="detailAddr" name="detailAddr" class="input-field" placeholder="Your Detail Addr" required>
			<button class="submit">REGISTER</button>
		</form>
    </div>
</div>
<script>
var x = document.getElementById("login");
var y = document.getElementById("register");
var z = document.getElementById("btn");

function login(){
    x.style.left = "50px";
    y.style.left = "450px";
    z.style.left = "-3px";
    
    $(".form-wrap").css("height", "480px");
}

function register(){
    x.style.left = "-400px";
    y.style.left = "50px";
    z.style.left = "113px";
    
    $(".form-wrap").css("height", "650px");
}
</script>
<script>
function DaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("addr").value = extraAddr;
            
            } else {
                document.getElementById("addr").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zipCode').value = data.zonecode;
            document.getElementById("addr").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailAddr").focus();
        }
    }).open();
}
</script>