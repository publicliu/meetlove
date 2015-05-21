Ext.define('Eway.view.goods.classify.ClassifyGrid',{

	extend : 'Ext.grid.GridPanel',
	alias : 'widget.goods_classify_classifygrid',

	initComponent : function(){
		var store = Ext.create('Eway.store.goods.Classify');
		store.load();

		Ext.apply(this,{
			tbar : ['->',{
				iconCls :'queryBtn',
				action: 'query',
				text : '查询'
			},{
				iconCls :'addBtn',
				action: 'add',
				text : '增加'
			},{
				iconCls :'updateBtn',
				action: 'update',
				text : '修改'
			},{
				iconCls :'deleteBtn',
				action: 'remove',
				text : '删除'
			}],
			store : store,
			columns : [{
				xtype: 'rownumberer'
			},{
				header : 'ID',
				dataIndex : 'id',
				hidden : true
			},{
				header : '类别名称',
				dataIndex : 'name',
				flex : 1
			},{
				header : '类别描述',
				dataIndex : 'remark',
				flex : 1
			},{
				header : '类别状态',
				dataIndex : 'status',
				flex : 1
			}],
			dockedItems: [{
    			xtype: 'pagingtoolbar',
    			store: store,
    			dock: 'bottom',
    			displayInfo: true
			}]
		});


		this.callParent(arguments);
	}


});