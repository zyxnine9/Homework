<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>图书详情</title>

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
    <h1>图书详情</h1>
    <hr/>

    <table class="table table-bordered table-striped">
        <tr>
            <th>图书号</th>
            <td>${book.id}</td>
        </tr>
        <tr>
            <th>书名</th>
            <td>${book.name}</td>
        </tr>
        <tr>
            <th>作者</th>
            <td>${book.writer}</td>
        </tr>
        <tr>
            <th>出版商</th>
            <td>${book.press}</td>
        </tr>
        <tr>
            <th>出版时间</th>
            <td>${book.time}</td>
        </tr>
        <tr>
            <th>内容摘要</th>
            <td>${book.bkcontext}</td>
        </tr>
        <tr>
            <th>在馆数</th>
            <td>${book.number}</td>
        </tr>
        <tr>
            <th>馆藏数</th>
            <td>${book.total}</td>
        </tr>
    </table>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>