<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
/* 	
	$(document).ready(
		function() {
			$("button").on("click",
				function() {
					$.ajax({
						type : "get",
						url : "CompareSearchServlet",
						dataType : "text",
						data : {
							search1 : $("#search1").val()
						},
						success : function() {
							
						},
						error : function() {
							
						}
					})
				}		
			)
		}
	)	//document 제이쿼리 끝
 */
	

</script>
<div>
<form action = "CompareSearchServlet">
	비교1
	<input type = "text" name = "search1" placeholder = "제품명을 적어주세요!" id = "search1"><button>검색</button>
	<br>
	<span id = "search1Result">
		<table border = "1">
		<tr>
			<td>제품명</td>
			<td>회사</td>
			<td>점수</td>
			<td>설명</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		</table>
	</span>
</form>
</div>