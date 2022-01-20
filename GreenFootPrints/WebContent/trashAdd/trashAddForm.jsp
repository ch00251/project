<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(
    	function() {
    		
    			
    			
    			
				$("#tName").on("keyup",
					function() {
						$.ajax({
							type : "get",
							url : "TrashNameCheckServlet",
							dataType : "text",
							data : {
								tName : $("#tName").val()
							},
							success : function(data) {
								$("#tNameCheck").text(data);
								if(data == "중복된 제품 입니다.") {
									$('#submit').attr('disabled','disabled');
								}
								else {
									$("#submit").removeAttr("disabled");
								}
							},
							error : function() {
								console.log("error")
							}
							
						})
						
					}		
				)	// 제품 중복 체크 중복될시 저장하기 버튼 잠금 기능 추가
				

				
				
				
				
				
		}	//document.ready 무명함수 끝
    );	//document.ready 끝
   
    
</script>    
<div style = "text-align: center;">
	<form action="TrashAddServlet" method="get">
		제조사
		<input type="text" placeholder = "제조사를 입력하세요" name = "company">
		<span id = "" style="text-shadow:1px 1px 1px #000;"></span>
		<br> 
		제품명
		<input type="text" id="tName" placeholder = "제품이름을 적어주세요" name = "tName">
		<span id = "tNameCheck" style="text-shadow:1px 1px 1px #000;"></span>
		<br> 
		제품 설명
		
		<textarea placeholder = "제품을 설명해주세요." name = "tExp" ></textarea>
		<br> 
	
		
		
		
		<br>
		<hr>
		<h4 style = "color : #34C6BE">그나마 괜찮은 쓰레기</h4>
		 
		종이
		<br>
		<input type = "text"  name = "tCateEGram1"  value = "0" placeholder = "무게를 적어주세요 g단위" style = "text-align:right;">g</input>&nbsp;&nbsp;<button>초기화</button>
		<br>
		 병
		 <br>
		<input type = "text" name = "tCateEGram2" value = "0" placeholder = "무게를 적어주세요 g단위" style = "text-align:right;">g</input>&nbsp;&nbsp;<button>초기화</button>
		<br>
		캔
		<br>
		<input type = "text" name = "tCateEGram3" value = "0" placeholder = "무게를 적어주세요 g단위" style = "text-align:right;">g</input>&nbsp;&nbsp;<button>초기화</button>
		<br>
		고철
		<br>
		<input type = "text" name = "tCateEGram4" value = "0" placeholder = "무게를 적어주세요 g단위" style = "text-align:right;">g</input>&nbsp;&nbsp;<button>초기화</button>
		<br>
		의류
		<br>
		<input type = "text" name = "tCateEGram5" value = "0" placeholder = "무게를 적어주세요 g단위" style = "text-align:right;">g</input>&nbsp;&nbsp;<button>초기화</button>
		<br>
		플라스틱
		<br>
		<input type = "text" name = "tCateEGram6" value = "0" placeholder = "무게를 적어주세요 g단위" style = "text-align:right;">g</input>&nbsp;&nbsp;<button>초기화</button>
		<br>
		박스
		<br>
		<input type = "text" name = "tCateEGram7" value = "0" placeholder = "무게를 적어주세요 g단위" style = "text-align:right;">g</input>&nbsp;&nbsp;<button>초기화</button>
		<br>
		
		<br>
		<h4 style = "color : #34C6BE">답도 없는 쓰레기 </h4>
		<br>
		종이
		<br>
		<input type = "text" name = "tCateNGram1" value = "0" style = "text-align:right;">g</input>&nbsp;&nbsp;<button>초기화</button>
		<br>
		병
		<br>
		<input type = "text" name = "tCateNGram2" value = "0" style = "text-align:right;">g</input>&nbsp;&nbsp;<button>초기화</button>
		<br>
		고철
		<br>
		<input type = "text" name = "tCateNGram3" value = "0" style = "text-align:right;">g</input>&nbsp;&nbsp;<button>초기화</button>
		<br>
		의류
		<br>
		<input type = "text" name = "tCateNGram4" value = "0" style = "text-align:right;">g</input>&nbsp;&nbsp;<button>초기화</button>
		<br>
		플라스틱
		<br>
		<input type = "text" name = "tCateNGram5" value = "0" style = "text-align:right;">g</input>&nbsp;&nbsp;<button>초기화</button>
		<br>
		<hr>
		
		
		<input type="submit" value="저장하기" id = "submit">	
		<input type="reset" value="초기화">
	</form>
</div>
