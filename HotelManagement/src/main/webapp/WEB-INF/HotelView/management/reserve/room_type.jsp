<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="resources/css/admin_style.css">

<!-- JS -->
<script type="text/javascript" src="resources/js/common.js"></script>
<script>
//객실타입수정
function typeUpdate(rname){
	if(rname=="DELUXE"){
		if($("#m_memo0").val()==""){
		     alert("설명을 입력하세요"); 
		     return false;
		}else{$.get("rtype_update",
	           {"rname" : "DELUXE", "m_memo" : $("#m_memo0").val() },
	           function(data){
	        	   window.location.reload(true);
	           }
	      );
		}
	}else if(rname=="EXCUTIVE"){
		if($("#m_memo1").val()==""){
		     alert("설명을 입력하세요"); 
		     return false;
		}else{$.get("rtype_update",
	           {"rname" : "EXCUTIVE", "m_memo" : $("#m_memo1").val() },
	           function(data){
	        	   window.location.reload(true);
	           }
	      );
		}
	}else if(rname=="SUITE"){
		if($("#m_memo2").val()==""){
		     alert("설명을 입력하세요"); 
		     return false;
		}else{$.get("rtype_update",
		           {"rname" : "SUITE", "m_memo" : $("#m_memo2").val() },
		           function(data){
		        	   window.location.reload(true);
		           }
		      );
		}
	}else{
	   alert("fail");
	}
}
</script>

</head>

<body>
	<%@include file="../../template/admin_header.jsp"%>
	<%@include file="../../template/admin_nav.jsp"%>
	<%@include file="../../template/admin_aside.jsp"%>
	<!-- S : MAIN SECTION -->
	<section>
	<div id="main_title">
		<img src="resources/img/btn01.png"> 객실타입관리
	</div>

	<!-- S : main_content -->
	<div id="main_content">

		<!-- S : content_list -->
		<div id="content_list">			

				<div id="content_list_top">ㅣ객실타입</div>

				<!-- S : content_table -->
				<div id="content_list_table">
					<table class="tableStyle">
						<tr align="center">
							<th width="20%">타입</th>
							<th>설명</th>
							<th width="15%">관리</th>
						</tr>
						
						<c:forEach items="${typelist }" var="typelist" varStatus="t">
						<tr align="center">
							<td>${typelist.rname }</td>
							<td><input type="text" id="m_memo${t.index}"
								value="${typelist.m_memo }" size="80"></td>
							<td><input type="button"
								onclick="typeUpdate('${typelist.rname }')" value="수정" class="btnStyle"></td>
						</tr>
						</c:forEach>
					</table>
				</div>
				<!-- E : content_table -->	

		</div>
		<!-- E : content_list -->

	</div>
	<!-- E :main_content --> </section>
	<!-- E : MAIN SECTION -->

	<%@include file="../../template/admin_footer.jsp"%>
</body>
</html>