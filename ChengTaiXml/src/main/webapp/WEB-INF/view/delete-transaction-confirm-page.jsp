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
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${transactionSucceeded}">
        succeeded
    </c:when>

    <c:otherwise>
        failed(unknown errors)
    </c:otherwise>
</c:choose>
<br>
<span onclick="window.history.go(-2);"> Go Back To List</span>


</body>
</html>
