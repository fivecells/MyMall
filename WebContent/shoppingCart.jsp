<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style type="text/css">
	
</style>
<script type="text/javascript">
	$(function(){
		$("#select").click(function(){
			$(".select").attr("checked",this.checked);
			if (this.checked){
				var totalprice=0.0;
				var count = 0;
				var pids = document.getElementsByName("orderPids");
				for (var i = 0; i < pids.length; i++) {
					var price = document.getElementById("price_"+pids[i].value); 
					var num = document.getElementById("value_"+pids[i].value); 
					var n = parseFloat(price.innerHTML);
					var m = parseInt(num.value);
					totalprice += n*m;
					count +=m;
				}
				$("#selectNum").html(count);
				$("#totalPrice").html(totalprice);
				$("#total").val(totalprice);
			}else{
				$("#selectNum").html(0);
				$("#totalPrice").html(0.0);
				$("#total").val(0.0);
			}
		});
	});
/* 	$(function(){
		$("#delete").click(function(){
			$.post(
				"${pageContext.request.contextPath }/deleteCartServlet",
				{"orderPids":"orderPids"},//获得当前控件的value的值,以json格式把数据传给服务器
				function(data){
					alert("success");
				},
				"json"
			);
		});
	}); */
	function boxChange(obj){
		check();
		//获得数量的id
		var id = "value_"+obj.id;
		var spanNum= $("#selectNum").text();
		var num = document.getElementById(id);
		var i = parseInt(spanNum);
		var j = parseInt(num.value);
		//获得shop_price的id
		var priceId = "price_"+obj.id;
		//获得已有的总价
		var selectPrice = $("#totalPrice").text();
		//获得商品价格
		var showPrice = document.getElementById(priceId);
		var price = showPrice.innerHTML;
		var m = parseFloat(price);
		var n = parseFloat(selectPrice);
		if (obj.checked) {
			$("#selectNum").html(i+j);
			$("#totalPrice").html(n+j*m);
			$("#total").val(n+j*m);
		}else{
			$("#selectNum").html(i-j);
			$("#totalPrice").html(n-j*m);
			$("#total").val(n-j*m);
		}
		
	}
	function check(){
		var flag = true;
		for (var i=0;i< $(".select").length;i++){
			if( $(".select")[i].checked==false){
				flag = false;
			}
		}
		$("#select").attr("checked",flag);
	}
	function increase(obj){
		var id = "value_"+obj;
		var num = document.getElementById(id);
			num.value++;
		if(document.getElementById(obj).checked){
			change(obj,"increase");
		}
	}
	function decrease(obj){
		var id = "value_"+obj;
		var num = document.getElementById(id);
		if(num.value>1){
			num.value--;
		}
		if(document.getElementById(obj).checked){
			change(obj,"decrease");
		}
	}
	function change(obj,word){
		var id = "value_"+obj;
		var num = document.getElementById(id);
		var j = parseInt(num.value);
		if(j>1){
			var spanNum= $("#selectNum").text();
			var i = parseInt(spanNum);
			//获得shop_price的id
			var priceId = "price_"+obj;
			//获得已有的总价
			var selectPrice = $("#totalPrice").text();
			//获得商品价格
			var showPrice = document.getElementById(priceId);
			var price = showPrice.innerHTML;
			var m = parseFloat(price);
			var n = parseFloat(selectPrice);
			if("decrease"==word){
				$("#selectNum").html(i--);
				$("#totalPrice").html(n-m);
				$("#total").val(n-m);
			}else{
				$("#selectNum").html(i++);
				$("#totalPrice").html(n+m);
				$("#total").val(n+m);
			}
		}
	}
	function checkLogin(){
		alert("您还未登陆，现在去登陆吧！")
	}
</script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
		<div class="container">
			<div class="row">
			<div class="col-lg-12">
				<c:if test="${empty cartMap }">
					<img  src="${pageContext.request.contextPath }/img/4.png" width="100%">
				</c:if>
			</div>
				<form  action="${pageContext.request.contextPath }/payServlet" method="post">
					<c:forEach items="${cartMap }" var="product">
						<div class="col-lg-12" style="margin-bottom:10px;background-color:;">
							<div class="col-lg-1 "><input type="checkbox" name="orderPids" value="${product.key.pid }" id="${product.key.pid }" class="select" onchange="boxChange(this)"></div>					
							<div class="col-lg-2" ><img width="50px" height="70px" src="${pageContext.request.contextPath }/${product.key.pimage}"></div>
							<div class="col-lg-2" >${product.key.pname }</div>
							<div class="col-lg-2" ><span id="price_${product.key.pid }" >${product.key.shop_price }</span>元</div>
							<div class="col-lg-4" ><button  type="button"  onclick="increase(${product.key.pid })" >+</button>
							<input type="text" name="num_${product.key.pid }" value="${product.value }" id="value_${product.key.pid }" >
							<button type="button" onclick="decrease(${product.key.pid })">-</button></div>
						</div>
					</c:forEach>
					<div class="col-lg-12">
						<div class="col-lg-1 "><input type="checkbox" id="select"></div>	
						<div class="col-lg-2 "><input type="submit" name="pay" id ="delete" value="删除"></div>	
						<div class="col-lg-2 col-lg-offset-2">已选中<span id="selectNum">0</span>件商品</div>	
						<div class="col-lg-2 ">总价：<span id="totalPrice">0.0</span>元</div>	
						<div class="col-lg-2 " style="display:none"><input type="text" id="total" name="totalPrice" ></div>	
						<c:if test="${empty user }">
							<div class="col-lg-2 "><input type="button" onclick="checkLogin()" value="结算"></div>	
						</c:if>
						<c:if test="${!empty user }">
							<div class="col-lg-2 "><input type="submit" name="pay" value="结算"></div>	
						</c:if>
					</div>
				</form>
			</div>
		</div>
		<jsp:include page="/bottom.jsp"></jsp:include>
</body>
</html>