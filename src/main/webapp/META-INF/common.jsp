<%--
  Created by IntelliJ IDEA.
  User: Lement
  Date: 2019/9/16
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

    <script type="text/javascript">

        /* easyui插件定义 */
        $.fn.linkbutton = function(){
            //添加类样式
            this.addClass("l-btn");
            //获取文本
            var text = this.text();

            //获取iconCls的值
            var iconCls = this.attr("iconCls");

            this.html('<span class="l-btn-left">'+
                '<span class="l-btn-text '+iconCls+' l-btn-icon-left">'+text+'</span>'+
                '</span>');
        };

        $(function(){
            //easyui通过html代码创建组建的原理:
            /*
                1.页面加载完毕
                2.获取页面中是以.easyui-{组件名}的选择器元素.  {组件名} : easyui中所有组件,比如:panel,linkbutton,tree
                3.判断是否有获取到的元素.
                4.调用对应的组件方法.   (组件 : panel() , linkbutton() )
            */
            //var els = $(".easyui-linkbutton");
            //els.linkbutton();

            $("#mya").linkbutton();
        });
    </script>

</head>
<body>

<a id="mya" iconCls="icon-ok">我是一个按钮</a>

</body>
</html>
