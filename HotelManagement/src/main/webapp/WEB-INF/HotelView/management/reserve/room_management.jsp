<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/admin_style.css">
<title>객실등록/관리 :: Eclipse Hotel</title>
	<script src="http://code.jquery.com/jquery-2.2.3.min.js"></script>

<script>
$(document).ready(function(){
	//유형선택
	$("#roomType").change(function(){
		$.get("room_list",
				{"rname":$("#roomType").val()},
				function(data){
					$("#main").html(data);
			});
	});
});

</script>
</head>

<body>
<div id = "main">
	<%@include file="../../template/admin_header.jsp" %>
	<%@include file="../../template/admin_nav.jsp" %>
	<%@include file="../../template/admin_aside.jsp" %>
	<!-- S : MAIN SECTION -->
	<section>
		<div id="main_title">	
			<img src="resources/img/btn01.png"> 객실등록/관리
		</div>
		<div id="main_content">
		<div id = "search_room">
			<div align="left" style="float:left">		
			<select id = "roomType" name = "roomType">
				<option value = "">객실유형</option>
				<option value = "">ALL</option>
				<option value = "DELUXE">DELUXE</option>
				<option value = "EXCUTIVE">EXCUTIVE</option>
				<option value = "SUITE">SUITE</option>
			</select>
			</div>
			<div align="right">
			<button id = "roomInsert" onclick = "location.href='room_insertOpen'">객실등록</button>
			</div>
				<!-- <td>
					<select id = "search" name = "search">
						<option>검색항목</option>
						<option value = "deluxe">DELUXE</option>
						<option value = "excutive">EXCUTIVE</option>
						<option value = "suite">SUITE</option>
					</select>
				</td>
				<td>
					<input type = "text" id = "roomName" name = "roomName">
				</td>
				<td>
					<button id = "searchRoom">검색</button>
				</td> -->		
		</div>
		
		<br>
		<table width = "100%">
			<tr align = "center">
				<td colspan = "2" rowspan = "2">객실정보</td>
				<td colspan = "2">요금정보</td>
				<td rowspan = "2">관리</td>
			</tr>
			<tr align = "center">
				<td>비수기</td>
				<td>성수기</td>
			</tr>
			
			<tbody align = "center">
			<c:forEach items="${roomlist }" var="rlist">
				<tr>
					<td colspan = "2" align = "left">${rlist.rname}</tb>
					<td rowspan = "2">${rlist.season}</td>
					<td rowspan = "2">${rlist.nonseason}</td>
					<td rowspan = "2"><button onclick = "location.href='room_detail?rnum=${rlist.rnum}'">수정</button>
						<button onclick = "location.href='room_delete?rnum=${rlist.rnum}'">삭제</button></td>
				</tr>
				<tr align = "left">
					<td>${rlist.img}</td>
					<td>호수 : ${rlist.rnum}<br>면적 : ${rlist.rsize} ㎡<br>유형 : ${rlist.rtype}<br>기준인원 : ${rlist.standperson}명<br>최대인원 : ${rlist.max_person}명</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>			
			
		</div>
	</section>
	<!-- E : MAIN SECTION -->
	<%@include file="../../template/admin_footer.jsp" %>
</div>
</body>
</html>