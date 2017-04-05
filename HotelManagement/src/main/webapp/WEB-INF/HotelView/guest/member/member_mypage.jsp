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
				<h3 class="title">마이페이지</h3>
			</div>
			
			<!-- S : CONTENT INNER -->
			<div id="content_inner">
				<form method="post" action="memberUpdate" id="updateFrm">
					<input type="hidden" name="m_num" value="${member.m_num }">
					<h5 class="s-title">개인 정보 수정</h5>
					<div class="list-tbl">
					<table width="100%">
						<tr>
							<th class="tbl-title" width="15%">이름</th>
							<td class="tbl-title" width="35%"><input type="text" name="name" id="name" value="${member.name }"></td>
							<th class="tbl-title" width="15%">성별</th>
							<td class="tbl-title" width="35%">								
								<c:if test="${member.gender == '남' }">
									<input type="radio" name="gender" id="gender" value="남" checked>남
									<input type="radio" name="gender" id="gender" value="여">여
								</c:if>
								<c:if test="${member.gender == '여' }">
									<input type="radio" name="gender" id="gender" value="남">남
									<input type="radio" name="gender" id="gender" value="여" checked>여
								</c:if>
							</td>
						</tr>
						<tr>
							<th class="tbl-title" width="15%">아이디</th>
							<td class="tbl-title" colspan="3" width="75%">
								${member.id }
								<span id="checkIdResult"></span>
							</td>
						</tr>
						<tr>
							<th class="tbl-title">비밀번호</th>
							<td class="tbl-title" colspan="3">
								<input type="password" name="password" id="password">
							</td>
						</tr>
						<tr>
							<th class="tbl-title">비밀번호 확인</th>
							<td class="tbl-title" colspan="3">
								<input type="password" id="passwordCheck">
							</td>
						</tr>
						<tr>
							<th class="tbl-title">생년월일</th>
							<td class="tbl-title" colspan="3">
								<input type="text" name="birth" id="birth" value="${member.birth }">
								<span class="tbl-desc">* 예)19900425</span>
							</td>
						</tr>
						<tr>
							<th class="tbl-title">전화번호</th>
							<td class="tbl-title" colspan="3">
								<input type="text" name="phone" id="phone" value="${member.phone }">
								<span class="tbl-desc">* 예)01011112222</span>
							</td>
						</tr>
						<tr>
							<th class="tbl-title">이메일</th>
							<td class="tbl-title" colspan="3">
								<input type="text" name="email" id="email" value="${member.email }">
							</td>
						</tr>
						<tr>
							<th class="tbl-title">주소</th>
							<td class="tbl-title" colspan="3">
								<input type="text" name="zipcode" id="zipcode" value="${member.zipcode }">
								<input type="button" onclick="btnZipcode()" value="우편번호검색" class="btn-tbl">
								<br>
								<input type="text" name="address" id="address" size="98" style="margin-top:10px;" value="${member.address }">
							</td>
						</tr>						
					</table>
					</div>
					
					<div class="btn-area">
						<input type="button" value="수정" onclick="memberUpdate()" class="btn-basic">
						<input type="button" value="취소" onclick="guestHome()" class="btn-basic">						
					</div>
				</form>					
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