<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 7/03/18
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/form-styles.css" />
<style>
    #uploadTable{
        width: 100%;
        height: 95%;
        overflow: auto;
    }

    #uploadTable table {
        border-collapse: collapse;
        border: 1px solid gray;
        width: 110%;
    }

    #uploadTable th {
        overflow: auto;
        font-size: 70%;
        padding-top: 0.3%;
        padding-bottom: 0.3%;
        background: #337ab7;
        border: 1px solid gray;
        color: #FFFFFF;
    }

    #uploadTable tr {
        text-align: center;
    }

    #uploadTable td {
        overflow: auto;
        font-size: 70%;
        padding-top: 0.3%;
        padding-bottom: 0.3%;
        border: 1px solid gray;
    }

    #uploadTable tr:nth-child(even) {
        background: #FFFFFF;
    }

    #uploadTable tr:nth-child(odd) {
        background: #BBBBBB;
    }
</style>
</head>
<body>

<div id="uploadTable">

<table>
    <tr>

        <th>PODS</th>
        <th>SOURCE HARBORS</th>
        <th>COUNTRIES</th>
        <th>IMP INFO</th>
        <th>CARRIERS</th>
        <th>20</th>
        <th>40</th>
        <th>40HQ</th>
        <th>REMARK</th>
        <th>FEEDER</th>
        <th>HL CLS</th>
        <th>ETP HK</th>
        <th>T/T</th>
        <th>EXTRA INFO</th>

    </tr>
    <c:forEach var="invalidToInfo" items="${invalidToInfoList}">

        <tr style="color: red">
            <td>${invalidToInfo.sourceHarbor}</td>
            <td>${invalidToInfo.pod}</td>
            <td>${invalidToInfo.country}</td>
            <td>${invalidToInfo.impInfo}</td>
            <td>${invalidToInfo.carrier}</td>
            <td>${invalidToInfo.gq20}</td>
            <td>${invalidToInfo.gq40}</td>
            <td>${invalidToInfo.hq40}</td>
            <td>${invalidToInfo.remark}</td>
            <td>${invalidToInfo.feeder}</td>
            <td>${invalidToInfo.HKCLS}</td>
            <td>${invalidToInfo.ETPHK}</td>
            <td>${invalidToInfo.TT}</td>
            <td>${invalidToInfo.extraInfo}</td>
        </tr>
    </c:forEach>

    <c:forEach var="legitInfo" items="${legitToInfoList}">

        <tr>
            <td>${legitInfo.sourceHarbor}</td>
            <td>${legitInfo.pod}</td>
            <td>${legitInfo.country}</td>
            <td>${legitInfo.impInfo}</td>
            <td>${legitInfo.carrier}</td>
            <td>${legitInfo.gq20}</td>
            <td>${legitInfo.gq40}</td>
            <td>${legitInfo.hq40}</td>
            <td>${legitInfo.remark}</td>
            <td>${legitInfo.feeder}</td>
            <td>${legitInfo.HKCLS}</td>
            <td>${legitInfo.ETPHK}</td>
            <td>${legitInfo.TT}</td>
            <td>${legitInfo.extraInfo}</td>
        </tr>
    </c:forEach>

</table>
</div>
 <a style="float: right; " href="${pageContext.request.contextPath}/upload/store"> Confirm </a>
</body>
</html>
