Ext.define('Eway.view.base.ComboTree',{
	extend : 'Ext.form.field.Picker',
	alias : 'widget.base_combotree',

	fieldLabel : '',

	config : {
		hiddenValue : '',
		rootVisible : false,
		expandRoot:true,
		valueField : ''
	},

	trigger1Cls : Ext.baseCSSPrefix + "form-clear-trigger",
	trigger2Cls : Ext.baseCSSPrefix + "form-arrow-trigger",

	onTrigger1Click : function() {
		var me = this;
		me.clearValue();
	},

	clearValue : function(){
		this.setValue('');
	},

	createPicker : function(){
		var me = this;
		var treePanel = Ext.create('Ext.tree.Panel',{
			hidden : true,
			floating : true,
			minHeight : 280,
			height: 280,
			autoScroll: true,
		 	rootVisible : me.getRootVisible(),
			store : me.store,
			listeners : {
				scope : me,
				itemclick : me.onTreeItemClick
			}
		});

		return treePanel;
	},

	onTreeItemClick : function(view,record){
		var me = this;
		me.hiddenValue = record.get(me.valueField);
		me.setValue(record.get('text'));
		this.collapse();
	},


    getSubmitValue : function(){
    	var me = this;
    	return me.processRawValue(me.hiddenValue);
    }
});