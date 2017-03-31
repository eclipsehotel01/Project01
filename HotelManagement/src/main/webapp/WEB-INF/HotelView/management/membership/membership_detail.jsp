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
<script type="text/javascript" src="resources/js/common.js"></script>

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
				
				<div id="content_list_top">	
					ㅣ<span style="color: #f3662b;font-weight: bold">${member.name }</span>님의 회원정보입니다.
				</div>
				
				<!-- S : content_table1 -->
				<div id="content_list_table">
					<table class="tableStyle">					
						<tr>
							<th width="15%">회원번호</th>
							<td width="35%" style="padding-left:15px">${member.m_num }</td>	
							<th width="15%">아이디</th>
							<td width="35%" style="padding-left:15px">${member.id }</td>	
							
						</tr>
						<tr>
							<th>이름</th>
							<td style="padding-left:15px">${member.name }</td>
							<th>성별</th>
							<td style="padding-left:15px">${member.gender }</td>
						</tr>
						<tr>
							<th>생년월일</th>
							<td style="padding-left:15px">${member.birth }</td>	
							<th>전화번호</th>
							<td style="padding-left:15px">${member.phone }</td>
						</tr>
						<tr>
							<th>E-MAIL</th>
							<td colspan="3" style="padding-left:15px">${member.email }</td>
						</tr>
						<tr>
							<th>우편번호</th>
							<td colspan="3" style="padding-left:15px">${member.zipcode }</td>
						</tr>
						<tr>
							<th>주소</th>
							<td colspan="3" style="padding-left:15px">${member.address }</td>
						</tr>
						<tr>
							<th>가입일</th>
							<td colspan="3" style="padding-left:15px">${member.register }</td>
						</tr>
					</table>
				</div>
				<!-- E : content_table1 -->
				
				<br><br>
				
				<div id="content_list_top">					
					ㅣ<span style="color: #f3662b;font-weight: bold">${member.name }</span>님의 예약정보입니다.
				</div>
				<!-- S : content_table2 -->
				<div id="content_list_table">
					<table class="tableStyle">
						<tr>
							<th width="10%">예약번호</th>
							<th width="15%">이용객실유형</th>
							<th width="10%">이용객실</th>
							<th width="7%">이용인원</th>
							<th width="30%">이용기간</th>
							<th width="14%">결제금액</th>
							<th width="14%">상태</th>
						</tr>
						
						<!-- 숙박 완료 예약리스트 -->											
						<c:forEach items="${reserveList }" var="reserve">
							<tr>
								<td align="center">${reserve.reservecode }</td>
								<td align="center">${reserve.rname }</td>
								<td align="center">${reserve.rnum }</td>
								<td align="center">${reserve.person }</td>
								<td align="center">${reserve.check_in } ~ ${reserve.check_out }</td>
								<td align="center">${reserve.p_price }</td>						
								<td align="center">숙박완료</td>
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
				</div>
				<!-- E : content_table1 -->
				
				<div id="content_list_bottom" class="bottomBtnStyle">				
					<input type="button" value="전체목록" onclick="btnAllList()" class="btnStyle">
					<input type="button" value="수정" onclick="btnUpdatePage(${member.m_num })" class="btnStyle">
					<input type="button" value="삭제" onclick="btnDelete(${member.m_num })" class="btnStyle">
				</div>
			
			</div>
			<!-- E : content_list -->
			
		</div>
		<!-- E :main_content -->
		
	</section>
	<!-- E : MAIN SECTION -->
	
	<%@include file="../../template/admin_footer.jsp" %>
</body>
</html>