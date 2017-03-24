<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/admin_style.css">

<!-- JS -->
<script type="text/javascript" src="resources/js/management_membership.js"></script>

</head>
<body>
	<%@include file="../../template/admin_header.jsp" %>
	<%@include file="../../template/admin_nav.jsp" %>
	<%@include file="../../template/admin_aside.jsp" %>
	<!-- S : MAIN SECTION -->
	<section>
		<div id="main_title">	
			<img src="resources/img/btn01.png"> 전체회원관리
		</div>
		<!-- S : main_content -->
		<div id="main_content">
		
			<!-- S : content_search -->
			<div id="content_search">
			
			</div>
			<!-- E : content_search -->
			
			<!-- S : content_list -->
			<div id="content_list">
				<div align="left" style="float:left">
					ㅣ총 <span style="color:orange; font-weight:bold">${memberCount }</span>명의 회원이 검색되었습니다.
				</div>
				<div align="right">
					오늘 가입 : <span style="color:orange; font-weight:bold">${todayCount }</span>명
				</div>
				<!-- S : content_table -->
				<table id="content_table">
					<tr>
						<th><input type="checkbox" id="table_checkbox"></th>
						<th>회원번호</th>
						<th>기본정보</th>						
						<th>생일</th>
						<th>휴대전화</th>						
						<th>가입일</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
					<c:forEach items="${memberList }" var="list">
						<tr>
							<td><input type="checkbox" id="table_checkbox" value="${list.m_num }"></td>
							<td>${list.m_num }</td>
							<td><a href="admin_membership_detail?m_num=${list.m_num }">${list.name } (${list.id })</a></td>
							<td>${list.birth }</td>
							<td>${list.phone }</td>
							<td>${list.register }</td>
							<td><input type="button" value="수정" onclick="btnUpdate(${list.m_num })" class="btnStyle"></td>
							<td><input type="button" value="삭제" onclick="btnDelete(${list.m_num })" class="btnStyle"></td>
						</tr>
					</c:forEach>
				</table>
				<!-- E : content_table -->
				<input type="button" value="전체선택" onclick="btnAll()" class="btnStyle">
				<input type="button" value="선택삭제" onclick="btnSelectDelete()" class="btnStyle">
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