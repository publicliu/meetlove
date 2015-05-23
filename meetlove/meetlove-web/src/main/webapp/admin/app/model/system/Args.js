Ext.define('Eway.model.system.Args',{

	extend : 'Ext.data.Model',
	idProperty : 'id',
	fields : ['id','name','value','remark','type'],

	proxy : {
		type : 'rest',
		url : 'api/admin/systemargs',

		reader : {
			type : 'json',
			root : 'data'
		},
		wirter : {
			type : 'json'
		}
	}
});