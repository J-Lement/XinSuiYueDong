<%--
  Created by IntelliJ IDEA.
  User: Lement
  Date: 2019/9/2
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8"/>
    <title>用户注册</title>
    <%--<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<link href="/css/bootstrap.css" rel="stylesheet">--%>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <%--<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>--%>
    <script src="/js/jquery-3.4.1.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <%--<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <%--<script src="/js/bootstrap.js"></script>--%>
    <script src="/js/check.js"></script>
</head>
<body class="login-page">
<section class="login-contain viewFlow" style="height: 100%;">
    <header>
        <h1>用户注册</h1>
    </header>
    <form action="/boot/doRegister">
        <div class="panel panel-default">
            <ul>
                <li>
                    <div class="form-group">
                        <label id="pAccount" class="required">账号：</label>
                        <input type="text" name="userName" class="form-control form-underlined" id="userName" />
                    </div>
                </li>
                <li>
                    <div class="form-group">
                        <label id="pPwd" class="required">密码：</label>
                        <input type="password"  class="form-control" id="password" name="password" />
                    </div>
                </li>
                <li>
                    <div class="form-group">
                        <label id="pPwd1" class="required">确认密码：</label>
                        <input type="password"  class="form-control"  id="password1" name="password1"/>
                    </div>
                </li>
                <li>
                    <button id="btn" class="btn btn-lg btn-block" type="submit">立即注册</button>
                </li>
            </ul>
        </div>
    </form>
</section>
</div>
</body>
</html>
