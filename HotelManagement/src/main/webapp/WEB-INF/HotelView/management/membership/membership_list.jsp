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
			<img src="resources/img/btn01.png"> 전체회원관리
		</div>
		
		<!-- S : main_content -->
		<div id="main_content">
		
			<!-- S : content_search -->
			<div id="content_search">
				<table class="searchTableStyle">
					<tr>
						<td>
							<select id="field">
								<option value="m_num">회원번호</option>
								<option value="id">아이디</option>
								<option value="name">이름</option>								
							</select>
							<input type="text" id="word">
							<input type="button" value="검색" onclick="btnSearch()" class="btnStyle">
						</td>
					</tr>
				</table>
			</div>
			<!-- E : content_search -->
			
			<!-- S : content_list -->
			<div id="content_list">
			
				<div id="content_list_top">			
					<div align="left" style="float:left">
						ㅣ총 <span>${memberCount }</span>명의 회원이 검색되었습니다.
					</div>
					<div align="right">
						오늘 가입 : <span>${todayCount }</span>명
					</div>
				</div>
				
				<!-- S : content_table -->
				<div id="content_list_all_table">
					<table class="tableStyle">
						<tr>
							<th width="5%"><input type="checkbox" id="table_checkbox"></th>
							<th width="7%">회원번호</th>
							<th width="13%">기본정보</th>						
							<th width="10%">생일</th>
							<th width="13%">휴대전화</th>	
							<th width="15%">이메일</th>					
							<th width="13%">가입일</th>
							<th width="7%">수정</th>
							<th width="7%">삭제</th>
						</tr>
						<c:forEach items="${memberList }" var="list">
							<tr>
								<td align="center"><input type="checkbox" id="table_checkbox" value="${list.m_num }"></td>
								<td align="center">${list.m_num }</td>
								<td style="padding-left:15px"><a href="admin_membership_detail?m_num=${list.m_num }">${list.name } (${list.id })</a></td>
								<td align="center">${list.birth }</td>
								<td align="center">${list.phone }</td>
								<td style="padding-left:15px">${list.email }</td>
								<td align="center">${list.register }</td>
								<td align="center"><input type="button" value="수정" onclick="btnUpdatePage(${list.m_num })" class="btnStyle"></td>
								<td align="center"><input type="button" value="삭제" onclick="btnDelete(${list.m_num })" class="btnStyle"></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<!-- E : content_table -->
				
				<div id="content_list_bottom">
					<div style="float:left">
						<input type="button" value="전체선택" onclick="btnAll()" class="btnStyle">
						<input type="button" value="선택삭제" onclick="btnSelectDelete()" class="btnStyle">
					</div>
					<div align="right">
						<input type="button" value="전체목록" onclick="btnAllList()" class="btnStyle">
					</div>					
					<div align="center">
						${pageHtml }
					</div>
				</div>
				
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