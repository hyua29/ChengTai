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
        删除成功
    </c:when>

    <c:otherwise>
        删除失败(unknown errors)
    </c:otherwise>
</c:choose>
<br>
<span onclick="window.history.go(-2);"> 返回</span>
</div>

</body>
</html>
