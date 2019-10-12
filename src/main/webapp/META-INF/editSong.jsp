<%--
  Created by IntelliJ IDEA.
  User: huangxiang
  Date: 2019/9/5
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>心随乐动</title>
    <link rel="stylesheet" href="/css/style.default.css" type="text/css" />
    <script type="text/javascript" src="/js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.validate.min.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.tagsinput.min.js"></script>
    <script type="text/javascript" src="/js/plugins/charCount.js"></script>
    <script type="text/javascript" src="/js/plugins/ui.spinner.min.js"></script>
    <script type="text/javascript" src="/js/plugins/chosen.jquery.min.js"></script>
    <script type="text/javascript" src="/js/custom/general.js"></script>
    <script type="text/javascript" src="/js/custom/forms.js"></script>
</head>
<body >
<div>
    <div class="contenttitle2">
        <h3>修改歌曲信息</h3>
    </div>

    <form class="stdform"  action="/edit_do" method="post">

        <p>
            <label>歌曲id：</label>
            <span class="field"><input type="text" name="songId" class="smallinput" value="${song.songId}"/></span>
        </p>
        <p>
            <label>歌曲名字：</label>
            <span class="field"><input type="text" name="songName" class="smallinput" value="${song.songName}" /></span>
        </p>
        <p>
            <label>歌手id：</label>
            <span class="field"><input type="text" name="singerId" class="smallinput" value="${song.singerId}" /></span>
        </p>

        <p>
            <label>歌曲类别：</label>
            <span class="field"><input type="text" name="categoryId" class="smallinput" value="${song.categoryId}" /></span>
        </p>


        <p>
            <label>歌曲文件地址：</label>
            <span class="field"><input type="text" name="songDocument" class="smallinput" value="${song.songDocument}" /></span>
        </p>
        <p>
            <label>歌曲歌词地址：</label>
            <span class="field"><input type="text" name="lyrics" class="smallinput" value="${song.lyrics}" /></span>
        </p>


        <p class="stdformbutton">
            <button class="submit ">提交</button>
            <a href="songList"><button type = "button"class="reset radius2" >返回</button></a>
        </p>
    </form>
</div>
<script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
</body>
</html>
