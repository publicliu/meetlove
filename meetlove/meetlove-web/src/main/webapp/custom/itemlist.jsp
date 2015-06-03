<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/lib/jquery/mobile/jquery.mobile-1.4.5.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/custom/css/meetlove.css">
<script src="<%=request.getContextPath()%>/lib/jquery/jquery-1.11.3.min.js"></script>
<script src="<%=request.getContextPath()%>/lib/jquery/mobile/jquery.mobile-1.4.5.min.js"></script>
<script src="<%=request.getContextPath()%>/custom/js/itemlist.js"></script>
<title>遇见爱</title>
</head>
<body>
  <script type="text/javascript">

  </script>
  <!-- Start of first page: #one -->
  <div id="listPage" data-role="page"  class="my-page" >

    <div data-role="header">
      <h1>商品列表</h1>
    </div>
    <!-- /header -->

    <div role="main" class="ui-content">
	    <ul data-role="listview"  data-split-icon="plus" data-split-theme="a" data-inset="false">
	    	<c:forEach items="${sessionScope.itemList}" var="item">
	        	<li>
	        		<a href="#">
						<img style="padding:5px;height:70px;width:70px;" src="${pageContext.request.contextPath}/api/admin/goods/item/resource/${item.resourceName}">
	              		<h2>
	              			<span name="itemName">${item.name}</span>
		              		<c:if test="${item.oldPrice > item.price}">
		              			<span class="price" style="font-size: 15px;color: red;text-decoration: line-through;">￥${item.oldPrice}</span>
		              		</c:if>
		                	<span style="font-size: 15px;color: red;">￥${item.price}</span>
		              	</h2>
		              	<p>售出：123,推荐：4  </p>
		              	<span class="ui-li-count">0</span>
		              	<span name="itemRemark" style="display: none;">${item.remark}</span>
	              	</a>
					<a href="#" name="operator"></a>
	          </li>
	        </c:forEach>
	     </ul>

	     <div data-role="popup" id="purchase" data-theme="a" data-overlay-theme="b" class="ui-content" style="max-width:340px; padding-bottom:2em;">
			<h3 name="itemName"></h3>
			<p name="itemRemark"></p>
	    	<a href="index.html" data-rel="back" class="ui-shadow ui-btn ui-corner-all ui-btn-b ui-icon-check ui-btn-icon-left ui-btn-inline ui-mini">Buy: $10.99</a>
	    	<a href="index.html" data-rel="back" class="ui-shadow ui-btn ui-corner-all ui-btn-inline ui-mini">Cancel</a>
		</div>

    </div>
    <!-- /content -->


    <div data-role="footer" data-position="fixed" data-fullscreen="false">
      <div data-role="navbar">
        <ul>
          <li><a href="#" data-icon="star" class="ui-btn-active">首页</a></li>
          <li><a href="#" data-icon="star">购物车<span class="ui-li-count">0</span></a></li>
          <li><a href="#" data-icon="star">订单</a></li>
          <li><a href="#" data-icon="star">我的</a></li>
        </ul>
      </div>
    </div>

  </div>
  <!-- /page one -->

</body>
</html>
