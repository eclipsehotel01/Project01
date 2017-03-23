<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/admin_style.css">
<title>결제정보관리 :: Eclipse Hotel</title>

</head>
<body>
	<%@include file="../../template/admin_header.jsp" %>
	<%@include file="../../template/admin_nav.jsp" %>
	<%@include file="../../template/admin_aside.jsp" %>
	<!-- S : MAIN SECTION -->
	<section>
		<div id="main_title">	
			<img src="resources/img/btn01.png"> 결제정보관리
		</div>
		<div id="main_content">
		
		<div id = "paySearch" align = "center">
		<form action = "pay_list">
			<select id = "searchType" name = "searchType">
				<option value = "name">예약자 이름</option>
				<option value = "id">예약자 아이디</option>
			</select>
			<input type = "text" name = "word">
			<input type = "submit" value = "검색">
		</form>
		</div>
		<br><br>
		
		<div align = "left">
		총 ${paycount}건의 결제정보가 검색되었습니다.
		</div>
		<div align = "right">
		총금액 : ${paytotal}원
		</div>
		
		<table width = "100%">
		<tr>
			<td><input type = "checkbox" id = "selectAll"></td>
			<td colspan = "3">예약정보</td>
			<td>예약자정보</td>
			<td>결제금액</td>
			<td>결제일</td>
		</tr>
		
		<c:forEach items="${paylist }" var="plist">
		<tr>
			<td rowspan = "2"><input type = "checkbox" id = "pnum"></td>
			<td colspan = "3">${plist.p_num}</td>
			<td rowspan = "2">${plist.name}<br>(id : ${plist.id})</td>
			<td rowspan = "2">${plist.p_price}원</td>
			<td rowspan = "2">${plist.p_date}</td>
		</tr>
		<tr>
			<td>${plist.img }</td>
			<td>예약객실 : ${plist.rnum}<br>객실유형 : ${plist.rname}(${plist.rtype})<br>이용기간 : ${plist.check_in}<br>~${plist.check_out}</td>
		</tr>
		</c:forEach>
		</table>
			
		</div>
	</section>
	<!-- E : MAIN SECTION -->
	<%@include file="../../template/admin_footer.jsp" %>
</body>
</html>