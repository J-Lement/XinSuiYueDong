$(document).ready(function() {

    var audio = $("audio")[0];//要在后面加[0]，否则获取不到
    // audio.src = "/music/song/李荣浩 - 老街.mp3";
    audio.src = $("#songAddress").val();

    var text;
    var lyricsAddress = $("#lyricsAddress").val();

    console.log("song:" + audio.src + " lyrics:" + lyricsAddress.length);

    //如果有歌词
    if(lyricsAddress.length > 15) {
        //ajax同步获取歌词文件中的歌词
        $.ajax({
            url: lyricsAddress, success: function (data) {
                console.log("data:" + data);
                text = data;
            }, async: false, error: function () {
                alert("失败");
            }
        });

        function analysisLyrics(text) {
            textArray = text.split("\n");
            //result要定义成数组，否则会出错
            var result = [];

            for (var i = 0; i < textArray.length; i++) {
                //获取歌词出现的时间，time[0]为分，time[1]为秒
                var time = textArray[i].substring(1, textArray[i].indexOf("]")).split(":");
                // console.log("i:" + i + " time: " + time[0] + " : " + time[1]);
                //获取歌词内容
                var content = textArray[i].substring(textArray[i].indexOf("]") + 1, textArray.length);
                result.push({
                    //将时间转换成以秒为单位，保留两位小数,要加括号，否则会被当成字符串
                    lineTime: (parseInt(time[0] * 60) + parseFloat(time[1])).toFixed(4),
                    content: content
                });
                // console.log(result[i].lineTime);
            }
            return result;
        }

        var result = analysisLyrics(text);

        //插入包含歌词的html组件
        var $ul = $("<ul></ul>");
        for (var i = 0; i < result.length; i++) {
            var $li = $("<li></li>").text(result[i].content);
            $ul.append($li);
        }
        //包含歌词的div
        var lyricsDiv = $(".lyricsDiv");
        lyricsDiv.append($ul);

        //开始3行不移动
        var startMoveLine = 3;
        //每次移动60个单位
        var lineMove = 60;
        //歌词总行数
        var allLine = result.length;
        var scrollHeight = 0;

        //当前行高亮
        function highLight() {
            var nowLine = getNowLine();
            // var $div = $(".lyricsDiv").target;
            $("li").eq(nowLine).addClass("active").siblings().removeClass("active");
            // console.log(scrollHeight + " 距离：" + (nowLine - startMoveLine) * lineMove);
            if (nowLine >= startMoveLine && scrollHeight != ((nowLine - startMoveLine) * lineMove)) {
                scrollHeight = (nowLine - startMoveLine) * lineMove;
                $(".lyricsDiv").stop(true, true).animate({scrollTop: scrollHeight});

            }
            // console.log("scrollTop:" + $(".lyricsDiv").scrollTop());
        }

        //获取当前行的行号
        function getNowLine() {
            for (var i = 0; i < allLine; i++) {
                // console.log(audio.currentTime);
                if (audio.currentTime < result[i].lineTime) {
                    // console.log(" : " + result[i].lineTime);
                    return --i;
                }
            }
            return 0;
        }

        //监听事件，播放位置改变时触发
        audio.addEventListener("timeupdate", function () {
            highLight();
        });
    }


    //ajax实现动态评论
    $("#commentsBtn").click(function(){
        $.ajax({
            async: false,//异步
            type: "get",//发送方式
            url: "/addAndGetComment",//发送的地址
            data: $("#mainForm").serialize(),
            datatype: "json",//接收的数据
            success: function (data) {
                $("#inputComment").val("");
                $(".comment").empty();
                $.each(data, function (i,obj) {//解析json数据
                    console.log("i:" + i + " songName:" + obj.commentsId + " userName:" + obj.userName);
                    var html = "<div>";
                    html = html + "<a href='#' style='color: #00bbee'>" + obj.userName + ":</a>";
                    html = html + obj.commentsContent + "<a class='replyA' target='_blank' href='/replyHome?commentsId="+ obj.commentsId
                        + "&userName=" + obj.userName + "'>回复</a>";
                    html = html + "<span class='floatRight'>" + obj.commentsTime + "</span></div>";
                    // alert(html);
                    $(".comment").append(html);
                });

            },
            error: function () {
                alert("发送失败。。。");
            }
        });

        //查询总评论数
        var songId=$("#songId").val();
        $.ajax({
            async: true,//异步
            type: "get",//发送方式
            url: "/getCommentsNumber",//发送的地址
            data: {"songId":songId},
            datatype: "json",//接收的数据
            success: function (data) {
                $(".totalComments").empty();
                $(".totalComments").append("（共有" + data + "条评论）");
            },
            error: function () {
                alert("发送失败。。。");
            }
        });
    });

    //分页
    $(".commentsA").click(function () {
        //获取当前元素id
        var pageNow = $(this).attr("id");

        var songId = $("#songId").val();
        var pageNum = $("#pageNum").val();

        $.ajax({
            async: true,//异步
            type: "get",//发送方式
            url: "/changeCommentsPage",//发送的地址
            data: {
                "songId":songId,
                "pageNum":pageNum,
                "pageNow":pageNow
            },
            datatype: "json",//接收的数据
            success: function (data) {
                $(".comment").empty();
                $.each(data, function (i,obj) {//解析json数据
                    console.log("i:" + i + " songName:" + obj.commentsId + " userName:" + obj.userName);
                    var html = "<div>";
                    html = html + "<a href='#' style='color: #00bbee'>" + obj.userName + ":</a>";
                    html = html + obj.commentsContent + "<a class='replyA' target='_blank' href='/replyHome?commentsId="+ obj.commentsId + "&userName=" + obj.userName + "'>回复</a>";
                    html = html + "<span class='floatRight'>" + obj.commentsTime + "</span></div>";
                    $(".comment").append(html);
                });
            },
            error: function () {
                alert("发送失败。。。");
            }
        });
        $(this).parent().addClass("active disable").siblings().removeClass("active disable");
    });


    //增加下载数量
    $(".addDownload").click(function () {
        var songId = $(this).prev().val();
        $.ajax({
            async: false,//异步
            type: "get",//发送方式
            url: "/addDownload",//发送的地址
            data: {
                "songId":songId
            },
            datatype: "json",//接收的数据
            success: function (data) {

            },
            error: function () {
                alert("发送失败。。。");
            }
        });
    });


    //添加歌曲到列表
    $(".addToList").click(function () {
        var songId = $("#songId").val();
        var userId = $("#loginUserId").val();
        $.ajax({
            async: false,//异步
            type: "get",//发送方式
            url: "/addSongToMyList",//发送的地址
            data: {
                "songId":songId,
                "userId":userId
            },
            datatype: "json",//接收的数据
            success: function (data) {
                alert("添加成功");
            },
            error: function () {
                alert("发送失败。。。");
            }
        });
    });
});