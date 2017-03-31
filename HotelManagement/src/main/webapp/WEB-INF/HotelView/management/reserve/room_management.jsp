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
<script type="text/javascript"
	src="resources/js/management_room.js"></script>
<script type="text/javascript" src="resources/js/common.js"></script>

</head>

<body>
	<%@include file="../../template/admin_header.jsp"%>
	<%@include file="../../template/admin_nav.jsp"%>
	<%@include file="../../template/admin_aside.jsp"%>

	<!-- S : MAIN SECTION -->
	<section>
	<div id="main_title">
		<img src="resources/img/btn01.png"> 객실등록/관리
	</div>

	<!-- S : main_content -->
	<div id="main_content">

		<!-- S : content_search -->
		<div id="content_search">
			<div align="left" style="float: left">
				<select id="roomType" name="roomType">
					<option value="">객실유형</option>
					<option value="">ALL</option>
					<option value="DELUXE">DELUXE</option>
					<option value="EXCUTIVE">EXCUTIVE</option>
					<option value="SUITE">SUITE</option>
				</select>
			</div>
		</div>
		<!-- E : content_search -->

		<!-- S : content_list -->
		<div id="content_list">

			<div id="content_list_top">
				<div align="left" style="float: left">
					ㅣ총 <span style="color: #f3662b;font-weight: bold">${count }</span>개의 객실이 있습니다.
				</div>
				<div align="right">
					<button id="roomInsert" onclick="location.href='room_insertOpen'"
						class="btnStyle">객실등록</button>
				</div>
			</div>

			<!-- S : content_table -->
			<div id="content_list_all_table">
				<table class="tableStyle">
					<tr align="center">
						<th colspan="2" rowspan="2" width="50%">객실정보</th>
						<th colspan="2" width="30%">요금정보</th>
						<th rowspan="2" width="10%">수정</th>
						<th rowspan="2" width="10%">삭제</th>
					</tr>
					<tr align="center">
						<th>비수기</th>
						<th>성수기</th>
					</tr>

					<tbody align="center">
						<c:forEach items="${roomlist }" var="rlist">
							<tr>
								<td colspan="2" align="left" style="padding-left:15px">${rlist.rname}</tb>
								<td rowspan="2">${rlist.season}</td>
								<td rowspan="2">${rlist.nonseason}</td>
								<td rowspan="2"><button
										onclick="location.href='room_detail?rnum=${rlist.rnum}'"
										class="btnStyle">수정</button></td>

								<td rowspan="2"><button
										onclick="location.href='room_delete?rnum=${rlist.rnum}'"
										class="btnStyle">삭제</button></td>
							</tr>
							<tr align="left">
								<td width="20%" align="center"><img src="resources/img/${rlist.img}" height="100px"></td>
								<td style="padding-left:15px; padding-top:10px; padding-bottom:10px">호수 : ${rlist.rnum}<br>면적 : ${rlist.rsize} ㎡<br>유형
									: ${rlist.rtype}<br>기준인원 : ${rlist.standperson}명<br>최대인원
									: ${rlist.max_person}명
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- E : content_table -->

			<div id="content_list_bottom">
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