<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(
    		function() {

    			var idLength = false;	//아이디길이 판정 변수
    			var passComp = false;	//비밀번호 비교 판정 변수
    			var nameLength = $("#name").length;
    			
				$("#userid").on("keyup",
					function() {
						var userid = $("#userid").val();
						
						if( (userid.length >= 4) && (userid.length <= 16) ) {
							$("#idVerify").text("아이디 사용 가능").css("color", "#78E150");
							idLength = true;
						}
						else {
							$("#idVerify").text("아이디 사용 불가능").css("color", "red");
						}
						
					}		
				);	//아이디 길이 판정 제이쿼리 끝
				
				
				$("#passwd2").keyup(
					function() {
						var pw1= $("#passwd").val();
						var pw2= $("#passwd2").val();
						
						if (pw1 == pw2) {
						   $("#result2").text("비밀번호 일치").css("color", "#78E150");
						   passComp = true;
						}
						else {
						   $("#result2").text("비밀번호 불일치").css("color", "red");   
						}
					}
				); // 비밀번호 동일 확인 제이쿼리 끝
				
				$("#passwd").on("keyup",
					function() {
						var pw1 = $("#passwd").val();
							
						if( (pw1.length >= 4) && (pw1.length <= 16) ) {
							$("#passVerify").text("비밀번호 사용가능").css("color", "#78E150");
						}
						else {
							$("#passVerify").text("4자리 이상 16자리 이하 비밀번호를 사용해야 합니다.").css("color", "red");
						}
					}
				); //비밀번호 길이 알림 제이쿼리 끝
				
				
				$("#phone2").on("keyup",
					function() {
						var p2 = $("#phone2").val();
						var p3 = $("#phone3");
						
						if(p2.length == 4) {
							p3.focus();
						}
					}		
				);	//폰번호2 중간 4자리 작성시 자동 포커스 이동
				
				$("#phone3").on("keyup",
					function() {
						var p3 = $("#phone3").val();
						var email = $("#email");
						
						if(p3.length == 4) {
							email.focus();
						}
					}		
				);	//폰번호3 중간 4자리 작성시 이메일로 자동 포커스 이동
				
				$("#emailPortal").on("change",
					function() {
				    	var emailPortal = $(this).val();
				    	
				    	$("#emailinfo").val(emailPortal);
					}
				);	// 메일 선택시 메일2에 자동입력
				
				
				$("input").on("keyup",
					function() {
						if(passComp && idLength && nameLength > 0) {
							$("#submit").removeAttr("disabled");
						}
						else {
							$('#submit').attr('disabled','disabled');
						}
					}
				);
				
				$("#userid").on("keyup",
					function() {
						$.ajax({
							type : "get",
							url : "MemberIdCheckServlet",
							dataType : "text",
							data : {
								userid : $("#userid").val()
							},
							success : function(responseData, status, xhr) {
								
							    if(responseDate = "아이디 중복") {
							    	$("#idVerify").text("아이디 사용 불가능").css("color", "red");
							    }
							},
							error : function(xhr, status, error) {
								
							}
							
						})
						
					}		
				)	
   
				
		}	//document.ready 무명함수 끝
    );	//document.ready 끝
   
    
</script>    
<form action="MemberAddServlet" method="get">
*아이디:
<input type="text" name="userid" id="userid" placeholder = "아이디를 입력하세요">
<span id = "idVerify" style="text-shadow:1px 1px 1px #000;"></span>
<br> 
*비밀번호:
<input type="password" name="passwd" id="passwd" placeholder = "비밀번호를 입력하세요">
<span id = "passVerify" style="text-shadow:1px 1px 1px #000;"></span>
<br> 
*비빌번호확인:
<input type="password" name="passwd2" id="passwd2" placeholder = "비밀번호 확인">
<span id="result2" style="text-shadow:1px 1px 1px #000;"></span>
<br> 
*이름:
<input type="text" name="username" placeholder="실명을 입력하세요" id = "name">
<br> 

*전화번호:
<select name="phone1">
	<option value="010">010</option>
	<option value="011" >011</option>
</select>-
<input type="text" name="phone2"  id = "phone2">-<input type="text" name="phone3" id = "phone3">
<br>
*이메일:
<input type="text" name="email1" id = "email">@
<input type="text" name="email2" id="emailinfo"  placeholder="직접입력">
<select id = "emailPortal">
	<option value="daum.net">daum.net</option>
	<option value="naver.com">naver.com</option>
	<option value="gmail.com">google.com</option>
</select>
<br>
<input type="submit" value="회원가입" id = "submit" disabled = "true">	
<input type="reset" value="초기화">
</form>

