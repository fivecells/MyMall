<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.js" ></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<title>欢迎登录</title>
</head>
<body>

	<table align="center" width="1200px" >
			<tr>
				<td>
				<table align="center" width="100%">
					<tr>
						<td align="left"><a href="${pageContext.request.contextPath }/index.jsp"><img src="${pageContext.request.contextPath }/img/2.png"></a></td>
						<td align="right"><a href="${pageContext.request.contextPath }/register.jsp">没有账户？请注册</a></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container" style="background-image: url('${pageContext.request.contextPath }/img/login.jpg');height:600px">
		<div class="row">
					<div class="col-lg-offset-8" style=" margin-top:200px;text-align:center">
						<%=request.getAttribute("info") ==null?"":"登录失败："+request.getAttribute("info")%>
						<form id="myform" action="${pageContext.request.contextPath }/loginServlet">
							用户名<input type = "text" name = "username" ><br>
							密&nbsp;&nbsp;&nbsp;&nbsp;码<input type = "password" name = "password" ><br>
							验证码<input type= "text" name="check" id="checkCode" ><br>
							<img id="check" src="${pageContext.request.contextPath }/checkImgServlet" onclick = "changeImg()"><br>
							<span id="span1"></span><br>
							<input type="checkbox" name="autoLogin" value="1"/>自动登录<br>
							<input type = "submit" value = "登录">
						</form>
					</div>
		</div>
	</div>
	<jsp:include page="/bottom.jsp"></jsp:include>
</body>
<script>
		$(function(){
			$("#myform").validate({
				rules:{
					username:{
						required:true,
						minlength:3
					},
					password:{
						required:true,
						digits:true,
						minlength:3
					},
					check:{
						required:true
					}
				}
			});
			$("#checkCode").blur(function(){
				$.get(
						"${pageContext.request.contextPath}/checkCodeServlet",
						{"checkCode":$(this).val()},//获得当前控件的value的值,以json格式把数据传给服务器
						function(data){
							if(data=="true"){
								$("#span1").html("验证码正确");
							}else{
								$("#span1").html("验证码错误");
							}
						},
						"text"
					);
			});
		});
	function changeImg(){
		var check = document.getElementById("check");
		check.src="${pageContext.request.contextPath }/checkImgServlet?time="+new Date().getTime();
	}
</script>
</html>