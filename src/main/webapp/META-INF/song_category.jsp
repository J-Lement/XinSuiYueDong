<%@ page import="com.nchu.music.bean.Song" %><%--
  Created by IntelliJ IDEA.S
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

            <th class="head1">类别id</th>
            <th class="head1">类别名</th>
            <th class="head0">操做</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${list}" var = "list">
        <tr class="grade" >
            <td>${list.categoryId}</td>
            <td>${list.categoryName}</td>

            <td>
                <a href="/editcategory/${list.categoryId}"><button class="stdbtn btn_blue">修改</button></a>
                <a href="/deleteCategory/${list.categoryId}"><button class="stdbtn btn_blue"  type="submit">删除</button></a>

            </td>

        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>

</body>
</html>