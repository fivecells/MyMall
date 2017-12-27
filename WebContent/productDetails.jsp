<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.qianfeng.domain.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情页</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
/* function addCart(){
	$.get(
		"${pageContext.request.contextPath}/addCartServlet",		
		{product:"${product}",num:"3"}, //传给后台对象的修订过得toString字段
		function(date){
			alert("添加购物车成功");
		},
		"json"
	);
}  */
	
 	function addCart(){
		// 创建Ajax对象 
		var xmlHttp = new XMLHttpRequest();
		//绑定响应事件
		xmlHttp.onreadystatechange=function(){
			if (xmlHttp.readyState==4&&xmlHttp.status==200) {
				alert("添加购物车成功");
			}
		}
		//绑定发送地址
		/* var pronum = document.getElementById("pronum"); */
		xmlHttp.open("get", "${pageContext.request.contextPath}/addCartServlet?pid=${product.pid}&num="+$("#pronum").val(), true);
		//发送
		xmlHttp.send();
	}
	function increase(){
		/* var pronum = document.getElementById("pronum");
		pronum.value++; */
		$("#pronum")[0].value++;
	}
	function decrease(){
		/* var pronum = document.getElementById("pronum");
		if(pronum.value>1){
		pronum.value--;
		} */
		if ($("#pronum")[0].value>1) {
			$("#pronum")[0].value--;
		}
	}
	
	
</script>
</head>
<body>
  	<jsp:include page="head.jsp"></jsp:include>
		<table align="center" width="1200px" border="0px">
			<tr>
				<td style = "text-align:center">
					<div style = "padding-left:50px;float:left;margin: 50px;width: 300px;">

									<div style = 'text-align:center;float:left;width:220px;padding:10px '>
									<img width = 260px height = 300px  src = '${pageContext.request.contextPath }/${product.pimage}'/>
									</div>
					</div>
					<div style="float: left;background-color:silver;width:500px;margin: 80px" >
						<p style="font-size: 30px">${product.pname }</p>
						<p>商城价格：${product.market_price }</p>
						<p>商店价格：${product.shop_price }</p>
						<p>
							<div style="float: left;margin-left: 180px"><input type="text" id="pronum" value="1" maxlength="8" style="width: 60px;height: 40px;"></div>
							<div style="float: left;" >
								<div><button style="height: 20px;margin: 2px" onclick="increase()">∧</button></div>
								<div><button style="height: 20px;margin: 2px" onclick="decrease()">∨</button></div>
							</div>
						<div style="float: left;margin-top: 10px">件</div>
						<br><br><br>
						<button style="background-color: red;border-color: red" onclick="addCart()"><font size="5px" color="white">加入购物车</font></button>
						<button><font size="5px" color="red">直接购买</font></button>
					</div>
				</td>
			</tr>
			<tr><td style="background-color: red;font-size: 30px;text-align:center">商品详情</td></tr>
			<tr><td><p>&nbsp;&nbsp;${product.pdesc }</p></td></tr>
		</table>
	</body>
			<jsp:include page="bottom.jsp"></jsp:include>
</html>