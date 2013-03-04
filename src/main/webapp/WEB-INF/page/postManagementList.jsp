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
	<a href="postManagementNewPost.html" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
		onclick="javascript:openTab(this);return false;" tabtitle="写文章" >写文章</a>
	<label> | </label>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no',plain:true"
		onclick="return false;" tabtitle="写文章" >批量删除</a>
</div>
<script type="text/javascript">
$(document).ready(function(){
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
		selectOnCheck: false,
		checkOnSelect: false,
		columns:[[
			{field:"ck", checkbox:true},
			{field:"title",title:"标题",align:"left",width:200},
			{field:"nickname",title:"作者",align:"center",width:80},
			{field:"part",title:"分类目录",align:"center",width:80},
			{field:"pl",title:"评论数",align:"center",width:60},
			{field:"posttime",title:"日期",align:"center",width:100,
				formatter: function(value,rowData,rowIndex){
					var date = new Date(value);
					var year = date.getFullYear();  
        			var month = ("0" + (date.getMonth() + 1)).slice(-2);  
        			var day = ("0" + date.getDate()).slice(-2);  
        			var h = ("0" + date.getHours()).slice(-2);  
        			var m = ("0" + date.getMinutes()).slice(-2);  
        			var s = ("0" + date.getSeconds()).slice(-2);   
					return year + "-" + month + "-" + day + "&nbsp;" + h + ":" + m + ":" + s;
				}	
			},
			{field:"poststage",title:"状态",align:"center",width:60},
			{field:"id",title:"操作",align:"center",width:100,
				formatter: function(value,rowData,rowIndex){
					return "<a href='../post/"+value+"/' target='_blank' >查看</a> | <a href='##' onclick='return false;' >编辑</a> | <a href='#' onclick='return false;' ><span style='color:red;'>移至回收站</span></a>";
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
		username: $("#${pageName}username").val()
    });
}

</script>