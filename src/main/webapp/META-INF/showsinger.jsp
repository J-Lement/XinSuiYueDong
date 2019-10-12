<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>

    <!--添加图标-->
    <link rel="shortcut icon" href="/static/images/logo.ico" />

    <!-- Vue.js文件-->
    <script src="https://cdn.staticfile.org/vue/2.2.2/vue.min.js"></script>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <script src="js/jquery-1.11.3.js"></script>
    <!--分页-->
    <link rel="stylesheet" href="css/pagination.css" />
    <script type="text/javascript" src="js/jquery.pagination.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>
                        歌手id
                    </th>
                    <th>
                        歌手名
                    </th>
                    <th>
                        歌手删除
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="singer" items="${list}" >
                <tr>
                    <td>
                        ${singer.singerId}
                    </td>
                    <td>
                        ${singer.singerName}
                    </td>
                    <td>
                        <a class="btn btn-warning" href="/deletesinger?name=${singer.singerName}">删除</a>
                    </td>
                </tr>
                </c:forEach>
                <tr>
                    <td>
                        xxx
                    </td>
                    <form action="/addsinger" method="get">
                    <td>
                        <input type="text" name="name">
                    </td>
                    <td>
                        <input type="submit" class="btn btn-success" value="添加歌手">
                    </td>
                    </form>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>