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
					���̸� �Է�
					<input type="text" name="dong" id="dong" onkeyup="zipcodeEnter()"> 
					<input type="button" value="�˻�" onclick="btnZipcodeSend()" class="btnStyle">
				</td>
				<td>*�˻� ��, �Ʒ� �����ȣ�� Ŭ���ϸ� �ڵ����� �Էµ˴ϴ�.</td>
			</tr>
		</table>
	</form>
	<br><br>
	<div id="zipcodeArea"></div>
</body>
</html>