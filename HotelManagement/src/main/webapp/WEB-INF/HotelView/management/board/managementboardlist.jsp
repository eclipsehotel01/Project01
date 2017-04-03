<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/admin_style.css">

<!-- JS -->
<script type="text/javascript" src="resources/js/management_board.js"></script>
<script type="text/javascript" src="resources/js/common.js"></script>

</head>
<body>
	<%@include file="../../template/admin_header.jsp" %>
	<%@include file="../../template/admin_nav.jsp" %>
	<%@include file="../../template/admin_aside.jsp" %>
	
	<!-- S : MAIN SECTION -->
	<section>
		<div id="main_title">	
			<img src="resources/img/btn01.png"> ${category }
		</div>
		
		<!-- S : main_content -->
		<div id="main_content">
		
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
			
			<!-- S : content_list -->
			<div id="content_list">
			
				<div id="content_list_top">			
					<div align="left" style="float:left">
						ㅣ게시물 <span style="color: #f3662b;font-weight: bold">${count }</span>개가 검색되었습니다.
					</div>
					<div align="right">
						<input type="button" value="글쓰기" onclick="javascript:location.href='managementboardregister?category=${category }'" class="btnStyle">
					</div>
				</div>
				
				<!-- S : content_table -->
				<div id="content_list_all_table">
					<table class="tableStyle">					
					<tr>
						<th width="5%"><input type="checkbox" id="table_checkbox"></th>
						<th width="10%">no</th>
						<th width="20%">category</th>
						<th width="30%">title</th>
						<th width="10%">writer</th>
						<th width="10%">count</th>
						<th width="15%">regdate</th>
					</tr>

					<c:forEach items="${managementboardlist}" var="m">
						<tr>
							<td align="center"><input type="checkbox" id="table_checkbox" value="${list.b_num }"></td>
							<td align="center">${m.b_num }</td>
							<td align="center">${m.category }</td>
							<td style="padding-left:15px"><c:if test="${m.levels>0}">
									<img src="resources/img/level.gif" width="${5*m.levels}"
										height="16">
									<img src="resources/img/reply_icon01.png">
								</c:if> <a href="managementboarddetail?b_num=${m.b_num}">${m.title }</a></td>

							<td style="padding-left:15px">${m.id }</td>
							<td align="center">${m.count }</td>
							<td align="center">${m.registerdate }</td>

						</tr>
					</c:forEach>
				</table>
				</div>
				<!-- E : content_table -->
				
				<div id="content_list_bottom">
					<div style="float:left">
						<input type="button" value="전체선택" onclick="btnAll()" class="btnStyle">
						<input type="button" value="선택삭제" onclick="btnSelectDelete()" class="btnStyle">
					</div>
					<div align="right">
						<input type="button" value="전체목록" onclick="btnAllList()" class="btnStyle">
					</div>					
					<div align="center">
						${pageHtml }
					</div>
				</div>
				
			</div>
			<!-- E : content_list -->
			
		</div>
		<!-- E :main_content -->
		
	</section>
	<!-- E : MAIN SECTION -->
	
	<%@include file="../../template/admin_footer.jsp" %>
</body>
</body>
</html>