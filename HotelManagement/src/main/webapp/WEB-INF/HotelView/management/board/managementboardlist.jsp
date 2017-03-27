<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<script src='https://code.jquery.com/jquery-3.1.1.min.js'></script>
<link rel="stylesheet" type="text/css" href="resources/css/admin_style.css">
<script>
	function search() {
		$.ajax({
			type : "get",
			url : "managementboardlist",
			data : {
				"field" : $("#field").val(),
				"word" : $("#word").val(),
				"category" :$("#category").val()
			},

			success : function(data) {
				$("body").html(data);
			},
			error : function(e) {
				alert("error:" + e)
			},
			beforeSend : wordCheck
		});
	}

	function getListData(pageNum, field,category, word) {
		word = (word == "") ? $("#word").val() : word;
		field = (field == "") ? $("#field").val() : field;
		$("body").load("managementboardlist", {
			"pageNum" : pageNum,
			"field" : field,
			"category" : category,
			"word" : word
		}, function(responseText) {
			$("body").html(responseText);
		});
	}
	function wordCheck() {
		if ($("#word").val() == "") {
			alert("검색어를 입력하세요");
			$("#word").focus();
			return false;
		}
		return true;
	}
</script>

</head>
<body>
	<%@include file="../../template/admin_header.jsp" %>
	<%@include file="../../template/admin_nav.jsp" %>
	<%@include file="../../template/admin_aside.jsp" %>
	<!-- S : MAIN SECTION -->
	<section>
		<div id="main_title">	
			<img src="resources/img/btn01.png"> 타이틀입니다.
		</div>
		<div id="main_content">
			<div id="total" align="center">
<div align="right">총 게시물 수:${count }</div><br><br>
<%-- <c:if test="${sessionLogin==null }"> 
<h2><a href="loginform">[로그인]</a></h2>
</c:if>
<c:if test="${sessionLogin!=null }">
<h2><a href="logout">[로그아웃]</a></h2>
</c:if> --%>
<table border=1>
<tr><th colspan="7"><a href="Managementboardregister?category=${category }">글쓰기</a></th></tr>
<tr>
	<th>no</th>
	<th>category</th>
	<th>title</th>
	<th>writer</th>
	<th>count</th>
	<th>regdate</th>
</tr> 

<c:forEach items="${managementboardlist}" var="m">
			<tr>
				<td>${m.b_num }</td>
				<td>${m.category }</td>
				<td> <c:if test="${m.levels>0}">
					<img src="resources/img/level.gif" width="${5*m.levels}" height="16">
					<img src="resources/img/reply_icon.gif">
				</c:if> 
				<a href="managementboarddetail?b_num=${m.b_num}">${m.title }</a></td>
				<%-- <td>${m.writer }</td> --%>
				<td>${m.id }</td>
				<td>${m.count }</td>
				<td>${m.registerdate }</td>
<%-- 				<c:if test="${guestadmin==null }">
				</c:if>
				<c:if test="${guestadmin!=null }">
				<td><a href="guestDelete?num=${m.num}">삭제</a></td>
				</c:if>
 --%>	
 			</tr> 
</c:forEach>
</table>
${pageHtml }
<form method="get">
<input type="hidden" id="category" value="${category }">
<select id="field" name="word">
<option value="title">제목</option>
<option value="id">작성자</option>
</select>
<input type="text" id="word" name="word"> <input type="button" id="searchBtn" value="검색" onclick="search()">
 </form>  
</div>
<div id="results"></div>


		</div>
	</section>
	<!-- E : MAIN SECTION -->
	<%@include file="../../template/admin_footer.jsp" %>
</body>
</body>
</html>