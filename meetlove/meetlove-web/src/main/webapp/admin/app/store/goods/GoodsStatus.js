Ext.define('Eway.store.goods.GoodsStatus',{

	extend : 'Eway.store.base.Store',
	requires : 'Eway.model.goods.GoodsStatus',
	model : 'Eway.model.goods.GoodsStatus',
	data : [{
		'status':'ON',
		'name':'在线'
	},{
		'status' : 'OFF',
		'name' : '离线'
	}]

});