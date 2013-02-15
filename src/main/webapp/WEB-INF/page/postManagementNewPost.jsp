<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:set var="pageName" value="postManagementPost" />
<div id="${pageName}NewPost">
<form action="#" method="post" id="${pageName}form">
	<div class="${pageName}suojin" id="${pageName}tip">编写新文章</div>
	<input class="${pageName}suojin" type="text" id="title" name="title" title="此处键入标题" autocomplete="off" style="width:500px;margin-bottom:12px;"/>
	<a id="${pageName}changeOption" href="javascript:;" onclick="return false;" >更多选项...</a>
	<div id="${pageName}options" class="${pageName}suojin" style="display:none;">
		<input type="text" /><a href="#" class="easyui-linkbutton" onclick="javascript:void(0);return false;">更改1</a><br />
		<input type="text" /><a href="#" class="easyui-linkbutton" onclick="javascript:void(0);return false;">更改2</a><br /><br />
	</div>
	<div id="${pageName}post" class="${pageName}suojin">
		<textarea id="postContent" name="postContent" style="width:97%;height:400px;visibility:hidden;"></textarea><br />
		<a href="postManagementNewPost.do?type=draft" class="easyui-linkbutton" onclick="javascript:savePost(this);return false;">保存为草稿</a>
		<a href="postManagementNewPost.do?type=publish" class="easyui-linkbutton" onclick="javascript:savePost(this);return false;">发布</a>
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
.${pageName}suojin{margin-left:30px;}
#${pageName}tip{height:50px;line-height:50px;color:#0E2D5F;font-size:medium;font-weight:bold;}
#${pageName}changeOption{margin-left:10px;}
</style>
<script type="text/javascript">
var editor;
$(function() {
	editor = KindEditor.create('textarea[name="postContent"]', {
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

function savePost(o){
	editor.sync();
	var url = $(o).attr("href");
	$.ajax({
		url: url,
		type: 'POST',
		data: $("#${pageName}form").serialize(),
		timeout: 20000,
		success: function(data, textStatus){
			if(textStatus == 'success'){
				if(data == 'success'){
					showMsg('成功');
				}else {
					showMsg('似乎文章出了问题');
				}
				
			}
		},
		error: function(){
	    	showMsg("发生错误，请重试或联系系统管理员！");
    	}
	});
	return false;
}
</script>