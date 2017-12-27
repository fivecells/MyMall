  	<jsp:include page="head.jsp"></jsp:include>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.qianfeng.domain.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="css/bootstrap.min.css" rel="stylesheet">
<title>购物车</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
  
<script type="text/javascript">

	function find(obj){
		$.get(
			"${pageContext.request.contextPath}/findProductByWordServlet",
			{word:$(obj).val()},
			function(date){
				var divcon ="";
				for (var i = 0; i < date.length; i++) {
					divcon +="<div onmouseover='over(this)' onmouseout='out(this)' onclick='clickfn(this)'>"+date[i].pname+"</div>";
				}
				$("#getProduct").html(divcon);
				$("#getProduct").css("display","block")
			},
			"json"
		)
	}
	function over(obj){
		$(obj).css("background","#ccc");
	}
	function out(obj){
		$(obj).css("background","#fff");
	}
	function clickfn(obj){
		$("#content").val($(obj).html());
		$("#getProduct").css("display","none");
	}
	
</script>

</head>
<body>
		<table align="center" width="1200px" border="0px">
			<tr>
				<td style = "text-align:center">
					<div style = "padding-left:50px">
				
						<c:forEach items="${pageBean.productList }" var = "product">
									<div style = 'border:0px solid red;text-align:center;float:left;width:220px; height:350px;padding:10px '>
									<img width = 150px height = 200px  src = '${pageContext.request.contextPath }/${product.pimage}'/>
									<a href="${pageContext.request.contextPath }/productDetailServlet?pid=${product.pid}"><p>${product.pname }</p></a><!-- productDetailsServlet改写 -->
									<p>商城价格：${product.market_price }</p>
									<p>商店价格：${product.shop_price }</p>
									</div>
						</c:forEach>
					</div>
				</td>
			</tr>
			<tr>
				<td style="text-align:center">
					<c:if test="${empty cid }">
					<nav aria-label="Page navigation">
  						<ul class="pagination">
						<c:if test="${pageBean.currentPage !=1}">
							<li><a href="${pageContext.request.contextPath }/showProductServlet?currentPage=${pageBean.currentPage -1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
						</c:if>
						<c:if test="${pageBean.currentPage ==1}">
							<li><a href="javascript:void(0)" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
						</c:if>
							<c:forEach  begin="1" end="${pageBean.totalPage }"  var="page" >
								<c:if test="${page!=pageBean.currentPage }">
									<li><a href="${pageContext.request.contextPath }/showProductServlet?currentPage=${page }">${page }</a></li>
								</c:if>
								<c:if test="${page==pageBean.currentPage }">
									<li><a href="javascript:(0)">${page }</a></li>
								</c:if>
							</c:forEach>
						<c:if test="${pageBean.currentPage !=pageBean.totalPage&&pageBean.totalPage!=0 }">
							<li><a href="${pageContext.request.contextPath }/showProductServlet?currentPage=${pageBean.currentPage +1}"  aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
						</c:if>
						<c:if test="${pageBean.currentPage ==pageBean.totalPage || pageBean.totalPage==0 }">
							<li><a href="javascript:void(0)" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
						</c:if>
					</ul>
				</nav>
				</c:if>
					<c:if test="${!empty cid }">
					<nav aria-label="Page navigation">
						<ul class="pagination">
							<c:if test="${pageBean.currentPage !=1}">
								<li><a href="${pageContext.request.contextPath }/getProductByCategoryServlet?currentPage=${pageBean.currentPage -1}&cid=${cid}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
							</c:if>
							<c:if test="${pageBean.currentPage ==1}">
								<li><a href="javascript:void(0)"aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
							</c:if>
								<c:forEach  begin="1" end="${pageBean.totalPage }"  var="page" >
									<c:if test="${page!=pageBean.currentPage }">
										<li><a href="${pageContext.request.contextPath }/getProductByCategoryServlet?currentPage=${page }&cid=${cid}">${page }</a></li>
									</c:if>
									<c:if test="${page==pageBean.currentPage }">
										<li><a href="javascript:(0)">${page }</a></li>
									</c:if>
								</c:forEach>
							<c:if test="${pageBean.currentPage !=pageBean.totalPage&&pageBean.totalPage!=0 }">
								<li><a href="${pageContext.request.contextPath }/getProductByCategoryServlet?currentPage=${pageBean.currentPage +1}&cid=${cid}"aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
							</c:if>
							<c:if test="${pageBean.currentPage ==pageBean.totalPage || pageBean.totalPage==0 }">
								<li><a href="javascript:void(0)" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
							</c:if>
						</ul>
						</nav>
					</c:if>
				</td>
			</tr>
		</table>
		<jsp:include page="/bottom.jsp"></jsp:include>
	</body>
</html>