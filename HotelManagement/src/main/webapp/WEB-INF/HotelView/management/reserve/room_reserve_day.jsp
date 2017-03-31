<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="resources/css/admin_style.css">
<script src="http://code.jquery.com/jquery-2.2.3.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(document).ready(
			function() {
				$("#showlist").click(function() {
					location.href = "open_reserve_list"
				});
				$("#delreserve").click(
						function() {
							location.href = "del_reserve?reservecode="
									+ $("#reservecode").val()
						});
				$("#updatereserve").click(
						function() {
							location.href = "updatereserve?reservecode="
									+ $("#reservecode").val() + "&m_num="
									+ $("#m_num").val() + "&rnum="
									+ $("#rnum").val() + "&check_in="
									+ $("#checkin").val() + "&check_out="
									+ $("#checkout").val()
						});
			});
</script>
</head>
<body>
	<%@include file="../../template/admin_header.jsp"%>
	<%@include file="../../template/admin_nav.jsp"%>
	<%@include file="../../template/admin_aside.jsp"%>

	<!-- S : MAIN SECTION -->
	<section>
	<div id="main_title">
		<img src="resources/img/btn01.png"> 객실예약정보
	</div>

	<!-- S : main_content -->
	<div id="main_content">

		<!-- S : content_list -->
		<div id="content_list">

			<div id="content_list_top">
				ㅣ예약번호 <span style="color: #f3662b; font-weight: bold">${selectlist.reservecode }</span> 객실예약정보입니다.
			</div>

			<!-- S : content_table1 -->
			<div id="content_list_table">
				<table class="tableStyle">
					<input type="hidden" id="reservecode"
						value="${selectlist.reservecode}">
					<input type="hidden" id="rnum" value="${selectlist.rnum }">
					<input type="hidden" id="checkin" value="${selectlist.check_in }">
					<input type="hidden" id="checkout" value="${selectlist.check_out }">
					<tr>
						<th width="15%">객실정보</th>
						<td width="85%" style="padding-left:15px">${selectlist.rnum}</td>
					</tr>
					<tr>
						<th>이용기간</th>
						<td style="padding-left:15px">${selectlist.check_in}~${selectlist.check_out}</td>
					</tr>
					<tr>
						<th>요금적용</th>
						<td style="padding-left:15px">${selectlist.r_price }원</td>
					</tr>
					<tr>
						<th>인원수</th>
						<td style="padding-left:15px">${selectlist.person }명</td>
					</tr>
					<tr>
						<th>추가항목</th>
						<td style="padding-left:15px">${selectlist.extracode}</td>
					</tr>
					<tr>
						<th>예약일</th>
						<td style="padding-left:15px">${selectlist.reservedate}</td>
					</tr>
					<tr>
						<th>총 요금</th>
						<td style="padding-left:15px">${selectlist.p_price}원</td>
					</tr>
				</table>
			</div>
			<!-- E : content_table1 -->

			<br>
			<br>

			<div id="content_list_top">
				ㅣ예약번호 <span style="color: #f3662b; font-weight: bold">${selectlist.reservecode }</span> 예약자정보입니다.
			</div>
			<!-- S : content_table2 -->
			<div id="content_list_table">
				<table class="tableStyle">
					<c:forEach items="${rmember }" var="rmember">
						<input type="hidden" id="m_num" value="${rmember.m_num}">						
						<tr>
							<th width="15%">예약자</th>
							<td width="85%" style="padding-left:15px">${rmember.name }(${rmember.id })</td>
						</tr>
						<tr>
							<th>연락처</th>
							<td style="padding-left:15px">${rmember.phone}</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td style="padding-left:15px">${rmember.email}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<!-- E : content_table1 -->

			<div id="content_list_bottom" class="bottomBtnStyle">
				<input type="button" id="updatereserve" value="수정" class="btnStyle"> <input
					type="button" id="delreserve" value="예약삭제" class="btnStyle"> <input
					type="button" id="showlist" value="목록" class="btnStyle">
			</div>

		</div>
		<!-- E : content_list -->

	</div>
	<!-- E :main_content --> </section>
	<!-- E : MAIN SECTION -->

	<%@include file="../../template/admin_footer.jsp"%>
</body>
</html>