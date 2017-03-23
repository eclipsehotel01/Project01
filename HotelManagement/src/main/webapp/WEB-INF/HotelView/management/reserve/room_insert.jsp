<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/admin_style.css">
<title>객실등록 :: Eclipse Hotel</title>
<script src="http://code.jquery.com/jquery-2.2.3.min.js"></script>
<script>
$(document).ready(function(){
	//빈값확인
	$("#insertBtn").click(function(){
		if($("#rnum").val()==""){
			alert("호실을 입력하세요"); 
			return false;
		}if($("#rsize").val()==""){	
			alert("객실 면적을 입력하세요");
			return false;
		}if($("#rname").val()==""){	
			alert("객실 유형을 선택하세요");
			return false;
		}if($("#rtype").val()==""){	
			alert("침대 유형을 선택하세요");
			return false;
		}if($("#standperson").val()==""){	
			alert("기준 인원을 입력하세요");
			return false;
		}if($("#max_person").val()==""){	
			alert("최대 인원을 입력하세요");
			return false;
		}if($("#img").val()==""){	
			alert("이미지를 추가하세요");
			return false;
		}if($("#price").val()==""){	
			alert("요금을 선택하세요");
			return false;
		}insert.submit();
	});
});
</script>
</head>

<body>
<div id = "main">
	<%@include file="../../template/admin_header.jsp" %>
	<%@include file="../../template/admin_nav.jsp" %>
	<%@include file="../../template/admin_aside.jsp" %>
	<!-- S : MAIN SECTION -->
	<section>
		<div id="main_title">	
			<img src="resources/img/btn01.png"> 새객실등록
		</div>
		<div id="main_content">		
		
		<div id = "room_table">
		<form action = "room_insert" id = "insert">
			<b>객실기본설정</b>
			<table width = "100%" align = "center">
				<tr>
					<td>객실호수</td>
					<td><input type = "text" id = "rnum" name = "rnum">호</td>
				</tr>
				<tr>
					<td>객실면적</td>
					<td><input type = "text" id = "rsize" name = "rsize">m</td>
				</tr>
				<tr>
					<td>객실유형</td>
					<td><select id = "rname" name = "rname">
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
					<td><select id = "rtype" name = "rtype">
						<option value = "">침대유형</option>
						<option value = "DOUBLE">DOUBLE</option>
						<option value = "TWIN">TWIN</option>
					</select></td>
				</tr>
				<tr>
					<td>기준인원</td>
					<td><input type = "text" id = "standperson" name = "standperson">명</td>
				</tr>
				<tr>
					<td>최대인원</td>
					<td><input type = "text" id = "max_person" name = "max_person">명</td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input type = "text" id = "img" name = "img">(*png형식)</td>
				</tr>
				<tr>
					<td>요금정보</td>
					<td><select id = "price" name = "price">
						<option value = "">요금유형</option>
						<option value = "A">A</option>
						<option value = "B">B</option>
						<option value = "C">C</option>
						<option value = "D">D</option>
						<option value = "E">E</option>
						<option value = "F">F</option>
					</select></td>
				</tr>
				<tr>
					<td colspan = "2" align = "center"><input type="button" id="insertBtn" value="등록">
						<input type="reset" value="취소" class="btn"> <input type = "button"  value = "목록보기" onclick = "location.href='room_list'"></td>
				</tr>
			</table>
		</form>
		</div>
		
		<br><br>
		
		<b>요금표</b>
		<table width = "100%" align = "center">
		<tr align = "center">
			<td rowspan = "2">타입</td>
			<td colspan = "2" align = "center">요금정보</td>
		</tr>
		<tr align = "center">
			<td>성수기</td>
			<td>비수기</td>
		</tr>
		<c:forEach items = "${pricelist }" var = "pricelist">
		<tr align = "center">
			<td>${pricelist.price }</td>
			<td>${pricelist.season }원</td>
			<td>${pricelist.nonseason }원</td>
		</tr>
		</c:forEach>
		</table>			
		</div>
	</section>
	<!-- E : MAIN SECTION -->
	<%@include file="../../template/admin_footer.jsp" %>
</div>
</body>
</html>