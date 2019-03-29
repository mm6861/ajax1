<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/user">
	<table border="1">
		<tr>
		<td colspan="2" style="text-align:center">==회원가입==</td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="ui_name"></td>
		</tr>
		<tr>
			<th>아이디 </th>
			<td><input type="text" name="ui_id"></td>
		</tr>
		<tr>
			<th>패스워드 </th>
			<td><input type="password" name="ui_password"></td>
		</tr>
		<tr>
			<th>e-mail </th>
			<td><input type="email" name="ui_email"></td>
		</tr>
		<tr>
			<td colspan="2"><button>가입하기</button></td>
		</tr>
	
	</table>
	<input type="hidden" name="cmd" value="insert">
</form>
</body>
</html>