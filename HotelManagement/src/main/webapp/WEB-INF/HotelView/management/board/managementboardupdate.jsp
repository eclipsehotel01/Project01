<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src='https://code.jquery.com/jquery-3.1.1.min.js'></script>
<link rel="stylesheet" type="text/css" href="resources/style.css">

<script>
function passCheck(){
	$.ajax({
		type:"post",
		url:"pwdCheck12",
		data:{"password" :$("input[name=password]").val(),"b_num":$("#b_num").val()},
		
		success:function(data){
			if(data=="false"){
				alert("비밀번호가 일치하지 않습니다");
				$("input[name=password]").val("");
			}else{
				$.post("managementboardUpdate",{"b_num":$("#b_num").val(),"content":$("#content").val(),"title":$("#title").val()});
				opener.location.href="managementboardlist?category="+$("#category").val();
				self.close();
			}
		},
		beforeSend:showRequest,
		error:function(e){
			alert("error:"+e)
		}
	});
}
function showRequest(chk){
	var flag=true;
	if(!$("input[name=password]").val()){
		alert("비밀번호를 입력하세요");
		flag=false;
	}
	return flag;
}

 </script>
</head>
<body>
<div align="center">
<form method="post">
<input type="hidden" id="b_num" name="b_num" value="${b_num}">
<input type="hidden" id="title" name="title" value="${title}">
<input type="hidden" id="content" name="content" value="${content}">
<input type="hidden" id="category" name="category" value="${category }">
<table>

<tr><th align="center">
비밀번호 입력</th></tr>
<tr><th><input type="text" name="password" id="password"><th></tr>
<tr><th align="center"><input type="button" value="수정" onclick="passCheck()"></th></tr>
</table>
</form>
</div>
</body>
</html>