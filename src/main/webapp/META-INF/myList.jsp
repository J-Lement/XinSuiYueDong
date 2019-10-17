<%--
  Created by IntelliJ IDEA.
  User: Lement
  Date: 2019/10/9
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>AllSong</title>
    <link href="/css/allSong.css" rel="stylesheet">
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script src="/js/allSong.js"></script>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="topMainDiv">
    <div class="firstLeftDiv">
        <table class="table table-striped">
            <input type="text" id="loginUserId" value="${loginUserId}" hidden>
            <tbody>
            <tr><h4>用户:${loginUserName}</h4></tr>
            <tr>
                <td class="navigateText">
                    <a href="/allMusic">主页</a>
                </td>
            </tr>
            <tr>
                <td class="navigateText">
                    <a href="/personalpage?loginUserId=${loginUserId}" target="_blank">个人信息</a>
                </td>
            </tr>
            <tr>
                <td class="navigateText">
                    <a href="/myList?userId=${loginUserId}">我的列表</a>
                </td>
            </tr>
            <tr>
                <td class="navigateText">
                    <a href="/loginOut?userId=${loginUserId}">退出</a>
                </td>
            </tr>

            </tbody>
        </table>
    </div>

    <div class="firstMainDiv">
        <div class="orderByWhat">
            <div class="dropdown floatRight">
                <button type="button" class="btn btn-primary" id="playAll">播放全部
                </button>
            </div>
        </div>

        <div class="songTable">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>歌名</th>
                    <th>歌手</th>
                    <th>类别</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="songInformation">
                <c:forEach items="${allSongs}" var="song">
                    <tr>
                        <td><a href="/musicHome?songId=${song.songId}">${song.songName}</a></td>
                        <td>${song.singerName}</td>
                        <td>${song.categoryName}</td>
                        <td>
                            <input class="theSongId" type="text" value="${song.songId}" hidden>
                            <a class="addDownload" href="${song.songDocument}" download="${song.songDocument}">下载</a>
                            <input id="songAddress" type="text" value="${song.songDocument}" hidden>
                            <a class="listening" href="#">试听</a>
                            <a href="/deleteSongFromList?userId=${loginUserId}&songId=${song.songId}">移除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>
<div>
    <audio id='audio' controls="controls" style="width: 100%">你的浏览器不支持喔！</audio>
</div>
</body>
</html>

