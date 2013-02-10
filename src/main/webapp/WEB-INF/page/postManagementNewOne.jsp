<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:set var="pageName" value="postManagementNewOne" />
<script>
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="${pageName}content"]', {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			items : [
			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline','removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
			'insertunorderedlist', '|', 'emoticons', 'image', 'link']
		});
	});
</script>
<div id="${pageName}NewPost">
	<form>
		<p>编辑文章题目</p>
		<input type="text" /><br />
		<textarea name="${pageName}content" style="width:700px;height:200px;visibility:hidden;"></textarea>
		<a href="#"  class="easyui-linkbutton" onclick="javascript:return false;">保存文章</a>
	</form>
</div>
