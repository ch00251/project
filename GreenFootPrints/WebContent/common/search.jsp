<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <style>
 input:-ms-input-placeholder {color:#a8a8a8;}
 input::-webkit-input-placeholder {color:#a8a8a8;}
 input::-moz-placeholder {color:#a8a8a8;}
 
 #search{
 height : 90px;/* 수정 */
 width : 700px;
 border : 3px solid black;
 background : #ffffff;
 margin:0 auto; 
 }
 
 input{
 margin-top:15px;  /* 추가 */
 margin-left:10px;	/* 추가 */
 font-size : 35px;	/* 수정 */
 width : 575px;
 padding : 10 px;
 border:0px;
 outline : none;
 float:left; 
 }
 
 button{
 	margin-top:5px;  /* 추가 */
 	font-size : 40px;
 	width : 100px;
 	height : 100%;
 	border : 0px;
 	background :#ffffff;
 	outline:none;
 	float:right;
 	color:#ffffff 
 	 }
 ul{/* 추가 */
 	padding: 30px;
 }
 ul li{ /* 추가 */
 	display: inline;
 }
 ul li img{ /* 추가 */
 	width: 145px;
 	height: 160px;
 	margin:0 5px;
 }
</style>
    
 <div id = "search">
 <form action="SearchUIServlet" method="get">
 	<input type = "text" name = "gName" placeholder="상품명 입력">
 	<button><img src="images/button.PNG"></button>
 </form>
 <!-- 추가 -->
 <br><br><br><br><br><br>
 	<ul>
 		<li><img src="images/재활용.png"></li>
 		<li><img src="images/녹색인증.png"></li>
 		<li><img src="images/이달의 녹색.png"></li>
 		<li><a href=""><img src="images/자유게시판.png"></a></li>
 	</ul>
 </div>
