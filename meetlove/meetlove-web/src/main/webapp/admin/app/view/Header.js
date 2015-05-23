Ext.define('Eway.view.Header',{
	alias : 'widget.appHeader',
	extend : 'Ext.panel.Panel',
	layout : 'fit',
	html:'<div class="appHeader">' +
			'<span style="position: absolute;left: 10px;font-size:30px;">遇见爱管理平台</span>' +
			'<span><img src="'+Ext.cxtPath+'/resources/admin/images/banner_bg.png"  width="100%"/></span>' +
			'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
		 '</div>',
	 bbar: [{
	 	xtype : 'button',
	 	action : 'index',
	 	text: '系统首页'
     },'-',{
     	text: '人员管理',
     	menu : [{
     		action : 'person.Person',
     		text : '人员管理'
     	},{
     		action : 'user.User',
     		text : '用户管理'
     	},{
     		action : 'org.Org',
     		text : '机构管理'
     	}]
     },'-',{
     	text: '权限管理',
        menu: [{
        	action : 'role.Role',
        	text: '角色管理'
        },{
        	action : 'role.Group',
        	text : '角色组管理'
        }]
     },'-',{
     	text : '微信平台',
     	menu : [{
     		text : '遇见爱',
     		menu : [{
     			text : '参数配置',
     			action : 'app.weixin.meetlove.Args'
     		}]
     	}]
     },{
    	 text : '商品管理',
    	 menu : [{
    		 text : '类别管理',
    		 action : 'goods.classify.Main'
    	 },{
    		 text : '商品管理',
    		 action : 'goods.item.Main'
    	 }]
     },'->',{
     	text : ewayUser.getName(),
     	menu : [{
     		text : '修改密码'
     	},{
     		action : 'logout',
     		text : '退出'
     	}]
     }]
});