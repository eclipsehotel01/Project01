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
		<img src="resources/img/btn01.png"> 객실정보수정
	</div>

	<!-- S : main_content -->
	<div id="main_content">

		<!-- S : content_list -->
		<div id="content_list">

			<div id="content_list_top">ㅣ객실기본설정</div>

			<!-- S : content_table1 -->
			<div id="content_list_table">
				<form action="room_update" id="update">
					<table class="tableStyle">
						<tr>
							<th width="15%">객실호수</th>
							<td width="85%" style="padding-left:15px"><input type="text" name="rnum"
								value="${infoDetail.rnum}" >호</td>
						</tr>
						<tr>
							<th>객실면적</th>
							<td style="padding-left:15px"><input type="text" name="rsize"
								value="${infoDetail.rsize}"> m</td>
						</tr>
						<tr>
							<th>객실유형</th>
							<td style="padding-left:15px"><select id="rname" name="rname">
									<option value="${infoDetail.rname}">${infoDetail.rname}</option>
									<option value="">------------------------------------------</option>
									<option value="DELUXE">DELUXE</option>
									<option value="EXCUTIVE">EXCUTIVE</option>
									<option value="EXCUTIVE_GRAND">EXCUTIVE_GRAND</option>
									<option value="FAMILY_SUITE">FAMILY_SUITE</option>
									<option value="EXCUTIVE_SUITE">EXCUTIVE_SUITE</option>
									<option value="PRESIDENTIAL_SUITE">PRESIDENTIAL_SUITE</option>
							</select></td>
						</tr>
						<tr>
							<th>침대유형</th>
							<td style="padding-left:15px"><select id="rtype" name="rtype">
									<option value="${infoDetail.rtype}">${infoDetail.rtype}</option>
									<option value="">-------------------</option>
									<option value="DOUBLE">DOUBLE</option>
									<option value="TWIN">TWIN</option>
									<option value="QUEEN">QUEEN</option>
									<option value="KING">KING</option>
							</select></td>
						</tr>
						<tr>
							<th>기준인원</th>
							<td style="padding-left:15px"><input type="text" name="standperson"
								value="${infoDetail.standperson}"> 명</td>
						</tr>
						<tr>
							<th>최대인원</th>
							<td style="padding-left:15px"><input type="text" name="max_person"
								value="${infoDetail.max_person}"> 명</td>
						</tr>
						<tr>
							<th>요금정보</th>
							<td style="padding-left:15px"><input type="text" name="price"
								value="${infoDetail.price}"> 타입</td>
						</tr>
					</table>
					<div id="content_list_bottom" class="bottomBtnStyle">
						<input type="button" id="updateBtn" value="수정" class="btnStyle">
						<input type="button" value="취소"
							onclick="location.href='room_list'" class="btnStyle">
					</div>
				</form>
			</div>

			<!-- E : content_table1 -->

			<br> <br>

			<div id="content_list_top" style="float: left">ㅣ객실 요금표</div>
			<div align="right">
				<input type="button" value="요금수정"
					onclick="location.href='room_price'" class="btnStyle">
			</div>
			<!-- S : content_table2 -->
			<div id="content_list_table">
				<table class="tableStyle2">
					<tr align="center">
						<th rowspan="2">타입</th>
						<th colspan="2" align="center">요금정보</th>
					</tr>
					<tr align="center">
						<th>성수기</th>
						<th>비수기</th>
					</tr>
					<c:forEach items="${pricelist }" var="pricelist">
						<tr align="center">
							<td>${pricelist.price }</td>
							<td>${pricelist.season }원</td>
							<td>${pricelist.nonseason }원</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<!-- E : content_table1 -->
		</div>

		<!-- E : content_list -->

	</div>
	<!-- E :main_content --> </section>
	<!-- E : MAIN SECTION -->

	<%@include file="../../template/admin_footer.jsp"%>
</body>
</html>