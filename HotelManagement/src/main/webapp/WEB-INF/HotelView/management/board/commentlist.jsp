<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				$("#aa").html(data);			
			}
		});
 		/* location.href="commentInsert?bnum=${board.seq}&seq=${board.seq}&memo="+$("#memo").val(); */
};
</script>
</head>
<body>
<table>
<c:forEach items="${commentlist}" var="m">
			<tr>
				<td> ${boardVO.id}</td>
				<td> ${m.c_num}</td>
				<td> ${m.memo }</td>
				<td> ${m.registerdate }</td>
				<td><input type="button" value="삭제" id="my_delete" onclick="cdelete(${m.c_num})"></td>
			</tr> 
</c:forEach>
</table>
</body>
</html>