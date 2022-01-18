<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(
    		function() {


				
		}	//document.ready 무명함수 끝
    );	//document.ready 끝
   
    
</script>    
<form action="MemberAddServlet" method="get">
	제조사
	<input type="text" name="" id="" placeholder = "제조사를 입력하세요">
	<span id = "idVerify" style="text-shadow:1px 1px 1px #000;"></span>
	<br> 
	제품명
	<input type="text" name="" id="" placeholder = "제품이름을 적어주세요">
	<span id = "passVerify" style="text-shadow:1px 1px 1px #000;"></span>
	<br> 
	제품 설명
	<br> 
	<textarea placeholder = "제품을 설명해주세요." style = 'noresize : none;'></textarea>
	<br> 
	제품 사진
	<input type = "file">
	<br>
	친환경
	<select>
		<option>종이</option>
		<option>병</option>
		<option>캔</option>
		<option>고철</option>
		<option>의류</option>
		<option>플라스틱</option>
		<option>박스</option>
	</select>
	<input type = "text">
	<button>투척</button>
	불친환경
	<select>
		<option>종이</option>
		<option>병</option>
		<option>고철</option>
		<option>의류</option>
		<option>플라스틱</option>
	</select>
	<input type = "text">
	<button>투척</button>
	<br>
	<hr>
	<span id = "trash1"></span><span id = "trash1Gram"></span>
	<br>
	<span id = "trash2"></span><span id = "trash2Gram"></span>
	<hr>
	
	
	<input type="submit" value="회원가입" id = "submit" disabled = "true">	
	<input type="reset" value="초기화">
</form>

