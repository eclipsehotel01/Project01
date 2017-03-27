<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/admin_style.css">
<title>객실정보수정 :: Eclipse Hotel</title>
	
</head>

<body>
<div id = "main">
	<%@include file="../../template/admin_header.jsp" %>
	<%@include file="../../template/admin_nav.jsp" %>
	<%@include file="../../template/admin_aside.jsp" %>
	<!-- S : MAIN SECTION -->
	<section>
		<div id="main_title">	
			<img src="resources/img/btn01.png"> 객실정보수정
		</div>
		<div id="main_content">		
		객실기본설정
		<table width = "100%">
			<tr>
				<td>객실호수</td>
				<td>${infoDetail.rnum}호</td>
			</tr>
			<tr>
				<td>객실유형</td>
				<td><select id = "rdetailType" name = "rdetailType">
					<option value = "">객실유형</option>
					<option value = "DELUXE">DELUXE</option>
					<option value = "EXCUTIVE">EXCUTIVE</option>
					<option value = "EXCUTIVE_GRAND">EXCUTIVE_GRAND</option>
					<option value = "FAMILY_SUITE">FAMILY_SUITE</option>
					<option value = "EXCUTIVE_SUITE">EXCUTIVE_SUITE</option>
					<option value = "PRESIDENTIAL_SUITE">PRESIDENTIAL_SUITE</option>
				</select></td>
			</tr>
			<tr>
				<td>침대유형</td>
				<td><select id = "rdetailType" name = "rdetailType">
					<option value = "">침대유형</option>
					<option value = "DOUBLE">DOUBLE</option>
					<option value = "TWIN">TWIN</option>
				</select></td>
			</tr>
			<tr>
				<td>기준인원</td>
				<td><input type = "text" name = "standperson" value = "${infoDetail.standperson}">명</td>
			</tr>
			<tr>
				<td>요금정보</td>
				<td>${infoDetail.price}타입</td>
			</tr>
		</table>
			
		</div>
	</section>
	<!-- E : MAIN SECTION -->
	<%@include file="../../template/admin_footer.jsp" %>
</div>
</body>
</html>