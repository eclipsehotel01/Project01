<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/admin_style.css">
<script src="http://code.jquery.com/jquery-2.2.3.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(document).ready(function(){
	$("#showlist").click(function(){
		location.href="open_reserve_list"
		});
	$("#delreserve").click(function(){
		location.href="del_reserve?reservecode="+$("#reservecode").val()
		});
	$("#updatereserve").click(function(){
		location.href="updatereserve?reservecode="+$("#reservecode").val()+"&m_num="+$("#m_num").val()+"&rnum="+$("#rnum").val()
		});
	});
</script>
</head>
<body>
	<%@include file="../../template/admin_header.jsp" %>
	<%@include file="../../template/admin_nav.jsp" %>
	<%@include file="../../template/admin_aside.jsp" %>
	<!-- S : MAIN SECTION -->
	<section>
		<div id="main_title">	
			<img src="resources/img/btn01.png"> 예약현황
		</div>
		<div id="main_content">
<table border=1 cols="2" width="1000px" height="500px">

<input type="hidden" id="reservecode" value="${selectlist.reservecode}">
<input type="hidden" id="rnum" value="${selectlist.rnum }">
<tr>
<td style="background-color:#A9F5F2 ;">객실정보</td>
<td>${selectlist.rnum}</td>
</tr>
<tr>
<td style="background-color: #A9F5F2;">이용기간</td>
<td>(${selectlist.check_in})~(${selectlist.check_out})</td>
</tr>
<tr>
<td style="background-color: #A9F5F2;">요금적용</td>
<td>${selectlist.r_price }원</td>
</tr>
<tr>
<td style="background-color: #A9F5F2;">인원수</td>
<td>${selectlist.person }명</td>
</tr>
<tr>
<td style="background-color: #A9F5F2;">추가항목</td>
<td>${selectlist.extracode}</td>
</tr>
<tr>
<td style="background-color: #A9F5F2;">예약일</td>
<td>${selectlist.reservedate}</td>
</tr>
<tr>
<td style="background-color: #A9F5F2;">총 요금</td>
<td>${selectlist.p_price}원</td>
</tr>
</table>

<table border="1" width="1000px" height="200px">
<c:forEach items="${rmember }" var="rmember">
<input type="hidden" id="m_num" value="${rmember.m_num}">
<tr><td colspan="2" style="background-color: #ffffff;"><h2 style="color: #000000;">고객정보</h2></td></tr>
<tr>
<td style="background-color: #A9F5F2;">예약자</td>
<td>${rmember.name }(${rmember.id })</td>
</tr>
<tr>
<td style="background-color: #A9F5F2;">연락처</td>
<td>${rmember.phone}</td>
</tr>
<tr>
<td style="background-color: #A9F5F2;">이메일</td>
<td>${rmember.email}</td>
</tr>
</table>
</c:forEach>
<input type="button" id="updatereserve" value="수정">
<input type="button" id="delreserve" value="예약삭제">
<input type="button" id="showlist" value="목록">
</div>
</body>
</html>