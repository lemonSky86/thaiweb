/**
 * @Description //右侧内容标签操作
 * @Param
 * @Author oneTi
 * @Date 16:43 2018/9/4
 * @Return
 **/
var menuTab = {
    openTab: function (url) {
        var iframe = "<iframe src='"+ url +"' frameborder='0'></iframe>";
        $(".contentDiv").html(iframe);
    }
}

