<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.lw.meetlove.web.util.UserSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ICE综合管理平台</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

  <link rel="shortcut icon" type="image/ico" href="resources/admin/images/logo.ico" />

  <link rel="stylesheet" type="text/css" href="lib/extjs/packages/ext-theme-classic/build/resources/ext-theme-classic-all.css" media="all" />
  <link rel="stylesheet" type="text/css" href="resources/admin/css/meetlove-base.css" media="all" />
  <link rel="stylesheet" type="text/css" href="resources/admin/css/data-view.css" media="all" />
  <script type="text/javascript" src="lib/extjs/ext-all-debug.js"></script>
  <script type="text/javascript" src="lib/extjs/locale/ext-lang-zh_CN.js"></script>

  <script type="text/javascript">

  var EwayUserObject = function(id,code,name,orgId,orgName,orgCode){
		var me = this;
		this.id = id;
		this.code = code;
		this.name = name;
		this.orgId = orgId;
		this.orgName = orgName;
		this.orgCode = orgCode;
		return {
			getId : function(){
				return me.id;
			},
			getCode : function(){
				return me.code;
			},
			getName : function(){
				return me.name;
			},
			getOrgId : function(){
				return me.orgId;
			},
			getOrgName : function(){
				return me.orgName;
			},
			getOrgCode : function(){
				return me.orgCode;
			}
		}
	}
  <% if(session.getAttribute("SESSION_USER")==null){%>
	window.location.href="login.html";
<%}else{
	UserSession userSession = (UserSession)session.getAttribute("SESSION_USER");%>
	var ewayUser = new EwayUserObject(
	'<%=userSession.getUserId()%>',
	'<%=userSession.getUserCode()%>',
	'<%=userSession.getUserName()%>',
	'<%=userSession.getOrgId()%>',
	'<%=userSession.getOrgName()%>',
	'<%=userSession.getOrgCode()%>');
<%}%>


  	Ext.BLANK_IMAGE_URL = 'resources/admin/images/s.gif';
  	Ext.Loader.setConfig({
  		/* disableCaching: false,*/
  		enabled:true,
        paths: {
             'Ext.ux': 'lib/extjs/ux'
        }
      });
  	Ext.cxtPath = '<%=request.getContextPath()%>';
  </script>
  <script type="text/javascript" src="admin/app.js"></script>
  </head>

<bodys>
<div id="loading"><span class="title">正在加载中...</span><span class="logo"></span></div>
<iframe id="downloadFileFromWeb" style="display:none"></iframe>
</body>
</html>