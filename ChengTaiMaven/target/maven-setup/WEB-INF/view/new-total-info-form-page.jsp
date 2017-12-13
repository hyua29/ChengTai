<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 8/12/17
  Time: 11:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form:form action="/amt/saveTotalInfo" modelAttribute="totalInfoToAdd" method="post">
            <table>
                <tbody>
                    <form:hidden path="id" />
                    <tr>
                        <td>POD: </td>
                        <td><form:input path="pod" /></td>
                    </tr>
                    <tr>
                        <td>SOURCE HARBOR: </td>
                        <td><input:input path="sourceHarbor" /> </td>
                    </tr>
                    <tr>
                        <td>COUNTRY: </td>
                        <td><form:input path="country" /></td>
                    </tr>
                    <tr>
                        <td>CARRIER: </td>
                        <td><input:input path="carrier" /> </td>
                    </tr>
                    <tr>
                        <td>IMPORTANT INFO: </td>
                        <td><form:input path="impInfo"/> </td>
                    </tr>
                    <tr>
                        <td>SIZE-20GQ: </td>
                        <td><form:input path="gq20"/> </td>
                    </tr>
                    <tr>
                        <td>SIZE-40GQ: </td>
                        <td><form:input path="gq40"/> </td>
                    </tr>
                    <tr>
                        <td>SIZE-40HQ: </td>
                        <td><form:input path="hq40"/> </td>
                    </tr>
                    <tr>
                        <td>REMARK: </td>
                        <td><form:input path="remark"/> </td>
                    </tr>
                    <tr>
                        <td>FEEDER: </td>
                        <td><form:input path="feeder"/> </td>
                    </tr>
                    <tr>
                        <td>HK CLS: </td>
                        <td><form:input path="HKCLS"/> </td>
                    </tr>
                    <tr>
                        <td>ETP HK: </td>
                        <td><form:input path="ETPHK"/> </td>
                    </tr>
                    <tr>
                        <td>T/T: </td>
                        <td><form:input path="TT"/> </td>
                    </tr>
                    <tr>
                        <td>EXTRA INFO: </td>
                        <td><form:input path="extraInfo"/> </td>
                    </tr>

                <tr>
                    <td><input type="submit" value="ADD"></td>
                </tr>
                </tbody>

            </table>

        </form:form>


    </div>
</body>
</html>
