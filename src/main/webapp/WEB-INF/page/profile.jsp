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
				</a> <a class="brand" href="${cxtPath}">小辛博客</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="${cxtPath}">首页</a></li>
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
			<div class="container-fluid">
				<div class="row-fluid" style="margin-top: 10px;">
					<article class="span8">
					<c:forEach var="post" items="${posts}">
						<div class="post-list">
							<a href="p.do?id=${post.id}" class="profile-title" >${post.title}</a>
							<div><span>作者：<a href="#">${post.own}</a>&nbsp;&nbsp;&nbsp;发布时间：&nbsp;${post.time}&nbsp;&nbsp;分类：&nbsp;<a href="#">默认</a> &nbsp;&nbsp;评论:暂无</span></div>
						</div>
						<br />
						<div>${post.content}</div>
						<br />
						<hr />
					</c:forEach>
						<ul class="pager">
							<li class="previous"><a href="#">&larr; Older</a></li>
							<li class="next"><a href="#">Newer &rarr;</a></li>
						</ul>
					</article>
					<aside class="span4" style="margin-top:25px;">
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
				2013  由 <a href="http://ixin.me">ixin.me</a> & <a href="http://meido.mx">meido.mx</a> 提供.
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