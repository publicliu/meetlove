Ext.application({
    name: 'Eway',
    appFolder: 'admin/app',

    controllers : [
    	'Main'
    ],

	autoCreateViewport : true,

    launch: function() {
    	Ext.get('loading').destroy();
       /* Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
                {
                    xtype: 'panel',
                    title: 'Users',
                    html : 'List of users will go here'
                }
            ]
        });*/
    }

});