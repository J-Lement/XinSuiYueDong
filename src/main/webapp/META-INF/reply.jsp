<%--
  Created by IntelliJ IDEA.
  User: Lement
  Date: 2019/9/26
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>reply</title>
    <link href="/css/reply.css" rel="stylesheet">
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script src="/js/reply.js"></script>

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

    </div>

    <div class="firstMainDiv">
        <div class="secondBottomDiv">
            <div class="originComment">
                <h3><a href="#" style="color: #00bbee">${userName}：</a></h3>
                <p>${comments.commentsContent}</p>
                <span class="floatRight commentsTime">${comments.commentsTime}</span>
            </div>

            <form id="mainForm" action="/addComment">
                <div class="inputComment">
                    <%--<input readonly="true"  placeholder="发表评论" style="width: 98%;margin: 7px">--%>
                    <input id="commentsId" type="text" name="commentsId" value="${comments.commentsId}" hidden>
                    <input type="text" name="replyId" value="${loginUserId}" hidden>
                    <input type="text" id="replyName" value="${loginUserName}" hidden>
                    <%--<input id="pageNow" type="text" name="pageNow" value="${page.pageNow}" hidden>--%>
                    <%--<input id="pageNum" type="text" name="pageNum" value="${page.pageNum}" hidden>--%>
                    <textarea id="inputComment" name="content" placeholder="发表评论"  rows="5"></textarea>
                    <input class="btn btn-info btn-sm" type="button" id="commentsBtn" value="评论">
                </div>
            </form>

            <h6>最近回复</h6>
            <hr>



            <div class="comment">
                <c:forEach items="${replyList}" var="reply">
                    <div>
                        <a href="#" style="color: #00bbee">${reply.replyUserName}</a>
                        <c:if test="${reply.userName != null}">
                            回复 <a href="#" style="color: #00bbee">${reply.userName}</a>
                        </c:if>：
                            ${reply.replyContent}
                        <a class="replyA" href="#">回复</a>
                        <span class="floatRight">${reply.replyTime}</span>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

    <div class="firstLeftDiv">

    </div>

</div>
</body>
</html>

