<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="resources/css/admin_style.css">

<!-- JS -->
<script type="text/javascript" src="resources/js/management_board.js"></script>
<script type="text/javascript" src="resources/js/common.js"></script>

<script>
	//게시물 삭제
	function btnDel() {
		if (confirm("정말 삭제할까요?")) {
			location.href = "managementboarddelete?b_num=" + $('#b_num').val()
					+ "&category=" + $("#category").val() + "&groups="
					+ $("#groups").val() + "&levels=" + $("#levels").val()
					+ "&steps=" + $("#steps").val();
		}

	}

	$(document).ready(
			function() {
				//게시물 수정
				$("#update").click(
						function() {
							window.open(
									"pwdCheck11?b_num=${board.b_num}&title="
											+ $("#title").val() + "&content="
											+ $("#content").val()
											+ "&category="
											+ $("#category").val(), "",
									"width=350 height=200 scrollbars=yes");
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
		<img src="resources/img/btn01.png"> 게시물 상세보기
	</div>

	<!-- S : main_content -->
	<div id="main_content">

		<!-- S : content_list -->
		<div id="content_list">

			<div id="content_list_top">
				ㅣ<span>${board.category }</span> 게시물 내용입니다.
			</div>

			<!-- S : content_table -->
			<div id="content_list_table">
				<form action="boardReply" method="post" >
					<input type="hidden" name="b_num" id="b_num" value="${board.b_num}">
					<input type="hidden" name="groups" id="groups"
						value="${board.groups}"> <input type="hidden"
						name="levels" id="levels" value="${board.levels}"> <input
						type="hidden" name="steps" id="steps" value="${board.steps}">
					<input type="hidden" name="category" id="category"
						value="${board.category }">
					<table class="tableStyle">
						<tr>
							<th width="15%">게시물번호</th>
							<td width="85%" style="padding-left: 15px">${board.b_num }</td>
						</tr>
						<tr>
							<th>제목</th>
							<td style="padding-left: 15px"><input type="text"
								name="title" id="title" value="${board.title }" size="70"></a></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td style="padding-left: 15px">${board.id }</td>
						</tr>
						<tr>
							<th>조회수</th>
							<td style="padding-left: 15px">${board.count }</td>
						</tr>
						<tr>
							<th>메모</th>
							<td><textarea rows="10" cols="119" name="content"
									id="content">${board.content }</textarea></td>
						</tr>
					</table>

					<div id="content_list_bottom" class="bottomBtnStyle">
						<input type="submit" value="답글등록" id="reply" class="btnStyle">
						<input type="button" value="수정" id="update" class="btnStyle">
						<input type="button" value="삭제" onclick="btnDel()" class="btnStyle">						
					</div>
				</form>
			</div>
			<!-- E : content_table -->	
			
			<!-- S : content_comment -->
			<div id="content_comment">
				<form method="get">
					<input type="hidden" name="b_num" value="${board.b_num }">
					<input type="hidden" name="id" id="id" value="${sessionLogin}">					
										
					<table id="comment_table" align="center">	
						<tr>				
							<td><textarea rows="3" cols="50" id="memo" name="memo"
								placeholder="댓글작성"></textarea>	</td>
							<td><input type="button" value="보내기" id="btnComment" class="btnStyle">
						</tr>
					</table>
				</form>
				<div id="comment_area"></div>
			</div>
			<!-- E : content_comment -->



		</div>
		<!-- E : content_list -->

	</div>
	<!-- E :main_content --> </section>
	<!-- E : MAIN SECTION -->

	<%@include file="../../template/admin_footer.jsp"%>
</body>
</body>
</html>