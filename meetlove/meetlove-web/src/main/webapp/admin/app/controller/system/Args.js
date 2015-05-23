Ext.define('Eway.controller.system.Args', {
    extend: 'Eway.controller.base.Controller',


    refs : [{
    	ref : 'ewayView',
    	selector : 'system_args',
    	autoCreate : true,
    	xtype: 'system_args'
    },{
		ref: 'grid',
		selector: 'system_argsgrid'
	}],

    views : [
    	'system.Args'
    ],

    init : function(){
   		var me = this;
   		me.control({
   			'system_args button[action=add]' : {
   				click : me.onAdd
   			},
   			'system_args button[action=remove]' : {
   				click : me.onRemove
   			},
   			'system_args button[action=update]' : {
   				click : me.onUpdate
   			}
   		});
    },



    onAdd : function(){
    	var addWin = Ext.create('Eway.view.system.Add');
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
			var win = Ext.create('Eway.view.system.Update');
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
		data = win.down('form').getForm().getValues();
		var record = Ext.ModelManager.create(data, 'Eway.model.system.Args');
		if(win.down('form').getForm().isValid()){
			var store = me.getGrid().getStore();
			store.add(record);
			store.sync({
				success : function(){
					Ext.MessageBox.alert('提示','新增参数信息成功');
					win.close();
				},
				failure : function(){
					store.rejectChanges();
					Ext.MessageBox.alert('提示','新增参数信息失败');
				}

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
