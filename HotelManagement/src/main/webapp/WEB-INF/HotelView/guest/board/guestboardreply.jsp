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
				<h3 class="title">ㅣ답글 등록</h3>
			</div>
			
			<!-- S : CONTENT INNER -->
			<div id="content_inner">
			<form action="guestboardReply1" id="replyfrm">
				<input type="hidden" id="b_num" name="b_num" value="${board.b_num }">
				<input type="hidden" id="title" name="title" value="${board.title }"> 
				<input type="hidden" id="category" name="category" value="${board.category }">
				<input type="hidden" id="levels" name="levels" value="${board.levels }">
				<input type="hidden" id="groups" name="groups" value="${board.groups }">
				<input type="hidden" id="steps" name="steps" value="${board.steps }">
				<table class="tableStyle">
						<tr>
							<th width="15%">제목</th>
							<td width="85%" style="padding-left: 15px">${board.title }</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td style="padding-left: 15px">
								${sessionScope.loginID}	
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
				</form>
				<div id="content_list_bottom" class="bottomBtnStyle">
					<input type="submit" id="btnReply" value="등록" class="btnStyle"> 
					<input type="button" value="전체목록" 
					onclick="javascript:location.href='guestboardlist?category=${board.category }'"
						class="btnStyle">
				</div>
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