<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>读者</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1>用户管理</h1>
    <hr/>

    <h3>所有用户 <a href="/admin/readers/addReader" type="button" class="btn btn-primary btn-sm">添加</a></h3>
    <!-- 如果用户列表非空 -->
    <c:if test="${!empty readers}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年级</th>
                <th>学院</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${readers}" var="reader">
                <tr>
                    <td>${reader.id}</td>
                    <td>${reader.name}</td>
                    <td>${reader.sex}</td>
                    <td>${reader.grade} </td>
                    <td>${reader.dept}</td>
                    <td>
                        <a href="/admin/readers/${reader.id}/detail" type="button" class="btn btn-sm btn-success" target="_blank">详情</a>
                        <a href="/admin/readers/${reader.id}/update" type="button" class="btn btn-sm btn-warning" target="_blank">修改</a>
                        <a href="/admin/readers/${reader.id}/delete" type="button" class="btn btn-sm btn-danger">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>