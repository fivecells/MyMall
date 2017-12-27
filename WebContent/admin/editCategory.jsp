<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/adminUpdateCategoryServlet" method="post">
	<input type="hidden" name = "cid" value="${category.cid }">
		<table border="1px" width="100%">
			<caption>编辑种类</caption>
			<tr>
				<td>类别名称</td>
				<td><input type="text" name = "cname" value="${category.cname }"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value = "提交" >
					<input type="reset" value = "重置" >
					<input type="button"  onclick="history.go(-1)" value ="返回"  >
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>