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

<table class="easyui-datagrid" style="width:400px;height:250px"
       data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true">
    <thead>
    <tr>
        <th data-options="field:'code',width:300">歌名</th>
        <th data-options="field:'name',width:300">歌手</th>
        <th data-options="field:'name',width:300">类别</th>
        <th data-options="field:'price',width:300,align:'right'">操作</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${allSongs}" var="song">
            <tr>
                <td>${song.songName}</td>
                <td>${song.singerName}</td>
                <td>${song.categoryName}</td>
                <td>
                    <a href="#">下载</a>
                    <a href="/musicHome?songId=${song.songId}">试听</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">New</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">Destroy</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow')">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">Cancel</a>
</div>
<script type="text/javascript">
    $(function(){
        $('#dg').edatagrid({
            url: 'get_users.php',
            saveUrl: 'save_user.php',
            updateUrl: 'update_user.php',
            destroyUrl: 'destroy_user.php'
        });
    });
</script>
</body>
</html>
