<%@page import="com.dto.MemberDTO"%>
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
							$("#passVerify").text("4자리 이상 16자리 이하 비밀번호").css("color", "red");
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
				
   
				
		}	//document.ready 무명함수 끝
    );	//document.ready 끝   
</script>   
<style>
	.bottom{
		display: table;
  		margin-left: auto;
 		margin-right: auto;
	}
	.bottom .btn{
		margin:10px;
	}
	form{
		display: table;
  		margin-left: auto;
 		margin-right: auto;
	}
</style> 
<%
	MemberDTO dto=(MemberDTO)session.getAttribute("login");
	System.out.print(dto);
	String userid=dto.getUserid();
	String username=dto.getUsername();
	String passwd=dto.getPasswd();
	String phone1=dto.getPhone1();
	String phone2=dto.getPhone2();
	String phone3=dto.getPhone3();
	String email1=dto.getEmail1();
	String email2=dto.getEmail2();
%>
<form action="MemberUpdateServlet" method="get">
<input type="hidden" value="<%=userid %>" name="userid">
<p>마이페이지 입니다</p>
<label style="margin-right: 16px;" for="userid">아이디</label>
<input type="text" name="userid" id="userid"  value="<%=userid %>">
<span id = "idVerify" style="text-shadow:1px 1px 1px #000;"></span>
<br>  
<label style="margin-right: 32px;" for="username">이름</label>
<input type="text" name="username" value="<%=username %>" id = "name">
<br> 

<label for="phone">전화번호</label>
<select name="phone1">
	<option value="010">010</option>
	<option value="011" >011</option>
</select> -
<input type="text" name="phone2"  id = "phone2" value="<%=phone2%>"> - <input type="text" name="phone3" value="<%=phone3%>" id = "phone3">
<br>
<label style="margin-right: 16px;" for="email">이메일</label>
<input type="text" name="email1" id = "email" value="<%=email1%>"> @
<input style="margin-right: 5px;" type="text" name="email2" id="emailinfo"  value="<%=email2%>">
<select id = "emailPortal">
	<option value="daum.net">daum.net</option>
	<option value="naver.com">naver.com</option>
	<option value="gmail.com">google.com</option>
</select>
<br>
<div class="bottom">
<input class="btn btn-outline-dark" type="submit" value="수정">	
<input class="btn btn-outline-dark" type="reset" value="취소">
</div>
</form>


