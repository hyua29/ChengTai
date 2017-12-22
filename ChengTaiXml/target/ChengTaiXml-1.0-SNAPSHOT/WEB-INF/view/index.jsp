<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>title</title>
    </head>
    <body>
    <h3>Welcome </h3>

    <!-- add log out. This will be sent to in-build spring security framework-->
    <div>
        <a href="${pageContext.request.contextPath}/admin/search-result">Go To Search Page</a>
    </div>
    <br>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST"> <!-- from app's domain -->
        <input type="submit" value="logout"/>
    </form:form>

    </body>

</html>