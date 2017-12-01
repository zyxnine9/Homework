<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/30
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>书籍列表</title>

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
    <hr/>
    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading text-center">
                <h2>图书列表</h2>
            </div>
            <form name="firstForm" action="<%= request.getContextPath()%>/reader/main/search" method="post">
                <div class="panel-heading ">
                    <table class="table table-bookName">
                    </table>
                </div>
                <h5>${result}</h5>
            </form>


            <div class="panel-body">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>图书ID</th>
                        <th>图书名称</th>
                        <th>馆藏数量</th>
                        <th>总数</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${books}" var="sk">
                        <tr>
                            <td>${sk.id}</td>
                            <td>${sk.name}</td>
                            <td>${sk.number}</td>
                            <td>${sk.total}</td>
                            <td>
                                <a class="btn btn-sm btn-success" href="/admin/detail/${sk.id} " target="_blank">详细</a>
                                <a class="btn btn-sm btn-warning" href="/admin/books/delete/${sk.id} " target="_blank">删除</a>
                                <a class="btn btn-sm btn-danger" href="/admin/books/update/${sk.id} " target="_blank">更新</a>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <a href="/returnMainPage">主页</a>
        </div>
    </div>
</div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>