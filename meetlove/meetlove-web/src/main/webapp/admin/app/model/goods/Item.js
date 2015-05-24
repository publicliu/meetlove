Ext.define('Eway.model.goods.Item',{

	extend : 'Ext.data.Model',
	idProperty : 'id',
	fields : ['id','name','remark','status','resourceName','resourcePath','classifyId'],

	proxy : {
		type : 'rest',
		url : 'api/admin/goods/item',

		reader : {
			type : 'json',
			root : 'data'
		},
		wirter : {
			type : 'json'
		}
	}
});