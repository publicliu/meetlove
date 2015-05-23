Ext.define('Eway.view.goods.item.Update', {
	extend: 'Ext.window.Window',
	alias: 'widget.goods_item_update',

	title: '修改商品信息',
	modal: true,
	resizable: false,
	constrainHeader: true,
	layout: 'fit',
	width: 300,
	height: 250,
	initComponent: function() {
		var statusStore = Ext.create('Eway.store.goods.GoodsStatus');
		Ext.apply(this, {
			items :[ {
				xtype: 'form',
				bodyStyle : 'padding: 10px 10px 10px 10px',
        		height: 80,
				defaults: {
					labelWidth: 60,
					labelAlign: 'right',
					msgTarget : 'side',
					anchor: '100%'
				},
				items: [{
					xtype : 'textfield',
					fieldLabel : 'ID',
					name : 'id',
					readOnly : true
				},{
					xtype : 'textfield',
					fieldLabel : '分类名称',
					name : 'name'
				},{
					xtype : 'textfield',
					fieldLabel : '分类描述',
					name : 'remark'
				},{
					xtype : 'combobox',
					fieldLabel : '分类状态',
					name : 'status',
					displayField : 'name',
					queryMode: 'local',
					store : statusStore,
					valueField : 'status'
				}]
			}],
			buttonAlign : 'center',
			buttons: [{
					text: '确认',
					//iconCls :'sureBtn',
					action: 'confirm'
				}, {
					text: '取消',
					//iconCls :'returnBtn',
					handler: this.onOver
			}]
		});

		this.callParent(arguments);
	},

	onOver: function() {
		this.up('window').close();
	}
});