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
	function addCategory(){
		location.href = "${pageContext.request.contextPath}/admin/addCategory.jsp";
	}
	function deleteCategory(cid){
		var isDelete = confirm("您确认删除该类");
		if(isDelete){
			location.href = "${pageContext.request.contextPath}/adminDeleteCategoryServlet?cid="+cid; 
		}
	}
	
	
</script>
</head>
<body>
	<table border="1px" width="100%">
		<caption>分类列表</caption>
		<tr>
			<td colspan="4" style="text-align:right"><button type = "button" onclick="addCategory()">添加分类</button>
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		
		<c:forEach items = "${categoryList }" var = "cat" varStatus = "num">
			<tr>
			<td>${num.count }</td>
			<td>${cat.cname }</td>
			<td><a href="${pageContext.request.contextPath }/adminEditCategoryServlet?cid=${cat.cid}">编辑</a></td>
			<td><a href = "javascript:void(0)" onclick="deleteCategory(${cat.cid})">删除</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>