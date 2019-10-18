<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人主页</title>
    <!--添加图标-->
    <link rel="shortcut icon" href="/static/images/logo.ico" />

    <!-- Vue.js文件-->
    <script src="https://cdn.staticfile.org/vue/2.2.2/vue.min.js"></script>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--JQuery validate插件-->
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>


</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-2 column"></div>

        <div class="col-md-8 column">
            <h1>个人主页</h1><br>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2 class="panel-title">
                        个人基本信息
                    </h2>
                </div>
                <div class="panel-body ">
                    <span>用户名：</span>${user.userName}
                </div>
                <div class="panel-body">
                    <span>个人邮箱:</span>${user.email}
                </div>
                <div class="panel-body">
                    <span>电话号码：</span>${user.phone}
                </div>
                <div class="panel-footer">
                    <a href="editPassword?email=${user.email}">修改密码</a>
                </div>
            </div>
            <hr>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2 class="panel-title">
                        个人基本信息
                    </h2>
                </div>
                <div class="panel-body">
                    <span>qq：</span>${user.qq}
                </div>
                <div class="panel-body">
                   <span> 国家:</span>${user.nation}
                </div>
                <div class="panel-body">
                    <span>省份:</span>${user.province}
                </div>
                <div class="panel-body">
                    <span>城市:</span>${user.city}
                </div>
                <div class="panel-footer">
                    <a href="updateUser">个人信息修改</a>
                </div>
            </div>


        </div>
        <div class="col-md-2 column"></div>


    </div>
</div>







</body>
</html>
