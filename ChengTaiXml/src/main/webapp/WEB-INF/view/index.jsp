<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/footer-distributed.css">
        <title>ChengTai</title>
    </head>
    <body>
    <div style="text-align:center; margin-left:22%; margin-top: 10%; width:55%">
    <h3>Welcome </h3>

    <!-- add log out. This will be sent to in-build spring security framework-->
    <div>
        <a href="${pageContext.request.contextPath}/admin/search-result">搜索</a>
        <br>
        <a href="${pageContext.request.contextPath}/admin/data-batch">基础资料</a>
    </div>

    <br>

    </div>

    </body>
    <footer style="padding:5px; width: 100%; position: absolute; bottom: 5px; background-color: #343434; color: white;">上海诚泰船务有限公司（广州） &copy; 2003</footer>
</html>