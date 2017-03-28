<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/admin_style.css">

</head>
<body>
예약현황

<table border=1 cols="2" width="1000px" height="1000px">
<tr>
<td>객실정보</td>
<td>${reserve.rnum}</td>
</tr>
<tr>
<td>이용기간</td>
<td>${reserve.check_in}~${reserve.check_out}</td>
</tr>
<tr>
<td>요금적용</td>
<td>rnum이랑 check_in이용 price테이블이랑 조인</td>
</tr>
<tr>
<td>인원수</td>
<td>${reserve.person }</td>
</tr>
<tr>
<td>추가항목</td>
<td>${reserve.extracode}</td>
</tr>
<tr>
<td>총 요금</td>
<td>${reserve.p_price}</td>
</tr>
</table>

</body>
</html>