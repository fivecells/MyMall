<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    	function search(){
    			$.get(
    				"${pageContext.request.contextPath}/findProductByWordServlet",
    				{"word":$("#searchword").val()},
    				function(data){
    					var content="";
    					if(data.length>0){
    						for(var i=0;i<data.length;i++){
    							content+="<div onmouseover='overfn(this)' onmouseout='outfn(this)' onclick='clickfn(this)'>"+data[i].pname+"</div>";
    						}
    						$("#showSearchProductDiv").html(content);
    						//填完值让该div出现
    						$("#showSearchProductDiv").css("display","block");
    					}
    				},
    				"json"
    			);
    	}
   function overfn(obj){
		$(obj).css("background","#ccc");
	}
	function outfn(obj){
		$(obj).css("background","#fff");
	}
	function clickfn(obj){
		$("#searchword").val($(obj).html());
		$("#showSearchProductDiv").css("display","none");
	}
    </script>
  </head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-2"><a href="${pageContext.request.contextPath }/index.jsp"><img src="${pageContext.request.contextPath }/img/2.png"></a></div>
				<div class="col-lg-2 col-lg-offset-8" style="margin-top:35px">
					<c:if test="${empty user }">
							<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
							<a href="register.jsp">注册</a>
							<a href="${pageContext.request.contextPath }/shoppingCart.jsp">购物车</a></td>
					</c:if>
					<c:if test="${!empty user }">
							<a href="${pageContext.request.contextPath }/showOrderServlet">欢迎您${user.username }</a>
							<a href="${pageContext.request.contextPath }/shoppingCart.jsp">购物车</a>
							<a href="${pageContext.request.contextPath }/logoutServlet">退出</a>
					</c:if>
				</div>
		</div>
	</div>
	<%--  <table align="center" width="1150px" border="0px">
			<tr>
				<td>
				<table align="center" width="100%">
					<c:if test="${empty user }">
						<tr>
							<td align="left"><a href="${pageContext.request.contextPath }/index.jsp"><img src="${pageContext.request.contextPath }/img/2.png"></a></td>
							<td align="right"><a href="${pageContext.request.contextPath }/login.jsp">登录</a>
								<a href="register.jsp">注册</a>
							<a href="${pageContext.request.contextPath }/shoppingCart.jsp">购物车</a></td>
						</tr>
					</c:if>
					<c:if test="${!empty user }">
						<tr>
							<td align="left"><a href="${pageContext.request.contextPath }/index.jsp"><img src="${pageContext.request.contextPath }/img/2.png"></a></td>
							<td align="right"><a href="${pageContext.request.contextPath }/showOrderServlet">欢迎您${user.username }</a>
							<a href="${pageContext.request.contextPath }/shoppingCart.jsp">购物车</a>
							<a href="${pageContext.request.contextPath }/logoutServlet">退出</a>
							</td>
						</tr>
					</c:if>
				</table>
				</td>
			</tr>
			<tr height="50px">
				<td bgcolor="red" width="100%" height="20px">
					<a href="${pageContext.request.contextPath }/showProductServlet">首页</a>
					<c:forEach items="${categoryList }" var="category">
					<!--获取所有种类  -->
					<a href="${pageContext.request.contextPath }/getProductByCategoryServlet?cid=${category.cid }">${category.cname }</a>					
					</c:forEach>
				</td>
			</tr>
		</table> --%>
<div class="container">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath }/index.jsp">首页</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath }/getProductByCategoryServlet?cid=1">手机 </a></li>
        <li><a href="${pageContext.request.contextPath }/getProductByCategoryServlet?cid=2">电脑</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">全部分类 <span class="caret"></span></a>
          <ul class="dropdown-menu">
        	 <c:forEach items="${categoryList }" var="category">
				<!--获取所有种类  -->
				<li><a href="${pageContext.request.contextPath }/getProductByCategoryServlet?cid=${category.cid }">${category.cname }</a></li>				
			</c:forEach>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-right">
        <div class="form-group" style="">
          <input type="text" id="searchword" onkeyup="search()"  autocomplete="off" class="form-control" placeholder="搜索商品">
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
      </form>
 		<div style="position:relative;width:675px;">
			<div id="showSearchProductDiv" style="border:1px solid #999;width:270px;display:none;position:absolute;left:800px;top:43px;z-index:9999;background-color: white" ></div>
		</div>
     
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</div>
</body>
</html>