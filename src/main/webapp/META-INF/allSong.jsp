<%--
  Created by IntelliJ IDEA.
  User: Lement
  Date: 2019/9/23
  Time: 9:58
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
            <tbody>
            <input type="text" id="loginUserId" value="${loginUserId}" hidden>
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
                <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">显示方式
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                    <input type="text" id="flag" value="${flag}" hidden>
                    <li role="presentation">
                        <a id="orderByListening" role="menuitem" tabindex="-1" href="/getHotestSong">最热歌曲</a>
                    </li>
                    <li role="presentation">
                        <a id="orderByTime" role="menuitem" tabindex="-1" href="/getLatestSong">最新歌曲</a>
                    </li>
                    <li role="presentation">
                        <a id="orderByDownload" role="menuitem" tabindex="-1" href="/getSongByDownload">下载最多</a>
                    </li>
                </ul>
            </div>

            <form action="/querySongByName">
                <input type="text" id="querySong" name="querySong" value="${querySong}" placeholder="输入歌名">
                <button class="btn btn-info" type="submit" value="提交">查询</button>
            </form>
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
                            <a class="addToList" href="#">收藏</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="commentPages">
            <ul class="pagination">
                <c:forEach items="${num}" var="item">
                    <li class="<c:if test="${item == page.pageNow}"> active disable</c:if>"><a href="/songChangePage?pageNow=${item}&flag=${flag}">${item}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<div>
    <audio id='audio' controls="controls" style="width: 100%">你的浏览器不支持喔！</audio>
</div>
</body>
</html>
