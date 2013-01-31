<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>登陆</title>
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
	
	<div class="container">
	<c:if test="${param.error=='true'}">
		<div class="alert alert-error">
  			<button type="button" class="close" data-dismiss="alert">&times;</button>
  			<strong>警告!</strong>&nbsp;&nbsp;貌似是用户名或密码不正确~请重试!
		</div>
	</c:if>
      <form class="form-signin" action="j_spring_security_check" method="post">
        <h2 class="form-signin-heading">请登录</h2>
        <input type="text" class="input-block-level" placeholder="Username" name="j_username">
        <input type="password" class="input-block-level" placeholder="Password" name="j_password">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> 记住我
        </label>
        <button class="btn btn-large btn-primary" type="submit">登录</button>
      </form>

    </div> <!-- /container -->
	<script src="script/jquery-1.8.0.min.js"></script>
    <script src="script/front/js/bootstrap.min.js"></script>
</body>
</html>