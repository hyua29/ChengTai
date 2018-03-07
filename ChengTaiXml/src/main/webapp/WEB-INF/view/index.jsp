<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>ChengTai</title>
    </head>
    <body>
    <div style="text-align:center; margin-left:22%; margin-top: 10%; width:55%">
    <h3>Welcome </h3>

    <!-- add log out. This will be sent to in-build spring security framework-->
    <div>
        <a href="${pageContext.request.contextPath}/admin/search-result">Go To Search Page</a>
        <br>
        <a href="${pageContext.request.contextPath}/admin/data-batch">Go To Data Batch</a>
    </div>

    <br>

    </div>
    </body>

</html>