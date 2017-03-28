<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/admin_style.css">

<!-- JS -->
<script type="text/javascript" src="resources/js/management_membership.js"></script>

</head>
</head>
<body>
	<%@include file="../../template/admin_header.jsp" %>
	<%@include file="../../template/admin_nav.jsp" %>
	<%@include file="../../template/admin_aside.jsp" %>
	<!-- S : MAIN SECTION -->
	<section>
		<div id="main_title">	
			<img src="resources/img/btn01.png"> 회원정보수정
		</div>
		<!-- S : main_content -->
		<div id="main_content">		
			
			<!-- S : content_list -->
			<div id="content_list">	
				<form id="updateForm" method="post" action="admin_membership_update">	
					<input type="hidden" name=m_num value="${member.m_num }">		
					<!-- S : content_table -->
					ㅣ회원기본정보수정(${member.name })				
					<table id="content_table">
						<tr>
							<th>회원번호</th>
							<td>${member.m_num }</td>
						</tr>									
						<tr>
							<th>아이디</th>
							<td>${member.id }</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="password" id="password" value=${member.password }></td>
						</tr>
						<tr>
							<th>비밀번호 확인</th>
							<td><input type="password" id="passwordCheck" value=${member.password }></td>
						</tr>					
						<tr>
							<th>이름</th>
							<td><input type="text" name="name" value=${member.name }></td>
						</tr>
						<tr>
							<th>성별</th>
							<td>						
								<c:if test="${member.gender == '남'}">
									<input type="radio" name="gender" value="남" checked="checked"> 남
									<input type="radio" name="gender" value="여">여
								</c:if>
								<c:if test="${member.gender == '여'}">
									<input type="radio" name="gender" value="남"> 남
									<input type="radio" name="gender" value="여" checked="checked">여
								</c:if>							
							</td>
						</tr>
						<tr>
							<th>생년월일</th>
							<!-- 생년월일,,, select로 구현해야 될까 흠 -->
							<td><input type="text" name="birth" value=${member.birth }></td>
						</tr>
						<tr>					
							<th>전화번호</th>
							<td><input type="text" name="phone" value=${member.phone }></td>
						</tr>
						<tr>					
							<th>E-MAIL</th>
							<td><input type="text" name="email" value=${member.email }></td>
						</tr>
						<tr>					
							<th>우편번호</th>
							<td><input type="text" name="zipcode" value=${member.zipcode }></td>
						</tr>
						<tr>					
							<th>주소</th>
							<td><input type="text" name="address" value=${member.address }></td>
						</tr>
						<tr>					
							<th>가입일</th>
							<td>${member.register }</td>
						</tr>
					</table>
					<!-- E : content_table -->
					<input type="button" value="수정하기" onclick="btnUpdate()" class="btnStyle">
					<input type="button" value="전체목록" onclick="btnAllList()" class="btnStyle">
					</form>			
			</div>			
			<!-- E : content_list -->
		</div>
		<!-- E :main_content -->
	</section>
	<!-- E : MAIN SECTION -->
	<%@include file="../../template/admin_footer.jsp" %>
</body>
</body>
</html>