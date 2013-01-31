<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>New Document</title>
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<META content="text/html; charset=UTF-8" http-equiv=Content-Type>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="style/front/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="style/front/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="style/front/style.css" rel="stylesheet">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">小辛博客</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="#">首页</a></li>
						<li><a href="#about">关于</a></li>
						<li><a href="#contact">联系我</a></li>
					</ul>
					<ul class="nav pull-right">
						<c:choose>
							<c:when test="${empty sessionScope.u}">
								<li><a href="#" data-toggle="modal" data-target="#myLoginModal">登录</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="admin/frameMain.html" class="hidden-phone visible-tablet visible-desktop" >设置</a></li>
								<li id="fat-menu" class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-user"></i><sec:authentication property="name"/><i class="icon-caret-down"></i></a>
									<ul class="dropdown-menu">
										<li><a tabindex="-1" href="admin/frameMain.html">我的账户</a></li>
										<li class="divider"></li>
										<li><a tabindex="-1" class="visible-phone" href="admin/frameMain.html">设置</a></li>
										<li class="divider visible-phone"></li>
										<li><a tabindex="-1" href="j_spring_security_logout">注销</a></li> 
									</ul>
								</li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- end top -->
	<div class="container">
		<div class="content">
			<div class="page-header">
				<h1>梦里桃花，伞下江南</h1>
				<div><span>作者：<a href="#">我</a>&nbsp;&nbsp;&nbsp;发布时间：&nbsp;DECEMBER&nbsp;1,&nbsp;2012&nbsp;&nbsp;分类：&nbsp;<a href="#">散文</a> &nbsp;暂无评论</span></div>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
					<article class="span8">
						<p>梦里的江南，春江水暖的时候，桃花又上了枝头，古铜色的枝干上，探出了鹅黄色的花蕾，象一颗颗小青豆缀在枝条上。不几天，便是一树纷白娇红，错落的开在江边，把沿江的柳条映得翠绿起来，风过的时候，有一片两片的花瓣飘落下来，静静的浮在水面上，随波逐流，一脉水分两岸香，一群鸭嘎嘎的游过，漪涟荡开去，平静的花影随一江春水漂散开。记忆里，我着一袭美丽的衣裳，坐在江南的岸边，立于琴前，为你弹奏一曲，哀怨缠绵的情歌，多么希望，这琴声能传入你的耳里，缓缓流淌的动人旋律，是我对你无限的爱念，仅仅希望，你能展现一瞬的笑颜。着一袭白衣，立于桃花林中，湖畔弥漫着江南烟雨，微风吹起片片桃花，幻化蝶雨。雨漫漫，蝶漫漫，琴声漫漫。你走来，带着迷人的微笑，你唇角的笑容，成为了这个季节最美丽的风景，那一刻，我便爱上了江南，爱上了你。</p>
						<p>桃之夭夭，烁烁其华，今日与你身旁，读着这样美丽的诗句，你说，若是能娶得诗中的女子，该是怎样的一种幸运，我笑，一如既往的微笑。许是如此，我不是你梦中带着花香的女子，我只是北方，立于花下，遥遥等待的那个痴人儿，不懂得欣赏诗词歌赋，少了江南女子的灵秀，普通的不曾引起你的注意。虽如此，依然想为你写下些什么，写着北方的春天吗？写这满树的桃花吗？那一树树粉红色的桃花，可是我等待娇羞的容颜？可是我妩媚的双眼，可是我遥遥的期盼？在你梦中，可会出现如我这般普通的女子？守着一世的盼望，痴痴立于彼岸，遥望着江南的满目葱绿，遥望着那个属于你的繁华季节，你可曾梦到，有这样一个平凡的女子，夜夜为你落泪，为你守望。</p>
						<p>美丽的花期总是非常的短暂，为了等待你匆匆的脚步，我已经耗尽了生命，不是没有花期，我只有一次忠贞的美丽。在于你相逢的那一刻，注定了此生只为你开放，在你的怀里，颤抖着枝叶，把最美的容颜交与你，低头沉醉在你的拥抱里，醉了整个春天。携一支玉笛，在寂静的深夜奏出绝美的音乐；咏一段旋律，在孤独的心灵唱出动人的歌声。如天籁般使人消魂，让人流连忘返。淡然的紫色，为何如此瑰丽柔和？沉睡的人儿，在梦中，可曾听见我轻轻的呼唤？可曾感受到我颤抖的双手，正抚过你沧桑的容颜！我爱的人啊！为了在最美的时候遇见你，我已经等待了整个寒冷的冬天，在三月的雪中，迎着寒风，傲然的展示着自己的美丽，你会为了我停留下你漂泊的脚步吗？会为了我舍弃江南的秀丽，守候着苍凉的北方吗？你看，你看，这满树的桃花开了，片片飘落的花瓣，都是我对你不变的思念，花瓣落于你的眉间，落于你温暖的掌心，顺着你的掌纹，轻轻滑落。</p>
						<p>——《桃花开了》</p>
						<hr />
						<ul class="pager">
							<li class="previous"><a href="#">&larr; Older</a></li>
							<li class="next"><a href="#">Newer &rarr;</a></li>
						</ul>
					</article>
					<aside class="span4">
						<section>
							<h3>热门文章</h3>
							<ul>
								<li><a href="javascript:void(0)">梦里桃花，伞下江南</a></li>
								<li><a href="javascript:void(0)">为了等待你匆匆的脚步，我已经耗尽了生命，</a></li>
								<li><a href="javascript:void(0)">该是怎样的一种幸运，我笑</a></li>
								<li><a href="javascript:void(0)">在于你相逢的那一刻，注定了此生只为你开放</a></li>
								<li><a href="javascript:void(0)">桃之夭夭，烁烁其华</a></li>
								<li><a href="javascript:void(0)">不懂得欣赏诗词歌赋，少了江南女子的灵秀</a></li>
								<li><a href="javascript:void(0)">在寂静的深夜奏出绝美的音乐</a></li>
								<li><a href="javascript:void(0)">为何如此瑰丽柔和？</a></li>
								<li><a href="javascript:void(0)">为了在最美的时候遇见你</a></li>
								<li><a href="javascript:void(0)">片片飘落的花瓣，都是我对你不变的思念</a></li>
							</ul>
						</section>
						<section>
							<h3>友情链接</h3>
							<ul>
								<li><a href="javascript:void(0)">Google.com</a></li>
								<li><a href="javascript:void(0)">萌糖燃糖</a></li>
								<li><a href="javascript:void(0)">糯米团团</a></li>
								<li><a href="javascript:void(0)">木瓜博客</a></li>
								<li><a href="javascript:void(0)">ilovejava.net</a></li>
								<li><a href="javascript:void(0)">游鱼技术站</a></li>
								<li><a href="javascript:void(0)">简单生活</a></li>
							</ul>
						</section>
					</aside>
				</div>
			</div>
		</div>
		<footer>
			<p>
				© <a href="https://github.com/ixin/jblog">JBLOG</a>
				2013  由 <a href="http://ixin.me">ixin.me</a> and <a href="http://meido.mx">meido.mx</a> 提供.
			</p>
		</footer>
	</div>
	<!-- 登录Modal -->
	<div id="myLoginModal" class="modal hide fade" tabindex="-1" >
  		<div class="modal-body">
	    	<form class="form-signin" method="post" action="j_spring_security_check">
        		<h2 class="form-signin-heading">请登录</h2>
        		<input type="text" class="input-block-level" placeholder="Username" name="j_username">
        		<input type="password" class="input-block-level" placeholder="Password" name="j_password">
        		<label class="checkbox">
          			<input type="checkbox" value="remember-me"> 记住我
        		</label>
        		<button class="btn btn-large btn-primary" type="submit">登录</button>
      		</form>
  		</div>
	</div>
	<script src="script/jquery-1.8.0.min.js"></script>
    <script src="script/front/js/bootstrap.min.js"></script>
</body>
</html>