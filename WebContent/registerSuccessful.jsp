<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<jsp:include page="head.jsp"></jsp:include>
		<div align="center"><p style="font-size: 30px">注册成功，<span id="span1">5</span>秒后返回首页</p></div>
		<jsp:include page="bottom.jsp"></jsp:include>
		
</body>
	<script>
		time = 5;
		window.onload = function(){
			function fn(){
				if(time>0){
					var span1 = document.getElementById("span1");
					time--;
					span1.innerHTML = time;
						setTimeout(fn,1000);
					}else{
						location.href = "${pageContext.request.contextPath}/showProductServlet";
					}
			}
			fn();
		}
		
	</script>
</html>