<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 8/12/17
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>ChengTai</title>

    <!-- ${pageContext.request.contextPath} -->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/form-styles.css" />

    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.js" ></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.js" ></script>
    <script src="${pageContext.request.contextPath}/resources/js/helpers.js" ></script>

    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>

</head>
<body>
<div>
    <<a href="${pageContext.request.contextPath}/index">Main Page</a>>
</div>
    <div>
        <div id="searchTable">
        <form:form action="${pageContext.request.contextPath}/admin/search-result" modelAttribute='searchObject' method="post">
            <table>
                <tbody>
                <tr>
                    <td>Source Harbor:</td>
                    <td><form:input id="sourceHarborSearch" path="sourceHb" placeholder="Source Harbor"/></td>
                </tr>
                <tr>
                    <td>
                        <form:select path="cOrPSelect" onchange="changeList()">
                            <form:option value="pod">POD</form:option>
                            <form:option value="country">Country</form:option>
                        </form:select>
                    </td>
                    <td><form:input id="ctyOrPodSearch" path="ctyOrPod" placeholder="Country Or POD Name"/></td>
                </tr>
                <tr hidden="hidden">
                    <td>From:</td>
                    <td><form:input id="dateFrom" path="dateFrom" placeholder="yyyy-mm-dd" /> </td>
                </tr>

                <tr hidden="hidden">
                    <td>To:</td>
                    <td><form:input id="dateTo" path="dateTo" placeholder="yyyy-mm-dd" /> </td>
                </tr>

                <tr>
                    <td>From:</td>
                    <td><input id="from" type="date" onchange="replaceDateFrom();"></td>
                </tr>

                <tr>
                    <td>To:</td>
                    <td><input id="to" type="date" onchange="replaceDateTo();"></td>
                </tr>

                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr>
                    <td></td>
                    <td><input style="float: right;  background: #337ab7; color: #FFFFFF; padding: 3%" type="submit" value="Search"></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        </div>
        <button id="addButton" type="button" onclick="onclickAdd()" >Add New Records</button>
        <button type="button" onclick="refresh()"> refresh</button>
        <c:url var="templateLink" value="${pageContext.request.contextPath}/download/lane-template">
            <c:param name="fileName" value="test-file.txt"/>
        </c:url>
        <a href="${templateLink}"> Download Template </a>
        <form action="${pageContext.request.contextPath}/upload/lane-info" method="post" enctype="multipart/form-data">
            <input type="file" name="laneInfo"/>
            <input type="submit" value="upload" />
        </form>
        <div id="resultTable">
            <table>
                <tr>
                    <th>LAST MODIFIED</th>
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
                    <th>ACTION</th>
                </tr>

                <div id='newInfo'>
                    <form:form hidden="hidden" action='${pageContext.request.contextPath}/admin/updateTotalInfo' modelAttribute='totalInfoToAdd' method='post'>
                        <tbody id="add" hidden="hidden" >
                        <form:hidden path='id' />
                        <tr>
                            <td>-</td>
                            <td><form:input style="height: 30%; width: 80%; font-size: 130%;" path='pod' /></td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='sourceHarbor' /> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='country' /></td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='carrier' /> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='impInfo'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='gq20'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='gq40'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='hq40'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='remark'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='feeder'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='HKCLS'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='ETPHK'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='TT'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='extraInfo'/> </td>
                            <td><input type='submit' value='Confirm'></td>
                        </tr>
                        </tbody>
                    </form:form>
                </div>


                <c:forEach var="totalInfo" items="${resultTotalInfo}">

                    <!-- url for update and delete --> <!-- domain already embedded -->
                    <c:url var="updateLink" value="/admin/show-form-for-update">
                        <c:param name="totalInfoId" value="${totalInfo.id}"/>
                    </c:url>

                    <c:url var="deleteLink" value="/admin/delete">
                        <c:param name="totalInfoId" value="${totalInfo.id}"/>
                    </c:url>
                    <tr>
                        <td>${totalInfo.lastModified}</td>
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
                        <td>
                            <a href="${updateLink}"> Update </a>
                            |
                            <a href="${deleteLink}" >Delete </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div style="color: red">
                <c:if test="${resultTotalInfo.size() == 0}">
                    No results found
                </c:if>
            </div>
        </div>
    </div>

</body>
<footer style="padding:5px; width: 100%; position: absolute; bottom: 5px; background-color: #343434; color: white;">上海诚泰船务有限公司（广州） &copy; 2003</footer>
<script type="text/javascript">
    var countries = [];
    var pods = [];
    var sHarbors = []; // These three variables are acquired by ajax query
                        // They are used to auto-fill the input fields
    /*
    Pop input fields for update
    */
    function popFieldsForUpdate(id) {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/json/update-total-info",
            data: JSON.stringify(id),
            dataType: 'json',  // specify respond dateFrom type
            timeOut: 10000,
            success: function (data) {
                console.log("update ajax succeeded");
                popUpdateForm(data);
            },
            error: function (e) {
                console.log("update ajax failed");
                console.log(e);
            }
        });
    }

    /*
    This function delete 'hidden' attribute from the adding menu accordingly
     */
    function onclickAdd(){
        var attr = $("#add").attr('hidden');

        if(attr !== undefined && attr !== false){
            $('#add').removeAttr('hidden');
            $('#addButton').text("cancel");
        } else {
            $('#add').attr('hidden', "hidden");
            $('#addButton').text("Add New Records");
        }

    }

    function changeList() {
        if ($("#cOrPSelect").val() === "pod") {
            myAutoComplete(pods, "#ctyOrPodSearch");
        } else {
            myAutoComplete(countries, "#ctyOrPodSearch");
        }
    }

    (function () {  //set default: 30 days from current time
        var dateFrom = new Date();
        window.document.getElementById("to").valueAsDate = dateFrom;
        dateFrom.setDate(dateFrom.getDate() - 30);
        window.document.getElementById("from").valueAsDate = dateFrom;


    })();

    (function () {  // query source harbor
        console.log("search request sent");
        var searchRequestJSON = {};
        searchRequestJSON["getPod"] = true;
        searchRequestJSON["getSourceHarbor"] = true;

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "${pageContext.request.contextPath}/json/get-pod",
            data: JSON.stringify(searchRequestJSON),
            dataType: 'json',
            timeOut: 10000,
            success: function (data) {
                console.log("search ajax succeeded");
                for (var i = 0; i < data.sourceHarborAJAXRespond.dataList.length; i++) {
                    sHarbors.push(data.sourceHarborAJAXRespond.dataList[i].sourceHarborName);
                }

                var previousCountry = null;
                for (var i = 0; i < data.podAJAXRespond.dataList.length; i++) {
                    if(previousCountry != data.podAJAXRespond.dataList[i].country){
                    countries.push(data.podAJAXRespond.dataList[i].country);
                    previousCountry = data.podAJAXRespond.dataList[i].country;
                    }
                }

                for (var i = 0; i < data.podAJAXRespond.dataList.length; i++) {
                    pods.push(data.podAJAXRespond.dataList[i].PODName);
                }
                myAutoComplete(sHarbors, "#sourceHarborSearch");
                myAutoComplete(pods, "#ctyOrPodSearch");
            },
            error: function (e) {
                console.log("search ajax failed");
                console.log(e);
            },
            done: function (e) {
                console.log("DONE");
                console.log(e);
            }

        });

    })();

    // replace input value on change of calender
    function replaceDateFrom () {
        var from = $("#from").val();
        $("#dateFrom").val(from);
    }

    function replaceDateTo() {
        var to = $("#to").val();
        $("#dateTo").val(to);
    }

</script>

</html>



