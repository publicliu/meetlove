
Ext.define('Eway.view.system.Update', {
	extend: 'Ext.window.Window',
	alias: 'widget.system_update',

	title: '修改参数信息',
	modal: true,
	resizable: true,
	constrainHeader: true,
	layout: 'fit',
	width: 300,
	height: 250,
	initComponent: function() {
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
					fieldLabel : 'ID',
					xtype : 'textfield',
					allowBlank : false,
					name : 'id'
				},{
					fieldLabel : '参数名称',
					xtype : 'textfield',
					allowBlank : false,
					name : 'name'
				},{
					xtype : 'textfield',
					fieldLabel : '参数值',
					name : 'value'
				},{
					xtype : 'textfield',
					fieldLabel : '参数描述',
					name : 'remark'
				},{
					xtype : 'textfield',
					fieldLabel : '参数类型',
					hidden : true,
					name : 'type',
					value : 'CUSTOM'
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