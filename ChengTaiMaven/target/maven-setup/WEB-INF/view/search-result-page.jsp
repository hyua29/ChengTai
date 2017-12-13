<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 8/12/17
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button type="button" onclick="window.location.href='/amt/add-to-total-info'" >Add New Record</button>

<br>
<br>

<div>
    <form action="/amt/search-result" method="get">
        <table>
            <tr>
                <td>Source Harbor: </td>
                <td><input name="sourceHarbor" type="text" placeholder="Source Harbor"/></td>
            </tr>
            <tr>
                <td>
                    <select name="cOrPSelect">
                        <option value="pod">POD</option>
                        <option value="country">Country</option>
                    </select>
                </td>
                <td><input name="ctyOrPod" type="text" placeholder="Country Or POD Name"/></td>
            </tr>
            <tr>
                <td>From:</td>
                <td><input id="DatePicker" type="date" name="time" ></td>
            </tr>


            <tr>
                <td></td>
                <td><input style="float: right;" type="submit" value="Search"></td>
            </tr>
        </table>

    </form>


    <div>
        <table>

            <tr>
                <th>PODS</th>
                <th>SOURCE HARBORS</th>
                <th>COUNTRIES</th>
                <th>CARRIERS</th>
                <th>IMP INFO</th>
                <th>20</th>
                <th>40</th>
                <th>40HQ</th>
                <th>REMARK</th>
                <th>FEEDER</th>
                <th>HL CLS</th>
                <th>ETP HK</th>
                <th>T/T</th>
                <th>EXTRA INFO</th>
                <th>LAST MODIFIED</th>
                <th>ACTION</th>
            </tr>

            <c:forEach var="totalInfo" items="${resultTotalInfo}">
                <!-- url for update and delete -->
                <c:url var="updateLink" value="/amt/show-form-for-update">
                    <c:param name="totalInfoId" value="${totalInfo.id}" />
                </c:url>

                <c:url var="deleteLink" value="/amt/delete">
                    <c:param name="totalInfoId" value="${totalInfo.id}" />
                </c:url>

                <tr>
                    <td>${totalInfo.pod}</td>
                    <td>${totalInfo.sourceHarbor}</td>
                    <td>${totalInfo.country}</td>
                    <td>${totalInfo.carrier}</td>
                    <td>${totalInfo.impInfo}</td>
                    <td>${totalInfo.gq20}</td>
                    <td>${totalInfo.gq40}</td>
                    <td>${totalInfo.hq40}</td>
                    <td>${totalInfo.remark}</td>
                    <td>${totalInfo.feeder}</td>
                    <td>${totalInfo.HKCLS}</td>
                    <td>${totalInfo.ETPHK}</td>
                    <td>${totalInfo.TT}</td>
                    <td>${totalInfo.extraInfo}</td>
                    <td>${totalInfo.lastModified}</td>
                    <td>
                        <a href="${updateLink}"> Update </a>
                        |
                        <a href="${deleteLink}" onclick=
                                "if(!(confirm('Are you sure you want to delete this'))) return false;"> Delete</a>
                    </td>

                </tr>
            </c:forEach>

        </table>
    </div>

</div>


</body>
<script type="text/javascript">
    //set default: 30 days from current time
    var date = new Date();
    date.setDate(date.getDate() - 30);
    window.document.getElementById("DatePicker").valueAsDate = date;

    //
</script>
</html>



