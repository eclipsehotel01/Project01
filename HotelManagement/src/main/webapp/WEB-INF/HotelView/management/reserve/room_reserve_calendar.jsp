<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/admin_style.css">

<!-- 캘린더 -->
<link href="resources/fullcalendar/fullcalendar.css" rel="stylesheet"/>
<link href="resources/fullcalendar/fullcalendar.print.css" rel="stylesheet" media="print"/>
<script type="text/javascript" src="resources/fullcalendar/lib/moment.min.js"></script>
<script type="text/javascript" src="resources/fullcalendar/lib/jquery.min.js"></script>
<script type="text/javascript" src="resources/fullcalendar/fullcalendar.js"></script>
<script type="text/javascript" src="resources/js/calendar.js"></script>

</head>
<body>
	<%@include file="../../template/admin_header.jsp" %>
	<%@include file="../../template/admin_nav.jsp" %>
	<%@include file="../../template/admin_aside.jsp" %>
	<!-- S : MAIN SECTION -->
	<section>
		<div id="main_title">	
			<img src="resources/img/btn01.png"> 객실예약정보
		</div>
		<!-- S : main_content -->
		<div id="main_content">
		
			<!-- S : content_calendar -->
			<div id="content_calendar">			
			</div>
			<!-- E : content_calendar -->
				
		</div>
		<!-- E :main_content -->
	</section>
	<!-- E : MAIN SECTION -->
	<%@include file="../../template/admin_footer.jsp" %>
</body>
</body>
</html>