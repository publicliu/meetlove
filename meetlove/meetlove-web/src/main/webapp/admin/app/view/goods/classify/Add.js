Ext.define('Eway.view.goods.classify.Add', {
	extend: 'Ext.window.Window',
	alias: 'widget.goods_classify_add',

	title: '增加商品分类信息',
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
					fieldLabel : '<font color="red">*</font>分类名称',
					allowBlank : false,
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
					valueField : 'status',
					typeAhead: true,
			        forceSelection: true,
			        autoSelect : true
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