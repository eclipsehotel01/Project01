<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="resources/js/guest_board.js"></script>
<script type="text/javascript" src="resources/js/common.js"></script>
</head>
</head>
<body>
<input type="hidden" name=m_num value="${member.m_num }">

	<form action="guestboardinsert" id="frm" method="get">
		
		<div id="content_list_top">ㅣ게시물 등록</div>

			<table>
				<tr>
					<th width="15%">게시판선택</th>
					<td width="85%" style="padding-left: 15px"><select
						id="category" name="category">
								<option selected="selected">공지사항</option>
								<option>QnA</option>
								<option>환불신청게시판</option>
								<option>자유게시판</option>
								<option>후기게시판</option>
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
					<th>제목</th>
					<td style="padding-left: 15px"><input type="text" name="title"
						id="title" size="110"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td style="padding-left: 15px"><input type="text" name="id"
						id="id"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td style="padding-left: 15px"><input type="text"
						name="password" id="password"></td>
				</tr>
				<tr>
					<th colspan="2">내용</th>
				</tr>
				<tr>
					<td colspan="2"><textarea rows="30" cols="139" name="content"
							id="content">
						</textarea></td>
				</tr>
			</table>
		</div>
		<input type="button" id="btnRegister" value="등록" class="btnStyle">
		<input type="button" value="전체목록"
			onclick="javascript:location.href='guestboardlist?category=${category }'"
			class="btnStyle">
	</form>
</body>
</html>