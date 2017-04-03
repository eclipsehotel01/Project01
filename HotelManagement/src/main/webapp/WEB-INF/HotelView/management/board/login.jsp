<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src='https://code.jquery.com/jquery-3.1.1.min.js'></script>
<script>
$(document).ready(function(){
	$("#login").click(function(){
		$.ajax({
		type:"POST",
		url:"memberLogin",
		data:{"id":$("#id").val(),"passwd":$("#passwd").val()},
			success:function(data){
				if(data=="pass_err"){
					alert("비밀번호가 맞지 않습니다.");
					$("#passwd").val("");
				}else if(data=="id_err"){
					alert("일치하는 ID 없습니다");
					$("#id").val("");
				}else if(data=="id_ok"){
					alert("로그인 되었습니다");
					opener.location.reload();
					self.close();
				}
			}
		});
	});
});
</script>
</head>
<body>
<div align="center">
<a href="guestInsert">[홈으로 돌아가기]</a><br><br>
<form method="post">
ID <input type="text" id="id" name="id"><br>
PW <input type="text" id="passwd" name="passwd"><br><br>
<input type="button" value="로그인" id="login"><br><br>
<a href="reg">회원가입</a>
</form>
</div>
<span style="color: #f3662b;font-weight: bold">${errMsg}</span> 
</body>
</html> 