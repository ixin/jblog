<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	随便显示： ${jdbc }
	<hr /> 
	<form action="msgbook.do" method="post">
		<label for="msgtitle">主题</label>
		<input type="text" id="msgtitle" name="msgtitle"><br />
		<label for="msg">内容</label>
		<textarea id="msg" name="msg" rows="20" cols="50"></textarea><hr />
		<input type="submit" value="提交">
	</form>
</body>
</html>