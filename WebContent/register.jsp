<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<title>购物车</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js" ></script>		<script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.js" ></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$("#username").blur(function(){
    			$.post(
    					"${pageContext.request.contextPath}/checkUserServlet",
    					{"username":$(this).val()},//获得当前控件的value的值,以json格式把数据传给服务器
    					function(data){
    						if(data=="true"){
    							$("#span1").html("用户名已存在");
    						}else{
    							$("#span1").html("用户名可以使用");
    						}
    					},
    					"text"
    				);
    		});
    		$("#checkCode").blur(function(){
    			$.get(
    					"${pageContext.request.contextPath}/checkCodeServlet",
    					{"checkCode":$(this).val()},//获得当前控件的value的值,以json格式把数据传给服务器
    					function(data){
    						if(data=="true"){
    							$("#span2").html("验证码正确");
    						}else{
    							$("#span2").html("验证码错误");
    						}
    					},
    					"text"
    				);
    		});
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
					repwd:{
						required:true,
						equalTo:"[name='password']"
					},
					email:{
						required:true,
						email:true
					},
					name:{
						required:true,
						maxlength:5
					},
					sex:{
						required:true
					},
					birthday:{
						required:true,
						date:true
					}
					
				}
			});
    	});
		function changeImg(){
			var cimg = document.getElementById("check");
			//为了防止缓存而每次提交一个新的请求。
			cimg.src = "${pageContext.request.contextPath }/checkImgServlet?time="+new Date().getTime();
		}
    </script>
    <style type="text/css">
    	td{
    	margin: 10px;
    	}
    </style>
  </head>
<body>
		<table align="center" width="1200px" >
			<tr>
				<td>
				<table align="center" width="100%">
					<tr>
						<td align="left"><a href="${pageContext.request.contextPath }/index.jsp"><img src="${pageContext.request.contextPath }/img/2.png"></a></td>
						<td align="right"><a href="${pageContext.request.contextPath }/login.jsp">已有账户？请登录</a></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
	<jsp:include page="navbar.jsp"></jsp:include>
		<table align="center" width="1200px" >
			<tr>
				<td>
						<form id="myform"  action="${pageContext.request.contextPath }/registerServlet" method="post">
							<table align="center" border="0px" width="600px" >
								<caption style="text-align: center;font-size:30px">注册表</caption>
								<tr>
									<td align="center" width="50%" >用户名</td>
									<td>
										<input type="text" name="username" id="username"	/><span id="span1"></span>
										<%=request.getAttribute("info2") ==null?"":request.getAttribute("info2")%>
									</td>
								</tr>
								<tr>
									<td align="center">密码</td>
									<td>
										<input type="password" name="password" 	/>
									</td>
								</tr><tr>
									<td align="center">确认密码</td>
									<td>
										<input type="password" name="repwd" />
									</td>
								</tr>
								<tr>
									<td align="center">真实姓名</td>
									<td>
										<input type="text" name="name" />
									</td>
								</tr>
								<tr>
									<td align="center">邮箱</td>
									<td>
										<input type="text" name="email" />
									</td>
								</tr>
								<tr>
									<td align="center">电话</td>
									<td>
										<input type="text" name="telephone" />
									</td>
								</tr>
								<tr>
									<td align="center">生日</td>
									<td>
										<input type="date" name="birthday" />
									</td>
								</tr>
								<tr>
									<td align="center">性别</td>
									<td>
										<input type="radio" name="sex" value="男"/>男
										<input type="radio" name="sex"  value="女"/>女
									</td>
								</tr> 
								<tr>
								  <td align="center">验证码</td>
								  <td>
								  			<input type = "text" name = "check" id="checkCode">
											<img id = "check" src="${pageContext.request.contextPath }/checkImgServlet" onclick = "changeImg()">
											<span id="span2"></span>
									</td>
								</tr>

								<tr>
									<td align="center">
										<input type="submit" value="注册" />
									</td > 
									<td align="center">
										<input type="reset" value="重置"/>
									</td>
								</tr>
							</table>
						</form>	
					<br />					
				</td>
			</tr>
			
		</table>
		<jsp:include page="/bottom.jsp"></jsp:include>
	</body>

</html>