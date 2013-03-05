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
	<table>
		<tr>
			<td align="right">文章别名：</td><td><input type="text" name="alias" class="${pageName}xuanxiang" /></td>
		</tr>
		<tr>
			<td align="right">标签：</td><td><input type="text" name="tags" class="${pageName}xuanxiang" /></td>
		</tr>
		<tr>
			<td align="right">分类目录：</td>
			<td>
			<table>
				<tr>
			<c:forEach var="category" items="${categorys}" varStatus="s">
					<td><input type="checkbox" name="category"  value="${category.terms_id }">${category.terms_name }</td>
					<c:if test="${s.count%2==0}"></tr><tr></c:if>			
			</c:forEach>
				</tr>
				<tr><td colspan="2"><input type="checkbox" name="category" checked="checked" value="0">默认</td></tr>
			</table>
			</td>
		</tr>
	</table>
	<br />
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
#title{border-radius:3px 3px 3px 3px;border-width:1px;border-color:#CCCCCC;font-size:1.5em;line-height:100%;outline:medium none;padding:3px 4px;}
.${pageName}suojin{margin-left:30px;}
#${pageName}tip{height:50px;line-height:50px;color:#0E2D5F;font-size:medium;font-weight:bold;}
#${pageName}changeOption{margin-left:10px;}
.${pageName}xuanxiang{width:400px;}
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
					showMsg('操作成功');
					$("#mainTabs").tabs('close','写文章');
					openTab($('#allpost'));
				}else {
					showMsg('似乎文章出了问题,再发一遍试试吧。。。 > .<');
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