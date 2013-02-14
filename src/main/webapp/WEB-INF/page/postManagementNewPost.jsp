<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:set var="pageName" value="postManagementNewPost" />
<div id="${pageName}NewPost">
<form action="#">
	<div class="${pageName}suojin" id="${pageName}tip">编写新文章</div>
	<input class="${pageName}suojin" type="text" id="title" id="title" title="此处键入标题" autocomplete="off" style="width:500px;margin-bottom:12px;"/>
	<a id="${pageName}changeOption" href="javascript:;" onclick="return false;" >更多选项...</a>
	<div id="${pageName}options" class="${pageName}suojin" style="display:none;">
		<input type="text" /><a href="#" class="easyui-linkbutton" onclick="javascript:void(0);">更改1</a><br />
		<input type="text" /><a href="#" class="easyui-linkbutton" onclick="javascript:void(0);">更改2</a><br /><br />
	</div>
	<div id="${pageName}post" class="${pageName}suojin">
		<textarea id="postContent" name="postContent" style="width:97%;height:400px;"></textarea><br />
		<a href="#" class="easyui-linkbutton" onclick="javascript:void(0);">保存为草稿</a>
		<a href="#" class="easyui-linkbutton" onclick="javascript:void(0);">发布</a>
	</div>
	<br />
</form>
</div>
<style>
.ke-content {font-size: 12px;background-color: #ffffff;}
.ke-content table {border-collapse:collapse;}
.red {color: white;background-color: red;}
.green {color: white;background-color: green;}
.yellow {color: white;background-color: yellow;}
/* #${pageName}NewPost{background-color:#EEF5FF;} */
.${pageName}suojin{margin-left:30px;}
#${pageName}tip{height:50px;line-height:50px;color:#0E2D5F;font-size:medium;font-weight:bold;}
#${pageName}changeOption{margin-left:10px;}
</style>
<script type="text/javascript">
$(function() {
	var editor = KindEditor.create('textarea[name="postContent"]', {
		resizeType : 1,
		allowPreviewEmoticons : false,
		allowImageUpload : false,
		items : [
			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
			'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
			'insertunorderedlist', '|', 'emoticons', 'image', 'link']
	});
	
	
	$("#${pageName}changeOption").click(function(){
		$("#${pageName}options").slideToggle();
		if($("#${pageName}changeOption").html() == '更多选项...'){
			$("#${pageName}changeOption").html('收起更多');
		}else {
			$("#${pageName}changeOption").html('更多选项...');
		}
	});
});
</script>