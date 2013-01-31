<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:set var="pageName" value="userManagementList" />
<table id="${pageName }datagrid" toolbar="#${pageName }toolbar"></table>
<div id="${pageName }toolbar"
	style="background:url(${ctxPath}/styles/themes/default/images/bg.gif) top repeat-x #d9ebfb;">
	<span style="margin-left:20px;margin-right:4px;">用户名：</span><input
		id="${pageName }username" class="combo-textl" maxlength="18"
		style="border:1px solid #A4BED4;width:150px;" />
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
		onclick="${pageName }reloadDataGridWithSearchValue();">查询</a>
</div>
<script type="text/javascript">
// http://www.phptogether.com/juidoc/datagrid.html
$(document).ready(function(){
	var district;
    $("#${pageName}datagrid").datagrid({
		nowrap: false,
		striped: true,
		fit: true,
		pagination: true,
		rownumbers: true,
		fitColumns: true,
		loadMsg: "正在加载，请稍候...",
		singleSelect: true,
		url: "#",
		loadFilter: function(data){
			var n = eval(data);
			district = n.district;
			return data;
		},
		columns:[[
			{field:"username",title:"用户名",align:"center",width:100},
			{field:"nickname",title:"昵称",align:"center",width:100},
			{field:"email",title:"电子邮件",align:"center",width:100},
			{field:"role",title:"角色",align:"center",width:100},
			{field:"post",title:"文章",align:"center",width:100},
			{field:"id",title:"操作",align:"center",width:150,
				formatter: function(value,rowData,rowIndex){
					return "<a href='#?sid=" + value + "' onclick='javascript:openWindow(this);return false;' windowtitle='查看' dataoption='{top:100}' ><span style='color:#03C;'>查看</span></a>";
				}
			}
		]],
		sortName: "role",
		sortOrder: "desc",
		idField: "id",
		pageSize: 30,
		onLoadSuccess: function() {
		    $("span.datagrid-sort-icon").each(function(){
		        if ("&nbsp;" == $(this).html()) {
		            $(this).html("");
		        }
		    });
		    $(this).prev().prev().css("background-color", "#F7FAFD");
		    $(this).prev().css("background-color", "#F7FAFD");
	        var datagridbody = $(this).prev().children(".datagrid-body");
		    if (0 == $("#${pageName}datagrid").datagrid("getData").total) {
			    $(datagridbody).css("color", "#808080");
			    $(datagridbody).css("text-align", "center");
			    $(datagridbody).html("<table style='width:100%;height:100%;'><tr><td style='border:none;'>没有可以显示的数据</td></tr></table>");
    		} else {
    		    $(datagridbody).css("color", "black");
			    $(datagridbody).css("text-align", "");
    		}
		}
    });
    $("#${pageName}datagrid").datagrid("getPager").pagination({
        showPageList: false,
        beforePageText: "第",
        afterPageText: "页，共{pages}页",
        displayMsg: "显示 {from} 到 {to} 条记录，共 {total} 条记录"
    });
    
    $(".combo-textl").keydown(function(event){
    	if(event.keyCode==13){
    		${pageName }reloadDataGridWithSearchValue();
    	}
    });
});
function ${pageName }reloadDataGridWithSearchValue() {
	$("#${pageName}datagrid").datagrid("load",{
            corpName: $("#${pageName}username").val()
    });
} 

function forDelUser(delid, username){ 
	$.messager.confirm("提示","确认删除[" + username + "]吗？",function(event){
		if(event){
			$.ajax({
				url: '#',
				type: 'GET',
				data: 'delid='+delid,
				timeout: 20000,
				success: function(data, textStatus){
					if(textStatus == 'success'){
						if(data == 'success'){
							${pageName}reloadDataGridWithSearchValue();
						}else {
							showMsg("操作失败，请重试或联系系统管理员！");
						}
					}
				},
				error: function(){
			    	showMsg("发生错误，请重试或联系系统管理员！");
            	}
			});
			return false;
		}
	}); 
}
function showMsg(msg){
	$.messager.alert("提示",msg);
}

function forUnlockUser(unlockid, username){
	$.messager.confirm("提示","确认要解锁[" + username + "]吗？",function(event){
		if(event){
			$.ajax({
				url: '#',
				type: 'GET',
				data: 'unlockid='+unlockid,
				timeout: 20000,
				success: function(data, textStatus){
					if(textStatus == 'success'){
						if(data == 'success'){
							${pageName}reloadDataGridWithSearchValue();
						}else {
							showMsg("操作失败，请重试或联系系统管理员！");
						}
					}
				},
				error: function(){
			    	showMsg("发生错误，请重试或联系系统管理员！");
            	}
			});
			return false;
		}
	}); 
}
</script>