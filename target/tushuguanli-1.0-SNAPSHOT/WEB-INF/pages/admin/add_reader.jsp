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
    <title>添加读者</title>

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
    <h1>添加读者</h1>
    <hr/>
    <div class="container">

        <form action="${pageContext.request.contextPath}/admin/readers/doAddReader" method="post" command="newReader" role="form">
            <div class="form-group">
                <label for="id">学号:</label>
                <input type="text" class="form-control" id="id" name="id" placeholder="请输入学号"
                       value="${newReader.id}"   />
            </div>
            <div class="form-group">
                <label for="name">姓名:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入学号"
                       value="${newReader.name}" />
            </div>
            <div class="form-group">
                <label for="sex">性别:</label>
                <input type="text" class="form-control" id="sex" name="sex" placeholder="请输入书号"
                       value="${newReader.sex}" />
            </div>
            <div class="form-group">
                <label for="grade">年级:</label>
                <input type="text" class="form-control" id="grade" name="grade" placeholder="请输入学号"
                       value="${newReader.grade}" />
            </div>
            <div class="form-group">
                <label for="dept">学院:</label>
                <input type="text" class="form-control" id="dept" name="dept" placeholder="请输入学号"
                       value="${newReader.dept}" />
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-sm btn-success">提交</button>
            </div>
        </form>
        <a href="${pageContext.request.contextPath}/returnMainPage">主页</a>
    </div>
</div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
