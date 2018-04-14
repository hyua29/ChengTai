    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!-- allow spring tags -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- allow jstl tag -->
<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 5/12/17
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>ChengTai Login</title>
</head>
<body>
    <div>
        <h3>Login Page</h3>
    </div>

    <div>
        <!-- check whether there is any error -->
        <!-- If there is any error, the spring security will send the user back to the login page automatically with
        'error' as the request parameter -->

        <c:if test="${param.error!=null}">
            <i>Sorry! your user name or password is wrong.</i>
        </c:if>

        <c:if test="${param.logout != null}">
            <i>You have been logged out. </i>
        </c:if>

        <!-- login form -->

        <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST"><!-- spring security will read the inputs by the name -->
        <p>User name: <input type="text" name="username"/></p>
        <p>Password: <input type="password" name="password"/></p>
        <p><input type="submit" value="login" /></p>
        </form:form>

    </div>

</body>
</html>
