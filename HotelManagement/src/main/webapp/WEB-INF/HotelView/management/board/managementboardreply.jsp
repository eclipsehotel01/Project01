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

</head>
<body>
	<%@include file="../../template/admin_header.jsp"%>
	<%@include file="../../template/admin_nav.jsp"%>
	<%@include file="../../template/admin_aside.jsp"%>

	<!-- S : MAIN SECTION -->
	<section>
	<div id="main_title">
		<img src="resources/img/btn01.png"> ${board.category } 답글 등록
	</div>


	<!-- S : main_content -->
	<div id="main_content">

		<!-- S : content_list -->
		<div id="content_list">
			<form action="boardReply1" id="frm">
				<input type="hidden" id="category" name="category"
					value="${board.category }"> <input type="hidden" id="b_num"
					name="b_num" value="${board.b_num }"> <input type="hidden"
					id="groups" name="groups" value="${board.groups }"> <input
					type="hidden" id="levels" name="levels" value="${board.levels }">
				<input type="hidden" id="steps" name="steps" value="${board.steps }">
				<input type="hidden" id="title" name="title" value="${board.title }">

				<div id="content_list_top">ㅣ답글 등록</div>

				<!-- S : content_table -->
				<div id="content_list_table">
					<table class="tableStyle">
						<tr>
							<th width="15%">제목</th>
							<td width="85%" style="padding-left: 15px">${board.title }</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td style="padding-left: 15px">
								<!-- 아이디값 받아와야함 -->
								<%-- ${board.id } --%>		
							</td>

						</tr>
						<tr>
							<th>비밀번호</th>
							<td style="padding-left: 15px"><input type="text" id="password" name="password"></td>
						</tr>
						<tr>
							<th colspan="2">내용</th>							
						</tr>
						<tr>
							<td colspan="2"><textarea rows="30" cols="139" id="content"
									name="content"></textarea></td>
						</tr>
					</table>
				</div>
				<!-- E : content_table -->

				<div id="content_list_bottom" class="bottomBtnStyle">
					<input type="submit" id="btnReply" value="등록" class="btnStyle"> <input
						type="button" value="전체목록"
						onclick="javascript:location.href='managementboardlist?category=${board.category }'"
						class="btnStyle">

				</div>
			</form>

		</div>
		<!-- E : content_list -->

	</div>
	<!-- E :main_content --> </section>
	<!-- E : MAIN SECTION -->

	<%@include file="../../template/admin_footer.jsp"%>
</body>
</body>
</html>