<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td{
	  text-align:center;
 	}
</style>
<script type="text/javascript">
	function deleteProduct(pid){
		var isdel = confirm("您确认删除吗");
		if(isdel){
			location.href="${pageContext.request.contextPath }/adminDeleteProductServlet?pid="+pid;
		}
	}
	function addProduct(){
		location.href="${pageContext.request.contextPath }/admin/add.jsp";
	}
	window.onload = function (){
		var cid = "${condition.cid}";
		var catcid = document.getElementById("cid");
		var options = catcid.childNodes;
		for (var int = 0; int < options.length; int++) {
			if(cid==options[int].value){
				options[int].selected="true";
			}
			
		}
/* 		for ( var option in options) {
			if(cid==option.value){
				alert("here");
				option.selected="true";
			}
		} */
		var is_hot = "${condition.is_hot}";
		var select = document.getElementById("is_hot");
		var options2 = select.childNodes;
		for (var int = 0; int < options2.length; int++) {
			if(is_hot==options2[int].value){
				options2[int].selected = "true";
			}
			
			}
		}
	
	
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/adminResearchServlet" method ="post">
	商品名称<input type="text" name="pname" value="${condition.pname }"> &nbsp;&nbsp;
	是否热门<select name="is_hot" id="is_hot">
					<option value="">未选择</option>
					<option value="1">是</option>
					<option value="0">否</option>
				</select>
	 商品种类  <select name="cid" id="cid">
					<option value="">未选择</option>
					<c:forEach items="${categoryList }" var="category">
						<option value="${category.cid }">${category.cname }</option>
					</c:forEach>
				</select>
		<input type="submit" value="搜索" >
	</form>
	<table align="center" border="1px" width="100%" cellpadding="0" cellspacing="0">
	<caption ><font size="40px">商品列表</font></caption>
		<tr height="30px">
			<td colspan="7" style="text-align:right" >
				<button type="button" onclick="addProduct()">添加商品</button>
			</td>
		</tr>
		<tr>
			<th>序号</th>
			<th>图片</th>
			<th>名称</th>
			<th>价格</th>
			<th>是否热门</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${productList }" var="pro" varStatus="num">
			<tr>
			<td>${num.count }</td>
			<td><img src='${pageContext.request.contextPath }/${pro.pimage }' width="40px" height="50px"></td>
			<td>${pro.pname }</td>
			<td>${pro.shop_price }</td>
			<td>${pro.is_hot ==1?'是':'否'}</td>
			<td><a href='${pageContext.request.contextPath }/adminUpdateProductServlet?pid=${pro.pid}'>编辑</a></td>
			<td><a onclick="deleteProduct('${pro.pid }')" href="javascript:void(0)">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>