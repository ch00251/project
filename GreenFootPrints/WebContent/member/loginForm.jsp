<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- id, 패스워드 입력 검사 후 진행하도록  작성  -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("form").on("submit",function(event){
			var userid=$("#userid").val();
			var passwd=$("#passwd").val();
			if(userid.length==0){
				alert("아이디를 입력하세요.");
				$("#userid").focus();
				event.preventDefault();
			}else if(passwd.length==0){
				alert("비밀번호를 입력하세요.");
				$("#passwd").focus();
				event.preventDefault();
			}
		})
	});
</script>  
<form action="LoginServlet" method="get">
아이디:<input type="text" name="userid" id="userid"><br>
비밀번호:<input type="text" name="passwd" id="passwd"><br> 
<input type="submit" value="로그인">
<input type="reset" value="취소">
</form>
