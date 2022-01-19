<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(
    	function() {
				

				
		}	//document.ready 무명함수 끝
    );	//document.ready 끝
   
    
</script>    
<form action="TrashAddServlet" method="get">
	제조사
	<input type="text" placeholder = "제조사를 입력하세요" name = "company">
	<span id = "" style="text-shadow:1px 1px 1px #000;"></span>
	<br> 
	제품명
	<input type="text" id="" placeholder = "제품이름을 적어주세요" name = "tName">
	<span id = "" style="text-shadow:1px 1px 1px #000;"></span>
	<br> 
	제품 설명
	<br> 
	<textarea placeholder = "제품을 설명해주세요." name = "tExp"></textarea>
	<br> 

	
	
	
	<br>
	<hr>
	그나마 괜찮은 쓰레기 <br>
	<span id = "trashG1">종이</span><input placeholder = "무게를 적어주세요 g단위"></span> <button>투척</button>
	<input type = "text"  name = "tCateEGram1"  value = "0"> <button>삭제</button>
	<br>
	<span id = "trashG2">병</span><input placeholder = "무게를 적어주세요 g단위"></span>  <button>투척</button> 
	<input type = "text" name = "tCateEGram2" value = "0"> <button>삭제</button>
	<br>
	<span id = "trashG3">캔</span><input  placeholder = "무게를 적어주세요 g단위"></span> <button>투척</button> 
	<input type = "text" name = "tCateEGram3" value = "0"> <button>삭제</button>
	<br>
	<span id = "trashG4">고철</span><input  placeholder = "무게를 적어주세요 g단위"></span> <button>투척</button>
	<input type = "text" name = "tCateEGram4" value = "0"> <button>삭제</button>
	<br>
	<span id = "trashG5">의류</span><input  placeholder = "무게를 적어주세요 g단위"></span> <button>투척</button> 
	<input type = "text" name = "tCateEGram5" value = "0"> <button>삭제</button>
	<br>
	<span id = "trashG6">플라스틱</span><input  placeholder = "무게를 적어주세요 g단위"></span> <button>투척</button>
	<input type = "text" name = "tCateEGram6" value = "0"> <button>삭제</button>
	<br>
	<span id = "trashG7">박스</span><input  placeholder = "무게를 적어주세요 g단위"></span> <button>투척</button> 
	<input type = "text" name = "tCateEGram7" value = "0"> <button>삭제</button>
	<br>
	
	<br>
	답도 없는 쓰레기 <br>
	<span id = "trashU1">종이</span><input  placeholder = "무게를 적어주세요 g단위"></span> <button>투척</button>
	<input type = "text" name = "tCateNGram1" value = "0"> <button>삭제</button>
	<br>
	<span id = "trashU2">병</span><input  placeholder = "무게를 적어주세요 g단위"></span> <button>투척</button>
	<input type = "text" name = "tCateNGram2" value = "0"> <button>삭제</button>
	<br>
	<span id = "trashU3">고철</span><input placeholder = "무게를 적어주세요 g단위"></span> <button>투척</button> 
	<input type = "text" name = "tCateNGram3" value = "0"> <button>삭제</button>
	<br>
	<span id = "trashU4">의류</span><input  placeholder = "무게를 적어주세요 g단위"></span> <button>투척</button>
	<input type = "text" name = "tCateNGram4" value = "0"> <button>삭제</button>
	<br>
	<span id = "trashU5">플라스틱</span><input  placeholder = "무게를 적어주세요 g단위"></span> <button>투척</button> 
	<input type = "text" name = "tCateNGram5" value = "0"> <button>삭제</button>
	<br>
	<hr>
	
	
	<input type="submit" value="저장하기" id = "submit">	
	<input type="reset" value="초기화">
</form>

