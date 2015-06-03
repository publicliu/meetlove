<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="<%=request.getContextPath()%>/custom/js/goodslist.js"></script>
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">

</script>
<!-- Start of first page: #one -->
<div id="page1" data-role="page" id="one">

	<div data-role="header">
		<h1>商品列表</h1>
	</div><!-- /header -->
<%
		out.print(Math.random()*100);
System.out.println("123456677");
	%>
	<div id="images-view" role="main" class="ui-content" align="center">
	</div><!-- /content -->


</div><!-- /page one -->
<script type="text/javascript">
/* var page = $('#page1');
console.debug(page);
page.on('pageshow',function(){
	console.debug('123');
}); */
</script>
</body>
</html>