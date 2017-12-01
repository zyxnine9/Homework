<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/30
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>借阅</title>

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
    <h1>更新图书信息</h1>
    <hr/>
    <div class="container">
        <form action="/admin/books/doUpdate" method="post" command="book" role="form">
            <div class="form-group">
                <label for="id">书号:</label>
                <input type="text" class="form-control" id="id" name="id" placeholder="请输入书号"
                       value="${book.id}"  readonly />
            </div>
            <div class="form-group">
                <label for="name">书名:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入学号"
                       value="${book.name}" />
            </div>
            <div class="form-group">
                <label for="writer">作者:</label>
                <input type="text" class="form-control" id="writer" name="writer" placeholder="请输入书号"
                       value="${book.writer}" />
            </div>
            <div class="form-group">
                <label for="time">出版时间:</label>
                <input type="text" class="form-control" id="time" name="time" placeholder="请输入学号"
                       value="${book.time}" />
            </div>
            <div class="form-group">
                <label for="number">出版时间:</label>
                <input type="text" class="form-control" id="number" name="number" placeholder="请输入学号"
                       value="${book.number}" readonly />
            </div>
            <div class="form-group">
                <label for="total">总数:</label>
                <input type="text" class="form-control" id="total" name="total" placeholder="请输入学号"
                       value="${book.total}" />
            </div>
            <div class="form-group">
                <label for="bkcontext">内容摘要:</label>
                <input type="text" class="form-control" id="bkcontext" name="bkcontext" placeholder="请输入学号"
                       value="${book.bkcontext}" />
            </div>
            <div class="form-group">
                <label for="press">出版社:</label>
                <input type="text" class="form-control" id="press" name="press" placeholder="请输入学号"
                       value="${book.press}" />
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-sm btn-success">提交</button>
            </div>
        </form>
        <a href="/returnMainPage">主页</a>
    </div>
</div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>