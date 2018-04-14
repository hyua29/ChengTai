<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 7/03/18
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ChengTai</title>
</head>
<body>
<div style="text-align:center; margin:20% auto auto; width:55%">
<c:choose>
    <c:when test="${status.equals('succeeded')}">
        <div>上传成功 </div>
    </c:when>
    <c:otherwise>
        <div>Upload failed </div>
    </c:otherwise>
</c:choose>
<br>
    <a href="${pageContext.request.contextPath}/admin/search-result">Go Back</a>
</div>


</body>
</html>
