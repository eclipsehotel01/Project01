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
	<%@include file="../template/admin_header.jsp" %>
	<%@include file="../template/admin_nav.jsp" %>
	<%@include file="../template/admin_aside.jsp" %>
	<!-- S : MAIN SECTION -->
	<section>
		<div id="main_title">	
			<img src="resources/img/btn01.png"> 타이틀입니다.
		</div>
		<div id="main_content">
			내용입니다.
			<a href="managementboardlist">글쓰기</a>
		</div>
	</section>
	<!-- E : MAIN SECTION -->
	<%@include file="../template/admin_footer.jsp" %>
</body>
</body>
</html>