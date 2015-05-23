Ext.define('Eway.view.goods.classify.ClassifyTree',{

	alias : 'widget.goods_classify_classifytree',
	extend : 'Ext.tree.Panel',

	initComponent : function(){
		var store = Ext.create('Eway.store.goods.ClassifyTree');
		Ext.apply(this,{
			border : true,
			title : '所有分类',
			rootVisible : true,
			store : store,
			lines : true
		});
		this.callParent(arguments);
	}



});