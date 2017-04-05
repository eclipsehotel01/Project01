<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>

<title>객실목록</title>
</head>
<body>

<div>
<ul>
	<c:forEach items="${room_infoList}" var="infoList">
	<li>
		<a href="room_infoTitle?rname=${infoList.rname}">
			<p><img src="​"></p>
			<dl>
				<dt>${infoList.rname }</dt>
				<dd>${infoList.m_memo }</dd>
			</dl>
		</a>
		<div>
			<a href="">Reservation</a>
			<a href="room_infoTitle?rname=${infoList.rname}">Read more</a>
		</div>
	</li>
	</c:forEach>
</ul>
</div>

</body>
</html>