Ext.define('Eway.controller.goods.item.Main', {
    extend: 'Eway.controller.base.Controller',


    refs : [{
    	ref : 'ewayView',
    	selector : 'goods_item_main',
    	autoCreate : true,
    	xtype: 'goods_item_main'
    },{
		ref: 'dataview',
		selector: 'goods_item_dataview'
	}],

    views : [
    	'goods.item.Main'
    ],

    init : function(){
   		var me = this;
   		me.control({
   			'goods_item_main button[action=query]' : {
   				click : me.onQuery
   			},
   			'goods_item_main button[action=add]' : {
   				click : me.onAdd
   			},
   			'goods_item_main button[action=remove]' : {
   				click : me.onRemove
   			},
   			'goods_item_main button[action=update]' : {
   				click : me.onUpdate
   			}
   		});
    },


    onQuery : function(){
    	var tree = this.getOrgTree();
    	var view = this.getEwayView();
    	var data = this.getFilterForm().getForm().getValues();
		var store = this.getGrid().getStore();
		store.setUrlParamsByObject(data);
		var treeRecord = tree.getSelectionModel().getLastSelected();
		store.setBaseParam('orgCode',treeRecord.data.id);
		store.loadPage(1);
    },

    onAdd : function(){
    	var addWin = Ext.create('Eway.view.goods.item.Add');
    	var form = addWin.down('form');
    	this.addWin = addWin;
    	addWin.down('button[action="confirm"]').on('click',this.onAddWinConfirm,this);
    	addWin.show();
    },

    onRemove : function(){
    	var me = this;
    	var grid = this.getGrid();
    	var store = grid.getStore();
    	var sm = grid.getSelectionModel();
    	var count = sm.getCount();
    	if(count == 0){
			Ext.Msg.alert("提示", "请选择您要删除的记录.");
			return;
		}
		else if(count > 1){
			Ext.Msg.alert("提示", "只能选择一条记录删除.");
			return;
		}
		Ext.MessageBox.confirm("请确认", "是否删除该记录?",function(button,text){
			if(button == 'yes'){

				var record = sm.getLastSelected();
				store.remove(record);
				store.sync({
					success : function(batch){
						var operation = batch.operations[batch.current];
						var response = Ext.JSON.decode(operation.response.responseText);
						if(response.success){
							Ext.Msg.alert("提示", "删除成功");
//							me.onQuery();
						}
						else {
							store.rejectChanges();
							Ext.Msg.alert("提示", "删除失败");
						}
					},
					failure : function(){
						store.rejectChanges();
						Ext.Msg.alert("提示", "删除失败");
					}
				});
			}
		});
    },

	onUpdate: function() {
		var grid = this.getGrid();
		var sm = grid.getSelectionModel();
		var flag = true;
		if(sm.getCount() == 1) {
			var win = Ext.create('Eway.view.goods.item.Update');
			var record = sm.getLastSelected();
			var form = win.down('form').getForm();
			form.loadRecord(record);
			/*form.setValues({
	    		orgName : treeRecord.data.text,
	    		orgCode : treeRecord.data.id
	    	});*/
			this.updateWin = win;
	    	win.down('button[action="confirm"]').on('click',this.onUpdateWinConfirm,this);
			win.show();
		}else {
			Ext.Msg.alert("提示", "请选择您要更改的记录.");
		}
	},

    onAddWinConfirm: function() {
    	var me = this;
		var ewayView = this.getEwayView();
		var win = this.addWin;
		var form = win.down('form').getForm();
		if(form.isValid()){

			form.submit({
				url : 'api/admin/goods/item/uploadResource',
				waitMsg : '正在上传资源',
				success : function(form,action){
					var response = Ext.decode(action.response.responseText);
					form.setValues({
						'resourceName' : response.data
					});

					var data = form.getValues();
					var record = Ext.ModelManager.create(data, 'Eway.model.goods.Item');
					var store = me.getDataview().getComponent('itemDataviewId').getStore();
					store.add(record);
					store.sync({
						success : function(){
							Ext.MessageBox.alert('提示','新增分类信息成功');
							win.close();
						},
						failure : function(){
							store.rejectChanges();
							Ext.MessageBox.alert('提示','新增分类信息失败');
						}

					});
				},
				failure : function(){
					Ext.MessageBox.alert('提示','失败');
				},
				scope : me
			});
		}
	},

	onUpdateWinConfirm: function() {
		var me = this;
		var win = me.updateWin;
		var updateForm = win.down('form');
		var store = this.getGrid().getStore();
		var form = updateForm.getForm();
		if(form.isValid()){
			form.updateRecord(form.getRecord());
			store.sync({
				success : function(batch){
					var operation = batch.operations[batch.current];
					var response = Ext.JSON.decode(operation.response.responseText);
					if(response.success){
						Ext.Msg.alert("提示", "修改成功");
						win.close();
					}
					else {
						store.rejectChanges();
						Ext.Msg.alert("提示", response.errorMsg);
					}
				},
				failure : function(batch,object){
					store.rejectChanges();
					Ext.Msg.alert("提示", "修改失败");
				}
			});
		}
	}
});
