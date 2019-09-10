$(document).ready(function(){
    var pwdFlag = false;
    var pwd1Flag = false;
    var accountFlag = false;
    $("#btn").attr("disabled", true);           //设置注册按钮不可用

    var $required = $("<strong style='color: red'>*</strong>");//在必填项后加红色的“*”号
    $("#pPwd").append($required);
    $required = $("<strong style='color: red'>*</strong>");
    $("#pPwd1").append($required);
    $required = $("<strong style='color: red'>*</strong>");
    $("#pAccount").append($required);


//为表单元素添加失去焦点事件
    $("form :input").blur(function(){
        $("#btn").attr("disabled", true);

        //验证账号account是否唯一
        if($(this).is("#userName")){
            $("#pAccount").parent().find(".onError").remove();
            $("#pAccount").parent().find(".onSuccess").remove();
            var userName = $.trim(this.value);
            var ok = false;

            $.ajax({
                async: false,           //取消异步（即同步），异步会使下面的代码在接收结果之前运行
                type: "get",            //发送方式
                url: "/boot/check",//发送的地址
                data: {                 //发送的数据
                    "userName":userName,
                },
                datatype: "json",       //接收的数据
                success: function (data) {
                    // alert("返回的数据："+data);
                    if(data == 0)
                        ok = true;
                },
                error: function () {
                    alert("发送失败。。。");
                }
            });

            if(!ok){
                var errorMsg = " 账号已存在";

                $("#pAccount").append("<span class='onError' style='color: red'>" + errorMsg + "</span>");
            }
            else{
                var okMsg=" 输入正确";
                $("#pAccount").append("<span class='onSuccess' style='color: green'>" + okMsg + "</span>");
                accountFlag = true;
            }
        }

        //验证密码
        if($(this).is("#password")){
            $("#pPwd").parent().find(".onError").remove();
            $("#pPwd").parent().find(".onSuccess").remove();

            var pwd = $.trim(this.value);
            // var regName = /[^[0-9]+$]/;
            var regName = /^[0-9]*$/;
            if(pwd.length < 6 || !regName.test(pwd)){
                var errorMsg = " 密码需6位以上的数字！";
                $("#pPwd").append("<span class='onError' style='color: red'>" + errorMsg + "</span>");
            }
            else{
                var okMsg=" 输入正确";
                $("#pPwd").append("<span class='onSuccess' style='color: green'>" + okMsg + "</span>");
                pwdFlag = true;
            }

        }

        //二次验证密码
        if($(this).is("#password1")) {
            if (pwdFlag) {
                $("#pPwd1").parent().find(".onError").remove();
                $("#pPwd1").parent().find(".onSuccess").remove();

                var pwd = $("#password").val();
                var pwd1 = $.trim(this.value);
                if (pwd == pwd1) {
                    var okMsg = " 输入正确";
                    $("#pPwd1").append("<span class='onSuccess' style='color: green'>" + okMsg + "</span>");
                    pwd1Flag = true;
                } else {
                    var errorMsg = " 两次密码输入不相同！";
                    $("#pPwd1").append("<span class='onError' style='color: red'>" + errorMsg + "</span>");
                }

            }
        }

        if(accountFlag && pwdFlag && pwd1Flag){        //若所有信息填写正确，将注册按钮设置为可用状态
            $("#btn").attr("disabled", false);
        }
    });

});