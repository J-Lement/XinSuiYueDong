<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息修改</title>
    <!--添加图标-->
    <link rel="shortcut icon" href="/static/images/logo.ico" />

    <!-- Vue.js文件-->
    <script src="https://cdn.staticfile.org/vue/2.2.2/vue.min.js"></script>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--JQuery validate插件-->
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>


</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form class="form-horizontal" role="form" action="updateUser" method="post">
                <div class="form-group">
                    <label for="qq" class="col-sm-2 control-label">qq</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="qq" name="qq" value="${user.qq}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="nation" class="col-sm-2 control-label">国家</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nation" name="nation" value="${user.nation}" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="province" class="col-sm-2 control-label">省份</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="province" name="province" value="${user.province}" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="city" class="col-sm-2 control-label">城市</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="city" name="city" value="${user.city}" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="is_public" class="col-sm-2 control-label">是否公开</label>
                    <div class="col-sm-10">
                        <select type="text" class="form-control" id="is_public" name="is_public" >
                            <option>是</option>
                            <option>否</option>
                        </select>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">修改</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
