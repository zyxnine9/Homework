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
                <h2>图书列表</h2>
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


            <div class="panel-body">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>图书ID</th>
                        <th>图书名称</th>
                        <th>馆藏数量</th>
                        <th>总数</th>
                        <th>详细</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${books}" var="sk">
                        <tr>
                            <td>${sk.id}</td>
                            <td>${sk.name}</td>
                            <td>${sk.number}</td>
                            <td>${sk.total}</td>
                            <td><a class="btn btn-info" href="/book/detail/${sk.id} " target="_blank">详细</a></td>
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