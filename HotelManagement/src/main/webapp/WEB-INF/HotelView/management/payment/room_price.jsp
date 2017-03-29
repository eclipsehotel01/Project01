<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/admin_style.css">
<title>객실요금정보 :: Eclipse Hotel</title>

<script src="http://code.jquery.com/jquery-2.2.3.min.js"></script>
<script>
$(document).ready(function(){
	//빈값확인
	$("#updateBtn").click(function(){
		if($("#season").val()==""){
			alert("금액을 입력하세요"); 
			return false;
		}if($("#nonseason").val()==""){	
			alert("금액을 입력하세요");
			return false;
		}priceUpdate.submit();
	});
});

//수정 할 데이터 넘기기
function update(price){
	if(price=="A"){
		$.get("price_update",
			 	 {"price" : "A", "season" : $("#season0").val(), "nonseason" : $("#nonseason0").val() }
			);
	}else if(price=="B"){
		$.get("price_update",
			 	 {"price" : "B", "season" : $("#season1").val(), "nonseason" : $("#nonseason1").val() }
			);
	}else if(price=="C"){
		$.get("price_update",
			 	 {"price" : "C", "season" : $("#season2").val(), "nonseason" : $("#nonseason2").val() }
			);
	}else if(price=="D"){
		$.get("price_update",
			 	 {"price" : "D", "season" : $("#season3").val(), "nonseason" : $("#nonseason3").val() }
			);
	}else if(price=="E"){
		$.get("price_update",
			 	 {"price" : "E", "season" : $("#season4").val(), "nonseason" : $("#nonseason4").val() }
			);
	}else if(price=="F"){
		$.get("price_update",
			 	 {"price" : "F", "season" : $("#season5").val(), "nonseason" : $("#nonseason5").val() }
			);
	}else{
		alert("수정 오류");
	}
	
}

// update()
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
			<img src="resources/img/btn01.png"> 객실요금정보
		</div>
		<div id="main_content">
		
			<b>요금표</b>
			<table width = "100%" align = "center">
			<tr align = "center">
				<td rowspan = "2">타입</td>
				<td colspan = "2">객실이용요금</td>
				<td rowspan = "2">관리</td>
			</tr>
			<tr align = "center">
				<td>성수기</td>
				<td>비수기</td>
			</tr>
			<c:forEach items = "${pricelist }" var = "pricelist" varStatus="p">
			<tr align = "center">
				<td>${pricelist.price }</td>
				<td><input type = "text" id = "season${p.index}" value = "${pricelist.season }">원</td>
				<td><input type = "text" id = "nonseason${p.index}" value = "${pricelist.nonseason }">원</td>
				<td><input type ="button" id = "updateBtn" onclick = "update('${pricelist.price }')" value = "수정"></td>
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