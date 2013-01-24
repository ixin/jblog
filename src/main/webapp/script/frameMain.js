$(function(){
    // 设置消息弹框默认按钮文字
    $.extend($.messager.defaults, {
    	ok : "确定",
    	cancel : "取消"
    });
    $("ul li div.tree-node span.tree-title a").bind("click", function(event) {
        openTab(event.target);
        return false;
    });
});
//打开tab的公共方法
function openTab(o) {
    var title = $(o).attr("tabtitle");
    var href = $(o).attr("href");
    var refreshIfExist = $(o).attr("refreshifexist");
    var isTabExist = $("#mainTabs").tabs("exists", title);
    if (isTabExist) {
        var tab = $("#mainTabs").tabs("getTab", title);
        $("#mainTabs").tabs("select", title);
        if ("true" == refreshIfExist)
            tab.panel("refresh", href);
    } else {
        $("#mainTabs").tabs("add", {
        title : title,
        closable : true,
        href : href
        });
    }
    return false;
}
//打开window的公共方法
function openWindow(o) {
    var sid = $(o).attr("sid");
    if (null == sid || "" == sid) {
        sid = "defaultWindow";
    }
    var title = $(o).attr("windowtitle");
    var href = $(o).attr("href");
    var id = "openWindow_" + sid;
    var dataOptionJSON = $(o).attr("dataoption");
    if (null == dataOptionJSON || "" == dataOptionJSON) {
        dataOptionJSON = "{}";
    }
    var dataOption = eval("(" + dataOptionJSON + ")");
    $("body").append("<div id='" + id + "'></div>");
    $("#" + id).window({
    title : title,
    href : href,
    width : null == dataOption.width ? 800 : dataOption.width,
    height : null == dataOption.height ? "auto" : dataOption.height,
    top : null == dataOption.top ? "auto" : dataOption.top,
    collapsible : false,
    minimizable : false,
    maximizable : null == dataOption.maximizable ? true : dataOption.maximizable,
    modal : true,
    closed : true,
    onClose : function() {
        $("#" + id).window("destroy", true);
    }
    });
    $("#" + id).window("hcenter");
    $("#" + id).window("open");
}
//右下角 弹框
function newsBounced(Title, Msg) {
   $.messager.show({
   title : Title,
   msg : Msg,
   timeout : 0,
   showType : 'slide'
   });
}