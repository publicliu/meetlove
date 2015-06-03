(function($,window,undefiend){
	$(document).on('pageinit','#listPage',function(event){
		$page = $(event.currentTarget);
		var $operatorA = $page.find('a[name="operator"]');
		$operatorA.click(function(){
			var $li = $(this).parent();
			var $name = $li.find('span[name="itemName"]');
			var $remark = $li.find('span[name="itemRemark"]');

			$('#purchase').one('popupafteropen',function(event,ui){
				$purchase = $(this);
				$purchase.find('h3[name="itemName"]').text($name.text());
				$purchase.find('p[name="itemRemark"]').text($remark.text());
			});
			$('#purchase').popup('open');

//			$( ":mobile-pagecontainer" ).pagecontainer( "load", "/confirm.html", { role: "dialog" } );
			return false;
		});
	});
})($,window);
