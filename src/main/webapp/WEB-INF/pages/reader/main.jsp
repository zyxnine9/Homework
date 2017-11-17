<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>主页</title>

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
        <h1>欢迎使用</h1>
        <hr/>
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading text-center">
                    <h2>查询书籍</h2>
                </div>
                <form name="firstForm" action="<%= request.getContextPath()%>/reader/main/search" method="post">
                    <div class="panel-heading ">
                        <table class="table table-bookName">
                            <thead>
                            <tr>
                                <th width="90" align="lift">图书名称</th>
                                <th width="150" align="lift">
                                    <input type="text" name="name" class="allInput" value="${name}" placeholder="输入书名搜索" />
                                </th>
                                <th>
                                    <input type="submit" class="btn btn-sm btn-success" value="搜索" />
                                </th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </form>
            </div>
            <div  class="page-header">
                <h1>其他功能</h1>
            </div>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="reader/main/borrow"
                   type="button" class="btn btn-lg btn-primary">借阅书籍</a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/reader/main/return"
                   type="button" class="btn btn-lg btn-success">归还书籍</a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="reader/main/record"
                   type="button" class="btn btn-lg btn-info">借阅记录</a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href=""
                   type="button" class="btn btn-lg btn-danger">管理员操作</a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </p>
            </div>
        </div>

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>