<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개봉 영화 등록</title>
</head>
<body>
<form method="post" action="/movie/insert">
	영화제목 : <input type="text" name="mi_name"><br>
	제작년도 : <input type="text" name="mi_year"><br>
	국가 : <input type="text" name="mi_national"><br>
	제작사 : <input type="text" name="mi_vendor"><br>
	영화감동 : <input type="text" name="mi_director"><br>
	<button>등록</button>
</form>
</body>
</html>