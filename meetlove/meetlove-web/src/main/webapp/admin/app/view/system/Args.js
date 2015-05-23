Ext.define('Eway.view.system.Args',{

	alias : 'widget.system_args',
	extend : 'Eway.view.base.Panel',

	requires : [
	     'Eway.view.system.ArgsGrid'
	],


	initComponent : function(){
		Ext.apply(this,{
			title : '参数配置',
			layout : 'border',
			margin : '0',
			items : [{
				region : 'center',
				title : '参数配置',
				xtype : 'system_argsgrid'
			}]
		});
		this.callParent(arguments);
	}


});