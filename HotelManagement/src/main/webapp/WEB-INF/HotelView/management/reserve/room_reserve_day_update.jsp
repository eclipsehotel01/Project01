<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- datepicker -->
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/admin_style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(document).ready(function(){
   //호실정보 불러오기
/*     $.get("roomInfo",
          {"rnum" : $("#frnum").val() },
          function(data){
        	  alert(data);
            $("#standp").html(data);
          }
      );  */  
   $("#rnum").change(function(){
      $.get("roomInfo",
          {"rnum" : $("#rnum").val() },
          function(data){
            // alert(data);
             arr = data.split("/");
             $("#standp").val(arr[0]);
             $("#max").val(arr[1]);
          }
      );
   }); 
       
    //예약가능한 호실 목록
     $("#rnum").change(function(){
      $.get("roomInfo",
          {"rnum" : $("#rnum").val() },
          function(data){
            // alert(data);
             arr = data.split("/");
             $("#standp").val(arr[0]);
          }
      );
   }); 

	//목록
	$("#showlist").click(function(){
		location.href="open_reserve_list"
		});
	//입퇴실 날짜 확인
	$("#updatereserve").click(function(){
		if($("#check_out").val()<=$("#check_in").val())
		{
			alert("퇴실일은 입실일보다 빠르거나 같을수 없습니다.")
			return false;
		}
	//인원수 확인
	if($("#person").val()>$("#max").val()){
		alert("최대인원을 초과하였습니다.");
		return false;
	}
		
	// 추가항목 체크 확인 
		var sss=updatereservedata.extracode;	
		var conf=false;
		 for(i=0;i<sss.length;i++)
		 {
			  if(sss[i].checked == true)
			  {
			   conf=true;
			  }
		 }
		 
		if(conf == false)
		{
			alert("추가항목을 선택해 주세요.")
		}
		else
		{
			updatereservedata.submit();
		}
		});		
});
//datepicker
$( function() {
  $( "#check_in" ).datepicker({
	  dateFormat:'yy/mm/dd'
  });
  $( "#check_out" ).datepicker({
	  dateFormat:'yy/mm/dd'
  });
});
</script>

</head>
<body>
	<%@include file="../../template/admin_header.jsp" %>
	<%@include file="../../template/admin_nav.jsp" %>
	<%@include file="../../template/admin_aside.jsp" %>
	<!-- S : MAIN SECTION -->
	<section>
		<div id="main_title">	
			<img src="resources/img/btn01.png"> 예약현황
		</div>
		<div id="main_content">
<form id="updatereservedata" name="updatereservedata" action="update" method="get">
<table border=1 cols="2" width="1000px" height="500px">

<input type="hidden" name="reservecode" value=${selectlist.reservecode}>
<tr>
<td style="background-color: #A9F5F2;">이용기간</td>
<td>
<p>
<input type="text" id="check_in" name="check_in" value = "${selectlist.check_in }">입실일
<input type="text" id="check_out" name="check_out" value = "${selectlist.check_out }">퇴실일
</p>
</td>
</tr>
<tr>
<td style="background-color:#A9F5F2 ;">객실정보</td>
<td>
	<select id="rnum" name="rnum">
		<option id="frnum" value="${selectlist.rnum }">${selectlist.rnum }</option>
		<c:forEach items="${roomnum }" var="room">	
			<option id ="room" value="${room.rnum}">${room.rnum}</option>	
		</c:forEach>
	</select>
</td>
</tr>
<tr>
<td style="background-color: #A9F5F2;">인원수</td>
<td><input type="text" id ="person" name="person" value="${selectlist.person }"> 
(기준인원:<input type="text" id="standp" value="${selectlist.standperson }" disabled="disabled" style="width: 15px;">,
최대인원:<input type="text" id="max" value="${selectlist.max_person }" disabled="disabled" style="width: 15px;">)</td>
</tr>
<tr>
 <td style="background-color: #A9F5F2;">추가항목</td>
	<td>
			<input type="checkbox" name = "extracode" id="extracode" value="없음"/>선택 없음
			<input type="checkbox" name = "extracode" id="extracode" value="조식"/>조식
			<input type="checkbox" name = "extracode" id="extracode" value="수영"/>수영
			<input type="checkbox" name = "extracode" id="extracode" value="헬스"/>헬스
			<input type="checkbox" name = "extracode" id="extracode" value="골프"/>골프
	</td>		
</tr>
<tr>
<td style="background-color: #A9F5F2;">예약일</td>
<td>${selectlist.reservedate}</td>
</tr>
<tr>
<td style="background-color: #A9F5F2;">총 요금</td>
<td>${selectlist.p_price}</td>
</tr>
</table>

<input type="hidden" name="paytype" value="${paytype }">

<input type="button" id="updatereserve" value="수정">
<input type="button" id="showlist" value="취소">
</form>
</div>
</body>
</html>