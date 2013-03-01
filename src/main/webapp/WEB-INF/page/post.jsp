<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>文章</title>
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<meta content="text/html; charset=UTF-8" http-equiv=Content-Type>
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
				<h1>${post.title}</h1>
				<div><span>作者：<a href="#">我</a>&nbsp;&nbsp;&nbsp;发布时间：&nbsp;DECEMBER&nbsp;1,&nbsp;2012&nbsp;&nbsp;分类：&nbsp;<a href="#">散文</a> &nbsp;暂无评论</span></div>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
					<article class="span8">
						${post.content}
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

							</ul>
						</section>
						<section>
							<h3>友情链接</h3>
							<ul>
								<li><a href="javascript:void(0)">Google.com</a></li>

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