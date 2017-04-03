<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/guest_style.css">

<!-- JS -->
<script type="text/javascript" src="resources/js/common.js"></script>
<script type="text/javascript" src="resources/js/guest_main.js"></script>

</head>
<body>
<!-- S : WRAP -->
<div id="wrap" class="bg-v1">

	<div id="main">
		
		<%@include file="../../template/guest_header.jsp" %>
		
		<!-- S : MAIN CONTENT -->
		<div id="main_content">
		
			<div id="top">
				<ul class="topmenu">
					<li><a href="" class="btn-topmenu">LOGIN</a></li>				
					<li><a href="javascript:location.href='guestRegister'" class="btn-topmenu">JOIN</a></li>
				</ul>
			</div>		
		
			<div id="content_title">
				<h3 class="title">회원가입</h3>
			</div>
			
			<!-- S : CONTENT INNER -->
			<div id="content_inner">
				<form method="post" action="guestRegister" id="registerFrm">
					<h5 class="s-title-1">필수 정보 입력</h5>
					<table>
						<tr>
							<th class="tbl-title">이름</th>
							<td class="tbl-title"><input type="text" name="name"></td>
							<th class="tbl-title">성별</th>
							<td class="tbl-title">
								<input type="radio" name="gender" value="남">남
								<input type="radio" name="gender" value="여">여
							</td>
						</tr>
						<tr>
							<th class="tbl-title">아이디</th>
							<td class="tbl-title">
								<input type="text" name="id">
								<button type="button" onclick="fncIdCheck(); return false;" class="btn-tbl mr6">ID중복확인</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<!-- E : CONTENT INNER -->
	
		</div>
		<!-- E : MAIN CONTENT -->
	</div>
	
	<%@include file="../../template/guest_footer.jsp" %>
	
</div>		
<!-- E : WRAP -->	
</body>
</html>