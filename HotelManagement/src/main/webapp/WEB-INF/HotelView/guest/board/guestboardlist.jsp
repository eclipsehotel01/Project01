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
<script type="text/javascript" src="resources/js/guest_member.js"></script>
<script type="text/javascript" src="resources/js/guest_board.js"></script>

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
					<c:if test="${sessionScope.loginID != null}">
						<li><span class="loginInfo">'${sessionScope.loginID}'님이 로그인하셨습니다.</span></li>
						<li><a href="javascript:memberLogout();" class="btn-topmenu">LOGOUT</a></li>				
						<li><a href="javascript:memberMypage();" class="btn-topmenu">MY PAGE</a></li>
					</c:if>
					<c:if test="${sessionScope.loginID == null}">				
						<li><a href="javascript:memberLogin();" class="btn-topmenu">LOGIN</a></li>				
						<li><a href="javascript:memberRegister();" class="btn-topmenu">JOIN</a></li>
					</c:if>
				</ul>
			</div>		
		
			<div id="content_title">
				<h3 class="title">${category }</h3>
			</div>
			
			<!-- S : content_search -->
			<div id="content_search">
				<form method="get">
				<input type="hidden" id="category" value="${category }">
				<table class="searchTableStyle">
					<tr>
						<td>
							<select id="field" name="word">
								<option value="title">제목</option>
								<option value="id">작성자</option>								
							</select>
							<input type="text" id="word" name="word">
							<input type="button" id="searchBtn" value="검색" onclick="search()">
						</td>
					</tr>
				</table>
				</form>
			</div>
			<!-- E : content_search -->
			
			<!-- S : CONTENT INNER -->
			<div id="content_inner">
			
				<div id="content_list_top">			
					<div align="left" style="float:left">
						ㅣ게시물 <span style="color: #f3662b;font-weight: bold">${count }</span>개가 검색되었습니다.
					</div>
					<div align="right">
						<input type="button" value="글쓰기" onclick="javascript:location.href='guestboardregister?category=${category }'" class="btnStyle">
					</div>
				</div>
				
				<!-- S : content_table -->
				<div id="content_list_all_table">
					<table class="tableStyle">					
					<tr>
						<th width="10%">no</th>
						<th width="20%">category</th>
						<th width="30%">title</th>
						<th width="10%">writer</th>
						<th width="10%">count</th>
						<th width="15%">regdate</th>
					</tr>

					<c:forEach items="${guestboardlist}" var="m">
						<tr>
							<td align="center">${m.b_num }</td>
							<td align="center">${m.category }</td>
							<td style="padding-left:15px"><c:if test="${m.levels>0}">
									<img src="resources/img/level.gif" width="${5*m.levels}"
										height="16">
									<img src="resources/img/reply_icon01.png">
								</c:if> <a href="guestboarddetail?b_num=${m.b_num}">${m.title }</a></td>

							<td style="padding-left:15px">${m.id }</td>
							<td align="center">${m.count }</td>
							<td align="center">${m.registerdate }</td>

						</tr>
					</c:forEach>
				</table>
				</div>
				<!-- E : content_table -->
				
				<div id="content_list_bottom">
					<div align="right">
						<input type="button" value="전체목록" onclick="btnAllList()" class="btnStyle">
					</div>					
					<div align="center">
						${pageHtml }
					</div>
				</div>
			
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