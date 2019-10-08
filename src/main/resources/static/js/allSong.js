$(document).ready(function () {

    var audio = $("audio")[0];//要在后面加[0]，否则获取不到
    // audio.src = "/music/song/李荣浩 - 老街.mp3";

    //js比较是严格比较，类型要一致才行
    var flag = parseInt($("#flag").val());
    var name;
    switch (flag) {
        case 1:name = "最热歌曲";break;
        case 2:name = "最新歌曲";break;
        case 3:name = "下载最多";break;
        default:name = "主题";
    }

    var $btn = $("#dropdownMenu1");
    $btn.empty();
    var html = "<span class=\"caret\"></span>";
    $btn.append(name + html);

    //试听歌曲
    $(".listening").click(function () {
        audio.src = $(this).prev().val();
        audio.play();

        var songId = $(this).siblings(".theSongId").val();
        $.ajax({
            async: false,//异步
            type: "get",//发送方式
            url: "/addPlayVolume",//发送的地址
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
});