<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/admin_style.css">

<!-- JS -->
<script type="text/javascript" src="resources/js/common.js"></script>

</head>
<body>
	<form>
		<table>
			<tr>
				<td>
					동이름 입력
					<input type="text" name="dong" id="dong" onkeyup="zipcodeEnter()"> 
					<input type="button" value="검색" onclick="btnZipcodeSend()" class="btnStyle">
				</td>
				<td>*검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.</td>
			</tr>
		</table>
	</form>
	<br><br>
	<div id="zipcodeArea"></div>
</body>
</html>