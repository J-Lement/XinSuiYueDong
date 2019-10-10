$(document).ready(function() {

    //ajax实现动态评论
    $("#commentsBtn").click(function(){
        $.ajax({
            async: false,//异步
            type: "get",//发送方式
            url: "/addAndGetReply",//发送的地址
            data: $("#mainForm").serialize(),
            datatype: "json",//接收的数据
            success: function (data) {
                $("#inputComment").val("");
                $(".comment").empty();
                $.each(data, function (i,obj) {//解析json数据
                    console.log("i:" + i + " songName:" + obj.userName + " userName:" + obj.replyUserName);
                    var html = "<div>";
                    html = html + "<a href='#' style='color: #00bbee'>" + obj.replyUserName + "</a>";

                    if(obj.userName != null)
                        html = html +  "回复<a href='#' style='color: #00bbee'>" + obj.userName + "</a>";
                    html = html + "：" + obj.replyContent + "<a class='replyA' href='#'>回复</a>";
                    html = html + "<span class='floatRight'>" + obj.replyTime + "</span></div>";
                    $(".comment").append(html);

                });

                //添加点击事件，每个都要添加，否则会失效
                $(".replyA").click(function (e) {
                    reply(e);
                });
            },
            error: function () {
                alert("发送失败。。。");
            }
        });

    });

    $(".replyA").click(function (e) {
        reply(e);
    });

    function reply(e) {
        // alert("值" + $(e.target).prev().prev().text());
        //获取上一个元素的文本内容，也就是将要回复的用户名（回复谁）
        var userName = $(e.target).prev().prev().text();
        if(userName == '')
            userName = $(e.target).prev().text();
        var replyContent = prompt("回复" + userName + "：");
        //谁回复
        var replyUserName = $("#replyName").val();
        var commentsId = $("#commentsId").val();

        if(replyContent == null || replyContent == '')
            return;

        $.ajax({
            async: false,//异步
            type: "get",//发送方式
            url: "/addAndGetLatestReply",//发送的地址
            data: {
                "commentsId":commentsId,
                "userName":userName,
                "replyContent":replyContent,
                "replyUserName":replyUserName
            },
            datatype: "json",//接收的数据
            success: function (data) {
                var html = "<div>";
                html = html + "<a href='#' style='color: #00bbee'>" + data.replyUserName + "</a>";

                if(data.userName != null)
                    html = html +  "回复<a href='#' style='color: #00bbee'>" + data.userName + "</a>";
                html = html + "：" + data.replyContent + "<a class='replyA' href='#'>回复</a>";
                html = html + "<span class='floatRight'>" + data.replyTime + "</span></div>";
                $(".comment").prepend(html);

                $(".replyA").click(function (e) {
                    reply(e);
                });
            },
            error: function () {
                alert("发送失败。。。");
            }
        });
    }


});