<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
	<div class="container" style="margin-top: 40px">
	  		<div class="row" >
	  			<div class="col-lg-12 col-md-4 col-sm-4">订单列表</div>
	  				<c:forEach items="${historyOrdersMap }" var="order" >
						<div class="col-lg-12" >订单号：${order.key.oid }</div>
								<c:forEach items="${order.value }" var="productMap" varStatus="status" >
								<div class="col-lg-12" style="margin: 20px">
									<div class="col-lg-1" >${status.index+1 }</div>
									<div class="col-lg-1" ><img width="50px" height="70px" src="${pageContext.request.contextPath }/${productMap.key.pimage}"></div>
									<div class="col-lg-4" >${productMap.key.pname }</div>
									<div class="col-lg-1" >数量：${productMap.value }件</div>
									<div class="col-lg-1" >单价：${productMap.key.shop_price }元</div>
									<div class="col-lg-1" >金额：${productMap.value*productMap.key.shop_price }元</div>
								</div>
								</c:forEach>
						<div class="col-lg-12 col-lg-offset-9" style="font-size: 20px">总价${order.key.totalprice }</div>
					</c:forEach>
	  		</div>
	  	</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>