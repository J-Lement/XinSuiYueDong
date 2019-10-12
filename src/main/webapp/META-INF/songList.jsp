<%@ page import="com.nchu.music.bean.Song" %><%--
  Created by IntelliJ IDEA.
  User: huangxiang
  Date: 2019/9/5
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>心随乐动</title>
    <link rel="stylesheet" href="/css/style.default.css" type="text/css" />
    <script type="text/javascript" src="/js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
</head>
<body>
<div>
    <div class="contenttitle2">
        <h3>课题列表</h3>
    </div><!--contenttitle-->
    <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="dyntable">
        <thead>
        <tr>
            <th class="head0">歌曲id</th>
            <th class="head1">歌曲名字</th>
            <th class="head0">歌手id</th>
            <th class="head1">类别id</th>
            <th class="head1">歌曲文件地址</th>
            <th class="head1">歌词文件地址</th>
            <th class="head0">操做</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${list}" var = "list">
        <tr class="grade" >
            <td>${list.songId}</td>
            <td>${list.songName}</td>
            <td>${list.singerId}</td>
            <td>${list.categoryId}</td>
            <td>${list.songDocument}
                <a href="/edit/${list.songId}"><button class="stdbtn btn_blue">歌词上传</button></a>

            </td>
            <td>${list.lyrics}</td>

            <td>
                <a href="/edit/${list.songId}"><button class="stdbtn btn_blue">修改</button></a>
                <a href="/deletesong/${list.songId}"><button class="stdbtn btn_blue"  type="submit">删除</button></a>

            </td>

        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>

</body>
</html>