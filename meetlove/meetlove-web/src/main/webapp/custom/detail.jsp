<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="pragma" content="no-cache">
<link rel="stylesheet" href="<%=request.getContextPath()%>/lib/jquery/mobile/jquery.mobile-1.4.5.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/custom/css/meetlove.css">
<script src="<%=request.getContextPath()%>/lib/jquery/jquery-1.11.3.min.js"></script>
<script src="<%=request.getContextPath()%>/lib/jquery/mobile/jquery.mobile-1.4.5.min.js"></script>
<title>商品详细信息</title>
</head>
<body>
<!-- Start of first page: #one -->
<div data-role="page" id="one">

	<div data-role="header">
	 <a href="#" data-role="button"  data-theme="b" data-icon="home">首页</a>
	 <a href="#" data-role="button"  data-theme="b" data-icon="home">购物车</a>
			<h1>详细信息</h1>
	</div><!-- /header -->

	<div role="main" class="ui-content">

	</div><!-- /content -->


</div><!-- /page one -->
<script type="text/javascript">
var context = $('#one');
context.on('pageshow',function(){

console.debug('pageshow');
	$.getJSON(
			'<%=request.getContextPath()%>/api/custom/item/detail?goodsId=<%=request.getParameter("goodsId")%>',
			function(result){
				console.debug('1');
				var goods = result.data;
				$('.ui-content').html(
						'<div>' + goods.id +'</div>'+
						'<div>' + goods.name +'</div>'+
						'<div>' + goods.remark +'</div>'+
						'<div>' + goods.status +'</div>'
				);
				console.debug('2');
				for(i in goods.resources){
					var contextPath = '<%=request.getContextPath()%>';
					$('.ui-content').append('<div><img src="'+contextPath+'/api/admin/goods/item/resource/'+goods.resources[i].name+'">'+'</div>');
				}
				console.debug('3');
			},
		'json');

});
</script>
</body>
</html>