$(document).ready(function(){
    var $tab_li = $('#tab ul li');
    $tab_li.hover(function(){
        $(this).addClass('selected').siblings().removeClass('selected');
        var index = $tab_li.index(this);
        $('div.tab_box > div').eq(index).show().siblings().hide();
    });
});
    $(function(){
        /*学生登录信息验证*/
        $("#stu_username_hide").focus(function(){
            var id = $(this).val();
            if(id=='输入学号'){
                $(this).val('');
            }
        });
        $("#stu_username_hide").focusout(function(){
            var id = $(this).val();
            if(id==''){
                $(this).val('输入学号');
            }
        });
        $("#stu_password_hide").focus(function(){
            var passowrd = $(this).val();
            if(passowrd=='输入密码'){
                $(this).val('');
            }
        });
        $("#stu_password_hide").focusout(function(){
            var id = $(this).val();
            if(id==''){
                $(this).val('输入密码');
            }
        });
        /*导师登录信息验证*/
        $("#tea_username_hide").focus(function(){
            var username = $(this).val();
            if(username=='输入教工号'){
                $(this).val('');
            }
        });
        $("#tea_username_hide").focusout(function(){
            var username = $(this).val();
            if(username==''){
                $(this).val('输入教工号');
            }
        });
        $("#tea_password_hide").focus(function(){
            var username = $(this).val();
            if(username=='输入密码'){
                $(this).val('');
            }
        });
        $("#tea_password_hide").focusout(function(){
            var username = $(this).val();
            if(username==''){
                $(this).val('输入密码');
            }
        });
        /*教务登录信息验证*/
        $("#sec_username_hide").focus(function(){
            var username = $(this).val();
            if(username=='输入教务号'){
                $(this).val('');
            }
        });
        $("#sec_username_hide").focusout(function(){
            var username = $(this).val();
            if(username==''){
                $(this).val('输入教务号');
            }
        });
        $("#sec_password_hide").focus(function(){
            var username = $(this).val();
            if(username=='输入密码'){
                $(this).val('');
            }
        });
        $("#sec_password_hide").focusout(function(){
            var username = $(this).val();
            if(username==''){
                $(this).val('输入密码');
            }
        });
    });
    $(function(){
        $(".screenbg ul li").each(function(){
            $(this).css("opacity","0");
        });
        $(".screenbg ul li:first").css("opacity","1");
        var index = 0;
        var t;
        var li = $(".screenbg ul li");
        var number = li.size();
        function change(index){
            li.css("visibility","visible");
            li.eq(index).siblings().animate({opacity:0},3000);
            li.eq(index).animate({opacity:1},3000);
        }
        function show(){
            index = index + 1;
            if(index<=number-1){
                change(index);
            }else{
                index = 0;
                change(index);
            }
        }
        t = setInterval(show,8000);
        //根据窗口宽度生成图片宽度
        var width = $(window).width();
        $(".screenbg ul img").css("width",width+"px");
    });
