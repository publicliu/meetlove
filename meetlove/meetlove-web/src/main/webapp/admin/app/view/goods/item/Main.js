Ext.define('Eway.view.goods.item.Main',{

	alias : 'widget.goods_item_main',
	extend : 'Eway.view.base.Panel',

	requires : [
		'Eway.view.goods.item.FilterForm',
		'Eway.view.goods.item.ItemGrid',
		'Eway.view.goods.classify.ClassifyTree'
	],

	initComponent : function(){
		Ext.apply(this,{
			title : '商品管理',
			layout : 'border',
			margin : '0',
			items : [{
				region : 'west',
				xtype : 'goods_classify_classifytree',
				width : 200
			},{
				region : 'center',
				layout : 'border',
				title : '商品管理',
				items : [{
					region : 'north',
					height : 100,
					xtype : 'goods_item_filterform'
				},{
					region : 'center',
					xtype : 'goods_item_itemgrid'
				}]
			}]
		});
		this.callParent(arguments);
	}


});