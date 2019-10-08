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
个人主页<br>
用户名：${user.userName}<br>
个人邮箱:${user.email}<br>
电话号码：${user.phone}<br>
<hr>
<a href="updateUser">个人信息修改</a><br>
<a href="updatePassword">修改密码</a> <br>
qq：${user.qq}<br>
国家:${user.nation}<br>
省份:${user.province}<br>
城市:${user.city}

</body>
</html>
