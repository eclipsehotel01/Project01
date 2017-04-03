<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
게시글등록하기
<form action="guestboardinsert">
	<table>
		<tr>
			<td>게시판선택</td>
			<td>
				<select id="category" name="category" >
					<option>--게시판선택--</option>
					<option>QnA</option>
					<option>환불신청게시판</option>
					<option>자유게시판</option>
					<option>후기게시판</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" id="title" name="title"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" id="name" name="name"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" id="password" name="password"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="20" cols="30"></textarea></td>
		</tr>
		<tr>
			<td>파일첨부</td>
			<td><input type="file" id="file" name="file"></td>
		</tr>		
	</table>
	<input type="submit" value="전송">
</form>
</body>
</html>