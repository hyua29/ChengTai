<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 10/12/17
  Time: 2:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ChengTai</title>
</head>
<body>
<div style="text-align:center; margin-left:22%; margin-top: 10%; width:55%">
    <c:choose>
        <c:when test="${transactionSucceeded}">
            修改成功
        </c:when>

        <c:otherwise>
            修改失败
            <br>
            请确保条目与基础资料相匹配
        </c:otherwise>
    </c:choose>
    <br>

    <span onclick="window.history.go(-1);"> 返回</span>
</div>
</body>
</html>



