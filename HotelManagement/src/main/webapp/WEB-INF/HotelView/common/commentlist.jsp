<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src='https://code.jquery.com/jquery-3.1.1.min.js'></script>
<script>
function cdelete(c_num){	
		$.ajax({
			type:"post",
			url:"cdelete?c_num="+c_num,
			success:function(data){
				$("#comment_area").html(data);	
				window.location.reload(true);	
			}
		});
};
</script>
</head>
<body>
	<table id="comment_list" align="center">
		<c:forEach items="${commentlist}" var="m">
			<tr>
				<td width="10%" align="left">${m.id}</td>
				<td width="10%" align="left">${m.c_num}</td>
				<td width="60%" align="left">${m.memo }</td>
				<td width="10%" align="left">${m.registerdate }</td>
				<td width="10%" align="left">
					<a onclick="cdelete(${m.c_num})">삭제</a>				
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>