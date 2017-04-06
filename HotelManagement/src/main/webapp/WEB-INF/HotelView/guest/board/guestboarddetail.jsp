<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/guest_style.css">

<!-- JS -->
<script type="text/javascript" src="resources/js/common.js"></script>
<script type="text/javascript" src="resources/js/guest_main.js"></script>
<script type="text/javascript" src="resources/js/guest_member.js"></script>
<script type="text/javascript" src="resources/js/guest_board.js"></script>

</head>
<body>
<!-- S : WRAP -->
<div id="wrap" class="bg-v1">
	
	<div id="main">
		
		<%@include file="../../template/guest_header.jsp" %>
		
		<!-- S : MAIN CONTENT -->
		<div id="main_content">
		
			<div id="top">
				<ul class="topmenu">
					<c:if test="${sessionScope.loginID != null}">
						<li><span class="loginInfo">'${sessionScope.loginID}'님이 로그인하셨습니다.</span></li>
						<li><a href="javascript:memberLogout();" class="btn-topmenu">LOGOUT</a></li>				
						<li><a href="javascript:memberMypage();" class="btn-topmenu">MY PAGE</a></li>
					</c:if>
					<c:if test="${sessionScope.loginID == null}">				
						<li><a href="javascript:memberLogin();" class="btn-topmenu">LOGIN</a></li>				
						<li><a href="javascript:memberRegister();" class="btn-topmenu">JOIN</a></li>
					</c:if>
				</ul>
			</div>		
		
			<div id="content_title">
				<h3 class="title">게시물 상세보기</h3>
			</div>
			
			<!-- S : CONTENT INNER -->
			<div id="content_inner">
				<div id="content_list_top">
				ㅣ<span style="color: #f3662b;font-weight: bold">${board.category }</span> 게시물 내용입니다.
			</div>

			<!-- S : content_table -->
			<div id="content_list_table">
				<form action="guestboardReply" method="post" >
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
						<input type="button" value="수정" onclick="checkUpdate()" class="btnStyle">
						<input type="button" value="삭제" onclick="checkDelete()" class="btnStyle">
					</div>					
					<div align="right">
						<input type="button" value="전체목록"
						onclick="javascript:location.href='guestboardlist?category=${board.category }'"
						class="btnStyle">
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
			<!-- E : CONTENT INNER -->
	
		</div>
		<!-- E : MAIN CONTENT -->
	</div>
	
	<%@include file="../../template/guest_footer.jsp" %>
	
</div>		
<!-- E : WRAP -->	
</body>
</html>