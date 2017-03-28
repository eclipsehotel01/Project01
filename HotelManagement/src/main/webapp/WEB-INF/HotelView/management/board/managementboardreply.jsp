<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="resources/css/admin_style.css">
<script src='https://code.jquery.com/jquery-3.1.1.min.js'></script>
<script>
$(document).ready(function() {
	$("#btn").click(function(){
		if($("#password").val()==""){
			alert("비밀번호를 입력하세요");
			return false;
		}
		if($("#content").val()==""){
			alert("내용을 입력하세요");
			return false;
		}
		$("#frm").submit();
	});
	
});   
</script>
</head>
<body>
	<%@include file="../../template/admin_header.jsp"%>
	<%@include file="../../template/admin_nav.jsp"%>
	<%@include file="../../template/admin_aside.jsp"%>
	<!-- S : MAIN SECTION -->
	<section>
	<div id="main_title">
		<img src="resources/img/btn01.png"> 타이틀입니다.
	</div>
	<div id="main_content">
		<form action="boardReply1" id="frm">
			<input type="text" id="category" name="category"
				value="${board.category }"> <input type="text" id="b_num"
				name="b_num" value="${board.b_num }"> <input type="text"
				id="groups" name="groups" value="${board.groups }"> <input
				type="text" id="levels" name="levels" value="${board.levels }">
			<input type="text" id="steps" name="steps" value="${board.steps }">
			<input type="hidden" id="title" name="title" value="${board.title }">

			<table>
				<tr>
					<th colspan="2">[답변글 등록]</th>
				</tr>
				<tr>
					<th>제목</th>
					<th>${board.title }</th>
				</tr>
				<tr>
					<th>id</th>
					<!-- 						<th><input type="text" id="id" name="id"></th>
 -->
				</tr>
				<%-- <tr>
				<th>게시글</th><th>${board.title}</th><th>작성자</th><th>${board.writer }</th>
				</tr>
				 --%>
				<tr>
					<th>pass</th>
					<th><input type="text" id="password" name="password"></th>
				</tr>
				<tr>
					<th>content</th>
					<th><textarea rows="10" cols="20" id="content" name="content"></textarea>
					</th>
				</tr>
				<tr>
					<th colspan="2" align="right"><input type="submit" id="btn"
						value="Submit"></th>
				</tr>
			</table>
		</form>
	</div>
	</section>
	<!-- E : MAIN SECTION -->
	<%@include file="../../template/admin_footer.jsp"%>
</body>
</body>
</html>