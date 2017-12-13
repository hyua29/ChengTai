<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 10/12/17
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
