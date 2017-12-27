<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>ChengTai</title>
    </head>
    <body>
    <h3>Welcome </h3>

    <!-- add log out. This will be sent to in-build spring security framework-->
    <div>
        <a href="${pageContext.request.contextPath}/admin/search-result">Go To Search Page</a>
        <br>
        <a href="${pageContext.request.contextPath}/admin/data-batch">Go To Data Batch</a>
    </div>

    <br>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST"> <!-- from app's domain -->
        <input type="submit" value="logout"/>
    </form:form>

    <c:url var="templateLink" value="${pageContext.request.contextPath}/download/lane-template">
        <c:param name="fileName" value="test-file.txt"/>
    </c:url>
    <a href="${templateLink}"> Download </a>

    </body>

</html>