<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화개봉리스트</title>
</head>
<body>
<table border="1" >
	<tr>
		<th>번호</th>
		<th>영화명</th>
		<th>년도</th>
		<th>국가</th>
		<th>제작사</th>
		<th>감독</th>
	</tr>
	<tbody id="tbody"></tbody>
</table>
	<c:if test="${sessionScope.user!=null }">
		<a href="/views/movie/insert">개봉 영화 등록</a>
	</c:if>
<script>
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/am/list');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var list = JSON.parse(xhr.response);
			var html = '';
			for(var movie of list){
				html += '<tr onmouseover="this.style.backgroundColor=\'pink\'"';
				html += ' onmouseout= "this.style.backgroundColor=\'\'"';
				html +=' onclick="goPage('+movie['mi_num']+')">';
				html += '<td>' + movie['mi_num'] + '</td>';
				html += '<td>' + movie['mi_name'] + '</td>';
				html += '<td>' + movie['mi_year'] + '</td>';
				html += '<td>' + movie['mi_national'] + '</td>';
				html += '<td>' + movie['mi_vendor'] + '</td>';
				html += '<td>' + movie['mi_director'] + '</td>';
				html += '</tr>';
			}
			document.querySelector('#tbody').innerHTML = html;
		}
	}
	xhr.send();
	function goPage(miNum){
		location.href = '/views/movie/ajax_view?miNum=' + miNum;
	}
</script>
</body>
</html>