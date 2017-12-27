<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
   
  </head>
  <body>
  	<jsp:include page="head.jsp"></jsp:include>
	  	<div class="container" style="margin-top: 40px">
	  		<div class="row" >
	  			<div class="col-lg-4 col-md-4 col-sm-4">订单号：${oid }</div>
	  				<c:forEach items="${orderMap }" var="product" varStatus="status">
						<div class="col-lg-12">
							<div class="col-lg-1" >${status.index+1 }</div>
							<div class="col-lg-2" ><img width="50px" height="70px" src="${pageContext.request.contextPath }/${product.key.pimage}"></div>
							<div class="col-lg-2" >${product.key.pname }</div>
							<div class="col-lg-2" >数量：${product.value }件</div>
							<div class="col-lg-2" >金额：${product.value*product.key.shop_price }元</div>
						</div>
					</c:forEach>
				<div class="col-lg-12">
	  				<div class="col-lg-2 col-lg-offset-8" >总价：${totalPrice}元</div>
	  				<div class="col-lg-2 col-lg-offset-8" ><button><a>取消订单</a></button></div>
	  				<div class="col-lg-2 " ><button><a href="${pageContext.request.contextPath}/paySuccessful.jsp">付款</a></button></div>
				</div>
	  		</div>
	  	</div>
	  <jsp:include page="bottom.jsp"></jsp:include>
  </body>
</html>