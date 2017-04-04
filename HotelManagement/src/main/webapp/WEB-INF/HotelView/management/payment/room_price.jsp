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
		<img src="resources/img/btn01.png"> 객실요금정보
	</div>

	<!-- S : main_content -->
	<div id="main_content">

		<!-- S : content_list -->
		<div id="content_list">			

				<div id="content_list_top">ㅣ요금표</div>

				<!-- S : content_table -->
				<div id="content_list_table">
					<table class="tableStyle">
						<tr align="center">
							<th rowspan="2">타입</th>
							<th colspan="2">객실이용요금</th>
							<th rowspan="2">관리</th>
						</tr>
						<tr align="center">
							<th>성수기</th>
							<th>비수기</th>
						</tr>
						<c:forEach items="${pricelist }" var="pricelist" varStatus="p">
							<tr align="center">
								<td>${pricelist.price }</td>
								<td><input type="text" id="season${p.index}"
									value="${pricelist.season }">원</td>
								<td><input type="text" id="nonseason${p.index}"
									value="${pricelist.nonseason }">원</td>
								<td><input type="button"
									onclick="update('${pricelist.price }')" value="수정" class="btnStyle"></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<!-- E : content_table -->	

		</div>
		<!-- E : content_list -->

	</div>
	<!-- E :main_content --> </section>
	<!-- E : MAIN SECTION -->

	<%@include file="../../template/admin_footer.jsp"%>
</body>
</html>