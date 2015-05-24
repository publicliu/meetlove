Ext.define('Eway.view.goods.item.DataView',{

	extend : 'Ext.panel.Panel',
	alias : 'widget.goods_item_dataview',

	initComponent : function(){
		var store = Ext.create('Eway.store.goods.Item');
		store.load();
		Ext.apply(this,{
			id: 'images-view',
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
			items : Ext.create('Ext.view.View',{
				itemId : 'itemDataviewId',
				store : store,
				tpl : [
				    '<tpl for=".">',
	                    '<div class="thumb-wrap" id="{name}">',
	                    '<div class="thumb"><img src="api/admin/goods/item/resource/{resourceName}" title="{name}"></div>',
	                    '<span class="x-editable">{name}</span></div>',
	                '</tpl>',
	                '<div class="x-clear"></div>'
	             ],
	             height: 310,
	             trackOver: true,
	             overItemCls: 'x-item-over',
	             itemSelector: 'div.thumb-wrap',
	             emptyText: 'No images to display',
	             prepareData: function(data) {
	                 Ext.apply(data, {
	                     shortName: Ext.util.Format.ellipsis(data.name, 15),
	                     sizeString: Ext.util.Format.fileSize(data.size),
	                     dateString: Ext.util.Format.date(data.lastmod, "m/d/Y g:i a")
	                 });
	                 return data;
	             }
			})

		});
		this.callParent(arguments);
	}

});