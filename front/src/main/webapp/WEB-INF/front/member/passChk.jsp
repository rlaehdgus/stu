<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<form id="passChk" method="POST">
		<input type="password" id="pass" name="pass" placeholder="Enter Password" required>
		<button type="button" id="passChkBtn">확인</button>
	</form>
</div>
<script>
$(function(){
	$("#passChkBtn").click(function(){
		$.ajax({
			url: "/mypage/passChkProc",
			type: "POST",
			data: $("#passChk").serialize(),
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