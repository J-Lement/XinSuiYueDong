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
    <title>Title</title>
    <link href="/css/audio.css" rel="stylesheet">
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script src="/js/audio.js"></script>

    <!-- easyui的样式主题文件 -->
    <link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css">
    <!-- easyui的系统图标-->
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
    <!-- easyui依赖的jquery库-->
    <script type="text/javascript" src="/easyui/jquery.min.js"></script>
    <!-- easyui的插件库-->
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
    <!-- easyui的汉化包 -->
    <script type="text/javascript" src="/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<div class="containerDiv">
    <div class="firstLeftDiv">

    </div>

    <div class="firstMainDiv">
        <div class="secondTopDiv">
            <img src="/images/music1.png" >
            <div class="buttonDiv">
                <button class="easyui-linkbutton">收藏到列表</button>
                <a class="easyui-linkbutton" href="/music/song/李荣浩 - 老街.mp3" download="/music/song/李荣浩 - 老街.mp3">下载</a>
            </div>
        </div>

        <div class="secondTopDiv">
            <div class="songName">
                <span >老街</span>
                <br>
                <span class="singer">歌手：<span>李荣浩</span></span>
            </div>
            <div class="lyricsDiv">
            </div>
        </div>

        <div class="secondBottomDiv">
            <h3>歌曲评论</h3><h6>（共有${commentNum}条评论）</h6>

            <hr>

            <form action="/addComment" method="post">
                <div class="inputComment">
                    <%--<input readonly="true"  placeholder="发表评论" style="width: 98%;margin: 7px">--%>
                    <input type="text" name="songId" value="${songId}" hidden>
                    <input type="text" name="userId" value="1" hidden>
                    <textarea name="content" placeholder="发表评论"  rows="5"></textarea>
                    <input class="easyui-linkbutton" type="submit" value="评论">
                </div>
            </form>

            <h6>精彩评论</h6>
            <hr>

            <div class="comment">
                <c:forEach items="${commentsList}" var="comments">
                    <div>
                        <span style="color: #00bbee">${comments.userName}：</span>
                        ${comments.commentsContent}
                        <a href="#">回复</a>
                        <span class="floatRight">${comments.commentsTime}</span>
                    </div>
                </c:forEach>

                <div >
                    <span style="color: #00bbee">冰淇淋：</span>
                    "何谓孤寂？" "清风，艳日，无笑意。" "可否具体？" "左拥，右抱，无情欲。" "可否再具体？" "不得你.
                    <a href="#">回复</a>
                    <span class="floatRight">2019年9月16日 17：00</span>
                </div>

                <div >
                    <span style="color: #00bbee">已注销：</span>
                    “何为思念？” “日月，星辰，旷野雨落。” “可否具体？” “山川，江流，烟袅湖泊。” “可否再具体？” “万物是你，无可躲。”
                    <a href="#">回复</a>
                    <span class="floatRight">2019年9月16日 17：00</span>
                </div>

                <div >
                    <span style="color: #00bbee">松松松：</span>
                    “何为无救？” “良药、妙方，无可医。” “可否具体？” “扁鹊、华佗，俱无策。” “可否再具体？” “念你成疾。”
                    <a href="#">回复</a>
                    <span class="floatRight">2019年9月16日 17：00</span>
                </div>
                <div >
                    <span style="color: #00bbee">松松松：</span>
                    “何为无救？” “良药、妙方，无可医。” “可否具体？” “扁鹊、华佗，俱无策。” “可否再具体？” “念你成疾。”
                    <a href="#">回复</a>
                    <span class="floatRight">2019年9月16日 17：00</span>
                </div>

                <div >
                    <span style="color: #00bbee">松松松：</span>
                    “何为无救？” “良药、妙方，无可医。” “可否具体？” “扁鹊、华佗，俱无策。” “可否再具体？” “念你成疾。”
                    <a href="#">回复</a>
                    <span class="floatRight">2019年9月16日 17：00</span>
                </div>

                <div >
                    <span style="color: #00bbee">松松松：</span>
                    “何为无救？” “良药、妙方，无可医。” “可否具体？” “扁鹊、华佗，俱无策。” “可否再具体？” “念你成疾。”
                    <a href="#">回复</a>
                    <span class="floatRight">2019年9月16日 17：00</span>
                </div>
            </div>
        </div>
    </div>

    <div class="firstLeftDiv">

    </div>

<audio id='audio' controls="controls" style="width: 100%">你的浏览器不支持喔！</audio>

<%--<div class='MusicPanel'>--%>
    <%--<div class='PanelLeft'><div class='circle'><span class='icon glyphicon-heart'></span></div></div> <!-- Like Button -->--%>

    <%--<div class='PanelRight'>--%>
        <%--<div class='Prev'><span class='icon glyphicon-step-backward'></span></div> <!-- Prev Song Button -->--%>
        <%--<div id='Play' class='Play'><span class='icon glyphicon-play'></span></div> <!-- Play & Pause Button -->--%>
        <%--<div class='Next'><span class='icon glyphicon-step-forward'></span></div> <!-- Next Song Button -->--%>
        <%--<div class="Song"><span class='SongAuthor'>Greyson Chance</span></br><span class='SongName'>Summertrain</span></div> <!-- Song Title -->--%>

        <%--<div class="Process"> <!-- Process -->--%>
            <%--<div class="ProcessAll" ></div> <!-- ProcessAll -->--%>
            <%--<div class="ProcessNow"></div> <!-- ProcessNow -->--%>
            <%--<div class="SongTime">00:00&nbsp;|&nbsp;00:00</div> <!-- Time -->--%>
        <%--</div> <!-- Process End -->--%>
    <%--</div> <!-- PanelRight End -->--%>
<%--</div> <!-- MusicPanel End -->--%>
</div>
</body>
</html>
