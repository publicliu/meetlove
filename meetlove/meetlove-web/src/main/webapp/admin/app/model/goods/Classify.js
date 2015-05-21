Ext.define('Eway.model.goods.Classify',{

	extend : 'Ext.data.Model',
	idProperty : 'id',
	fields : ['id','name','remark','status'],

	proxy : {
		type : 'rest',
		url : 'api/admin/goods/classify',

		reader : {
			type : 'json',
			root : 'data'
		},
		wirter : {
			type : 'json'
		}
	}
});