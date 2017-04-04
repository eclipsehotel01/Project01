<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="resources/css/admin_style.css">

<!-- JS -->
<script type="text/javascript" src="resources/js/management_payment.js"></script>
<script type="text/javascript" src="resources/js/common.js"></script>

</head>
<body>
	<%@include file="../../template/admin_header.jsp"%>
	<%@include file="../../template/admin_nav.jsp"%>
	<%@include file="../../template/admin_aside.jsp"%>

	<!-- S : MAIN SECTION -->
	<section>
	<div id="main_title">
		<img src="resources/img/btn01.png"> 결제정보관리
	</div>

	<!-- S : main_content -->
	<div id="main_content">

		<!-- S : content_search -->
		<div id="content_search">
			<table class="searchTableStyle">
				<tr>
					<td>
						<form action="pay_list">
							<select id="field" name="field">
								<option value="name">예약자 이름</option>
								<option value="id">예약자 아이디</option>
							</select> <input type="text" name="word"> <input type="submit"
								value="검색" class="btnStyle">
						</form>
					</td>
				</tr>
			</table>
		</div>
		<!-- E : content_search -->

		<!-- S : content_list -->
		<div id="content_list">

			<div id="content_list_top">
				<div align="left" style="float: left">
					ㅣ총 <span style="color: #f3662b;font-weight: bold">${paycount}</span>건의 결제정보가 검색되었습니다.
				</div>
				<div align="right">
					총금액 : <span style="color: #f3662b;font-weight: bold">${paytotal}</span>원
				</div>
			</div>

			<!-- S : content_table -->
			<div id="content_list_all_table">
				<table class="tableStyle">
					<tr>
						<th width="3%"><input type="checkbox" id="selectAll"></th>
						<th colspan="3" width="50%">예약정보</th>
						<th width="15%">예약자정보</th>
						<th width="12%">결제금액</th>
						<th width="10%">결제일</th>
						<th width="10%">결제취소일</th>
					</tr>

					<c:forEach items="${paylist }" var="plist" varStatus="pay">
						<tr>
							<td rowspan="2" align="center"><input type="checkbox"
								id="cb" name="cb" value="${plist.p_num}"></td>
							<td colspan="3" style="padding-left: 15px">${plist.p_num}</td>
							<td rowspan="2" style="padding-left: 15px">${plist.name}<br>(id
								: ${plist.id})
							</td>
							<td rowspan="2" align="center">${plist.p_price}원</td>
							<td rowspan="2" align="center">${plist.p_date}</td>
							<td rowspan="2" align="center">${plist.p_cancel}</td>
						</tr>
						<tr>
							<td>${plist.img }</td>
							<td
								style="padding-left: 15px; padding-top: 10px; padding-bottom: 10px">예약객실
								: ${plist.rnum}<br>객실유형 : ${plist.rname}(${plist.rtype})<br>이용기간
								: ${plist.check_in}<br>~${plist.check_out}
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<!-- E : content_table -->

			<div id="content_list_bottom">
				<div style="float: left">
					<input type="button" id="checked" value="전체선택" class="btnStyle">
					<input type="button" value="선택취소" onclick="unchecked()" class="btnStyle">
					<input type="button" onclick="payCancel()" value="결제취소"
						class="btnStyle">
				</div>
				<div align="right">
					<input type="button" value="전체목록"
						onclick="javascript:location.href='pay_list'" class="btnStyle">
				</div>
				<div align="center">${pageHtml }</div>
			</div>

		</div>
		<!-- E : content_list -->

	</div>
	<!-- E :main_content --> </section>
	<!-- E : MAIN SECTION -->

	<%@include file="../../template/admin_footer.jsp"%>
</body>
</html>