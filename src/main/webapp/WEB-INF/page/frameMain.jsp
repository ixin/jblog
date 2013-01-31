<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>后台管理中心</title>
	<link rel="stylesheet" type="text/css" href="../style/back/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../style/back/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../style/back/frameMain.css">
	<script type="text/javascript" src="../script/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="../script/back/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../script/back/frameMain.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" class="head" style="height:60px;padding:0;background-color:#EEF5FF;overflow:hidden;">
		<dl>
			<dt></dt>
			<dd>
				<ul>
					<li> 当前用户：<strong><sec:authentication property="name" /></strong><span>[<a title="注销登陆" class="hand" href="../j_spring_security_logout">退出</a>] [<span id="enterDc" style="padding:0px"><a title="查看首页" href="${ctxPath}" >查看首页</a></span>]</span> </li>
				</ul>
			</dd>
		</dl>
	</div>
	<div data-options="region:'west',split:true" title="<span style='color:#888888;'>导航菜单</span>" style="width:210px;padding:1px;overflow:auto;background-color:#eef5ff;">
		<div class="easyui-accordion" data-options="fit:false,border:false,animate:true">
			<div title="文章管理" data-options="" style="padding:10px;font-size:14px;">
				<ul id="tt2" class="easyui-tree topMenuUl" data-options="animate:true,dnd:false">
					<li><a href="../msgbook.html" tabtitle="添加文章" >添加文章</a></li>
					<li><a href="../msgbook.html" tabtitle="查看文章" >查看文章</a></li>
					<li>
						<span>文件夹子</span>
						<ul class="easyui-tree topMenuUl" data-options="animate:true,dnd:false">
							<li><a href="#" >子目录</a></li>
							<li><a href="#" >子目录</a></li>
							<li><a href="#" >子目录</a></li>
							<li><a href="#" >子目录</a></li>
						</ul>
					</li>
					
				</ul>
			</div>
			<div title="评论管理" data-options="" style="padding:10px;font-size:14px;">
				<ul id="tt2" class="easyui-tree topMenuUl" data-options="animate:true,dnd:false,title:'评论管理'">
					<li>添加文章</li>
					<li>查看文章</li>
				</ul>
			</div>
			<div title="用户管理" data-options="" style="padding:10px;font-size:14px;">
				<ul id="tt2" class="easyui-tree topMenuUl" data-options="animate:true,dnd:false,title:'用户管理'">
					<li><a href="userManagementList.html" tabtitle="所有用户" >所有用户</a></li>
				</ul>
			</div>
			<div title="系统设置" data-options="" style="padding:10px;font-size:14px;">
				<ul id="tt2" class="easyui-tree topMenuUl" data-options="animate:true,dnd:false,title:'系统设置'">
					<li>添加文章</li>
					<li>查看文章</li>
				</ul>
			</div>
		</div>
	</div>
	<div data-options="region:'south',border:false" style="height:25px;background:#A9FACD;padding:5px;">
		<span style="float:left;"></span>
		<span style="float:right;">meido.mx为您提供最专业的技术支持~~</span> 
	</div>
	<div data-options="region:'center'">
		<div id="mainTabs" class="easyui-tabs" data-options="fit:true,border:false">
			<div title="欢迎" style="color:#888888">
				<!-- <iframe id="Welcome" scrolling="auto" frameborder="0" style="width:100%;height:99.5%;" src="#"></iframe> -->
			</div>
		</div>
	</div>
</body>
</html>