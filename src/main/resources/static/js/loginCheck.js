$(document).ready(function(){
$("#btn").click(function () {
    var account = $("#acc").val();
    var password = $("#pwd").val();
    var ok = false;

    $.ajax({
        async: false,           //取消异步（即同步），异步会使下面的代码在接收结果之前运行
        type: "get",            //发送方式
        url: "/boot/loginCheck",//发送的地址
        data: {                 //发送的数据
            "userName":account,
            "password":password
        },
        datatype: "json",       //接收的数据
        success: function (data) {
            // alert("返回的数据："+data);
            if(data == 1)
                ok = true;
        },
        error: function () {
            alert("发送失败。。。");
        }
    });

    if(ok){
        $(location).attr('href', '/boot/index?userName=' + account);
    }
    else
        alert("信息不匹配，登录失败!");

    });
});