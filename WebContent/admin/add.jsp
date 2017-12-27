<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/adminForAddProduct" method="post">
		<table border="1px">
			<caption>添加商品</caption>
			<tr>
				<td>商品名称</td>
				<td><input type = "text" name = "pname"></td>
			</tr>
			<tr>
				<td>商城价格</td>
				<td><input type = "text" name = "market_price" ></td>
			</tr>
			<tr>
				<td>商店价格</td>
				<td><input type = "text" name = "shop_price" ></td>
			</tr>
			<tr>
				<td>商品图片</td>
				<td><input type="file" name = "upload"></td>
			</tr>
			<tr>
				<td>所属分类</td>
				<td>
				<select name="cid">
				<option>未选择</option>
					<c:forEach items="${categoryList }" var="category">
						<option value="${category.cid }">${category.cname }</option>
					</c:forEach>
				</select>
				</td>
			</tr>	
			<tr>
				<td>是否热门</td>
				<td>
					<select name="is_hot">
						<option value="1">是</option>
						<option value="0">否</option>
					</select>
				</td>
			<tr>
				<td>商品描述</td>
				<td><textarea rows="5" cols="10" name = "pdesc"></textarea></td>
			</tr>
			
			<tr>
				<td colspan = "2" > 
					<input type = "submit" name="提交">
					<input type = "reset" name="重置">
					<button type = "button" onclick="history.go(-1)">返回</button>
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>