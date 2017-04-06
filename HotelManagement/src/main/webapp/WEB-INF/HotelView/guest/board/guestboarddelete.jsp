<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 확인창</title>
<script src='https://code.jquery.com/jquery-3.1.1.min.js'></script>
<script type="text/javascript" src="resources/js/guest_board.js"></script>

<link rel="stylesheet" type="text/css" href="resources/style.css">

</head>
<body>
	<div align="center">
		<form method="post">
			<input type="hidden" id="b_num" name="b_num" value="${b_num}">
			<input type="hidden" id="steps" name="steps" value="${steps}">
			<input type="hidden" id="groups" name="groups" value="${groups}">
			<input type="hidden" id="levels" name="levels" value="${levels}">
			<input type="hidden" id="category" name="category" value="${category }">
			<table>

				<tr>
					<th align="center">비밀번호 입력</th>
				</tr>
				<tr>
					<th><input type="text" name="password" id="password">
					<th>
				</tr>
				<tr>
					<th align="center"><input type="button" value="삭제"
						onclick="passCheck11()"></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>