<%--
  Created by IntelliJ IDEA.
  User: Lement
  Date: 2019/9/11
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>musicHome</title>
    <link href="/css/musicHome.css" rel="stylesheet">
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script src="/js/musicHome.js"></script>

    <%--<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<script src="/bootstrap/js/bootstrap.min.js"></script>--%>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- easyui的样式主题文件 -->
    <%--<link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css">--%>
    <%--<!-- easyui的系统图标-->--%>
    <%--<link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">--%>
    <%--<!-- easyui依赖的jquery库-->--%>
    <%--<script type="text/javascript" src="/easyui/jquery.min.js"></script>--%>
    <%--<!-- easyui的插件库-->--%>
    <%--<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>--%>
    <%--<!-- easyui的汉化包 -->--%>
    <%--<script type="text/javascript" src="/easyui/locale/easyui-lang-zh_CN.js"></script>--%>
</head>
<body>
<div class="containerDiv">
    <div class="firstLeftDiv">
        <input type="text" id="loginUserId" value="${loginUserId}" hidden>
    </div>

    <div class="firstMainDiv">
        <div class="secondTopDiv">
            <img src="/images/music1.png" >
            <div class="buttonDiv">
                <button class="btn btn-primary btn-sm  addToList">收藏到列表</button>
                <input type="text" name="songId" value="${songId}" hidden>
                <a class="btn btn-primary btn-sm addDownload" href="${song.songDocument}" download="${song.songDocument}">下载</a>
                <input id="songAddress" type="text" value="${song.songDocument}" hidden>
                <input id="lyricsAddress" type="text" value="${song.lyrics}" hidden>
            </div>
        </div>

        <div class="secondTopDiv">
            <div class="songName">
                <span >${song.songName}</span>
                <br>
                <span class="singer">歌手：<span>${song.singerName}</span></span>
            </div>
            <div class="lyricsDiv">
            </div>
        </div>

        <div class="secondBottomDiv">
            <h3>歌曲评论</h3><h6 class="totalComments">（共有${commentsNum}条评论）</h6>

            <hr>

            <form id="mainForm" action="/addComment">
                <div class="inputComment">
                    <%--<input readonly="true"  placeholder="发表评论" style="width: 98%;margin: 7px">--%>
                    <input id="songId" type="text" name="songId" value="${songId}" hidden>
                    <input type="text" name="userId" value="${loginUserId}" hidden>
                    <input id="pageNow" type="text" name="pageNow" value="${page.pageNow}" hidden>
                    <input id="pageNum" type="text" name="pageNum" value="${page.pageNum}" hidden>
                    <textarea id="inputComment" name="content" placeholder="发表评论"  rows="5"></textarea>
                    <input class="btn btn-info btn-sm" type="button" id="commentsBtn" value="评论">
                </div>
            </form>

            <h6>精彩评论</h6>
            <hr>



            <div class="comment">
                    <c:forEach items="${commentsList}" var="comments">
                        <div>
                            <a href="#" style="color: #00bbee">${comments.userName}：</a>
                            ${comments.commentsContent}
                            <a class="replyA" href="/replyHome?commentsId=${comments.commentsId}&userName=${comments.userName}" target="_blank">回复</a>
                            <span class="floatRight">${comments.commentsTime}</span>
                        </div>
                    </c:forEach>
            </div>

            <div class="commentPages">
                <ul class="pagination">
                    <c:forEach items="${num}" var="item">
                        <li class="<c:if test="${item == page.pageNow}"> active disable</c:if>"><a class="commentsA" id="${item}">${item}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>

    <div class="firstLeftDiv">

    </div>

<audio id='audio' controls="controls" autoplay="autoplay" style="width: 100%">你的浏览器不支持喔！</audio>
</div>
</body>
</html>
