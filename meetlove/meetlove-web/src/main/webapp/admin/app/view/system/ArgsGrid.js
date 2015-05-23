Ext.define('Eway.view.system.ArgsGrid',{

	extend : 'Ext.grid.GridPanel',
	alias : 'widget.system_argsgrid',

	initComponent : function(){
		var store = Ext.create('Eway.store.system.Args');
		store.loadPage(1);

		Ext.apply(this,{
			tbar : ['->',{
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
				header : '参数名称',
				dataIndex : 'name',
				flex : 1
			},{
				header : '参数值',
				dataIndex : 'value',
				flex : 1
			},{
				header : '描述',
				dataIndex : 'remark',
				flex : 1
			},{
				header : '参数类型',
				dataIndex : 'type',
				flex : 1
			}]
		});


		this.callParent(arguments);
	}


});