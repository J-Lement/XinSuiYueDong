<%--
  Created by IntelliJ IDEA.
  User: Lement
  Date: 2019/9/2
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div><p>注册成功，<span id="num">3</span>s后跳转到登录界面...</p></div>
<input id="userName" type="hidden" name="userName" value="${userName}">
</body>
<script>
    $(document).ready(function(){
    var userName = $("#userName").val();
        setInterval(go, 1000);
    var x=3; //利用了全局变量来执行
    function go(){
        x--;
        if(x>0){
            document.getElementById("num").innerHTML=x;  //每次设置的x的值都不一样了。
        }else{
            location.href='/boot/login';  //要跳转的页面
        }
    }
    });

</script>
</html>
