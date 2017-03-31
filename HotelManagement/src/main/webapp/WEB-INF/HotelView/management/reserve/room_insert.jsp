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
		<img src="resources/img/btn01.png"> 새객실등록
	</div>

	<!-- S : main_content -->
	<div id="main_content">

		<!-- S : content_list -->
		<div id="content_list">

			<div id="content_list_top">ㅣ객실기본설정</div>

			<!-- S : content_table1 -->
			<div id="content_list_table">
				<form action="room_insert" id="insert">
					<table class="tableStyle">
						<tr>
							<th width="15%">객실호수</th>
							<td width="85%" style="padding-left:15px"><input type="text" id="rnum" name="rnum"> 호</td>
						</tr>
						<tr>
							<th>객실면적</th>
							<td style="padding-left:15px"><input type="text" id="rsize" name="rsize"> m</td>
						</tr>
						<tr>
							<th>객실유형</th>
							<td style="padding-left:15px"><select id="rname" name="rname">
									<option value="">객실유형</option>
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
									<option value="">침대유형</option>
									<option value="DOUBLE">DOUBLE</option>
									<option value="TWIN">TWIN</option>
							</select></td>
						</tr>
						<tr>
							<th>기준인원</th>
							<td style="padding-left:15px"><input type="text" id="standperson" name="standperson"> 명</td>
						</tr>
						<tr>
							<th>최대인원</th>
							<td style="padding-left:15px"><input type="text" id="max_person" name="max_person"> 명</td>
						</tr>
						<tr>
							<th>이미지</th>
							<td style="padding-left:15px"><input type="text" id="img" name="img"> <span style="color: #f3662b;font-weight: bold">(*jpg형식)</span></td>
						</tr>
						<tr>
							<th>요금정보</th>
							<td style="padding-left:15px"><select id="price" name="price">
									<option value="">요금유형</option>
									<option value="A">A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="E">E</option>
									<option value="F">F</option>
							</select></td>
						</tr>
						<tr>
							<th>설명</th>
							<td style="padding-left:15px">
								<input type="text" id="memo" name="memo" size="80"> 
								<span style="color: #f3662b;font-weight: bold">(*40자 이내 작성)</span>
							</td>
						</tr>
						
					</table>
					<div id="content_list_bottom" class="bottomBtnStyle">
				<input type="button" id="insertBtn" value="등록" class="btnStyle"> <input
					type="reset" value="취소" class="btnStyle"> <input type="button"
					value="목록보기" onclick="location.href='room_list'" class="btnStyle">
			</div>
				</form>
			</div>
			
			<!-- E : content_table1 -->

			<br>
			<br>

			<div id="content_list_top" style="float: left">ㅣ객실 요금표</div>
			<div align="right">
				<input type="button" value="요금수정"
					onclick="location.href='room_price'" class="btnStyle">
			</div>
			<!-- S : content_table2 -->
			<div id="content_list_table">
				<table class="tableStyle2">
					<tr align="center">
						<th rowspan="2" height="30px">타입</th>
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