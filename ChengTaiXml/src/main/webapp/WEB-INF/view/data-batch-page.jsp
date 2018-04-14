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
    <script src="${pageContext.request.contextPath}/resources/js/helpers.js" ></script>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/databatch.css" />

</head>

<body>

<div>
    <<a href="${pageContext.request.contextPath}/index">Main Page</a>>
</div>
<div style="width: 66%; float: left;">

    <div class = table style="float: left; width: 47%;">
        <form action="${pageContext.request.contextPath}/admin/data-batch" method="post">
        <table id="deletable">
            <button type="button" onclick="showForm('#podForm')">Add</button>
            <tr>
                <th>Counties</th>
                <th>PODs</th>
                <th>Action</th>
            </tr>
            <tr id="podForm" hidden="hidden">
                <td hidden="hidden"><input id="isPod" name="isPod" value="false"></td>
                <td><input style="width: 100%;" type="text" name="country"></td>
                <td><input style="width: 100%;" type="text" name="pod"></td>
                <td><input style="width: 100%;" type="submit" value="submit" onclick="$('#isPod').val('true')"></td>
            </tr>
            <c:forEach var="podBatch" items="${PODBatches}">
            <tr id="${podBatch.podNameWithoutSpace}">
                <td>${podBatch.country}</td>
                <td>${podBatch.PODName}</td>
                <td><button type="button" onclick="ajaxPodDelete(${podBatch.podNameWithoutSpace}.id, ${podBatch.podNameWithoutSpace});">delete</button></td>
            </tr>
            </c:forEach>
        </table>
        </form>
    </div>

    <div class = table  style="float: right;width: 50%">
        <form action="${pageContext.request.contextPath}/admin/data-batch" method="post">
        <table>
            <button type="button" onclick="showForm('#harborForm')">Add</button>
            <tr>
                <th>Source Harbors</th>
                <th>Action</th>
            </tr>
            <tr id="harborForm"  hidden="hidden">
                <td hidden="hidden"><input id="isHarbor" name="isHarbor" value="false"></td>
                <td><input style="width: 60%;" name="harbor" type="text">
                <td><input style="width: 100%;" type="submit" value="submit" onclick="$('#isHarbor').val('true')"></td>
            </tr>
            <c:forEach var="sourceHb" items="${sourceHbList}">
                <tr id="${sourceHb.sourceHbWithoutSpace}">
                    <td>${sourceHb.sourceHarborName}</td>
                    <td><button type="button" onclick="ajaxHarborDelete(${sourceHb.sourceHbWithoutSpace}.id, ${sourceHb.sourceHbWithoutSpace});">delete</button></td>
                </tr>
            </c:forEach>
        </table>
        </form>
    </div>
</div>

    <div class = table  style="float: right; width: 33%;">
        <form action="${pageContext.request.contextPath}/admin/data-batch" method="post">
        <table>
            <button type="button" onclick="showForm('#carrierForm')">Add</button>
            <tr>
                <th>Carriers </th>
                <th>Action</th>
            </tr>
            <tr id="carrierForm" class="form" hidden="hidden">
                <td hidden="hidden"><input id="isCarrier" name="isCarrier" value="false"></td>
                <td><input style="width: 50%;" type="text" name="carrier"></td>
                <td><input style="width: 100%;" type="submit" value="submit" onclick="$('#isCarrier').val('true')"></td>
            </tr>
            <c:forEach var="carrier" items="${carrierList}">
                <tr id="${carrier.carrierWithoutSpace}">
                    <td>${carrier.carrierName}</td>
                    <td><button type="button" onclick="ajaxCarrierDelete(${carrier.carrierWithoutSpace}.id, ${carrier.carrierWithoutSpace});">delete</button></td>
                </tr>
            </c:forEach>
        </table>
        </form>
    </div>
</body>

<script>

    function ajaxPodDelete(name, tagToDelete) {
        console.log(name);
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "${pageContext.request.contextPath}/json/delete-pod",
            data: JSON.stringify(name),
            dataType: 'json',
            timeOut: 10000,
            success: function (data) {
                if(data.succeeded=="true") {
                    console.log("delete ajax succeeded");
                    $(tagToDelete).remove();
                }
                else
                    console.log("failed to delete");
            },
            error: function (e) {
                console.log("delete ajax failed");
                console.log(e);
            },
            done: function (e) {
                console.log("DONE");
                console.log(e);
            }

        });
    }

    function ajaxHarborDelete(name, tagToDelete) {
        console.log(name);
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "${pageContext.request.contextPath}/json/delete-harbor",
            data: JSON.stringify(name),
            dataType: 'json',
            timeOut: 10000,
            success: function (data) {
                if(data.succeeded=="true") {
                    console.log("delete ajax succeeded");
                    $(tagToDelete).remove();
                }
                else
                    console.log("failed to delete");
            },
            error: function (e) {
                console.log("delete ajax failed");
                console.log(e);
            },
            done: function (e) {
                console.log("DONE");
                console.log(e);
            }
        });
    }

    function ajaxCarrierDelete(name, tagToDelete) {
        console.log(name);
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "${pageContext.request.contextPath}/json/delete-carrier",
            data: JSON.stringify(name),
            dataType: 'json',
            timeOut: 10000,
            success: function (data) {
                if(data.succeeded=="true") {
                    console.log("delete ajax succeeded");
                    $(tagToDelete).remove();
                }
                else
                    console.log("failed to delete");
            },
            error: function (e) {
                console.log("delete ajax failed");
                console.log(e);
            },
            done: function (e) {
                console.log("DONE");
                console.log(e);
            }
        });
    }
    function showForm(id) {
        $(id).removeAttr("hidden");
    }
</script>
</html>
