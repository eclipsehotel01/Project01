<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<script src='https://code.jquery.com/jquery-3.1.1.min.js'></script>
<link rel="stylesheet" type="text/css" href="resources/css/admin_style.css">
<script>

function del(){
	 if(confirm("정말 삭제할까요?")){
		location.href="managementboarddelete?b_num=${board.b_num}&category=${board.category}"; 
	} 

}

$(document).ready(function(){
		$("#aa").load("commentList?b_num="+$("#b_num").val(),
				function(data) {
					$("#aa").html(data);	
				});
	
 	/* $("#delete").click(function(){
 		
 		 $.ajax({  
			type:"post", 
			url:"managementboarddelete",
			data:{"b_num":$("#b_num").val()},
	 		success:function(data){
	 			location.href="managementboarddelete"			
			}
		}); 
 	}); */
	$("#update").click(function(){
		window.open("pwdCheck11?b_num=${board.b_num}&title="+$("#title").val()+"&content="+$("#content").val()+"&category="+$("#category").val(),"","width=350 height=200 scrollbars=yes");
	});
	$("#memo1").click(function(){
		window.open("loginform","","width=350 height=550 scrollbars=yes");
	});
 
 	$("#comment_btn").click(function(){
 		$.ajax({  
			type:"post", 
			url:"commentInsert",
			data:{"b_num":$("#b_num").val(),"memo":$("#memo").val(),"id":$("#id").val()},
			
			success:function(data){
				$("#aa").html(data);			
			}
		});
	});
	$("#my_btn").click(function(){
 		$.ajax({
			type:"post",
			url:"myme",
			data:{"b_num":$("#b_num").val(),"id":$("#id").val()},
			
			success:function(data){
				$("#aa").html(data);
			} 
		}); 
 	});
});
</script>
</head>
<body>
	<%@include file="../../template/admin_header.jsp" %>
	<%@include file="../../template/admin_nav.jsp" %>
	<%@include file="../../template/admin_aside.jsp" %>
	<!-- S : MAIN SECTION -->
	<section>
		<div id="main_title">	
			<img src="resources/img/btn01.png"> 타이틀입니다.
		</div>
		<div id="main_content">
			z
			
			<form action="boardReply" method="post">
				<h1>게시물 상세보기</h1>
				
				<input type="hidden" name="b_num"  id ="b_num"  value="${board.b_num}">
				<input type="hidden" name="groups"  id ="groups"  value="${board.groups}">
				<input type="hidden" name="levels"  id ="levels"  value="${board.levels}">
				<input type="hidden" name="steps"  id ="steps"  value="${board.steps}">
				<input type="hidden" name="category" id="category" value="${board.category }">
			
				<table border=1>  
				<tr>			
					<th>게시물번호</th><td>${board.b_num }</td>
				</tr>  
				<tr>
					<th>제목</th><td><input type="text" name="title" id="title" value="${board.title }"></a></td>
				</tr>
				<tr>
					<th>작성자</th><td>${board.id }</td>
				</tr>
				<tr>
					<th>조회수</th><td>${board.count }</td>
				</tr>
				<tr>
					<th>메모</th><td><textarea rows="10" cols="20" name="content" id="content" >${board.content }</textarea></td>			
				</tr>
				<tr>
				<th colspan="2" align="right">
				<input type="submit" value="답글등록" id="reply">
				<input type="button" value="수정" id="update">
				<input type="button" value="삭제" id="delete" onclick="del()">		
				</th>
				</tr>
				</table>
				<br><br>
			</form>
		

		<form method="get">
		<input type="hidden" name="b_num" value="${board.b_num }">
		<input type="hidden" name="id" id="id" value="${sessionLogin}">
		<h5>댓글</h5><%-- <h6 align="right"><a href="myme?bnum=${board.seq }&id=${sessionLogin}">내댓글 보기</a></h6> --%>

			<textarea rows="3" cols="50" id="memo" name="memo" placeholder="댓글작성"></textarea>
			<input type="button" value="보내기" id="comment_btn"> 

<%-- 		<c:if test="${sessionLogin!=null }">		
			<textarea rows="3" cols="50" id="memo" name="memo" placeholder="댓글작성"></textarea>
			<input type="button" value="보내기" id="comment_btn"> 
			<input type="button" value="내댓글" id="my_btn">
		</c:if>
		<c:if test="${sessionLogin==null }">
		<textarea rows="3" cols="50" id="memo1" name="memo1" placeholder="로그인정보"></textarea>
		</c:if>
 --%>
 		</form>
			<div id=aa>
			</div>
		</div>
	</section>
	<!-- E : MAIN SECTION -->
	<%@include file="../../template/admin_footer.jsp" %>
</body>
</body>
</html>