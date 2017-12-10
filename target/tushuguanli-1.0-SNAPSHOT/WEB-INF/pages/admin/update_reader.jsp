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
    <h1>更新读者信息</h1>
    <hr/>
    <div class="container">
        <form action="${pageContext.request.contextPath}/admin/readers/doUpdate" method="post" command="reader" role="form">
            <div class="form-group">
                <label for="id">学号:</label>
                <input type="text" class="form-control" id="id" name="id" placeholder="请输入学号"
                       value="${reader.id}"  readonly />
            </div>
            <div class="form-group">
                <label for="name">姓名:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名"
                       value="${reader.name}" />
            </div>
            <div class="form-group">
                <label for="grade">年级:</label>
                <input type="text" class="form-control" id="grade" name="grade" placeholder="请输入年级"
                       value="${reader.grade}" />
            </div>
            <div class="form-group">
                <label for="dept">学院:</label>
                <input type="text" class="form-control" id="dept" name="dept" placeholder="请输入学院"
                       value="${reader.dept}" />
            </div>
            <div class="form-group">
                <label for="sex">性别:</label>
                <input type="text" class="form-control" id="sex" name="sex" placeholder="请输入性别"
                       value="${reader.sex}"  />
            <br>
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