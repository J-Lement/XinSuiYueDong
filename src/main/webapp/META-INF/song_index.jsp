<%--
  Created by IntelliJ IDEA.
  User: huangxiang
  Date: 2019/9/5
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>心随乐动</title>
    <link rel="stylesheet" type="text/css" href="/css/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="/css/base.css}" />
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/css/jquery-ui-1.8.22.custom.css" />
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.22.custom.min.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>
</head>
<body>
<div class="warp">
    <!--头部开始-->
    <div class="top_c">
        <div class="top-title"><h1>心随乐动</h1></div>
        <div class="top-nav">欢迎您，&nbsp;&nbsp;<a href="#">修改密码</a> | <a href="#">安全退出</a></div>
    </div>
    <!--头部结束-->
    <!--左边菜单开始-->
    <div class="left_c left">
        <h1>操作菜单</h1>
        <div class="acc">
            <div>
                <a class="one">歌曲管理</a>
                <ul class="kid">
                    <li><b class="tip"></b><a role = "button"target="Conframe" href="/list">歌手信息查询</a></li>
                    <li><b class="tip"></b><a role = "button" target="Conframe" href="/add_song">增加歌曲</a></li>
                </ul>
            </div>

            <div>
                <a class="one">类别管理</a>
                <ul class="kid">
                    <li><b class="tip"></b><a role = "button"target="Conframe" href="/cate">歌曲类别</a></li>
                    <li><b class="tip"></b><a role = "button"target="Conframe" href="/add_category">类别添加</a></li>
                </ul>
            </div>




        </div>


    </div>
    <!--左边菜单结束-->
    <!--右边框架开始-->
    <div class="right_c">

        <div class="nav-tip" onclick="javascript:void(0)">&nbsp;</div>
    </div>
    <div class="Conframe">
        <iframe name="Conframe" id="Conframe"></iframe>
    </div>
    <!--右边框架结束-->


</div>
</body>
</html>

