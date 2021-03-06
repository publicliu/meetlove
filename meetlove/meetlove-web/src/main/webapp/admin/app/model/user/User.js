Ext.define('Eway.model.user.User',{

	extend : 'Ext.data.Model',
	idProperty : 'id',
	fields : ['id','code','name','mobile','phone','email'],

	proxy : {
		type : 'rest',
		url : 'api/admin/user',

		reader : {
			type : 'json',
			root : 'data'
		},
		wirter : {
			type : 'json'
		}
	}
});