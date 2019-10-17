
$().ready(function() {

// 在键盘按下并释放及提交后验证提交表单
    $("#signinForm").validate({
        rules: {
            username: {
                required: true,
                minlength: 3,
                maxlength:16,
                remote:{
                    type: "get",
                    url: "/checkname",
                    data: {
                        name: function() {
                            return $("#username").val();
                        }
                    },
                    dataType: "html",
                    dataFilter: function(data, type) {
                        if (data == "true")
                            return true;
                        else
                            return false;
                    }
                }
            },
            password1: {
                required: true,
                minlength: 6,
                maxlength: 16
            },
            password2: {
                required: true,
                minlength: 6,
                maxlength:16,
                equalTo: "#password1"
            },
            email: {
                required: true,
                email: true,
                remote:{
                    type: "get",
                    url: "/checkemail",
                    data: {
                        email: function() {
                            return $("#email").val();
                        }
                    },
                    dataType: "html",
                    dataFilter: function(data, type) {
                        if (data == "true")
                            return true;
                        else
                            return false;
                    }
                }

            },
            phone:{
                required:true,
                minlength: 11,
                maxlength:11
            }

        },
        messages: {
            username: {
                required: "请输入用户名",
                minlength: "用户名必需由两个字母组成",
                remote:"此用户名已存在"
            },
            password1: {
                required: "请输入密码",
                minlength: "密码长度不能小于 6 个字母"
            },
            password2: {
                required: "请输入密码",
                minlength: "密码长度不能小于 6 个字母",
                maxlength:"密码长度不能超过16个字符",
                equalTo: "两次密码输入不一致"
            },
            email: {
                required:"请输入你的邮箱",
                email:"请输入一个正确的邮箱",
                remote:"此邮箱已存在",
            },
            phone:{
                required:"请输入你的电话号码",
                minlength: "电话号码为11位",
                maxlength:"电话号码为11位",
            }

        }
    })
});