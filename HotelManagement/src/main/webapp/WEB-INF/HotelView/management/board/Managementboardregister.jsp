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
		if($("#title").val()==""){
			alert("제목을 입력하세요");
			return false;
		}
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
		<form action="managementboardinsert" id="frm" method="post">

			<c:if test="${sessionLogin==null }">
				<input type="hidden" name="writer" id="writer"
					value="${sessionLogin }">
			</c:if>
			<c:if test="${sessionLogin!=null }">
				<input type="hidden" name="writer" id="writer" value="손님">
			</c:if>

			<table>
				<tr>
					<td>게시판선택</td>
					<td><select id="category" name="category">
							<c:if test="${category=='공지사항'}">
								<option selected="selected">공지사항</option>
								<option>QnA</option>
								<option>환불신청게시판</option>
								<option>자유게시판</option>
								<option>후기게시판</option>
							</c:if>
							<c:if test="${category=='QnA' }">
								<option>공지사항</option>
								<option selected="selected">QnA</option>
								<option>환불신청게시판</option>
								<option>자유게시판</option>
								<option>후기게시판</option>
							</c:if>
							<c:if test="${category=='환불신청게시판' }">
								<option>공지사항</option>
								<option>QnA</option>
								<option selected="selected">환불신청게시판</option>
								<option>자유게시판</option>
								<option>후기게시판</option>
							</c:if>
							<c:if test="${category=='자유게시판' }">
								<option>공지사항</option>
								<option>QnA</option>
								<option>환불신청게시판</option>
								<option selected="selected">자유게시판</option>
								<option>후기게시판</option>
							</c:if>
							<c:if test="${category=='후기게시판' }">
								<option>공지사항</option>
								<option>QnA</option>
								<option>환불신청게시판</option>
								<option>자유게시판</option>
								<option selected="selected">후기게시판</option>
							</c:if>
					</select></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" id="title"></td>
				</tr>
				<!-- 				<tr>
					<td>작성자</td> <td><input type="text" name="id" id="id"></td>
				</tr> 
 -->
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="password" id="password"></td>
				</tr>
				<tr>
					<td>내용</td>
				</tr>
				<tr>
					<td colspan="2"><textarea rows="30" cols="70" name="content"
							id="content"></textarea></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" id="btn" value="등록"><input
						type="button" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
	</section>
	<!-- E : MAIN SECTION -->
	<%@include file="../../template/admin_footer.jsp"%>
</body>
</html>