(function($,window,undefiend){

	$.get(
		'api/admin/goods/item',
		{},
		function(result){
			var $view = $('#images-view');
			var items = result.data;
			for(i in items){
				var goods = items[i];
				var $item = $('<div class="thumb-wrap">'+
									'<div class="thumb">'+
									'<ul>'+
										'<li>'+
											'<a href="custom/detail.jsp?goodsId='+goods.id+'&goodsName='+goods.name+'">'+
												'<img class="left" src="api/admin/goods/item/resource/'+goods.resourceName+'">'+
											'</a>'+
										'</li>'+
									'</ul>'	+
									'</div>'+
									'<span>'+goods.name+'</span>'+
								'</div>');
				$item.appendTo($view);
				/*var as = $item.find(".thumb ul li a");
				as.click(function(event){
					location.replace(this.href)
					return true;
				});*/
			}
		},
		'json')

})($,window);