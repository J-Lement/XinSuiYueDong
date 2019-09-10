<%--
  Created by IntelliJ IDEA.
  User: Lement
  Date: 2019/9/2
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <%--<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <script src="/js/loginCheck.js"></script>
</head>
<body>
<form action="/boot/index">
<div class="modal-dialog" style="margin-top: 10%;width: 30%;">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title text-center" id="myModalLabel">登录</h4>
        </div>
        <div class="modal-body" id = "model-body">
            <div class="form-group">

                <input id="acc" type="text" name="userName" class="form-control" placeholder="用户名" autocomplete="off">
            </div>
            <div class="form-group">

                <input id="pwd" type="password" name="password" class="form-control" placeholder="密码" autocomplete="off">
            </div>
        </div>
        <div class="modal-footer">
            <div class="form-group">
                <button id="btn" type="button" class="btn btn-primary form-control">登录</button>
            </div>
            <div class="form-group text-center">
                <a href="/boot/register">注册</a>
            </div>

        </div>
    </div><!-- /.modal-content -->
</div><!-- /.modal -->
</form>
</body>
</html>
