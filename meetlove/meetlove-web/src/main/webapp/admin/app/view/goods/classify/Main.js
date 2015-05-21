Ext.define('Eway.view.goods.classify.Main',{

	alias : 'widget.goods_classify_main',
	extend : 'Eway.view.base.Panel',

	requires : [
		'Eway.view.goods.classify.FilterForm',
		'Eway.view.goods.classify.ClassifyGrid'
	],

	initComponent : function(){
		Ext.apply(this,{
			title : '类别管理',
			layout : 'border',
			margin : '0',
			items : [{
				region : 'center',
				layout : 'border',
				title : '类别管理',
				items : [{
					region : 'north',
					height : 100,
					xtype : 'goods_classify_filterform'
				},{
					region : 'center',
					xtype : 'goods_classify_classifygrid'
				}]
			}]
		});
		this.callParent(arguments);
	}


});