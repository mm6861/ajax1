<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/ajaxUtil.js"></script>
</head>
<body>
<script>
	function callback(res){
		var res = JSON.parse(res);
		for(var addr of res.list){
			//document.write(addr);
			document.write(addr.ad_num+","+addr.ad_sido);
			// 이걸하면 이것.toString해야하는데  타입이 오브젝트면 그냥 오브젝트 찎는데 ???
		}
	}
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/addr2/list');
	xhr.onreadystatechange = function(){ 
		if(xhr.readyState==4){
			if(xhr.status==200){
				callback(xhr.response);
				// 
			}
		}
	}
	xhr.send();
	var Test = function(){
		this.abc = 123;
	}
	
	
	var t = new Test();
	t.func = function(){
		alert(t.abc);
	}
	t.func();
</script>

</body>
</html>















