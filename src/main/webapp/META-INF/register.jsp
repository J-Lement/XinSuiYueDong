<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>

    <!--添加图标-->
    <link rel="shortcut icon" href="/images/logo.ico" />

    <link rel="stylesheet" type="text/css" href="/css/register.css">



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

    <script type="application/javascript" src="/js/signin.js"></script>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">

                <div class="col-md-12 column">
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a>注册</a>
                        </li>
                        <li>
                            <a href="/login">登录</a>
                        </li>
                    </ul>
                </div>
            </div>

                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-3 column">
                </div>
                <div class="col-md-6 column">
                    <h3>

                        用户注册
                    </h3>
                    <br>
                    <form role="form" id="signinForm" method="post" action="register">
                        <div class="form-group" >
                            <label for="username">用户名</label><input type="text" class="form-control" placeholder="用户名" id="username" name="username"/>
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label><input type="email" class="form-control" placeholder="email" id="email" name="email" />
                        </div>

                        <div class="form-group">
                            <label for="password1">密码</label><input type="password" class="form-control"  placeholder="密码" id="password1"  name="password1" />
                        </div>
                        <div class="form-group">
                            <label for="password2">密码确认</label><input type="password" class="form-control" placeholder="重复密码" id="password2"  name="password2" />
                        </div>
                        
                        <div class="form-group">
                            <label for="phone">电话号码</label><input type="text" class="form-control" placeholder="电话号码" id="phone" name="phone"/>
                        </div>

                        <button type="submit" class="btn btn-default">提交</button>
                        <button type="reset" class="btn btn-default">重置</button>
                        <a type="button">test</a>

                    </form>
                </div>
                <div class="col-md-3 column">
                </div>
            </div>
        </div>



</body>
<script type="application/javascript" src="/js/check.js"></script>
</html>