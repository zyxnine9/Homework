<%--@elvariable id="bookName" type="java.lang.String"--%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/30
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html  lang="zh-CN">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>管理员操作台</title>

    <!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!--PAGE LEVEL STYLES-->
    <link href="assets/css/pricing.css" rel="stylesheet" />
    <!--CUSTOM BASIC STYLES-->
    <link href="assets/css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<div class="container">
    <!-- /. NAV SIDE  -->
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-head-line">管理员操作台</h1>
                    <h1 class="page-subhead-line">
                    亲爱的管理员，您好。下面是您可以进行的操作</h1>

                </div>
            </div>
            <!-- /. ROW  -->


            <div class="row text-center pad-row">
                <div class="col-md-3">
                    <div class="panel-danger simple-table">
                        <div class="panel-heading">
                            <h4>书籍操作</h4>
                        </div>
                        <div class="alert alert-danger">
                            <form name="firstFrom" action="${pageContext.request.contextPath}/admin/books" method="get">
                                <input type="text" name="bookName" class="allInput" value="${bookName}" placeholder="输入书名搜索" />
                                <br>
                                <br>

                                <input type="submit" class="btn btn-danger" value="搜索" />

                            </form>
                            <%--<a href="#" class="btn btn-danger ">BUY NOW</a>--%>
                        </div>

                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel-warning simple-table">
                        <div class="panel-heading">
                            <h4>读者操作</h4>
                        </div>
                        <div class="alert alert-warning">

                            <form name="firstFrom" action="/admin/readers" method="get">
                                <input type="text" name="readerName" class="allInput" value="${readerName}" placeholder="输入书名搜索" />
                                <br>
                                <br>

                                <input type="submit" class="btn btn-warning " value="搜索" />

                            </form>

                        </div>

                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel-success simple-table">
                        <div class="panel-heading">
                            <h4>查看已借书籍</h4>
                        </div>
                        <div class="alert alert-success">

                            <ul class="plan">

                            </ul>
                            <a href="#" class="btn btn-success ">查看</a>
                        </div>

                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel-info simple-table">
                        <div class="panel-heading">
                            <h4>查看超期读者</h4>
                        </div>
                        <div class=" alert alert-info">

                        <ul class="plan">

                            </ul>
                            <a href="#" class="btn btn-info ">查看</a>
                        </div>

                    </div>
                </div>


            </div>
            <a href="/returnMainPage">主页</a>
        </div>

        <!-- /. PAGE INNER  -->
    </div>
</div>
    <!-- /. PAGE WRAPPER  -->
<!-- /. WRAPPER  -->
<!-- /. FOOTER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="assets/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="assets/js/bootstrap.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="assets/js/jquery.metisMenu.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="assets/js/custom.js"></script>


</body>
</html>
