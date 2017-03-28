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
			<img src="resources/img/btn01.png"> 회원정보
		</div>
		<!-- S : main_content -->
		<div id="main_content">		
			
			<!-- S : content_list -->
			<div id="content_list">				
				<!-- S : content_table -->
				ㅣ${member.name }님의 회원정보입니다.
				<table>					
					<tr>
						<th width="20%">회원번호</th>
						<td width="30%">${member.m_num }</td>	
						<th width="20%">아이디</th>
						<td width="30%">${member.id }</td>	
						
					</tr>
					<tr>
						<th>이름</th>
						<td>${member.name }</td>
						<th>성별</th>
						<td>${member.gender }</td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td>${member.birth }</td>	
						<th>전화번호</th>
						<td>${member.phone }</td>
					</tr>
					<tr>
						<th>E-MAIL</th>
						<td colspan="3">${member.email }</td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td colspan="3">${member.zipcode }</td>
					</tr>
					<tr>
						<th>주소</th>
						<td colspan="3">${member.address }</td>
					</tr>
					<tr>
						<th>가입일</th>
						<td colspan="3">${member.register }</td>
					</tr>
				</table>
				<br><br>
				
				ㅣ${member.name }님의 예약정보입니다.
				<table>
					<tr>
						<th>예약번호</th>
						<th>이용객실</th>
						<th>이용인원</th>
						<th>이용기간</th>
						<th>결제금액</th>
						<th>상태</th>
					</tr>
					
					<!-- 숙박 완료 예약리스트 -->											
					<c:forEach items="${reserveList }" var="reserve">
						<tr>
							<td>${reserve.reservecode }</td>
							<td>${reserve.rname } (${reserve.rnum }) </td>
							<td>${reserve.person }</td>
							<td>${reserve.check_in } ~ ${reserve.check_out }</td>
							<td>${reserve.p_price }</td>						
							<td>숙박완료</td>
						</tr>
					</c:forEach>
					
					<!-- 숙박 예정 예약리스트 -->					
					<c:forEach items="${pre_reserveList }" var="pre">
						<tr>
							<td>${pre.reservecode }</td>
							<td>${pre.rname } (${pre.rnum }) </td>
							<td>${pre.person }</td>
							<td>${pre.check_in } ~ ${pre.check_out }</td>
							<td>${pre.p_price }</td>						
							<td>숙박예정</td>
						</tr>
					</c:forEach>					
				</table>
				<!-- E : content_table -->				
				<input type="button" value="전체목록" onclick="btnAllList()" class="btnStyle">
				<input type="button" value="수정" onclick="btnUpdatePage(${member.m_num })" class="btnStyle">
				<input type="button" value="삭제" onclick="btnDelete(${member.m_num })" class="btnStyle">
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