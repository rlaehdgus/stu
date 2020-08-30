<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
.form-wrap {
    width: 380px;
    height: 550px;
    position: relative;
    margin: 3% auto;
    background: #fff;
    padding: 5px;
    overflow: hidden;
    border: 1px solid #ece6e8;
}

.input-group-form {
	position: absolute;
    width: 280px;
}

.input-field-form {
	width: 100%;
    padding: 10px 0;
    margin: 5px 0;
    border: none;
    border-bottom: 1px solid #999;
    outline: none;
    background: transparent;
}

.submit {
	width: 85%;
    padding: 10px 30px;
    cursor: pointer;
    display: block;
    margin: 25px auto;
    background: #ffffff;
    border: 1px solid #000000;
    outline: none;
    border-radius: 30px;
}

</style>
<div class="wrap">
	<div class="form-wrap">
		<div>
			<h2 style="text-align: center;">내정보 수정</h2>
		</div>
		<div style="left: 55px; position: absolute;">
			<form id="editForm" class="input-group-form" method="POST">
				<input type="text" name="id" class="input-field-form" placeholder="Your ID" required>
				<input type="password" name="pass" class="input-field-form" placeholder="Your Password" required>
				<input type="text" name="name" class="input-field-form" placeholder="Your Full name" required>
				<input type="text" name="phone" class="input-field-form" placeholder="Your Phone" required>
				<input type="text" name="birth" class="input-field-form" placeholder="Your Birth" required>
				<input type="text" id="zipCode" name="zipCode" class="input-field-form" placeholder="Your Zip Code" required>
				<button type="button" class="juso-btn" onclick="DaumPostcode()">우편번호</button>
				<input type="text" id="addr" name="addr" class="input-field-form" placeholder="Your Juso" required>
				<input type="text" id="detailAddr" name="detailAddr" class="input-field-form" placeholder="Your Detail Addr" required>
				<button type="button" id="editBtn" class="submit">Edit</button>
			</form>
		</div>
	</div>
</div>
<script>
$(function(){
	$("#editBtn").click(function(){
		$.ajax({
			url: "/mypage/editInfo",
			type: "POST",
			data: $("#editForm").serialize(),
			success: function(data) {
				if(data.RESULT == "SUCCESS"){
					alert(data.MESSAGE);
					location.href="/mypage/info";
				} else {
					alert(data.MESSAGE);
				}
			}
		});
	});
});
</script>