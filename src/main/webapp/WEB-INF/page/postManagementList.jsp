<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:set var="pageName" value="postManagementList" />
<table id="${pageName }datagrid" toolbar="#${pageName }toolbar"></table>
<div id="${pageName }toolbar"
	style="background:url(${ctxPath}/styles/themes/default/images/bg.gif) top repeat-x #d9ebfb;">
	<span style="margin-left:20px;margin-right:4px;">文章名：</span><input
		id="${pageName }username" class="combo-textl" maxlength="18"
		style="border:1px solid #A4BED4;width:150px;" />
	<span style="margin-left:20px;margin-right:4px;">作者：</span><input
		id="${pageName }email" class="combo-textl" maxlength="50"
		style="border:1px solid #A4BED4;width:150px;margin-right:10px;" />
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
		onclick="${pageName }reloadDataGridWithSearchValue();">查询</a>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
		onclick="return false;">写文章</a>
</div>
<script type="text/javascript">
$(document).ready(function(){
	
/* 	$.extend($.fn.datagrid.defaults.view, {
		renderRow: function(target, fields, frozen, rowIndex, rowData) {
			var opts = $.data(target, 'datagrid').options;

			var cc = [];
			if (frozen && opts.rownumbers) {
				var rownumber = rowIndex + 1;
				if (opts.pagination) {
					rownumber += (opts.pageNumber - 1) * opts.pageSize;
				}
				cc.push('<td class="datagrid-td-rownumber"><div class="datagrid-cell-rownumber">' + rownumber + '</div></td>');
			}
			for (var i = 0; i < fields.length; i++) {
				var field = fields[i];
				var col = $(target).datagrid('getColumnOption', field);
				if (col) {
					//start 处理多级数据
	                var fieldSp = field.split(".");
	                var dta = rowData[fieldSp[0]];
	                for (var j = 1; j < fieldSp.length; j++) {
	                    dta = dta[fieldSp[j]];
	                }
	                //end 处理多级数据
					// get the cell style attribute
					var styleValue = col.styler ? (col.styler(dta, rowData, rowIndex) || '') : '';
					var style = col.hidden ? 'style="display:none;' + styleValue + '"' : (styleValue ? 'style="' + styleValue + '"' : '');

					cc.push('<td field="' + field + '" ' + style + '>');

					if (col.checkbox) {
						var style = '';
					} else {
						var style = '';
						//var style = 'width:' + (col.boxWidth) + 'px;';
						style += 'text-align:' + (col.align || 'left') + ';';
						if (!opts.nowrap) {
							style += 'white-space:normal;height:auto;';
						} else if (opts.autoRowHeight) {
							style += 'height:auto;';
						}
					}

					cc.push('<div style="' + style + '" ');
					if (col.checkbox) {
						cc.push('class="datagrid-cell-check ');
					} else {
						cc.push('class="datagrid-cell ' + col.cellClass);
					}
					cc.push('">');

					if (col.checkbox) {
						cc.push('<input type="checkbox" name="' + field + '" value="' + (dta != undefined ? dta : '') + '"/>');
					} else if (col.formatter) {
						cc.push(col.formatter(dta, rowData, rowIndex));
					} else {
						cc.push(dta);
					}

					cc.push('</div>');
					cc.push('</td>');
				}
			}
			return cc.join('');
		}
	}); */
	
    $("#${pageName}datagrid").datagrid({
		nowrap: false,
		striped: true,
		fit: true,
		pagination: true,
		rownumbers: true,
		fitColumns: true,
		loadMsg: "正在加载，请稍候...",
		singleSelect: true,
		url: "postManagementList.do",
		columns:[[
			{field:"postValue.title",title:"标题",align:"center",width:150},
			{field:"user.nickname",title:"作者",align:"center",width:150},
			{field:"EMAIL",title:"分类目录",align:"center",width:150},
			{field:"ROLEID",title:"标签",align:"center",width:80},
			{field:"POST",title:"评论",align:"center",width:60},
			{field:"POST.postTime",title:"日期",align:"center",width:100}
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