<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 12/22/17
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ChengTai</title>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.js" ></script>

</head>

<body>

    <div>
        <table id="deletable">
            <tr>
                <th>Counties</th>
                <th>PODs</th>
            </tr>
            <c:forEach var="podBatch" items="${PODBatches}">
            <tr id="${podBatch.podNameWithoutSpace}">
                <td>${podBatch.country}</td>
                <td>${podBatch.PODName}</td>
                <td><button type="button" onclick="$(${podBatch.podNameWithoutSpace}).remove();">delete</button></td>
            </tr>
            </c:forEach>
        </table>
    </div>

    <div>
        <table>
            <tr>
                <th>Source Harbors</th>
            </tr>
            <c:forEach var="sourceHb" items="${sourceHbList}">
                <tr id="${sourceHb.sourceHbWithoutSpace}">
                    <td>${sourceHb.sourceHarborName}</td>
                    <td><button type="button" onclick="$(${sourceHb.sourceHbWithoutSpace}).remove();">delete</button></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div>
        <table>
            <tr>
                <th>Carriers: </th>
            </tr>
            <c:forEach var="carrier" items="${carrierList}">
                <tr id="${carrier.carrierWithoutSpace}">
                    <td>${carrier.carrierName}</td>
                    <td><button type="button" onclick="$(${carrier.carrierWithoutSpace}).remove();">delete</button></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>

</html>
