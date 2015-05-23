Ext.define('Eway.store.goods.ClassifyTree', {
	extend: 'Ext.data.TreeStore',
	requires : 'Eway.model.goods.ClassifyTree',
	model : 'Eway.model.goods.ClassifyTree',

	root: {
		id: -1,
		text: '所有分类',
		expanded: true
	},

    proxy: {
        type: 'ajax',
        url : 'api/admin/goods/classify/tree',
	    reader: {
	        type: 'json',
	        root: 'data'
	    }
    },
    autoLoad: false
});