<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" herf="${pageContext.request.contextPath }/css/dtree.css" >
</head>
<body>
	<table>
		<tr>
				<td>
						<div class="dTree">
								<a href="javascript: d.openAll()">展开所有</a><a href = "javascript: d.closeAll()">关闭所有</a>
								<script type="text/javascript" src="${pageContext.request.contextPath }/js/dtree.js"></script>
								<script type="text/javascript">
									d = new dTree('d');
									d.add('01',-1,'电器商城管理');
									d.add('0101','01','分类管理模块');
									d.add('010101','0101','分类管理','${pageContext.request.contextPath }/admin/category.jsp','','right');
									d.add('0102','01','商品管理模块');
									d.add('010201','0102','商品管理','${pageContext.request.contextPath }/adminProductList','','right');
									document.write(d);
								</script>
						</div>
						<a href="${pageContext.request.contextPath }">前去商城</a>
	</table>
</body>
</html>